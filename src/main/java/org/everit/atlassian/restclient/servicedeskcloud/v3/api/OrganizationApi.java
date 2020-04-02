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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.OrganizationCreateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.OrganizationDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOOrganizationDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOUserDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.UsersOrganizationUpdateDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<OrganizationDTO> returnType_createOrganization = new TypeReference<OrganizationDTO>() {};

  private static final TypeReference<OrganizationDTO> returnType_getOrganization = new TypeReference<OrganizationDTO>() {};

  private static final TypeReference<PagedDTOOrganizationDTO> returnType_getOrganizations = new TypeReference<PagedDTOOrganizationDTO>() {};

  private static final TypeReference<PagedDTOUserDTO> returnType_getUsersInOrganization = new TypeReference<PagedDTOUserDTO>() {};

  private final RestClient restClient;

  public OrganizationApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add users to organization
   * <p>This method adds users to an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk administrator or agent. Note: Permission to add users to an organization can be switched to users with the Jira administrator permission, using the <strong><a href=\"https://confluence.atlassian.com/servicedeskcloud/setting-up-service-desk-users-732528877.html#Settingupservicedeskusers-manageorgsManageorganizations\">Organization management</a></strong> feature.</p> 
   * @param organizationId <p>The ID of the organization.</p>  (required)
   * @param usersOrganizationUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable addUsersToOrganization(
    Integer organizationId, UsersOrganizationUpdateDTO usersOrganizationUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/user");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(usersOrganizationUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Create organization
   * <p>This method creates an organization by passing the name of the organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk administrator or agent. Note: Permission to create organizations can be switched to users with the Jira administrator permission, using the <strong><a href=\"https://confluence.atlassian.com/servicedeskcloud/setting-up-service-desk-users-732528877.html#Settingupservicedeskusers-manageorgsManageorganizations\">Organization management</a></strong> feature.</p> 
   * @param organizationCreateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;OrganizationDTO&gt;
   */
  public Single<OrganizationDTO> createOrganization(
    OrganizationCreateDTO organizationCreateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(organizationCreateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createOrganization);
  }

  /**
   * Delete organization
   * <p>This method deletes an organization. Note that the organization is deleted regardless of other associations it may have. For example, associations with service desks.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Jira administrator.</p> 
   * @param organizationId <p>The ID of the organization.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteOrganization(
    Integer organizationId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get organization
   * <p>This method returns details of an organization. Use this method to get organization details whenever your application component is passed an organization ID but needs to display other organization details.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> <p><strong>Response limitations</strong>: Customers can only retrieve organization of which they are members.</p> 
   * @param organizationId <p>The ID of the organization.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;OrganizationDTO&gt;
   */
  public Single<OrganizationDTO> getOrganization(
    Integer organizationId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getOrganization);
  }

  /**
   * Get organizations
   * <p>This method returns a list of organizations in the Jira Service Desk instance. Use this method when you want to present a list of organizations or want to locate an organization by name.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> <p><strong>Response limitations</strong>: If the user is a customer, only those organizations of which the customer is a member are listed.</p> 
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of organizations to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOOrganizationDTO&gt;
   */
  public Single<PagedDTOOrganizationDTO> getOrganizations(
    Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (start.isPresent()) {
      queryParams.put("start", Collections.singleton(String.valueOf(start.get())));
    }
    if (limit.isPresent()) {
      queryParams.put("limit", Collections.singleton(String.valueOf(limit.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getOrganizations);
  }

  /**
   * Get users in organization
   * <p>This method returns all the users associated with an organization. Use this method where you want to provide a list of users for an organization or determine if a user is associated with an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk administrator or agent.</p> 
   * @param organizationId <p>The ID of the organization.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of users to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOUserDTO&gt;
   */
  public Single<PagedDTOUserDTO> getUsersInOrganization(
    Integer organizationId, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/user");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (start.isPresent()) {
      queryParams.put("start", Collections.singleton(String.valueOf(start.get())));
    }
    if (limit.isPresent()) {
      queryParams.put("limit", Collections.singleton(String.valueOf(limit.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getUsersInOrganization);
  }

  /**
   * Remove users from organization
   * <p>This method removes users from an organization.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk administrator or agent. Note: Permission to delete users from an organization can be switched to users with the Jira administrator permission, using the <strong><a href=\"https://confluence.atlassian.com/servicedeskcloud/setting-up-service-desk-users-732528877.html#Settingupservicedeskusers-manageorgsManageorganizations\">Organization management</a></strong> feature.</p> 
   * @param organizationId <p>The ID of the organization.</p>  (required)
   * @param usersOrganizationUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUsersFromOrganization(
    Integer organizationId, UsersOrganizationUpdateDTO usersOrganizationUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/organization/{organizationId}/user");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("organizationId", String.valueOf(organizationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(usersOrganizationUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
