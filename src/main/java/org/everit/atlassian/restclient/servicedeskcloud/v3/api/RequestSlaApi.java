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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOSlaInformationDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.SlaInformationDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestSlaApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PagedDTOSlaInformationDTO> returnType_getSlaInformation = new TypeReference<PagedDTOSlaInformationDTO>() {};

  private static final TypeReference<SlaInformationDTO> returnType_getSlaInformationById = new TypeReference<SlaInformationDTO>() {};

  private final RestClient restClient;

  public RequestSlaApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get sla information
   * <p>This method returns all the SLA records on a customer request. A customer request can have zero or more SLAs. Each SLA can have recordings for zero or more &quot;completed cycles&quot; and zero or 1 &quot;ongoing cycle&quot;. Each cycle includes information on when it started and stopped, and whether it breached the SLA goal.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Agent for the Service Desk containing the queried customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request whose SLAs will be retrieved.</p>  (required)
   * @param start <p>The starting index of the returned objects. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of request types to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOSlaInformationDTO&gt;
   */
  public Single<PagedDTOSlaInformationDTO> getSlaInformation(
    String issueIdOrKey, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/sla");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getSlaInformation);
  }

  /**
   * Get sla information by id
   * <p>This method returns the details for an SLA on a customer request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Agent for the Service Desk containing the queried customer request.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request whose SLAs will be retrieved.</p>  (required)
   * @param slaMetricId <p>The ID or key of the SLAs metric to be retrieved.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SlaInformationDTO&gt;
   */
  public Single<SlaInformationDTO> getSlaInformationById(
    String issueIdOrKey, Long slaMetricId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/sla/{slaMetricId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("slaMetricId", String.valueOf(slaMetricId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getSlaInformationById);
  }

}
