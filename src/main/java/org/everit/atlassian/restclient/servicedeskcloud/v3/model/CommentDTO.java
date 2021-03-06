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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.DateDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedDTOAttachmentDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.RenderedValueDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.SelfLinkDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.UserDTO;

/**
 * CommentDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class CommentDTO {
  @JsonProperty("id")
  private String id;

  @JsonProperty("body")
  private String body;

  @JsonProperty("renderedBody")
  private RenderedValueDTO renderedBody;

  @JsonProperty("author")
  private UserDTO author;

  @JsonProperty("created")
  private DateDTO created;

  @JsonProperty("attachments")
  private PagedDTOAttachmentDTO attachments;

  @JsonProperty("_expands")
  private List<String> expands = new ArrayList<>();

  @JsonProperty("public")
  private Boolean _public;

  @JsonProperty("_links")
  private SelfLinkDTO links;

  public CommentDTO id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the comment.
   * @return id
  **/
  @ApiModelProperty(value = "ID of the comment.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CommentDTO body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Content of the comment.
   * @return body
  **/
  @ApiModelProperty(value = "Content of the comment.")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public CommentDTO renderedBody(RenderedValueDTO renderedBody) {
    this.renderedBody = renderedBody;
    return this;
  }

   /**
   * The rendered body of the comment.
   * @return renderedBody
  **/
  @ApiModelProperty(value = "The rendered body of the comment.")
  public RenderedValueDTO getRenderedBody() {
    return renderedBody;
  }

  public void setRenderedBody(RenderedValueDTO renderedBody) {
    this.renderedBody = renderedBody;
  }

  public CommentDTO author(UserDTO author) {
    this.author = author;
    return this;
  }

   /**
   * Details of the customer who authored the comment.
   * @return author
  **/
  @ApiModelProperty(value = "Details of the customer who authored the comment.")
  public UserDTO getAuthor() {
    return author;
  }

  public void setAuthor(UserDTO author) {
    this.author = author;
  }

  public CommentDTO created(DateDTO created) {
    this.created = created;
    return this;
  }

   /**
   * Date the comment was created.
   * @return created
  **/
  @ApiModelProperty(value = "Date the comment was created.")
  public DateDTO getCreated() {
    return created;
  }

  public void setCreated(DateDTO created) {
    this.created = created;
  }

  public CommentDTO attachments(PagedDTOAttachmentDTO attachments) {
    this.attachments = attachments;
    return this;
  }

   /**
   * List of the attachments included in the comment.
   * @return attachments
  **/
  @ApiModelProperty(value = "List of the attachments included in the comment.")
  public PagedDTOAttachmentDTO getAttachments() {
    return attachments;
  }

  public void setAttachments(PagedDTOAttachmentDTO attachments) {
    this.attachments = attachments;
  }

  public CommentDTO expands(List<String> expands) {
    this.expands = expands;
    return this;
  }

  public CommentDTO addExpandsItem(String expandsItem) {
    if (this.expands == null) {
      this.expands = new ArrayList<>();
    }
    this.expands.add(expandsItem);
    return this;
  }

   /**
   * List of items that can be expanded in the response by specifying the expand query parameter.
   * @return expands
  **/
  @ApiModelProperty(value = "List of items that can be expanded in the response by specifying the expand query parameter.")
  public List<String> getExpands() {
    return expands;
  }

  public void setExpands(List<String> expands) {
    this.expands = expands;
  }

  public CommentDTO _public(Boolean _public) {
    this._public = _public;
    return this;
  }

   /**
   * Indicates whether the comment is public (true) or private/internal (false).
   * @return _public
  **/
  @ApiModelProperty(value = "Indicates whether the comment is public (true) or private/internal (false).")
  public Boolean getPublic() {
    return _public;
  }

  public void setPublic(Boolean _public) {
    this._public = _public;
  }

  public CommentDTO links(SelfLinkDTO links) {
    this.links = links;
    return this;
  }

   /**
   * REST API URL link to the comment.
   * @return links
  **/
  @ApiModelProperty(value = "REST API URL link to the comment.")
  public SelfLinkDTO getLinks() {
    return links;
  }

  public void setLinks(SelfLinkDTO links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentDTO commentDTO = (CommentDTO) o;
    return Objects.equals(this.id, commentDTO.id) &&
        Objects.equals(this.body, commentDTO.body) &&
        Objects.equals(this.renderedBody, commentDTO.renderedBody) &&
        Objects.equals(this.author, commentDTO.author) &&
        Objects.equals(this.created, commentDTO.created) &&
        Objects.equals(this.attachments, commentDTO.attachments) &&
        Objects.equals(this.expands, commentDTO.expands) &&
        Objects.equals(this._public, commentDTO._public) &&
        Objects.equals(this.links, commentDTO.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, body, renderedBody, author, created, attachments, expands, _public, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    renderedBody: ").append(toIndentedString(renderedBody)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    expands: ").append(toIndentedString(expands)).append("\n");
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

