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

package com.my.tester_frameworks2;

import com.appspot.example_88523.backend.Backend;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

import javax.annotation.Nullable;

/**
 * Application constants and simple utilities.
 */
public class AppConstants {
  /**
   * Your WEB CLIENT ID from the API Access screen of the Developer Console for your project. This
   * is NOT the Android client id from that screen.
   *
   * @see <a href="https://developers.google.com/console">https://developers.google.com/console</a>
   */
  public static final String WEB_CLIENT_ID = "your_web_client_id";

  /**
   * The audience is defined by the web client id, not the Android client id.
   */
  public static final String AUDIENCE = "server:client_id:" + WEB_CLIENT_ID;

  /**
   * Class instance of the JSON factory.
   */
  public static final JsonFactory JSON_FACTORY = new AndroidJsonFactory();

  /**
   * Class instance of the HTTP transport.
   */
  public static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();

  public static String base;
  static Boolean datastore = true;

  public static void setServer(String selection){
    if(selection.equals("cloud")){
      datastore = true;
    }else{
//      Log.d("AppConstants", "Setting base");
      base = selection;
      datastore = false;
    }
  }

  public static Backend getApiServiceHandle(@Nullable GoogleAccountCredential credential) {
    Backend.Builder tastebudz = new Backend.Builder(AppConstants.HTTP_TRANSPORT,
        AppConstants.JSON_FACTORY, credential);
    if (datastore){
      tastebudz.setRootUrl("https://example-88523.appspot.com/_ah/api/");
//      tastebudz.setRootUrl("https://example-88523.appspot.com/_ah/api/");
    }else {
      tastebudz.setRootUrl("http://192.168." + base + ":8080/_ah/api/");
    }
    return tastebudz.build();
  }
}
