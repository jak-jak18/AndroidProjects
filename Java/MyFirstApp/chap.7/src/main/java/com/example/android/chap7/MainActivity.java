package com.example.android.chap7;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.protocol.HTTP;

import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Get the intent that started this activity
        Intent intent = getIntent();
        Uri data = intent.getData();

        // Figure out what to do based on the intent type
        if (intent.getType().indexOf("image/") != -1) {
            // Handle intents with image data ...
        } else if (intent.getType().equals("text/plain")) {
            // Handle intents with text ...
        }
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

    Uri number = Uri.parse("tel:5551234");
    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

    // Map point based on address
    Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
    // Or map point based on latitude/longitude
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

    Uri webpage = Uri.parse("http://www.android.com");
    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

    Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
    emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
    emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris

    Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
    Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
    Calendar endTime = Calendar.getInstance().set(2012, 0, 19, 10, 30);
    calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
    calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
    calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
    calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

    PackageManager packageManager = getPackageManager();
    List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
    boolean isIntentSafe = activities.size() > 0;

    startActivity(intent);

    // Build the intent
    Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

    // Verify it resolves
    PackageManager packageManager = getPackageManager();
    List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
    boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
    if (isIntentSafe) {
        startActivity(mapIntent);
    }

    Intent intent = new Intent(Intent.ACTION_SEND);

    // Always use string resources for UI text.
// This says something like "Share this photo with"
    String title = getResources().getString(R.string.chooser_title);
    // Create intent to show chooser
    Intent chooser = Intent.createChooser(intent, title);

// Verify the intent will resolve to at least one activity
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(chooser);
    }

    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    private void pickContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);

                // Do something with the phone number...
            }
        }
    }

    // Create intent to deliver some kind of result data
    Intent result = new Intent("com.example.RESULT_ACTION", Uri.parse("content://result_uri");
    setResult(Activity.RESULT_OK, result);
    finish();



}
