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
/*
 * Service Desk Public REST API
 * Public REST API for Jira Service Desk
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.everit.atlassian.restclient.servicedeskcloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;

/**
 * AttachmentLinkDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class AttachmentLinkDTO {
  @JsonProperty("self")
  private URI self;

  @JsonProperty("jiraRest")
  private URI jiraRest;

  @JsonProperty("content")
  private URI content;

  @JsonProperty("thumbnail")
  private URI thumbnail;

  public AttachmentLinkDTO self(URI self) {
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @ApiModelProperty(value = "")
  public URI getSelf() {
    return self;
  }

  public void setSelf(URI self) {
    this.self = self;
  }

  public AttachmentLinkDTO jiraRest(URI jiraRest) {
    this.jiraRest = jiraRest;
    return this;
  }

   /**
   * REST API URL for the attachment
   * @return jiraRest
  **/
  @ApiModelProperty(value = "REST API URL for the attachment")
  public URI getJiraRest() {
    return jiraRest;
  }

  public void setJiraRest(URI jiraRest) {
    this.jiraRest = jiraRest;
  }

  public AttachmentLinkDTO content(URI content) {
    this.content = content;
    return this;
  }

   /**
   * URL for the attachment.
   * @return content
  **/
  @ApiModelProperty(value = "URL for the attachment.")
  public URI getContent() {
    return content;
  }

  public void setContent(URI content) {
    this.content = content;
  }

  public AttachmentLinkDTO thumbnail(URI thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

   /**
   * URL for the attachment&#39;s thumbnail image.
   * @return thumbnail
  **/
  @ApiModelProperty(value = "URL for the attachment's thumbnail image.")
  public URI getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(URI thumbnail) {
    this.thumbnail = thumbnail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentLinkDTO attachmentLinkDTO = (AttachmentLinkDTO) o;
    return Objects.equals(this.self, attachmentLinkDTO.self) &&
        Objects.equals(this.jiraRest, attachmentLinkDTO.jiraRest) &&
        Objects.equals(this.content, attachmentLinkDTO.content) &&
        Objects.equals(this.thumbnail, attachmentLinkDTO.thumbnail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, jiraRest, content, thumbnail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentLinkDTO {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    jiraRest: ").append(toIndentedString(jiraRest)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

