/* Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devrel.samples.helloendpoints;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.appspot.blobstore.helloworld.Helloworld;
//import com.appspot.blobstore.helloworld.Helloworld.Greetings.Authed;
import com.appspot.blobstore.helloworld.Helloworld.Greetings.GetGreeting;
import com.appspot.blobstore.helloworld.Helloworld.Greetings.ListGreeting;
import com.appspot.blobstore.helloworld.Helloworld.Greetings.Multiply;
import com.appspot.blobstore.helloworld.model.HelloGreeting;
import com.appspot.blobstore.helloworld.model.HelloGreetingCollection;
//import com.google.api.client.http.HttpResponse;
import com.google.common.base.Strings;
import com.appspot.blobstore.helloworld.Helloworld.Greetings.Images;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.net.URL;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import com.google.devrel.samples.helloendpoints.R.id;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import static com.google.devrel.samples.helloendpoints.BuildConfig.DEBUG;

/**
 * Sample Android application for the Hello World tutorial for Google Cloud Endpoints. The sample
 * code shows many of the better practices described in the links below.
 *
 * @see <a href="https://developers.google.com/appengine/docs/java/endpoints">https://developers.google.com/appengine/docs/java/endpoints</a>
 * @see <a href="https://developers.google.com/appengine/docs/java/endpoints/consume_android">https://developers.google.com/appengine/docs/java/endpoints/consume_android</a>
 *
 */
public class MainActivity extends Activity {
  private static final String LOG_TAG = "MainActivity";

  /**
   * Activity result indicating a return from the Google account selection intent.
   */
  private static final int ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION = 2222;

