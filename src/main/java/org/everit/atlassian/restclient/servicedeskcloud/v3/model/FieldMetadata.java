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
import org.everit.atlassian.restclient.servicedeskcloud.v3.model.JsonTypeBean;

/**
 * The metadata describing an issue field.
 */
@ApiModel(description = "The metadata describing an issue field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class FieldMetadata {
  @JsonProperty("required")
  private Boolean required;

  @JsonProperty("schema")
  private JsonTypeBean schema;

  @JsonProperty("name")
  private String name;

  @JsonProperty("key")
  private String key;

  @JsonProperty("autoCompleteUrl")
  private String autoCompleteUrl;

  @JsonProperty("hasDefaultValue")
  private Boolean hasDefaultValue;

  @JsonProperty("operations")
  private List<String> operations = new ArrayList<>();

  @JsonProperty("allowedValues")
  private List<Object> allowedValues = new ArrayList<>();

  @JsonProperty("defaultValue")
  private Object defaultValue = null;

   /**
   * Whether the field is required.
   * @return required
  **/
  @ApiModelProperty(required = true, value = "Whether the field is required.")
  public Boolean getRequired() {
    return required;
  }

   /**
   * The data type of the field.
   * @return schema
  **/
  @ApiModelProperty(value = "The data type of the field.")
  public JsonTypeBean getSchema() {
    return schema;
  }

   /**
   * The name of the field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the field.")
  public String getName() {
    return name;
  }

   /**
   * The key of the field.
   * @return key
  **/
  @ApiModelProperty(required = true, value = "The key of the field.")
  public String getKey() {
    return key;
  }

   /**
   * The URL that can be used to automatically complete the field.
   * @return autoCompleteUrl
  **/
  @ApiModelProperty(value = "The URL that can be used to automatically complete the field.")
  public String getAutoCompleteUrl() {
    return autoCompleteUrl;
  }

   /**
   * Whether the field has a default value.
   * @return hasDefaultValue
  **/
  @ApiModelProperty(value = "Whether the field has a default value.")
  public Boolean getHasDefaultValue() {
    return hasDefaultValue;
  }

   /**
   * The list of operations that can be performed on the field.
   * @return operations
  **/
  @ApiModelProperty(required = true, value = "The list of operations that can be performed on the field.")
  public List<String> getOperations() {
    return operations;
  }

   /**
   * The list of values allowed in the field.
   * @return allowedValues
  **/
  @ApiModelProperty(value = "The list of values allowed in the field.")
  public List<Object> getAllowedValues() {
    return allowedValues;
  }

   /**
   * The default value of the field.
   * @return defaultValue
  **/
  @ApiModelProperty(value = "The default value of the field.")
  public Object getDefaultValue() {
    return defaultValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldMetadata fieldMetadata = (FieldMetadata) o;
    return Objects.equals(this.required, fieldMetadata.required) &&
        Objects.equals(this.schema, fieldMetadata.schema) &&
        Objects.equals(this.name, fieldMetadata.name) &&
        Objects.equals(this.key, fieldMetadata.key) &&
        Objects.equals(this.autoCompleteUrl, fieldMetadata.autoCompleteUrl) &&
        Objects.equals(this.hasDefaultValue, fieldMetadata.hasDefaultValue) &&
        Objects.equals(this.operations, fieldMetadata.operations) &&
        Objects.equals(this.allowedValues, fieldMetadata.allowedValues) &&
        Objects.equals(this.defaultValue, fieldMetadata.defaultValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(required, schema, name, key, autoCompleteUrl, hasDefaultValue, operations, allowedValues, defaultValue);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldMetadata {\n");
    
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    autoCompleteUrl: ").append(toIndentedString(autoCompleteUrl)).append("\n");
    sb.append("    hasDefaultValue: ").append(toIndentedString(hasDefaultValue)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    allowedValues: ").append(toIndentedString(allowedValues)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
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
