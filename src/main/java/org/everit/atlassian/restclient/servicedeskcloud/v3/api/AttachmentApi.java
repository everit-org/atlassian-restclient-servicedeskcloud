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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.AttachmentCreateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.AttachmentCreateResultDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOAttachmentDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttachmentApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<AttachmentCreateResultDTO> returnType_createAttachment = new TypeReference<AttachmentCreateResultDTO>() {};

  private static final TypeReference<PagedDTOAttachmentDTO> returnType_getAttachmentsForRequest = new TypeReference<PagedDTOAttachmentDTO>() {};

  private final RestClient restClient;

  public AttachmentApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create attachment
   * <p>This method adds one or more temporary files (attached to the request's service desk using <a href=\"#api-servicedesk-serviceDeskId-attachTemporaryFile-post\">servicedesk/{serviceDeskId}/attachTemporaryFile</a>) as attachments to a customer request and set the attachment visibility using the <code>public</code> flag. Also, it is possible to include a comment with the attachments.</p> <p>To get a list of attachments for a comment on the request use <a href=\"#api-request-issueIdOrKey-comment-commentId-attachment-get\">servicedeskapi/request/{issueIdOrKey}/comment/{commentId}/attachment</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to add an attachment.</p> <p><strong>Request limitations</strong>: Customers can set attachments to public visibility only.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to which the attachment will be added.</p>  (required)
   * @param attachmentCreateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AttachmentCreateResultDTO&gt;
   */
  public Single<AttachmentCreateResultDTO> createAttachment(
    String issueIdOrKey, AttachmentCreateDTO attachmentCreateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/attachment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(attachmentCreateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createAttachment);
  }

  /**
   * Get attachments for request
   * <p>This method returns all the attachments for a customer requests.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> <p><strong>Response limitations</strong>: Customers will only get a list of public attachments.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request from which the attachments will be listed.</p>  (required)
   * @param start <p>The starting index of the returned attachment. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of comments to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOAttachmentDTO&gt;
   */
  public Single<PagedDTOAttachmentDTO> getAttachmentsForRequest(
    String issueIdOrKey, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/attachment");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAttachmentsForRequest);
  }

}
