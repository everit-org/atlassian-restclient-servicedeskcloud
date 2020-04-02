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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTORequestTypeDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalRequestTypeApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTORequestTypeDTO> returnType_getAllRequestTypes = new TypeReference<PagedDTORequestTypeDTO>() {};

  private final RestClient restClient;

  public GlobalRequestTypeApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get all request types
   * <p>This method returns all customer request types used in the Jira Service Desk instance, optionally filtered by a query string.</p> <p>Use <a href=\"#api-servicedesk-serviceDeskId-requesttype-get\">servicedeskapi/servicedesk/{serviceDeskId}/requesttype</a> to find the customer request types supported by a specific service desk.</p> <p>The returned list of customer request types can be filtered using the <code>query</code> parameter. The parameter is matched against the customer request types' <code>name</code> or <code>description</code>. For example, searching for &quot;Install&quot;, &quot;Inst&quot;, &quot;Equi&quot;, or &quot;Equipment&quot; will match a customer request type with the <em>name</em> &quot;Equipment Installation Request&quot;.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Any</p> 
   * @param searchQuery <p>String to be used to filter the results.</p>  (optional)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 100. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param expand  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTORequestTypeDTO&gt;
   */
  public Single<PagedDTORequestTypeDTO> getAllRequestTypes(
    Optional<String> searchQuery, Optional<Integer> start, Optional<Integer> limit, Optional<List<String>> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/requesttype");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (searchQuery.isPresent()) {
      queryParams.put("searchQuery", Collections.singleton(String.valueOf(searchQuery.get())));
    }
    if (start.isPresent()) {
      queryParams.put("start", Collections.singleton(String.valueOf(start.get())));
    }
    if (limit.isPresent()) {
      queryParams.put("limit", Collections.singleton(String.valueOf(limit.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllRequestTypes);
  }

}
