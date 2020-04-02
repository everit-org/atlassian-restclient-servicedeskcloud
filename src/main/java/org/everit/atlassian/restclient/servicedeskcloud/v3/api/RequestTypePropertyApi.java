/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
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
package org.everit.atlassian.restclient.servicedeskcloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.EntityProperty;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestTypePropertyApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PropertyKeys> returnType_getPropertiesKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<EntityProperty> returnType_getProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<Object> returnType_setProperty = new TypeReference<Object>() {};

  private final RestClient restClient;

  public RequestTypePropertyApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete property
   * <p>Removes a property from a request type.</p> <p>Properties for a Request Type in next-gen are stored as Issue Type properties and therefore can also be deleted by calling the Jira Cloud Platform <a href=\"https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issuetype-issueTypeId-properties-propertyKey-delete\">Delete issue type property</a> endpoint.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Jira project administrator with a Jira Service Desk agent license.</p> 
   * @param serviceDeskId <p>The ID of the service desk which contains the request type. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeId <p>The ID of the request type for which the property will be removed.</p>  (required)
   * @param propertyKey <p>The key of the property to remove.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteProperty(
    Integer serviceDeskId, Integer requestTypeId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get properties keys
   * <p>Returns the keys of all properties for a request type.</p> <p>Properties for a Request Type in next-gen are stored as Issue Type properties and therefore the keys of all properties for a request type are also available by calling the Jira Cloud Platform <a href=\"https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issuetype-issueTypeId-properties-get\">Get issue type property keys</a> endpoint.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: The user must have permission to view the request type.</p> 
   * @param requestTypeId <p>The ID of the request type for which keys will be retrieved.</p>  (required)
   * @param serviceDeskId <p>The ID of the service desk which contains the request type. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getPropertiesKeys(
    Integer requestTypeId, Integer serviceDeskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/property");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPropertiesKeys);
  }

  /**
   * Get property
   * <p>Returns the value of the property from a request type.</p> <p>Properties for a Request Type in next-gen are stored as Issue Type properties and therefore also available by calling the Jira Cloud Platform <a href=\"https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issuetype-issueTypeId-properties-propertyKey-get\">Get issue type property</a> endpoint.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User must have permission to view the request type.</p> 
   * @param serviceDeskId <p>The ID of the service desk which contains the request type. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeId <p>The ID of the request type from which the property will be retrieved.</p>  (required)
   * @param propertyKey <p>The key of the property to return.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getProperty(
    Integer serviceDeskId, Integer requestTypeId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProperty);
  }

  /**
   * Set property
   * <p>Sets the value of a request type property. Use this resource to store custom data against a request type.</p> <p>Properties for a Request Type in next-gen are stored as Issue Type properties and therefore can also be set by calling the Jira Cloud Platform <a href=\"https://developer.atlassian.com/cloud/jira/platform/rest/v3/#api-rest-api-3-issuetype-issueTypeId-properties-propertyKey-put\">Set issue type property</a> endpoint.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Jira project administrator with a Jira Service Desk agent license.</p> 
   * @param serviceDeskId <p>The ID of the service desk which contains the request type. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeId <p>The ID of the request type on which the property will be set.</p>  (required)
   * @param propertyKey <p>The key of the request type property. The maximum length of the key is 255 bytes.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setProperty(
    Integer serviceDeskId, Integer requestTypeId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setProperty);
  }

}
