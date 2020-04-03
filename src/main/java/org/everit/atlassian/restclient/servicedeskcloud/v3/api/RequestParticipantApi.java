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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.RequestParticipantUpdateDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParticipantApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOUserDTO> returnType_addRequestParticipants = new TypeReference<PagedDTOUserDTO>() {};

  private static final TypeReference<PagedDTOUserDTO> returnType_getRequestParticipants = new TypeReference<PagedDTOUserDTO>() {};

  private static final TypeReference<PagedDTOUserDTO> returnType_removeRequestParticipants = new TypeReference<PagedDTOUserDTO>() {};

  private final RestClient restClient;

  public RequestParticipantApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add request participants
   * <p>This method adds participants to a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to manage participants on the customer request.</p> <p>Note, participants can be added when creating a customer request using the <a href=\"#api-request-post\">request</a> resource, by defining the participants in the <code>requestParticipants</code> field.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to have participants added.</p>  (required)
   * @param requestParticipantUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOUserDTO&gt;
   */
  public Single<PagedDTOUserDTO> addRequestParticipants(
    String issueIdOrKey, RequestParticipantUpdateDTO requestParticipantUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/participant");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestParticipantUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addRequestParticipants);
  }

  /**
   * Get request participants
   * <p>This method returns a list of all the participants on a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to be queried for its participants.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of request types to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOUserDTO&gt;
   */
  public Single<PagedDTOUserDTO> getRequestParticipants(
    String issueIdOrKey, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/participant");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestParticipants);
  }

  /**
   * Remove request participants
   * <p>This method removes participants from a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to manage participants on the customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to have participants removed.</p>  (required)
   * @param requestParticipantUpdateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOUserDTO&gt;
   */
  public Single<PagedDTOUserDTO> removeRequestParticipants(
    String issueIdOrKey, RequestParticipantUpdateDTO requestParticipantUpdateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/participant");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestParticipantUpdateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeRequestParticipants);
  }

}
