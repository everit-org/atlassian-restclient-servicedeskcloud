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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.ApprovalDTO;
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.PagedLinkDTO;

/**
 * PagedDTOApprovalDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class PagedDTOApprovalDTO {
  @JsonProperty("size")
  private Integer size;

  @JsonProperty("start")
  private Integer start;

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("isLastPage")
  private Boolean isLastPage;

  @JsonProperty("values")
  private List<ApprovalDTO> values = new ArrayList<>();

  @JsonProperty("_expands")
  private List<String> expands = new ArrayList<>();

  @JsonProperty("_links")
  private PagedLinkDTO links;

  public PagedDTOApprovalDTO size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Number of items returned in the page.
   * @return size
  **/
  @ApiModelProperty(value = "Number of items returned in the page.")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public PagedDTOApprovalDTO start(Integer start) {
    this.start = start;
    return this;
  }

   /**
   * Index of the first item returned in the page.
   * @return start
  **/
  @ApiModelProperty(value = "Index of the first item returned in the page.")
  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public PagedDTOApprovalDTO limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Number of items to be returned per page, up to the maximum set for these objects in the current implementation.
   * @return limit
  **/
  @ApiModelProperty(value = "Number of items to be returned per page, up to the maximum set for these objects in the current implementation.")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public PagedDTOApprovalDTO isLastPage(Boolean isLastPage) {
    this.isLastPage = isLastPage;
    return this;
  }

   /**
   * Indicates if this is the last page of records (true) or not (false).
   * @return isLastPage
  **/
  @ApiModelProperty(value = "Indicates if this is the last page of records (true) or not (false).")
  public Boolean getIsLastPage() {
    return isLastPage;
  }

  public void setIsLastPage(Boolean isLastPage) {
    this.isLastPage = isLastPage;
  }

  public PagedDTOApprovalDTO values(List<ApprovalDTO> values) {
    this.values = values;
    return this;
  }

  public PagedDTOApprovalDTO addValuesItem(ApprovalDTO valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * Details of the items included in the page.
   * @return values
  **/
  @ApiModelProperty(value = "Details of the items included in the page.")
  public List<ApprovalDTO> getValues() {
    return values;
  }

  public void setValues(List<ApprovalDTO> values) {
    this.values = values;
  }

  public PagedDTOApprovalDTO expands(List<String> expands) {
    this.expands = expands;
    return this;
  }

  public PagedDTOApprovalDTO addExpandsItem(String expandsItem) {
    if (this.expands == null) {
      this.expands = new ArrayList<>();
    }
    this.expands.add(expandsItem);
    return this;
  }

   /**
   * Get expands
   * @return expands
  **/
  @ApiModelProperty(value = "")
  public List<String> getExpands() {
    return expands;
  }

  public void setExpands(List<String> expands) {
    this.expands = expands;
  }

  public PagedDTOApprovalDTO links(PagedLinkDTO links) {
    this.links = links;
    return this;
  }

   /**
   * List of the links relating to the page.
   * @return links
  **/
  @ApiModelProperty(value = "List of the links relating to the page.")
  public PagedLinkDTO getLinks() {
    return links;
  }

  public void setLinks(PagedLinkDTO links) {
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
    PagedDTOApprovalDTO pagedDTOApprovalDTO = (PagedDTOApprovalDTO) o;
    return Objects.equals(this.size, pagedDTOApprovalDTO.size) &&
        Objects.equals(this.start, pagedDTOApprovalDTO.start) &&
        Objects.equals(this.limit, pagedDTOApprovalDTO.limit) &&
        Objects.equals(this.isLastPage, pagedDTOApprovalDTO.isLastPage) &&
        Objects.equals(this.values, pagedDTOApprovalDTO.values) &&
        Objects.equals(this.expands, pagedDTOApprovalDTO.expands) &&
        Objects.equals(this.links, pagedDTOApprovalDTO.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, start, limit, isLastPage, values, expands, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedDTOApprovalDTO {\n");
    
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    isLastPage: ").append(toIndentedString(isLastPage)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    expands: ").append(toIndentedString(expands)).append("\n");
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

