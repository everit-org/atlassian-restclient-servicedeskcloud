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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.I18nErrorMessage;

/**
 * ErrorResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class ErrorResponse {
  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("i18nErrorMessage")
  private I18nErrorMessage i18nErrorMessage;

  public ErrorResponse errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Get errorMessage
   * @return errorMessage
  **/
  @ApiModelProperty(value = "")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ErrorResponse i18nErrorMessage(I18nErrorMessage i18nErrorMessage) {
    this.i18nErrorMessage = i18nErrorMessage;
    return this;
  }

   /**
   * Get i18nErrorMessage
   * @return i18nErrorMessage
  **/
  @ApiModelProperty(value = "")
  public I18nErrorMessage getI18nErrorMessage() {
    return i18nErrorMessage;
  }

  public void setI18nErrorMessage(I18nErrorMessage i18nErrorMessage) {
    this.i18nErrorMessage = i18nErrorMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.errorMessage, errorResponse.errorMessage) &&
        Objects.equals(this.i18nErrorMessage, errorResponse.i18nErrorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessage, i18nErrorMessage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    i18nErrorMessage: ").append(toIndentedString(i18nErrorMessage)).append("\n");
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
