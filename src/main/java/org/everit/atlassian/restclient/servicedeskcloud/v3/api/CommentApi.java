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

import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CommentCreateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.CommentDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ErrorResponse;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOAttachmentDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOCommentDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<CommentDTO> returnType_createRequestComment = new TypeReference<CommentDTO>() {};

  private static final TypeReference<PagedDTOAttachmentDTO> returnType_getCommentAttachments = new TypeReference<PagedDTOAttachmentDTO>() {};

  private static final TypeReference<CommentDTO> returnType_getRequestCommentById = new TypeReference<CommentDTO>() {};

  private static final TypeReference<PagedDTOCommentDTO> returnType_getRequestComments = new TypeReference<PagedDTOCommentDTO>() {};

  private final RestClient restClient;

  public CommentApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create request comment
   * <p>This method creates a public or private (internal) comment on a customer request, with the comment visibility set by <code>public</code>. The user recorded as the author of the comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: User has Add Comments permission.</p> <p><strong>Request limitations</strong>: Customers can set comments to public visibility only.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request to which the comment will be added.</p>  (required)
   * @param commentCreateDTO  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CommentDTO&gt;
   */
  public Single<CommentDTO> createRequestComment(
    String issueIdOrKey, CommentCreateDTO commentCreateDTO, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/comment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(commentCreateDTO));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createRequestComment);
  }

  /**
   * Get comment attachments
   * <p>This method returns the attachments referenced in a comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> <p><strong>Response limitations</strong>: Customers can only view public comments, and retrieve their attachments, on requests where they are the reporter or a participant whereas agents can see both internal and public comments.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request that contains the comment.</p>  (required)
   * @param commentId <p>The ID of the comment.</p>  (required)
   * @param start <p>The starting index of the returned comments. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of comments to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOAttachmentDTO&gt;
   */
  public Single<PagedDTOAttachmentDTO> getCommentAttachments(
    String issueIdOrKey, Long commentId, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/comment/{commentId}/attachment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("commentId", String.valueOf(commentId));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCommentAttachments);
  }

  /**
   * Get request comment by id
   * <p>This method returns details of a customer request's comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> <p><strong>Response limitations</strong>: Customers can only view public comments on requests where they are the reporter or a participant whereas agents can see both internal and public comments.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request that contains the comment.</p>  (required)
   * @param commentId <p>The ID of the comment to retrieve.</p>  (required)
   * @param expand <p>A multi-value parameter indicating which properties of the comment to expand:</p> <ul> <li><code>attachment</code> returns the attachment details, if any, for the comment. (If you want to get all attachments for a request, use <a href=\"#api-request-issueIdOrKey-attachment-get\">servicedeskapi/request/{issueIdOrKey}/attachment</a>.)</li> <li><code>renderedBody</code> (Experimental) returns the rendered body in HTML format (in addition to the raw body) of the comment.</li> </ul>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CommentDTO&gt;
   */
  public Single<CommentDTO> getRequestCommentById(
    String issueIdOrKey, Long commentId, Optional<List<String>> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/comment/{commentId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("commentId", String.valueOf(commentId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", RestClientUtil.objectCollectionToStringCollection(expand.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestCommentById);
  }

  /**
   * Get request comments
   * <p>This method returns all comments on a customer request. No permissions error is provided if, for example, the user doesn't have access to the service desk or request, the method simply returns an empty response.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to view the customer request.</p> <p><strong>Response limitations</strong>: Customers are returned public comments only.</p> 
   * @param issueIdOrKey <p>The ID or key of the customer request whose comments will be retrieved.</p>  (required)
   * @param _public <p>Specifies whether to return public comments or not. Default: true.</p>  (optional)
   * @param internal <p>Specifies whether to return internal comments or not. Default: true.</p>  (optional)
   * @param expand <p>A multi-value parameter indicating which properties of the comment to expand:</p> <ul> <li><code>attachment</code> returns the attachment details, if any, for each comment. (If you want to get all attachments for a request, use <a href=\"#api-request-issueIdOrKey-attachment-get\">servicedeskapi/request/{issueIdOrKey}/attachment</a>.)</li> <li><code>renderedBody</code> (Experimental) returns the rendered body in HTML format (in addition to the raw body) for each comment.</li> </ul>  (optional, default to new ArrayList&lt;&gt;())
   * @param start <p>The starting index of the returned comments. Base index: 0. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param limit <p>The maximum number of comments to return per page. Default: 50. See the <a href=\"#pagination\">Pagination</a> section for more details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PagedDTOCommentDTO&gt;
   */
  public Single<PagedDTOCommentDTO> getRequestComments(
    String issueIdOrKey, Optional<Boolean> _public, Optional<Boolean> internal, Optional<List<String>> expand, Optional<Integer> start, Optional<Integer> limit, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/request/{issueIdOrKey}/comment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (_public.isPresent()) {
      queryParams.put("public", Collections.singleton(String.valueOf(_public.get())));
    }
    if (internal.isPresent()) {
      queryParams.put("internal", Collections.singleton(String.valueOf(internal.get())));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getRequestComments);
  }

}
