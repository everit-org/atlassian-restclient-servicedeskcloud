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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.RequestTypeCreateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.RequestTypeDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestTypeApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<RequestTypeDTO> returnType_createRequestType = new TypeReference<RequestTypeDTO>() {};

  private static final TypeReference<RequestTypeDTO> returnType_getRequestTypeById = new TypeReference<RequestTypeDTO>() {};

  private static final TypeReference<PagedDTORequestTypeDTO> returnType_getRequestTypes = new TypeReference<PagedDTORequestTypeDTO>() {};

  private final RestClient restClient;

  public RequestTypeApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create request type
   * <p>This method enables a customer request type to be added to a service desk based on an issue type. Note that not all customer request type fields can be specified in the request and these fields are given the following default values:</p> <ul> <li>Request type icon is given the question mark icon.</li> <li>Request type groups is left empty, which means this customer request type will not be visible on the <a href=\"https://confluence.atlassian.com/servicedeskcloud/configuring-the-customer-portal-732528918.html\">customer portal</a>.</li> <li>Request type status mapping is left empty, so the request type has no custom status mapping but inherits the status map from the issue type upon which it is based.</li> <li>Request type field mapping is set to show the required fields as specified by the issue type used to create the customer request type.</li> </ul> <p>These fields can be updated by a service desk administrator using the <strong>Request types</strong> option in <strong>Project settings</strong>.<br /> Request Types are created in next-gen projects by creating Issue Types. Please use the Jira Cloud Platform Create issue type endpoint instead.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Service desk's administrator</p> 
   * @param serviceDeskId <p>The ID of the service desk where the customer request type is to be created. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeCreateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;RequestTypeDTO&gt;
   */
  public Single<RequestTypeDTO> createRequestType(
    Integer serviceDeskId, RequestTypeCreateDTO requestTypeCreateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestTypeCreateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createRequestType);
  }

  /**
   * Get request type by id
   * <p>This method returns a customer request type from a service desk.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to access the service desk.</p> 
   * @param serviceDeskId <p>The ID of the service desk whose customer request type is to be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeId <p>The ID of the customer request type to be returned.</p>  (required)
   * @param expand  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;RequestTypeDTO&gt;
   */
  public Single<RequestTypeDTO> getRequestTypeById(
    Integer serviceDeskId, Integer requestTypeId, Optional<List<String>> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestTypeById);
  }

  /**
   * Get request types
   * <p>This method returns all customer request types from a service desk. There are two parameters for filtering the returned list:</p> <ul> <li><code>groupId</code> which filters the results to items in the customer request type group.</li> <li><code>searchQuery</code> which is matched against request types' <code>name</code> or <code>description</code>. For example, the strings &quot;Install&quot;, &quot;Inst&quot;, &quot;Equi&quot;, or &quot;Equipment&quot; will match a request type with the <em>name</em> &quot;Equipment Installation Request&quot;.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to access the service desk.</p> 
   * @param serviceDeskId <p>The ID of the service desk whose customer request types are to be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param groupId <p>Filters results to those in a customer request type group.</p>  (optional)
   * @param expand  (optional, default to new ArrayList&lt;&gt;())
   * @param searchQuery <p>The string to be used to filter the results.</p>  (optional)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of items to return per page. Default: 100. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTORequestTypeDTO&gt;
   */
  public Single<PagedDTORequestTypeDTO> getRequestTypes(
    Integer serviceDeskId, Optional<Integer> groupId, Optional<List<String>> expand, Optional<String> searchQuery, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
    }
    if (searchQuery.isPresent()) {
      queryParams.put("searchQuery", Collections.singleton(String.valueOf(searchQuery.get())));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestTypes);
  }

}
