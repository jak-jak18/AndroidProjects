package com.example.justin.tester_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getSimpleName();

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mImageView;
    FirebaseAuth mAuth;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        FloatingActionButton upload = findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(imageBitmap != null){
                    Toast.makeText(MainActivity.this, "Uploading image", Toast.LENGTH_SHORT).show();
                    FirebaseStorage storage = FirebaseStorage.getInstance("gs://images-88523/");
                    StorageReference storageRef = storage.getReference();
                    StorageReference imagesRef = storageRef.child("test-image");
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 97, outputStream);

                    UploadTask uploadTask = imagesRef.putBytes(outputStream.toByteArray());
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Snackbar.make(view, "Upload Failed :<", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                            Log.d(LOG_TAG, "Path: " + taskSnapshot.getMetadata().getPath());
                            Log.d(LOG_TAG, "Bucket: " + taskSnapshot.getMetadata().getBucket());
                            Log.d(LOG_TAG, "Name: " + taskSnapshot.getMetadata().getName());
                            Log.d(LOG_TAG, "Bytes: " + taskSnapshot.getMetadata().getSizeBytes());
                            Log.d(LOG_TAG, "Download Url: " + taskSnapshot.getDownloadUrl());
                            Snackbar.make(view, "Upload Successful", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    });

                }else {
                    Toast.makeText(MainActivity.this, "Take a picture",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mImageView = (ImageView) findViewById(R.id.imageView);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            String email = "jkatzwhite@gmail.com", password = "addition";
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "signInWithEmail:success",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                //TODO: throw authentication failure cause
                                Log.w(LOG_TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageBitmap = resizeImage(imageBitmap);
//            imageBitmap.describeContents();
            Log.d(LOG_TAG, "Height: " + imageBitmap.getHeight() + " Width: " + imageBitmap.getWidth());
            Log.d(LOG_TAG, imageBitmap.getByteCount()/1000+" KB");
            Log.d(LOG_TAG, "Density: " + imageBitmap.getDensity());
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    Bitmap resizeImage(Bitmap imageBitmap){
        int width, height;
        float xTranslation, yTranslation, scale;
        float originalWidth = imageBitmap.getWidth();
        float originalHeight = imageBitmap.getHeight();

        if (originalHeight>originalWidth){
            height = 250;
            scale = height / originalHeight;
            width = Math.round(scale*originalWidth);
//            xTranslation = (width - originalWidth * scale) / 2.0f;
//            yTranslation = 0.0f;

        }else {
            width = 250;
            scale = width / originalWidth;
            height = Math.round(scale*originalHeight);
//            xTranslation = 0.0f;
//            yTranslation = (height - originalHeight * scale) / 2.0f;
        }

        Bitmap newImage = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(newImage);

        Matrix transformation = new Matrix();
//        transformation.postTranslate(xTranslation, yTranslation);
        transformation.preScale(scale, scale);

        Paint paint = new Paint();
        paint.setFilterBitmap(true);

        canvas.drawBitmap(imageBitmap, transformation, paint);

        return newImage;
    }
}
