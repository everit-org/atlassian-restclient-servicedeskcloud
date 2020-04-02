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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.OrganizationServiceDeskUpdateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOOrganizationDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationServiceDeskApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOOrganizationDTO> returnType_getOrganizations = new TypeReference<PagedDTOOrganizationDTO>() {};

  private final RestClient restClient;

  public OrganizationServiceDeskApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add organization
   * <p>This method adds an organization to a service desk. If the organization ID is already associated with the service desk, no change is made and the resource returns a 204 success code.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk's agent.</p> 
   * @param serviceDeskId <p>The ID of the service desk to which the organization will be added. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param organizationServiceDeskUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable addOrganization(
    Integer serviceDeskId, OrganizationServiceDeskUpdateDTO organizationServiceDeskUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/organization");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(organizationServiceDeskUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get organizations
   * <p>This method returns a list of all organizations associated with a service desk.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk's agent.</p> 
   * @param serviceDeskId <p>The ID of the service desk from which the organization list will be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOOrganizationDTO&gt;
   */
  public Single<PagedDTOOrganizationDTO> getOrganizations(
    Integer serviceDeskId, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/organization");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
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
   * Remove organization
   * <p>This method removes an organization from a service desk. If the organization ID does not match an organization associated with the service desk, no change is made and the resource returns a 204 success code.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk's agent.</p> 
   * @param serviceDeskId <p>The ID of the service desk from which the organization will be removed. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param organizationServiceDeskUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeOrganization(
    Integer serviceDeskId, OrganizationServiceDeskUpdateDTO organizationServiceDeskUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/organization");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(organizationServiceDeskUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
