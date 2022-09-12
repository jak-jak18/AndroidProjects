/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-09-26 19:19:48 UTC)
 * on 2017-10-03 at 22:26:37 UTC 
 * Modify at your own risk.
 */

package com.appspot.tastebudz.backend;

/**
 * Service definition for Backend (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link BackendRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Backend extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.23.0 of the backend library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "http://tastebudz.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "backend/v1/";

  /**
   * The default encoded batch path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.23
   */
  public static final String DEFAULT_BATCH_PATH = "batch";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Backend(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Backend(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the Menu collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Backend backend = new Backend(...);}
   *   {@code Backend.Menu.List request = backend.menu().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Menu menu() {
    return new Menu();
  }

  /**
   * The "menu" collection of methods.
   */
  public class Menu {

    /**
     * Create a request for the method "menu.displayItem".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link DisplayItem#execute()} method to invoke the remote operation.
     *
     * @param menuName
     * @return the request
     */
    public DisplayItem displayItem(java.lang.String menuName) throws java.io.IOException {
      DisplayItem result = new DisplayItem(menuName);
      initialize(result);
      return result;
    }

    public class DisplayItem extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzItem> {

      private static final String REST_PATH = "tastebudz/display_item/{menu_name}";

      /**
       * Create a request for the method "menu.displayItem".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link DisplayItem#execute()} method to invoke the remote operation. <p>
       * {@link
       * DisplayItem#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param menuName
       * @since 1.13
       */
      protected DisplayItem(java.lang.String menuName) {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzItem.class);
        this.menuName = com.google.api.client.util.Preconditions.checkNotNull(menuName, "Required parameter menuName must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public DisplayItem setAlt(java.lang.String alt) {
        return (DisplayItem) super.setAlt(alt);
      }

      @Override
      public DisplayItem setFields(java.lang.String fields) {
        return (DisplayItem) super.setFields(fields);
      }

      @Override
      public DisplayItem setKey(java.lang.String key) {
        return (DisplayItem) super.setKey(key);
      }

      @Override
      public DisplayItem setOauthToken(java.lang.String oauthToken) {
        return (DisplayItem) super.setOauthToken(oauthToken);
      }

      @Override
      public DisplayItem setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (DisplayItem) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public DisplayItem setQuotaUser(java.lang.String quotaUser) {
        return (DisplayItem) super.setQuotaUser(quotaUser);
      }

      @Override
      public DisplayItem setUserIp(java.lang.String userIp) {
        return (DisplayItem) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key("menu_name")
      private java.lang.String menuName;

      /**

       */
      public java.lang.String getMenuName() {
        return menuName;
      }

      public DisplayItem setMenuName(java.lang.String menuName) {
        this.menuName = menuName;
        return this;
      }

      @Override
      public DisplayItem set(String parameterName, Object value) {
        return (DisplayItem) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.getCourse".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link GetCourse#execute()} method to invoke the remote operation.
     *
     * @param menuName
     * @param courseName
     * @return the request
     */
    public GetCourse getCourse(java.lang.String menuName, java.lang.String courseName) throws java.io.IOException {
      GetCourse result = new GetCourse(menuName, courseName);
      initialize(result);
      return result;
    }

    public class GetCourse extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzItem> {

      private static final String REST_PATH = "tastebudz/{course_name}/{menu_name}";

      /**
       * Create a request for the method "menu.getCourse".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link GetCourse#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetCourse#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param menuName
       * @param courseName
       * @since 1.13
       */
      protected GetCourse(java.lang.String menuName, java.lang.String courseName) {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzItem.class);
        this.menuName = com.google.api.client.util.Preconditions.checkNotNull(menuName, "Required parameter menuName must be specified.");
        this.courseName = com.google.api.client.util.Preconditions.checkNotNull(courseName, "Required parameter courseName must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetCourse setAlt(java.lang.String alt) {
        return (GetCourse) super.setAlt(alt);
      }

      @Override
      public GetCourse setFields(java.lang.String fields) {
        return (GetCourse) super.setFields(fields);
      }

      @Override
      public GetCourse setKey(java.lang.String key) {
        return (GetCourse) super.setKey(key);
      }

      @Override
      public GetCourse setOauthToken(java.lang.String oauthToken) {
        return (GetCourse) super.setOauthToken(oauthToken);
      }

      @Override
      public GetCourse setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetCourse) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetCourse setQuotaUser(java.lang.String quotaUser) {
        return (GetCourse) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetCourse setUserIp(java.lang.String userIp) {
        return (GetCourse) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key("menu_name")
      private java.lang.String menuName;

      /**

       */
      public java.lang.String getMenuName() {
        return menuName;
      }

      public GetCourse setMenuName(java.lang.String menuName) {
        this.menuName = menuName;
        return this;
      }

      @com.google.api.client.util.Key("course_name")
      private java.lang.String courseName;

      /**

       */
      public java.lang.String getCourseName() {
        return courseName;
      }

      public GetCourse setCourseName(java.lang.String courseName) {
        this.courseName = courseName;
        return this;
      }

      @Override
      public GetCourse set(String parameterName, Object value) {
        return (GetCourse) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.getItem".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link GetItem#execute()} method to invoke the remote operation.
     *
     * @param itemName
     * @return the request
     */
    public GetItem getItem(java.lang.String itemName) throws java.io.IOException {
      GetItem result = new GetItem(itemName);
      initialize(result);
      return result;
    }

    public class GetItem extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzItem> {

      private static final String REST_PATH = "tastebudz/item/{item_name}";

      /**
       * Create a request for the method "menu.getItem".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link GetItem#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetItem#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param itemName
       * @since 1.13
       */
      protected GetItem(java.lang.String itemName) {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzItem.class);
        this.itemName = com.google.api.client.util.Preconditions.checkNotNull(itemName, "Required parameter itemName must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetItem setAlt(java.lang.String alt) {
        return (GetItem) super.setAlt(alt);
      }

      @Override
      public GetItem setFields(java.lang.String fields) {
        return (GetItem) super.setFields(fields);
      }

      @Override
      public GetItem setKey(java.lang.String key) {
        return (GetItem) super.setKey(key);
      }

      @Override
      public GetItem setOauthToken(java.lang.String oauthToken) {
        return (GetItem) super.setOauthToken(oauthToken);
      }

      @Override
      public GetItem setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetItem) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetItem setQuotaUser(java.lang.String quotaUser) {
        return (GetItem) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetItem setUserIp(java.lang.String userIp) {
        return (GetItem) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key("item_name")
      private java.lang.String itemName;

      /**

       */
      public java.lang.String getItemName() {
        return itemName;
      }

      public GetItem setItemName(java.lang.String itemName) {
        this.itemName = itemName;
        return this;
      }

      @Override
      public GetItem set(String parameterName, Object value) {
        return (GetItem) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.getMenu".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link GetMenu#execute()} method to invoke the remote operation.
     *
     * @param menuName
     * @return the request
     */
    public GetMenu getMenu(java.lang.String menuName) throws java.io.IOException {
      GetMenu result = new GetMenu(menuName);
      initialize(result);
      return result;
    }

    public class GetMenu extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzItem> {

      private static final String REST_PATH = "tastebudz/{menu_name}";

      /**
       * Create a request for the method "menu.getMenu".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link GetMenu#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetMenu#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param menuName
       * @since 1.13
       */
      protected GetMenu(java.lang.String menuName) {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzItem.class);
        this.menuName = com.google.api.client.util.Preconditions.checkNotNull(menuName, "Required parameter menuName must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetMenu setAlt(java.lang.String alt) {
        return (GetMenu) super.setAlt(alt);
      }

      @Override
      public GetMenu setFields(java.lang.String fields) {
        return (GetMenu) super.setFields(fields);
      }

      @Override
      public GetMenu setKey(java.lang.String key) {
        return (GetMenu) super.setKey(key);
      }

      @Override
      public GetMenu setOauthToken(java.lang.String oauthToken) {
        return (GetMenu) super.setOauthToken(oauthToken);
      }

      @Override
      public GetMenu setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetMenu) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetMenu setQuotaUser(java.lang.String quotaUser) {
        return (GetMenu) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetMenu setUserIp(java.lang.String userIp) {
        return (GetMenu) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key("menu_name")
      private java.lang.String menuName;

      /**

       */
      public java.lang.String getMenuName() {
        return menuName;
      }

      public GetMenu setMenuName(java.lang.String menuName) {
        this.menuName = menuName;
        return this;
      }

      @Override
      public GetMenu set(String parameterName, Object value) {
        return (GetMenu) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.getMenuInfo".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link GetMenuInfo#execute()} method to invoke the remote operation.
     *
     * @param menuName
     * @return the request
     */
    public GetMenuInfo getMenuInfo(java.lang.String menuName) throws java.io.IOException {
      GetMenuInfo result = new GetMenuInfo(menuName);
      initialize(result);
      return result;
    }

    public class GetMenuInfo extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzMenuCollection> {

      private static final String REST_PATH = "tastebudz/info/{menu_name}";

      /**
       * Create a request for the method "menu.getMenuInfo".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link GetMenuInfo#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetMenuInfo#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param menuName
       * @since 1.13
       */
      protected GetMenuInfo(java.lang.String menuName) {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzMenuCollection.class);
        this.menuName = com.google.api.client.util.Preconditions.checkNotNull(menuName, "Required parameter menuName must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetMenuInfo setAlt(java.lang.String alt) {
        return (GetMenuInfo) super.setAlt(alt);
      }

      @Override
      public GetMenuInfo setFields(java.lang.String fields) {
        return (GetMenuInfo) super.setFields(fields);
      }

      @Override
      public GetMenuInfo setKey(java.lang.String key) {
        return (GetMenuInfo) super.setKey(key);
      }

      @Override
      public GetMenuInfo setOauthToken(java.lang.String oauthToken) {
        return (GetMenuInfo) super.setOauthToken(oauthToken);
      }

      @Override
      public GetMenuInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetMenuInfo) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetMenuInfo setQuotaUser(java.lang.String quotaUser) {
        return (GetMenuInfo) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetMenuInfo setUserIp(java.lang.String userIp) {
        return (GetMenuInfo) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key("menu_name")
      private java.lang.String menuName;

      /**

       */
      public java.lang.String getMenuName() {
        return menuName;
      }

      public GetMenuInfo setMenuName(java.lang.String menuName) {
        this.menuName = menuName;
        return this;
      }

      @Override
      public GetMenuInfo set(String parameterName, Object value) {
        return (GetMenuInfo) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.listMenu".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link ListMenu#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public ListMenu listMenu() throws java.io.IOException {
      ListMenu result = new ListMenu();
      initialize(result);
      return result;
    }

    public class ListMenu extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzMenuCollection> {

      private static final String REST_PATH = "tastebudz";

      /**
       * Create a request for the method "menu.listMenu".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link ListMenu#execute()} method to invoke the remote operation. <p>
       * {@link
       * ListMenu#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected ListMenu() {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzMenuCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public ListMenu setAlt(java.lang.String alt) {
        return (ListMenu) super.setAlt(alt);
      }

      @Override
      public ListMenu setFields(java.lang.String fields) {
        return (ListMenu) super.setFields(fields);
      }

      @Override
      public ListMenu setKey(java.lang.String key) {
        return (ListMenu) super.setKey(key);
      }

      @Override
      public ListMenu setOauthToken(java.lang.String oauthToken) {
        return (ListMenu) super.setOauthToken(oauthToken);
      }

      @Override
      public ListMenu setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (ListMenu) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public ListMenu setQuotaUser(java.lang.String quotaUser) {
        return (ListMenu) super.setQuotaUser(quotaUser);
      }

      @Override
      public ListMenu setUserIp(java.lang.String userIp) {
        return (ListMenu) super.setUserIp(userIp);
      }

      @Override
      public ListMenu set(String parameterName, Object value) {
        return (ListMenu) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.listOrders".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link ListOrders#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public ListOrders listOrders() throws java.io.IOException {
      ListOrders result = new ListOrders();
      initialize(result);
      return result;
    }

    public class ListOrders extends BackendRequest<com.appspot.tastebudz.backend.model.TastebudzOrderMessage> {

      private static final String REST_PATH = "tastebudz/orderlist";

      /**
       * Create a request for the method "menu.listOrders".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link ListOrders#execute()} method to invoke the remote operation. <p>
       * {@link
       * ListOrders#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected ListOrders() {
        super(Backend.this, "GET", REST_PATH, null, com.appspot.tastebudz.backend.model.TastebudzOrderMessage.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public ListOrders setAlt(java.lang.String alt) {
        return (ListOrders) super.setAlt(alt);
      }

      @Override
      public ListOrders setFields(java.lang.String fields) {
        return (ListOrders) super.setFields(fields);
      }

      @Override
      public ListOrders setKey(java.lang.String key) {
        return (ListOrders) super.setKey(key);
      }

      @Override
      public ListOrders setOauthToken(java.lang.String oauthToken) {
        return (ListOrders) super.setOauthToken(oauthToken);
      }

      @Override
      public ListOrders setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (ListOrders) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public ListOrders setQuotaUser(java.lang.String quotaUser) {
        return (ListOrders) super.setQuotaUser(quotaUser);
      }

      @Override
      public ListOrders setUserIp(java.lang.String userIp) {
        return (ListOrders) super.setUserIp(userIp);
      }

      @Override
      public ListOrders set(String parameterName, Object value) {
        return (ListOrders) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "menu.orderItem".
     *
     * This request holds the parameters needed by the backend server.  After setting any optional
     * parameters, call the {@link OrderItem#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.appspot.tastebudz.backend.model.TastebudzOrderMessage}
     * @return the request
     */
    public OrderItem orderItem(com.appspot.tastebudz.backend.model.TastebudzOrderMessage content) throws java.io.IOException {
      OrderItem result = new OrderItem(content);
      initialize(result);
      return result;
    }

    public class OrderItem extends BackendRequest<Void> {

      private static final String REST_PATH = "tastebudz";

      /**
       * Create a request for the method "menu.orderItem".
       *
       * This request holds the parameters needed by the the backend server.  After setting any optional
       * parameters, call the {@link OrderItem#execute()} method to invoke the remote operation. <p>
       * {@link
       * OrderItem#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.appspot.tastebudz.backend.model.TastebudzOrderMessage}
       * @since 1.13
       */
      protected OrderItem(com.appspot.tastebudz.backend.model.TastebudzOrderMessage content) {
        super(Backend.this, "POST", REST_PATH, content, Void.class);
      }

      @Override
      public OrderItem setAlt(java.lang.String alt) {
        return (OrderItem) super.setAlt(alt);
      }

      @Override
      public OrderItem setFields(java.lang.String fields) {
        return (OrderItem) super.setFields(fields);
      }

      @Override
      public OrderItem setKey(java.lang.String key) {
        return (OrderItem) super.setKey(key);
      }

      @Override
      public OrderItem setOauthToken(java.lang.String oauthToken) {
        return (OrderItem) super.setOauthToken(oauthToken);
      }

      @Override
      public OrderItem setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (OrderItem) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public OrderItem setQuotaUser(java.lang.String quotaUser) {
        return (OrderItem) super.setQuotaUser(quotaUser);
      }

      @Override
      public OrderItem setUserIp(java.lang.String userIp) {
        return (OrderItem) super.setUserIp(userIp);
      }

      @Override
      public OrderItem set(String parameterName, Object value) {
        return (OrderItem) super.set(parameterName, value);
      }
    }

  }

  /**
   * Builder for {@link Backend}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Backend}. */
    @Override
    public Backend build() {
      return new Backend(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link BackendRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setBackendRequestInitializer(
        BackendRequestInitializer backendRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(backendRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}