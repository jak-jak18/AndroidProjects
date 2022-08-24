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
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-22 at 08:04:00 UTC 
 * Modify at your own risk.
 */

package com.example.justin.cloud_example4;

/**
 * Collection of Greetings.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the helloworld. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class HelloGreetingCollection extends com.google.api.client.json.GenericJson {

  /**
   * Greeting that stores a message.
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<HelloGreeting> items;

  static {
    // hack to force ProGuard to consider HelloGreeting used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(HelloGreeting.class);
  }

  /**
   * Greeting that stores a message.
   * @return value or {@code null} for none
   */
  public java.util.List<HelloGreeting> getItems() {
    return items;
  }

  /**
   * Greeting that stores a message.
   * @param items items or {@code null} for none
   */
  public HelloGreetingCollection setItems(java.util.List<HelloGreeting> items) {
    this.items = items;
    return this;
  }

  @Override
  public HelloGreetingCollection set(String fieldName, Object value) {
    return (HelloGreetingCollection) super.set(fieldName, value);
  }

  @Override
  public HelloGreetingCollection clone() {
    return (HelloGreetingCollection) super.clone();
  }

}
