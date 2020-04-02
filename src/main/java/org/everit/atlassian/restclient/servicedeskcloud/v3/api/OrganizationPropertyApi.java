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

public class OrganizationPropertyApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PropertyKeys> returnType_getPropertiesKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<EntityProperty> returnType_getProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<Object> returnType_setProperty = new TypeReference<Object>() {};

  private final RestClient restClient;

  public OrganizationPropertyApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete property
   * <p>Removes a property from an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service Desk Administrator or Agent.</p> <p>Note: Permission to manage organizations can be switched to users with the Jira administrator permission, using the <strong><a href=\"https://confluence.atlassian.com/servicedeskcloud/setting-up-service-desk-users-732528877.html#Settingupservicedeskusers-manageorgsManageorganizations\">Organization management</a></strong> feature.</p> 
   * @param organizationId <p>The ID of the organization from which the property will be removed.</p>  (required)
   * @param propertyKey <p>The key of the property to remove.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteProperty(
    String organizationId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
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
   * <p>Returns the keys of all properties for an organization. Use this resource when you need to find out what additional properties items have been added to an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> <p><strong>Response limitations</strong>: Customers can only access properties of organizations of which they are members.</p> 
   * @param organizationId <p>The ID of the organization from which keys will be returned.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getPropertiesKeys(
    String organizationId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/property");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPropertiesKeys);
  }

  /**
   * Get property
   * <p>Returns the value of a property from an organization. Use this method to obtain the JSON content for an organization's property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> <p><strong>Response limitations</strong>: Customers can only access properties of organizations of which they are members.</p> 
   * @param organizationId <p>The ID of the organization from which the property will be returned.</p>  (required)
   * @param propertyKey <p>The key of the property to return.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getProperty(
    String organizationId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
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
   * <p>Sets the value of a property for an organization. Use this resource to store custom data against an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service Desk Administrator or Agent.</p> <p>Note: Permission to manage organizations can be switched to users with the Jira administrator permission, using the <strong><a href=\"https://confluence.atlassian.com/servicedeskcloud/setting-up-service-desk-users-732528877.html#Settingupservicedeskusers-manageorgsManageorganizations\">Organization management</a></strong> feature.</p> 
   * @param organizationId <p>The ID of the organization on which the property will be set.</p>  (required)
   * @param propertyKey <p>The key of the organization's property. The maximum length of the key is 255 bytes.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setProperty(
    String organizationId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/property/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setProperty);
  }

}
