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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOIssueBean;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOQueueDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.QueueDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOIssueBean> returnType_getIssuesInQueue = new TypeReference<PagedDTOIssueBean>() {};

  private static final TypeReference<QueueDTO> returnType_getQueue = new TypeReference<QueueDTO>() {};

  private static final TypeReference<PagedDTOQueueDTO> returnType_getQueues = new TypeReference<PagedDTOQueueDTO>() {};

  private final RestClient restClient;

  public QueueApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get issues in queue
   * <p>This method returns the customer requests in a queue. Only fields that the queue is configured to show are returned. For example, if a queue is configured to show description and due date, then only those two fields are returned for each customer request in the queue.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk's agent.</p> 
   * @param serviceDeskId <p>The ID of the service desk containing the queue to be queried. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param queueId <p>The ID of the queue whose customer requests will be returned.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOIssueBean&gt;
   */
  public Single<PagedDTOIssueBean> getIssuesInQueue(
    Long serviceDeskId, Long queueId, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/queue/{queueId}/issue");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("queueId", String.valueOf(queueId));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssuesInQueue);
  }

  /**
   * Get queue
   * <p>This method returns a specific queues in a service desk. To include a customer request count for the queue (in the <code>issueCount</code> field) in the response, set the query parameter <code>includeCount</code> to true (its default is false).</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: service desk's Agent.</p> 
   * @param serviceDeskId <p>ID of the service desk whose queues will be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param queueId <p>ID of the required queue.</p>  (required)
   * @param includeCount <p>Specifies whether to include each queue's customer request (issue) count in the response.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;QueueDTO&gt;
   */
  public Single<QueueDTO> getQueue(
    Long serviceDeskId, Long queueId, Optional<Boolean> includeCount, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/queue/{queueId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("queueId", String.valueOf(queueId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (includeCount.isPresent()) {
      queryParams.put("includeCount", Collections.singleton(String.valueOf(includeCount.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getQueue);
  }

  /**
   * Get queues
   * <p>This method returns the queues in a service desk. To include a customer request count for each queue (in the <code>issueCount</code> field) in the response, set the query parameter <code>includeCount</code> to true (its default is false).</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: service desk's Agent.</p> 
   * @param serviceDeskId <p>ID of the service desk whose queues will be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param includeCount <p>Specifies whether to include each queue's customer request (issue) count in the response.</p>  (optional, default to false)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOQueueDTO&gt;
   */
  public Single<PagedDTOQueueDTO> getQueues(
    Long serviceDeskId, Optional<Boolean> includeCount, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/queue");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (includeCount.isPresent()) {
      queryParams.put("includeCount", Collections.singleton(String.valueOf(includeCount.get())));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getQueues);
  }

}
