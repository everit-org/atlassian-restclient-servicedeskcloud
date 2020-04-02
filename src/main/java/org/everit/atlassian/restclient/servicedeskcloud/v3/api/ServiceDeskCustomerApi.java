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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOUserDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ServiceDeskCustomerDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDeskCustomerApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOUserDTO> returnType_getCustomers = new TypeReference<PagedDTOUserDTO>() {};

  private final RestClient restClient;

  public ServiceDeskCustomerApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add customers
   * <p>Adds one or more customers to a service desk. If any of the passed customers are associated with the service desk, no changes will be made for those customers and the resource returns a 204 success code.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk administrator</p> 
   * @param serviceDeskId <p>The ID of the service desk the customer list should be returned from. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param serviceDeskCustomerDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable addCustomers(
    Long serviceDeskId, ServiceDeskCustomerDTO serviceDeskCustomerDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/customer");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(serviceDeskCustomerDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get customers
   * <p>This method returns a list of the customers on a service desk.</p> <p>The returned list of customers can be filtered using the <code>query</code> parameter. The parameter is matched against customers' <code>displayName</code>, <code>name</code>, or <code>email</code>. For example, searching for &quot;John&quot;, &quot;Jo&quot;, &quot;Smi&quot;, or &quot;Smith&quot; will match a user with display name &quot;John Smith&quot;.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view this Service Desk's customers.</p> 
   * @param serviceDeskId <p>The ID of the service desk the customer list should be returned from. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param query <p>The string used to filter the customer list.</p>  (optional)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of users to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOUserDTO&gt;
   */
  public Single<PagedDTOUserDTO> getCustomers(
    Long serviceDeskId, Optional<String> query, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/customer");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (start.isPresent()) {
      queryParams.put("start", Collections.singleton(String.valueOf(start.get())));
    }
    if (limit.isPresent()) {
      queryParams.put("limit", Collections.singleton(String.valueOf(limit.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomers);
  }

  /**
   * Remove customers
   * <p>This method removes one or more customers from a service desk. The service desk must have closed access. If any of the passed customers are not associated with the service desk, no changes will be made for those customers and the resource returns a 204 success code.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Services desk administrator</p> 
   * @param serviceDeskId <p>The ID of the service desk the customers should be removed from. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param serviceDeskCustomerDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeCustomers(
    Long serviceDeskId, ServiceDeskCustomerDTO serviceDeskCustomerDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/customer");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(serviceDeskCustomerDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
