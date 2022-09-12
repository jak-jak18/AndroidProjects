package com.example.justin.nfc_tester;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.Tag;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity implements OnItemClickListener,ReaderCallback{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    NfcAdapter nfcAdapter;
    String options[] = {"Read", "Write", "Info", "Erase"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    GridView gridView;

    @Override
    public void onStart(){
        super.onStart();

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    String selected;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int selection, long id) {
        Log.d(LOG_TAG, "Option selected: " + selection);

        selected = options[selection];
        operation(selected);
    }

    @Override
    public void onNewIntent(Intent intent) {
        Log.i("Foreground dispatch", "Discovered tag with intent: " + intent);
        StringBuilder builder = new StringBuilder();

        if (intent != null && NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages =
                    intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

            if (rawMessages != null) {
                NdefMessage[] messages = new NdefMessage[rawMessages.length];

                for (int i = 0; i < rawMessages.length; i++) {
                    messages[i] = (NdefMessage) rawMessages[i];
                    Log.d(LOG_TAG, "Number of NdefMessages: " + rawMessages.length);
                }

//                for (int i = 0; i < messages.length; i++) {
//                    for (int j = 0; j < messages[i].getRecords().length; j++) {
//                        String msg = new String(messages[i].getRecords()[j].getPayload());
//                        Log.d(LOG_TAG, "Message returned: " + msg);
//                        builder.append(msg + "\n");
//                    }
//                }

                for (NdefRecord record: messages[0].getRecords()) {
                    String msg = getTextData(record.getPayload());
                    Log.d(LOG_TAG, "Message returned: " + msg);
                    builder.append(msg + "\n");
                }
            }
        }

        textView.setText(builder.toString());
    }

    private String getTextData(byte[] payload){
        ByteArrayInputStream stream = new ByteArrayInputStream(payload);

        int intStream = stream.read();
        byte langLength = (byte)(intStream & 0x1F);

        byte[] langStream = new byte[langLength];
        stream.read(langStream, 0, langLength);

        byte[] textStream = new byte[payload.length - langLength -1];
        stream.read(textStream, 0, textStream.length);

        return new String(textStream, Charset.forName("UTF-8"));
    }

    @Override
    public void onTagDiscovered(Tag tag) {
        Log.d(LOG_TAG, "New tag discovered");
        StringBuilder infoBuilder = new StringBuilder();
        NfcA nfcA = NfcA.get(tag);
        if (nfcA != null) {
            try {
                nfcA.connect();
                Tag mTag = nfcA.getTag();

                byte[] id = mTag.getId();
//                Log.d(LOG_TAG, "ID length: " + id.length);
                StringBuilder builder = new StringBuilder();
                for (byte data: id){
                    builder.append(String.format("%02x", data) + ":");
                }

                Log.d(LOG_TAG, "ID: " + builder.toString());
                infoBuilder.append(builder.toString() + "\n");
                builder.delete(0, builder.length());

                int contents = mTag.describeContents();
                Log.d(LOG_TAG, "Contents: " + contents);
                infoBuilder.append(contents + "\n");

                String[] techlist = mTag.getTechList();
//                Log.d(LOG_TAG, "Techlist length: " + techlist.length);
                for (String tech: techlist){
                    builder.append(tech + ", ");
                }
                Log.d(LOG_TAG, "Techlist: " + builder.toString());
                infoBuilder.append(builder.toString() + "\n");
                builder.delete(0, builder.length());

                String debug = mTag.toString();
                Log.d(LOG_TAG, "Debug: " + debug);
                infoBuilder.append(debug + "\n");

                byte[] atqa = nfcA.getAtqa();
//                Log.d(LOG_TAG, "ATQA length: " + atqa.length);
                Log.d(LOG_TAG, "ATQA: " + String.format("%02x", atqa[1])+ String.format("%02x", atqa[0]));
                infoBuilder.append(String.format("%02x", atqa[1])+ String.format("%02x", atqa[0]) + "\n" );

                short sak = nfcA.getSak();
                Log.d(LOG_TAG, "Sak: " + String.format("%02x", sak));
                infoBuilder.append(String.format("%02x", sak) + "\n");

                final String info = infoBuilder.toString();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(info);
                    }
                });

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error communicating with card: " + e.toString());
            }
        }
        nfcAdapter.disableReaderMode(this);
    }

    private void TagInfo(String info){
        textView.setText(info);
    }

    private void operation(String selected) {
        Log.d(LOG_TAG, "Result sent: " + selected);

        if(selected == "Read") {
            textView.setText("Scan to retrieve data contained on Tag.");

            PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0,
                    new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
            IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
            try {
                ndef.addDataType("*/*");
            } catch (IntentFilter.MalformedMimeTypeException e) {
                throw new RuntimeException("fail", e);
            }
            IntentFilter[] mFilters = new IntentFilter[] {
                    ndef,
            };
            String[][] mTechLists = new String[][] { new String[] {NfcF.class.getName()} };

            if (nfcAdapter != null) nfcAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters,
                    mTechLists);

        }else if(selected == "Write"){

        }else if(selected == "Info"){
            textView.setText("Scan to learn about Tag.");
            int READER_FLAGS = NfcAdapter.STATE_ON;
            nfcAdapter.enableReaderMode(this, this, READER_FLAGS, null);

        }else {
            textView.setText("Hold device near a Tag that you want to erase");
        }

//        switch (selected) {
//            case "Read":
//
//            case "Write":
//
//            case "Info":
//
//
//            case "Erase":
//        }
    }
}