  private AuthorizationCheckTask mAuthTask;
  private String mEmailAccount = "";
  private GreetingsDataAdapter listAdapter;
  private Bitmap image;
  private Bitmap imageCollection [] = new Bitmap[3];
  int i;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Prevent the keyboard from being visible upon startup.
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    ListView listView = (ListView)this.findViewById(R.id.greetings_list_view);
    listAdapter = new GreetingsDataAdapter((Application)this.getApplication());
    listView.setAdapter(listAdapter);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (mAuthTask!=null) {
      mAuthTask.cancel(true);
      mAuthTask = null;
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION && resultCode == RESULT_OK) {
      // This path indicates the account selection activity resulted in the user selecting a
      // Google account and clicking OK.

      // Set the selected account.
      String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
      TextView emailAccountTextView = (TextView)this.findViewById(id.email_address_tv);
      emailAccountTextView.setText(accountName);

      // Fire off the authorization check for this account and OAuth2 scopes.
      performAuthCheck(accountName);
    }
  }

  private boolean isSignedIn() {
    if (!Strings.isNullOrEmpty(mEmailAccount)) {
      return true;
    } else {
      return false;
    }
  }

  public void onClickGetImage(View unused) {
    //String address = "http://192.168.0.100:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==";
      String address0 = "http://images.nitrosell.com/product_images/6/1339/whitefish_bakedsalmon_salad.jpg";
      String address1 = "http://blogs.plos.org/obesitypanacea/files/2014/10/sandwich.jpg";
      String address2 = "http://cdn.swide.com/binaries/content/gallery/legacy/2011/4/23/colors/inside/colors_inside_01.jpg";
      String addressCollection [] = {address0, address1, address2};

    for (i =0; i < addressCollection.length; i++) {
      try {
        image = new ImageFetch().execute(addressCollection[i]).get();
        imageCollection[i]= image;
      } catch (CancellationException e) {
        Log.e(LOG_TAG, "Task Cancelled", e);
      } catch (ExecutionException e) {
        Log.e(LOG_TAG, "Somethin happened here", e);
      } catch (InterruptedException e) {
        Log.e(LOG_TAG, "Got interrupeted", e);
      }
    }

    if(image != null){
      setContentView(R.layout.test);
      LinearLayout view = (LinearLayout) findViewById(R.id.test);
      ImageView imageView = new ImageView(this);

      for (i=0; i<1; i++){
        imageView.setImageBitmap(imageCollection[i]);
        view.addView(imageView);
//        imageView.setImageBitmap(null);
      }

    }else{
      Toast.makeText(this, "Image is empty :(", Toast.LENGTH_SHORT).show();
    }



    /**AsyncTask<String, Void, Bitmap> getAndDisplayImage =
            new AsyncTask<String, Void, Bitmap> () {
              @Override
              protected Bitmap doInBackground(String... address) {
                try {
                  URL url = new URL(address[0]);
                  HttpGet httpRequest = null;

                  httpRequest = new HttpGet(url.toURI());

                  HttpClient httpclient = new DefaultHttpClient();
                  HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);

                  HttpEntity entity = response.getEntity();
                  BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
                  InputStream input = bufHttpEntity.getContent();

                  Bitmap image = BitmapFactory.decodeStream(input);

                  input.close();
                  return image;

                } catch (MalformedURLException e) {
                  Log.e(LOG_TAG, "bad url", e);
                } catch (Exception e) {
                  Log.e(LOG_TAG, "io error", e);
                }
                return null;
              }

              @Override
              protected void onPostExecute(Bitmap image) {
                if (image!=null) {
                  setContentView(R.layout.test);
                  ImageView view1 = (ImageView) findViewById(R.id.imageView);
                  view1.setImageBitmap(image);
                } else {
                  Log.e(LOG_TAG, "No images were returned :(");
                }
              }
            };

    getAndDisplayImage.execute(address);
     */

    /**try {
      URL url = new URL(address);
      HttpGet httpRequest = null;

      httpRequest = new HttpGet(url.toURI());

      HttpClient httpclient = new DefaultHttpClient();
      HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);

      HttpEntity entity = response.getEntity();
      BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
      InputStream input = bufHttpEntity.getContent();

      Bitmap image = BitmapFactory.decodeStream(input);

      input.close();

      setContentView(R.layout.test);
      ImageView view1 = (ImageView) findViewById(R.id.imageView);
      view1.setImageBitmap(image);

    } catch (MalformedURLException e) {
      Log.e(LOG_TAG, "bad url", e);
    } catch (Exception e) {
      Log.e(LOG_TAG, "io error", e);
    }*/

    /** try {
      URL url = new URL (address);
    } catch (Exception e) {
      Log.e(LOG_TAG, " URL Not workin yet :(");
    }*/
    /**
    try {
      URL url = new URL (address);
      InputStream input_data = url.openStream();
      image = BitmapFactory.decodeStream(input_data);
      input_data.close();
    } catch (Exception e) {
      Log.e(LOG_TAG, "Input Stream Not workin yet :(");
    }
    */
    /**try {
      URL url = new URL (address);
      HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
      urlConn.connect();
      InputStream input_data = urlConn.getInputStream();
      image = BitmapFactory.decodeStream(input_data);
      urlConn.disconnect();
    } catch (Exception e) {
      Log.e(LOG_TAG, "Input Stream Not workin yet :(");
    }*/

  /**
    setContentView(R.layout.test);
    ImageView view1 = (ImageView) findViewById(R.id.imageView);
    view1.setImageBitmap(image);
  */
    /** address = "http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==";
    URL url = new URL ("http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==")
    setContentView(R.layout.test);
    ImageView view1 = (ImageView) findViewById(R.id.imageView);
    URL url = URL(address);
    view1.setImageBitmap(GetImage(url));

  //public URL URL (String address){
    //URL url = URL (address);
    //return url;
  //}

    public Bitmap GetImage(URL url) {

      try {
        InputStream input_data = url.openStream();
        image = BitmapFactory.decodeStream(input_data);
      } catch (Exception e) {
        Log.e("Error", e.getMessage());

      }
      return image;
    }
  }*/

    /**
  DefaultHttpClient httpClient = new DefaultHttpClient();
  HttpGet request = new HttpGet("http://0.0.0.0:8080/_ah/img/WhBGhpJ3zia4xzq40b9mFw==");
  HttpResponse response = httpClient.execute(request);
  */

   /** AsyncTask<Void, Void, BitmapDrawable> getAndDisplayGreeting =
            new AsyncTask<Void, Void, BitmapDrawable> () {
              @Override
              protected BitmapDrawable doInBackground(Void... unused) {
                Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(null);

                try {
                  Images getGreetingCommand = apiServiceHandle.greetings().images();
                  BitmapDrawable image = getGreetingCommand.execute();
                  return image;
                } catch (IOException e) {
                  Log.e(LOG_TAG, "Exception during API call", e);
                }
                return null;
              }

              @Override
              protected void onPostExecute(BitmapDrawable image) {
                if (image!=null) {
                  displayImages(image);
                } else {
                  Log.e(LOG_TAG, "No image was returned by the API.");
                }
              }
            };

    getAndDisplayGreeting.execute((Void)null);
    */
  }

  /**private void displayImages(BitmapDrawable... images) {
    String msg;
    if (image==null) {
      msg = "Image not present";
      Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    } else {
      setContentView(R.layout.test);
      ImageView view1 = (ImageView) findViewById(R.id.imageView);
      //Drawable new_image = (Drawable) getResources().getDrawable(R.drawable.up);
      view1.setImageDrawable(image);
    }
  }*/

  /**
   * This method is invoked when the "Get Greeting" button is clicked. See activity_main.xml for
   * the dynamic reference to this method.
   */
  public void onClickGetGreeting(View view) {
    View rootView = view.getRootView();
    TextView greetingIdInputTV = (TextView)rootView.findViewById(R.id.greeting_id_edit_text);
    if (greetingIdInputTV.getText()==null ||
        Strings.isNullOrEmpty(greetingIdInputTV.getText().toString())) {
      Toast.makeText(this, "Input a Greeting ID", Toast.LENGTH_SHORT).show();
      return;
    };

    String greetingIdString = greetingIdInputTV.getText().toString();
    int greetingId = Integer.parseInt(greetingIdString);

    // Use of an anonymous class is done for sample code simplicity. {@code AsyncTasks} should be
    // static-inner or top-level classes to prevent memory leak issues.
    // @see http://goo.gl/fN1fuE @26:00 for an great explanation.
    AsyncTask<Integer, Void, HelloGreeting> getAndDisplayGreeting =
        new AsyncTask<Integer, Void, HelloGreeting> () {
          @Override
          protected HelloGreeting doInBackground(Integer... integers) {
            // Retrieve service handle using null credential since this is an unauthenticated call.
            Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(null);

            try {
              GetGreeting getGreetingCommand = apiServiceHandle.greetings().getGreeting(integers[0]);
              HelloGreeting greeting = getGreetingCommand.execute();
              return greeting;
            } catch (IOException e) {
              Log.e(LOG_TAG, "Exception during API call", e);
            }
            return null;
          }

          @Override
          protected void onPostExecute(HelloGreeting greeting) {
            if (greeting!=null) {
              displayGreetings(greeting);
            } else {
              Log.e(LOG_TAG, "No greetings were returned by the API.");
            }
          }
        };

    getAndDisplayGreeting.execute(greetingId);
  }

  /**
   * This method is invoked when the "List Greetings" button is clicked. See activity_main.xml for
   * the dynamic reference to this method.
   */
  public void onClickListGreetings(View unused) {

    // Use of an anonymous class is done for sample code simplicity. {@code AsyncTasks} should be
    // static-inner or top-level classes to prevent memory leak issues.
    // @see http://goo.gl/fN1fuE @26:00 for an great explanation.
    AsyncTask<Void, Void, HelloGreetingCollection> getAndDisplayGreeting =
        new AsyncTask<Void, Void, HelloGreetingCollection> () {
          @Override
          protected HelloGreetingCollection doInBackground(Void... unused) {
            // Retrieve service handle using null credential since this is an unauthenticated call.
            Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(null);

            try {
              ListGreeting getGreetingCommand = apiServiceHandle.greetings().listGreeting();
              HelloGreetingCollection greeting = getGreetingCommand.execute();
              return greeting;
            } catch (IOException e) {
              Log.e(LOG_TAG, "Exception during API call", e);
            }
            return null;
          }

          @Override
          protected void onPostExecute(HelloGreetingCollection greeting) {
            if (greeting!=null && greeting.getItems()!=null) {
              displayGreetings(greeting.getItems().toArray(new HelloGreeting[] {}));
            } else {
              Log.e(LOG_TAG, "No greetings were returned by the API.");
            }
          }
        };

    getAndDisplayGreeting.execute((Void)null);
  }

  /**
   * This method is invoked when the "Multiply Greeting" button is clicked. See activity_main.xml
   * for the dynamic reference to this method.
   */
  public void onClickSendGreetings(View view) {
    View rootView = view.getRootView();

    TextView greetingCountInputTV = (TextView)rootView.findViewById(id.greeting_count_edit_text);
    if (greetingCountInputTV.getText()==null ||
        Strings.isNullOrEmpty(greetingCountInputTV.getText().toString())) {
      Toast.makeText(this, "Input a Greeting Count", Toast.LENGTH_SHORT).show();
      return;
    };

    String greetingCountString = greetingCountInputTV.getText().toString();
    final int greetingCount = Integer.parseInt(greetingCountString);

    TextView greetingTextInputTV = (TextView)rootView.findViewById(id.greeting_text_edit_text);
    if (greetingTextInputTV.getText()==null ||
        Strings.isNullOrEmpty(greetingTextInputTV.getText().toString())) {
      Toast.makeText(this, "Input a Greeting Message", Toast.LENGTH_SHORT).show();
      return;
    };

    final String greetingMessageString = greetingTextInputTV.getText().toString();

    // Use of an anonymous class is done for sample code simplicity. {@code AsyncTasks} should be
    // static-inner or top-level classes to prevent memory leak issues.
    // @see http://goo.gl/fN1fuE @26:00 for an great explanation.
    AsyncTask<Void, Void, HelloGreeting> sendGreetings = new AsyncTask<Void, Void, HelloGreeting> () {
      @Override
      protected HelloGreeting doInBackground(Void... unused) {
        // Retrieve service handle using null credential since this is an unauthenticated call.
        Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(null);

        try {
          HelloGreeting greeting = new HelloGreeting();
          greeting.setMessage(greetingMessageString);

          Multiply multiplyGreetingCommand = apiServiceHandle.greetings().multiply(greetingCount,
                  greeting);
          greeting = multiplyGreetingCommand.execute();
          return greeting;
        } catch (IOException e) {
          Log.e(LOG_TAG, "Exception during API call", e);
        }
        return null;
      }

      @Override
      protected void onPostExecute(HelloGreeting greeting) {
        if (greeting!=null) {
          displayGreetings(greeting);
        } else {
          Log.e(LOG_TAG, "No greetings were returned by the API.");
        }
      }
    };

    sendGreetings.execute((Void)null);
  }

  /**
   * This method is invoked when the "Get Authenticated Greeting" button is clicked. See
   * activity_main.xml for the dynamic reference to this method.
   */
  /**public void onClickGetAuthenticatedGreeting(View unused) {
    if (!isSignedIn()) {
      Toast.makeText(this, "You must sign in for this action.", Toast.LENGTH_LONG).show();
      return;
    }

    // Use of an anonymous class is done for sample code simplicity. {@code AsyncTasks} should be
    // static-inner or top-level classes to prevent memory leak issues.
    // @see http://goo.gl/fN1fuE @26:00 for an great explanation.
    AsyncTask<Void, Void, HelloGreeting> getAuthedGreetingAndDisplay =
        new AsyncTask<Void, Void, HelloGreeting> () {
          @Override
          protected HelloGreeting doInBackground(Void... unused) {
            if (!isSignedIn()) {
              return null;
            };

            if (!AppConstants.checkGooglePlayServicesAvailable(MainActivity.this)) {
              return null;
            }

            // Create a Google credential since this is an authenticated request to the API.
            GoogleAccountCredential credential = GoogleAccountCredential.usingAudience(
                MainActivity.this, AppConstants.AUDIENCE);
            credential.setSelectedAccountName(mEmailAccount);

            // Retrieve service handle using credential since this is an authenticated call.
            Helloworld apiServiceHandle = AppConstants.getApiServiceHandle(credential);

            try {
              Authed getAuthedGreetingCommand = apiServiceHandle.greetings().authed();
              HelloGreeting greeting = getAuthedGreetingCommand.execute();
              return greeting;
            } catch (IOException e) {
              Log.e(LOG_TAG, "Exception during API call", e);
            }
            return null;
          }

          @Override
          protected void onPostExecute(HelloGreeting greeting) {
            if (greeting!=null) {
              displayGreetings(greeting);
            } else {
              Log.e(LOG_TAG, "No greetings were returned by the API.");
            }
          }
        };

    getAuthedGreetingAndDisplay.execute((Void)null);
  }*/

  private void displayGreetings(HelloGreeting... greetings) {
    String msg;
    if (greetings==null || greetings.length < 1) {
      msg = "Greeting was not present";
      Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    } else {
      if (DEBUG) {
        Log.d(LOG_TAG, "Displaying " + greetings.length + " greetings.");
      }

      List<HelloGreeting> greetingsList = Arrays.asList(greetings);
      listAdapter.replaceData(greetings);
    }
  }

  /**
   * This method is invoked when the "Sign In" button is clicked. See activity_main.xml for the
   * dynamic reference to this method.
   */
  public void onClickSignIn(View view) {
    TextView emailAddressTV = (TextView) view.getRootView().findViewById(id.email_address_tv);
    // Check to see how many Google accounts are registered with the device.
    int googleAccounts = AppConstants.countGoogleAccounts(this);
    if (googleAccounts == 0) {
      // No accounts registered, nothing to do.
      Toast.makeText(this, R.string.toast_no_google_accounts_registered,
          Toast.LENGTH_LONG).show();
    } else if (googleAccounts == 1) {
      // If only one account then select it.
      Toast.makeText(this, R.string.toast_only_one_google_account_registered,
          Toast.LENGTH_LONG).show();
      AccountManager am = AccountManager.get(this);
      Account[] accounts = am.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
      if (accounts != null && accounts.length > 0) {
        // Select account and perform authorization check.
        emailAddressTV.setText(accounts[0].name);
        mEmailAccount = accounts[0].name;
        performAuthCheck(accounts[0].name);
      }
    } else {
      // More than one Google Account is present, a chooser is necessary.

      // Reset selected account.
      emailAddressTV.setText("");

      // Invoke an {@code Intent} to allow the user to select a Google account.
      Intent accountSelector = AccountPicker.newChooseAccountIntent(null, null,
          new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE}, false,
          "Select the account to access Google Compute Engine API.", null, null, null);
      startActivityForResult(accountSelector,
          ACTIVITY_RESULT_FROM_ACCOUNT_SELECTION);
    }

  }

  /**
   * Schedule the authorization check in an {@code Tasks}.
   */
  public void performAuthCheck(String emailAccount) {
    // Cancel previously running tasks.
    if (mAuthTask != null) {
      try {
        mAuthTask.cancel(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return;
    }

    // Start task to check authorization.
    mAuthTask = new AuthorizationCheckTask();
    mAuthTask.execute(emailAccount);
  }

  /**
   * Verifies OAuth2 token access for the application and Google account combination with
   * the {@code AccountManager} and the Play Services installed application. If the appropriate
   * OAuth2 access hasn't been granted (to this application) then the task may fire an
   * {@code Intent} to request that the user approve such access. If the appropriate access does
   * exist then the button that will let the user proceed to the next activity is enabled.
   */
  class AuthorizationCheckTask extends AsyncTask<String, Integer, Boolean> {
    @Override
    protected Boolean doInBackground(String... emailAccounts) {
      Log.i(LOG_TAG, "Background task started.");

      if (!AppConstants.checkGooglePlayServicesAvailable(MainActivity.this)) {
        return false;
      }

      String emailAccount = emailAccounts[0];
      // Ensure only one task is running at a time.
      mAuthTask = this;

      // Ensure an email was selected.
      if (Strings.isNullOrEmpty(emailAccount)) {
        publishProgress(R.string.toast_no_google_account_selected);
        // Failure.
        return false;
      }

      if (DEBUG) {
        Log.d(LOG_TAG, "Attempting to get AuthToken for account: " + mEmailAccount);
      }

      try {
        // If the application has the appropriate access then a token will be retrieved, otherwise
        // an error will be thrown.
        GoogleAccountCredential credential = GoogleAccountCredential.usingAudience(
            MainActivity.this, AppConstants.AUDIENCE);
        credential.setSelectedAccountName(emailAccount);

        String accessToken = credential.getToken();

        if (DEBUG) {
          Log.d(LOG_TAG, "AccessToken retrieved");
        }

        // Success.
        return true;
      } catch (GoogleAuthException unrecoverableException) {
        Log.e(LOG_TAG, "Exception checking OAuth2 authentication.", unrecoverableException);
        publishProgress(R.string.toast_exception_checking_authorization);
        // Failure.
        return false;
      } catch (IOException ioException) {
        Log.e(LOG_TAG, "Exception checking OAuth2 authentication.", ioException);
        publishProgress(R.string.toast_exception_checking_authorization);
        // Failure or cancel request.
        return false;
      }
    }

    @Override
    protected void onProgressUpdate(Integer... stringIds) {
      // Toast only the most recent.
      Integer stringId = stringIds[0];
      Toast.makeText(MainActivity.this, stringId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPreExecute() {
      mAuthTask = this;
    }

    @Override
    protected void onPostExecute(Boolean success) {
      TextView emailAddressTV = (TextView) MainActivity.this.findViewById(id.email_address_tv);
      if (success) {
        // Authorization check successful, set internal variable.
        mEmailAccount = emailAddressTV.getText().toString();
      } else {
        // Authorization check unsuccessful, reset TextView to empty.
        emailAddressTV.setText("");
      }
      mAuthTask = null;
    }

    @Override
    protected void onCancelled() {
      mAuthTask = null;
    }
  }

  /**
   * Simple use of an ArrayAdapter but we're using a static class to ensure no references to the
   * Activity exists.
   */
  static class GreetingsDataAdapter extends ArrayAdapter {
    GreetingsDataAdapter(Application application) {
      super(application.getApplicationContext(), android.R.layout.simple_list_item_1,
          application.greetings);
    }

    void replaceData(HelloGreeting[] greetings) {
      clear();
      for (HelloGreeting greeting : greetings) {
        add(greeting);
      }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      TextView view = (TextView)super.getView(position, convertView, parent);

      HelloGreeting greeting = (HelloGreeting)this.getItem(position);

      StringBuilder sb = new StringBuilder();

      Set<String> fields = greeting.keySet();
      boolean firstLoop = true;
      for (String fieldName : fields) {
        // Append next line chars to 2.. loop runs.
        if (firstLoop) {
          firstLoop = false;
        } else {
          sb.append("\n");
        }

        sb.append(fieldName)
          .append(": ")
          .append(greeting.get(fieldName));
      }

      view.setText(sb.toString());
      return view;
    }
  }
}
