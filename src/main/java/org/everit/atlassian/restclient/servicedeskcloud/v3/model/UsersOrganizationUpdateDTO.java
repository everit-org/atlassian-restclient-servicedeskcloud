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

/**
 * UsersOrganizationUpdateDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-04-02T14:33:08.600+02:00[Europe/Prague]")
public class UsersOrganizationUpdateDTO {
  @JsonProperty("usernames")
  private List<String> usernames = new ArrayList<>();

  @JsonProperty("accountIds")
  private List<String> accountIds = new ArrayList<>();

  public UsersOrganizationUpdateDTO usernames(List<String> usernames) {
    this.usernames = usernames;
    return this;
  }

  public UsersOrganizationUpdateDTO addUsernamesItem(String usernamesItem) {
    if (this.usernames == null) {
      this.usernames = new ArrayList<>();
    }
    this.usernames.add(usernamesItem);
    return this;
  }

   /**
   * This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. Use &#x60;accountIds&#x60; instead.
   * @return usernames
  **/
  @ApiModelProperty(value = "This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. Use `accountIds` instead.")
  public List<String> getUsernames() {
    return usernames;
  }

  public void setUsernames(List<String> usernames) {
    this.usernames = usernames;
  }

  public UsersOrganizationUpdateDTO accountIds(List<String> accountIds) {
    this.accountIds = accountIds;
    return this;
  }

  public UsersOrganizationUpdateDTO addAccountIdsItem(String accountIdsItem) {
    if (this.accountIds == null) {
      this.accountIds = new ArrayList<>();
    }
    this.accountIds.add(accountIdsItem);
    return this;
  }

   /**
   * List of customers, specific by account IDs, to add to or remove from the organization.
   * @return accountIds
  **/
  @ApiModelProperty(value = "List of customers, specific by account IDs, to add to or remove from the organization.")
  public List<String> getAccountIds() {
    return accountIds;
  }

  public void setAccountIds(List<String> accountIds) {
    this.accountIds = accountIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersOrganizationUpdateDTO usersOrganizationUpdateDTO = (UsersOrganizationUpdateDTO) o;
    return Objects.equals(this.usernames, usersOrganizationUpdateDTO.usernames) &&
        Objects.equals(this.accountIds, usersOrganizationUpdateDTO.accountIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usernames, accountIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersOrganizationUpdateDTO {\n");
    
    sb.append("    usernames: ").append(toIndentedString(usernames)).append("\n");
    sb.append("    accountIds: ").append(toIndentedString(accountIds)).append("\n");
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

