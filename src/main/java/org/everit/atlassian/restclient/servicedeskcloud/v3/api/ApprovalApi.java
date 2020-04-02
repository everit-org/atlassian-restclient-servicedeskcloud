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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ApprovalDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ApprovalDecisionRequestDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOApprovalDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApprovalApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ApprovalDTO> returnType_answerApproval = new TypeReference<ApprovalDTO>() {};

  private static final TypeReference<ApprovalDTO> returnType_getApprovalById = new TypeReference<ApprovalDTO>() {};

  private static final TypeReference<PagedDTOApprovalDTO> returnType_getApprovals = new TypeReference<PagedDTOApprovalDTO>() {};

  private final RestClient restClient;

  public ApprovalApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Answer approval
   * <p>This method enables a user to <strong>Approve</strong> or <strong>Decline</strong> an approval on a customer request. The approval is assumed to be owned by the user making the call.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User is assigned to the approval request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to be updated.</p>  (required)
   * @param approvalId <p>The ID of the approval to be updated.</p>  (required)
   * @param approvalDecisionRequestDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ApprovalDTO&gt;
   */
  public Single<ApprovalDTO> answerApproval(
    String issueIdOrKey, Integer approvalId, ApprovalDecisionRequestDTO approvalDecisionRequestDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/approval/{approvalId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("approvalId", String.valueOf(approvalId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(approvalDecisionRequestDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_answerApproval);
  }

  /**
   * Get approval by id
   * <p>This method returns an approval. Use this method to determine the status of an approval and the list of approvers.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request the approval is on.</p>  (required)
   * @param approvalId <p>The ID of the approval to be returned.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ApprovalDTO&gt;
   */
  public Single<ApprovalDTO> getApprovalById(
    String issueIdOrKey, Integer approvalId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/approval/{approvalId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("approvalId", String.valueOf(approvalId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getApprovalById);
  }

  /**
   * Get approvals
   * <p>This method returns all approvals on a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to be queried for its approvals.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of approvals to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOApprovalDTO&gt;
   */
  public Single<PagedDTOApprovalDTO> getApprovals(
    String issueIdOrKey, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/approval");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getApprovals);
  }

}
