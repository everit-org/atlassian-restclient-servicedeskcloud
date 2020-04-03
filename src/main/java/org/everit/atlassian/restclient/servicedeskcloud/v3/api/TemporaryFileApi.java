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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemporaryFileApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private final RestClient restClient;

  public TemporaryFileApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Attach temporary file
   * <p>This method adds one or more temporary attachments to a service desk, which can then be permanently attached to a customer request using <a href=\"#api-request-issueIdOrKey-attachment-post\">servicedeskapi/request/{issueIdOrKey}/attachment</a>.</p> <p><strong>Note</strong>: It is possible for a service desk administrator to turn off the ability to add attachments to a service desk.</p> <p>This method expects a multipart request. The media-type multipart/form-data is defined in RFC 1867. Most client libraries have classes that make dealing with multipart posts simple. For instance, in Java the Apache HTTP Components library provides <a href=\"http://hc.apache.org/httpcomponents-client-ga/httpmime/apidocs/org/apache/http/entity/mime/MultipartEntity.html\">MultiPartEntity</a>.</p> <p>Because this method accepts multipart/form-data, it has XSRF protection on it. This means you must submit a header of X-Atlassian-Token: no-check with the request or it will be blocked.</p> <p>The name of the multipart/form-data parameter that contains the attachments must be <code>file</code>.</p> <p>For example, to upload a file called <code>myfile.txt</code> in the Service Desk with ID 10001 use</p> <pre><code>curl -D- -u customer:customer -X POST -H &quot;X-ExperimentalApi: opt-in&quot; -H &quot;X-Atlassian-Token: no-check&quot; -F &quot;file=@myfile.txt&quot; https://your-domain.atlassian.net/rest/servicedeskapi/servicedesk/10001/attachTemporaryFile </code></pre> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: Permission to add attachments in this Service Desk.</p> 
   * @param serviceDeskId <p>The ID of the Service Desk to which the file will be attached. This can alternatively be a <a href=\"#project-identifiers\">project identifier.</a></p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable attachTemporaryFile(
    Long serviceDeskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/servicedeskapi/servicedesk/{serviceDeskId}/attachTemporaryFile");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("serviceDeskId", String.valueOf(serviceDeskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
