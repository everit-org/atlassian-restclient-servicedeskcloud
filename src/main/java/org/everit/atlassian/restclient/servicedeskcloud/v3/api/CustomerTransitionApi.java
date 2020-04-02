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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CustomerTransitionExecutionDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOCustomerTransitionDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerTransitionApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOCustomerTransitionDTO> returnType_getCustomerTransitions = new TypeReference<PagedDTOCustomerTransitionDTO>() {};

  private final RestClient restClient;

  public CustomerTransitionApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get customer transitions
   * <p>This method returns a list of transitions, the workflow processes that moves a customer request from one status to another, that the user can perform on a request. Use this method to provide a user with a list if the actions they can take on a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request whose transitions will be retrieved.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 100. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOCustomerTransitionDTO&gt;
   */
  public Single<PagedDTOCustomerTransitionDTO> getCustomerTransitions(
    String issueIdOrKey, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/transition");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomerTransitions);
  }

  /**
   * Perform customer transition
   * <p>This method performs a customer transition for a given request and transition. An optional comment can be included to provide a reason for the transition.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: The user must be able to view the request and have the Transition Issues permission. If a comment is passed the user must have the Add Comments permission.</p> 
   * @param issueIdOrKey <p>ID or key of the issue to transition</p>  (required)
   * @param customerTransitionExecutionDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable performCustomerTransition(
    String issueIdOrKey, CustomerTransitionExecutionDTO customerTransitionExecutionDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/transition");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(customerTransitionExecutionDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
