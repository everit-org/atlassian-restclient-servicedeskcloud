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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CustomerRequestCreateMetaDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestTypeFieldApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<CustomerRequestCreateMetaDTO> returnType_getRequestTypeFields = new TypeReference<CustomerRequestCreateMetaDTO>() {};

  private final RestClient restClient;

  public RequestTypeFieldApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get request type fields
   * <p>This method returns the fields for a service desk's customer request type.</p> <p>Also, the following information about the user's permissions for the request type is returned:</p> <ul> <li><code>canRaiseOnBehalfOf</code> returns <code>true</code> if the user has permission to raise customer requests on behalf of other customers. Otherwise, returns <code>false</code>.</li> <li><code>canAddRequestParticipants</code> returns <code>true</code> if the user can add customer request participants. Otherwise, returns <code>false</code>.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the Service Desk.</p> 
   * @param serviceDeskId <p>The ID of the service desk containing the request types whose fields are to be returned. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param requestTypeId <p>The ID of the request types whose fields are to be returned.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomerRequestCreateMetaDTO&gt;
   */
  public Single<CustomerRequestCreateMetaDTO> getRequestTypeFields(
    Integer serviceDeskId, Integer requestTypeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/requesttype/{requestTypeId}/field");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    pathParams.put("requestTypeId", String.valueOf(requestTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestTypeFields);
  }

}
