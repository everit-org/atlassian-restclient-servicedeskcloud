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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.SelfLinkDTO;

/**
 * QueueDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class QueueDTO {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("jql")
  private String jql;

  @JsonProperty("fields")
  private List<String> fields = new ArrayList<>();

  @JsonProperty("issueCount")
  private Long issueCount;

  @JsonProperty("_links")
  private SelfLinkDTO links;

  public QueueDTO id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID for the queue.
   * @return id
  **/
  @ApiModelProperty(value = "ID for the queue.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public QueueDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Short name for the queue.
   * @return name
  **/
  @ApiModelProperty(value = "Short name for the queue.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public QueueDTO jql(String jql) {
    this.jql = jql;
    return this;
  }

   /**
   * JQL query that filters reqeusts for the queue.
   * @return jql
  **/
  @ApiModelProperty(value = "JQL query that filters reqeusts for the queue.")
  public String getJql() {
    return jql;
  }

  public void setJql(String jql) {
    this.jql = jql;
  }

  public QueueDTO fields(List<String> fields) {
    this.fields = fields;
    return this;
  }

  public QueueDTO addFieldsItem(String fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Fields returned for each request in the queue.
   * @return fields
  **/
  @ApiModelProperty(value = "Fields returned for each request in the queue.")
  public List<String> getFields() {
    return fields;
  }

  public void setFields(List<String> fields) {
    this.fields = fields;
  }

  public QueueDTO issueCount(Long issueCount) {
    this.issueCount = issueCount;
    return this;
  }

   /**
   * The count of customer requests in the queue.
   * @return issueCount
  **/
  @ApiModelProperty(value = "The count of customer requests in the queue.")
  public Long getIssueCount() {
    return issueCount;
  }

  public void setIssueCount(Long issueCount) {
    this.issueCount = issueCount;
  }

  public QueueDTO links(SelfLinkDTO links) {
    this.links = links;
    return this;
  }

   /**
   * REST API URL to the queue.
   * @return links
  **/
  @ApiModelProperty(value = "REST API URL to the queue.")
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
    QueueDTO queueDTO = (QueueDTO) o;
    return Objects.equals(this.id, queueDTO.id) &&
        Objects.equals(this.name, queueDTO.name) &&
        Objects.equals(this.jql, queueDTO.jql) &&
        Objects.equals(this.fields, queueDTO.fields) &&
        Objects.equals(this.issueCount, queueDTO.issueCount) &&
        Objects.equals(this.links, queueDTO.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, jql, fields, issueCount, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueueDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    jql: ").append(toIndentedString(jql)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    issueCount: ").append(toIndentedString(issueCount)).append("\n");
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

