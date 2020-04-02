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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CustomerRequestDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOCustomerRequestDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.RequestCreateDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRequestApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<CustomerRequestDTO> returnType_createCustomerRequest = new TypeReference<CustomerRequestDTO>() {};

  private static final TypeReference<CustomerRequestDTO> returnType_getCustomerRequestByIdOrKey = new TypeReference<CustomerRequestDTO>() {};

  private static final TypeReference<PagedDTOCustomerRequestDTO> returnType_getCustomerRequests = new TypeReference<PagedDTOCustomerRequestDTO>() {};

  private final RestClient restClient;

  public CustomerRequestApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create customer request
   * <p>This method creates a customer request in a service desk.</p> <p>The JSON request must include the service desk and customer request type, as well as any fields that are required for the request type. A list of the fields required by a customer request type can be obtained using <a href=\"#api-servicedesk-serviceDeskId-requesttype-requestTypeId-field-get\">servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/field</a>.</p> <p>The fields required for a customer request type depend on the user's permissions:</p> <ul> <li><code>raiseOnBehalfOf</code> is not available to Users who have the customer permission only.</li> <li><code>requestParticipants</code> is not available to Users who have the customer permission only or if the feature is turned off for customers.</li> </ul> <p><code>requestFieldValues</code> is a map of Jira field IDs and their values. See <a href=\"#fieldformats\">Field input formats</a>, for details of each field's JSON semantics and the values they can take.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to create requests in the specified service desk.</p> 
   * @param requestCreateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomerRequestDTO&gt;
   */
  public Single<CustomerRequestDTO> createCustomerRequest(
    RequestCreateDTO requestCreateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestCreateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createCustomerRequest);
  }

  /**
   * Get customer request by id or key
   * <p>This method returns a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to access the specified service desk.</p> <p><strong>Response limitations</strong>: For customers, only a request they created, was created on their behalf, or they are participating in will be returned.</p> 
   * @param issueIdOrKey <p>The ID or Key of the customer request to be returned</p>  (required)
   * @param expand <p>A multi-value parameter indicating which properties of the customer request to expand, where:</p> <ul> <li><code>serviceDesk</code> returns additional service desk details.</li> <li><code>requestType</code> returns additional customer request type details.</li> <li><code>participant</code> returns the participant details.</li> <li><code>sla</code> returns the SLA information.</li> <li><code>status</code> returns the status transitions, in chronological order.</li> <li><code>attachment</code> returns the attachments.</li> <li><code>action</code> returns the actions that the user can or cannot perform.</li> <li><code>comment</code> returns the comments.</li> <li><code>comment.attachment</code> returns the attachment details for each comment.</li> <li><code>comment.renderedBody</code> (Experimental) return the rendered body in HTML format (in addition to the raw body) for each comment.</li> </ul>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomerRequestDTO&gt;
   */
  public Single<CustomerRequestDTO> getCustomerRequestByIdOrKey(
    String issueIdOrKey, Optional<List<String>> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomerRequestByIdOrKey);
  }

  /**
   * Get customer requests
   * <p>This method returns all customer requests for the user executing the query.</p> <p>The returned customer requests are ordered chronologically by the latest activity on each request. For example, the latest status transition or comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to access the specified service desk.</p> <p><strong>Response limitations</strong>: For customers, the list returned will include request they created (or were created on their behalf) or are participating in only.</p> 
   * @param searchTerm <p>Filters customer requests where the request summary matches the <code>searchTerm</code>. <a href=\"https://confluence.atlassian.com/display/JIRACORECLOUD/Search+syntax+for+text+fields\">Wildcards</a> can be used in the <code>searchTerm</code> parameter.</p>  (optional)
   * @param requestOwnership <p>Filters customer requests using the following values:</p> <ul> <li><code>OWNED_REQUESTS</code> returns customer requests where the user is the creator.</li> <li><code>PARTICIPATED_REQUESTS</code> returns customer requests where the user is a participant.</li> <li><code>ORGANIZATION</code> returns customer requests for an organization of which the user is a member when used in conjunction with <code>organizationId</code>.</li> <li><code>ALL_ORGANIZATIONS</code> returns customer requests that belong to all organizations of which the user is a member.</li> <li><code>APPROVER</code> returns customer requests where the user is an approver. Can be used in conjunction with <code>approvalStatus</code> to filter pending or complete approvals.</li> <li><code>ALL_REQUESTS</code> returns all customer requests. <strong>Deprecated and will be removed, as the returned requests may change if more values are added in the future. Instead, explicitly list the desired filtering strategies.</strong></li> </ul> <p>Multiple values of the query parameter are supported. For example, <code>requestOwnership=OWNED_REQUESTS&amp;requestOwnership=PARTICIPATED_REQUESTS</code> will only return customer requests where the user is the creator or a participant. If not specified, filtering defaults to <code>OWNED_REQUESTS</code>, <code>PARTICIPATED_REQUESTS</code>, and <code>ALL_ORGANIZATIONS</code>.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param requestStatus <p>Filters customer requests where the request is closed, open, or either of the two where:</p> <ul> <li><code>CLOSED_REQUESTS</code> returns customer requests that are closed.</li> <li><code>OPEN_REQUESTS</code> returns customer requests that are open.</li> <li><code>ALL_REQUESTS</code> returns all customer requests.</li> </ul>  (optional)
   * @param approvalStatus <p>Filters results to customer requests based on their approval status:</p> <ul> <li><code>MY_PENDING_APPROVAL</code> returns customer requests pending the user's approval.</li> <li><code>MY_HISTORY_APPROVAL</code> returns customer requests where the user was an approver.</li> </ul> <p><strong>Note</strong>: Valid only when used with requestOwnership=APPROVER.</p>  (optional)
   * @param organizationId <p>Filters customer requests that belong to a specific organization (note that the user must be a member of that organization). <strong>Note</strong>: Valid only when used with requestOwnership=ORGANIZATION.</p>  (optional)
   * @param serviceDeskId <p>Filters customer requests by service desk.</p>  (optional)
   * @param requestTypeId <p>Filters customer requests by request type. Note that the <code>serviceDeskId</code> must be specified for the service desk in which the request type belongs.</p>  (optional)
   * @param expand <p>A multi-value parameter indicating which properties of the customer request to expand, where:</p> <ul> <li><code>serviceDesk</code> returns additional details for each service desk.</li> <li><code>requestType</code> returns additional details for each request type.</li> <li><code>participant</code> returns the participant details, if any, for each customer request.</li> <li><code>sla</code> returns the SLA information on each customer request.</li> <li><code>status</code> returns the status transitions, in chronological order, for each customer request.</li> <li><code>attachment</code> returns the attachments for the customer request.</li> <li><code>action</code> returns the actions that the user can or cannot perform on this customer request.</li> <li><code>comment</code> returns the comments, if any, for each customer request.</li> <li><code>comment.attachment</code> returns the attachment details, if any, for each comment.</li> <li><code>comment.renderedBody</code> (Experimental) returns the rendered body in HTML format (in addition to the raw body) for each comment.</li> </ul>  (optional, default to new ArrayList&lt;&gt;())
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOCustomerRequestDTO&gt;
   */
  public Single<PagedDTOCustomerRequestDTO> getCustomerRequests(
    Optional<String> searchTerm, Optional<List<String>> requestOwnership, Optional<String> requestStatus, Optional<String> approvalStatus, Optional<Integer> organizationId, Optional<Integer> serviceDeskId, Optional<Integer> requestTypeId, Optional<List<String>> expand, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (searchTerm.isPresent()) {
      queryParams.put("searchTerm", Collections.singleton(String.valueOf(searchTerm.get())));
    }
    if (requestOwnership.isPresent()) {
      queryParams.put("requestOwnership", RestClientUtil.objectCollectionToStringCollection(requestOwnership.get()));
    }
    if (requestStatus.isPresent()) {
      queryParams.put("requestStatus", Collections.singleton(String.valueOf(requestStatus.get())));
    }
    if (approvalStatus.isPresent()) {
      queryParams.put("approvalStatus", Collections.singleton(String.valueOf(approvalStatus.get())));
    }
    if (organizationId.isPresent()) {
      queryParams.put("organizationId", Collections.singleton(String.valueOf(organizationId.get())));
    }
    if (serviceDeskId.isPresent()) {
      queryParams.put("serviceDeskId", Collections.singleton(String.valueOf(serviceDeskId.get())));
    }
    if (requestTypeId.isPresent()) {
      queryParams.put("requestTypeId", Collections.singleton(String.valueOf(requestTypeId.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomerRequests);
  }

}
