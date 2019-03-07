package org.mule.extension.secretsmanager.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.Configuration;

/**
 * This class represents an extension configuration, values set in this class
 * are commonly used across multiple operations since they represent something
 * core from the extension.
 */
// @ConnectionProviders(SecretsmanagerConnectionProvider.class)
@Operations(SecretsManagerOperations.class)
public class SecretsManagerConfiguration {
  @Parameter
  @Optional(defaultValue = "")
  private String prefix;

  public String getPrefix() {
    return prefix;
  }
}
