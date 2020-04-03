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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RequestTypeIconLinkDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class RequestTypeIconLinkDTO {
  @JsonProperty("iconUrls")
  private Map<String, URI> iconUrls = new HashMap<>();

  public RequestTypeIconLinkDTO iconUrls(Map<String, URI> iconUrls) {
    this.iconUrls = iconUrls;
    return this;
  }

  public RequestTypeIconLinkDTO putIconUrlsItem(String key, URI iconUrlsItem) {
    if (this.iconUrls == null) {
      this.iconUrls = new HashMap<>();
    }
    this.iconUrls.put(key, iconUrlsItem);
    return this;
  }

   /**
   * URLs for the request type icons.
   * @return iconUrls
  **/
  @ApiModelProperty(value = "URLs for the request type icons.")
  public Map<String, URI> getIconUrls() {
    return iconUrls;
  }

  public void setIconUrls(Map<String, URI> iconUrls) {
    this.iconUrls = iconUrls;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestTypeIconLinkDTO requestTypeIconLinkDTO = (RequestTypeIconLinkDTO) o;
    return Objects.equals(this.iconUrls, requestTypeIconLinkDTO.iconUrls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iconUrls);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestTypeIconLinkDTO {\n");
    
    sb.append("    iconUrls: ").append(toIndentedString(iconUrls)).append("\n");
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

