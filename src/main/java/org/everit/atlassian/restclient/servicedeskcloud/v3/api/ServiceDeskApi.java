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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOServiceDeskDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ServiceDeskDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDeskApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ServiceDeskDTO> returnType_getServiceDeskById = new TypeReference<ServiceDeskDTO>() {};

  private static final TypeReference<PagedDTOServiceDeskDTO> returnType_getServiceDesks = new TypeReference<PagedDTOServiceDeskDTO>() {};

  private final RestClient restClient;

  public ServiceDeskApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get service desk by id
   * <p>This method returns a service desk. Use this method to get service desk details whenever your application component is passed a service desk ID but needs to display other service desk details.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to access the Service Desk. For example, being the Service Desk's Administrator or one of its Agents or Users.</p> 
   * @param serviceDeskId <p>The ID of the service desk to return. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ServiceDeskDTO&gt;
   */
  public Single<ServiceDeskDTO> getServiceDeskById(
    Long serviceDeskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getServiceDeskById);
  }

  /**
   * Get service desks
   * <p>This method returns all the service desks in the Jira Service Desk instance that the user has permission to access. Use this method where you need a list of service desks or need to locate a service desk by name or keyword.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> 
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 100. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOServiceDeskDTO&gt;
   */
  public Single<PagedDTOServiceDeskDTO> getServiceDesks(
    Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getServiceDesks);
  }

}
