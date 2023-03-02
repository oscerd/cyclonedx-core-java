/*
 * This file is part of CycloneDX Core (Java).
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
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.cyclonedx.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.cyclonedx.util.serializer.CustomDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"altIds", "licensor", "licensee", "purchaser", "purchaseOrder", "licenseTypes", "lastRenewal", "expiration"})
@JsonRootName("licensing")
public class Licensing extends ExtensibleElement
{
  public enum LicensingType
  {
    @JsonProperty("academic")
    ACADEMIC("academic"),
    @JsonProperty("appliance")
    APPLIANCE("appliance"),
    @JsonProperty("client-access")
    CLIENT_ACCESS("client-access"),
    @JsonProperty("concurrent-user")
    CONCURRENT_USER("concurrent-user"),
    @JsonProperty("core-points")
    CORE_POINTS("core-points"),
    @JsonProperty("custom-metric")
    CUSTOM_METRIC("custom-metric"),
    @JsonProperty("device")
    DEVICE("device"),
    @JsonProperty("evaluation")
    EVALUATION("evaluation"),
    @JsonProperty("named-user")
    NAMED_USER("named-user"),
    @JsonProperty("node-locked")
    NODE_LOCKED("node-locked"),
    @JsonProperty("oem")
    OEM("oem"),
    @JsonProperty("perpetual")
    PERPETUAL("perpetual"),
    @JsonProperty("processor-points")
    PROCESSOR_POINTS("processor-points"),
    @JsonProperty("subscription")
    SUBSCRIPTION("subscription"),
    @JsonProperty("user")
    USER("user"),
    @JsonProperty("other")
    OTHER("other");

    private final String name;

    public String getLicensingType() {
      return this.name;
    }

    LicensingType(String name) {
      this.name = name;
    }
  }

  private List<String> altIds;

  private OrganizationalInstance licensor;

  private OrganizationalInstance licensee;

  private OrganizationalInstance purchaser;

  private String purchaseOrder;

  private List<LicensingType> licenseTypes;

  @JsonSerialize(using = CustomDateSerializer.class)
  private Date lastRenewal = new Date();

  @JsonSerialize(using = CustomDateSerializer.class)
  private Date expiration = new Date();

  public List<String> getAltIds() {
    return altIds;
  }

  public void setAltIds(final List<String> altIds) {
    this.altIds = altIds;
  }

  @JacksonXmlProperty(localName = "licensor")
  @JsonProperty("licensor")
  public OrganizationalInstance getLicensor() {
    return licensor;
  }

  public void setLicensor(final OrganizationalInstance licensor) {
    this.licensor = licensor;
  }

  @JacksonXmlProperty(localName = "licensee")
  @JsonProperty("licensee")
  public OrganizationalInstance getLicensee() {
    return licensee;
  }

  public void setLicensee(final OrganizationalInstance licensee) {
    this.licensee = licensee;
  }

  @JacksonXmlProperty(localName = "purchaser")
  @JsonProperty("purchaser")
  public OrganizationalInstance getPurchaser() {
    return purchaser;
  }

  public void setPurchaser(final OrganizationalInstance purchaser) {
    this.purchaser = purchaser;
  }

  public String getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(final String purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  public List<LicensingType> getLicenseTypes() {
    return licenseTypes;
  }

  public void setLicenseTypes(final List<LicensingType> licenseTypes) {
    this.licenseTypes = licenseTypes;
  }

  public Date getLastRenewal() {
    return lastRenewal;
  }

  public void setLastRenewal(final Date lastRenewal) {
    this.lastRenewal = lastRenewal;
  }

  public Date getExpiration() {
    return expiration;
  }

  public void setExpiration(final Date expiration) {
    this.expiration = expiration;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Licensing)) {
      return false;
    }
    Licensing licensing = (Licensing) o;
    return Objects.equals(altIds, licensing.altIds) && Objects.equals(licensor, licensing.licensor) &&
        Objects.equals(licensee, licensing.licensee) &&
        Objects.equals(purchaser, licensing.purchaser) &&
        Objects.equals(purchaseOrder, licensing.purchaseOrder) &&
        Objects.equals(licenseTypes, licensing.licenseTypes) &&
        Objects.equals(lastRenewal, licensing.lastRenewal) &&
        Objects.equals(expiration, licensing.expiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(altIds, licensor, licensee, purchaser, purchaseOrder, licenseTypes, lastRenewal, expiration);
  }
}
