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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CSATFeedbackFullDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsatFeedbackPublicApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_deleteFeedback = new TypeReference<Object>() {};

  private static final TypeReference<CSATFeedbackFullDTO> returnType_getFeedback = new TypeReference<CSATFeedbackFullDTO>() {};

  private static final TypeReference<CSATFeedbackFullDTO> returnType_postFeedback = new TypeReference<CSATFeedbackFullDTO>() {};

  private final RestClient restClient;

  public CsatFeedbackPublicApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete feedback
   * <p>This method deletes the feedback of request using it's <code>requestKey</code> or <code>requestId</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User must be the reporter or an Atlassian Connect app.</p> 
   * @param requestIdOrKey <p>The id or the key of the request to post the feedback on</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteFeedback(
    String requestIdOrKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{requestIdOrKey}/feedback");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("requestIdOrKey", String.valueOf(requestIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteFeedback);
  }

  /**
   * Get feedback
   * <p>This method retrieves a feedback of a request using it's <code>requestKey</code> or <code>requestId</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User has view request permissions.</p> 
   * @param requestIdOrKey <p>The id or the key of the request to post the feedback on</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CSATFeedbackFullDTO&gt;
   */
  public Single<CSATFeedbackFullDTO> getFeedback(
    String requestIdOrKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{requestIdOrKey}/feedback");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("requestIdOrKey", String.valueOf(requestIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFeedback);
  }

  /**
   * Post feedback
   * <p>This method adds a feedback on an request using it's <code>requestKey</code> or <code>requestId</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User must be the reporter or an Atlassian Connect app.</p> 
   * @param requestIdOrKey <p>The id or the key of the request to post the feedback on</p>  (required)
   * @param csATFeedbackFullDTO <p>The feedback to be added on the request</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CSATFeedbackFullDTO&gt;
   */
  public Single<CSATFeedbackFullDTO> postFeedback(
    String requestIdOrKey, CSATFeedbackFullDTO csATFeedbackFullDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{requestIdOrKey}/feedback");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("requestIdOrKey", String.valueOf(requestIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(csATFeedbackFullDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_postFeedback);
  }

}
