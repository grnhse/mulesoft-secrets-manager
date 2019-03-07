package org.mule.extension.secretsmanager.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.extension.secretsmanager.internal.SecretsManager;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;

import software.amazon.awssdk.regions.Region;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class SecretsManagerOperations {
  @MediaType(value = ANY, strict = false)
  public String getSecretValue(@Config SecretsManagerConfiguration configuration, String keyName, boolean simulated,
      @Optional String simulatedKeyValue) {
    if (simulated) {
      return getMockSecret(simulatedKeyValue);
    } else {
      return getAmazonSecret(configuration.getPrefix(), keyName);
    }
  }

  private String getAmazonSecret(String prefix, String keyName) {
    String fullKey = "";
    if (prefix != "") {
      fullKey = prefix + "_" + keyName;
    }
    SecretsManager sm = new SecretsManager();
    return sm.getSecretString(fullKey);
  }

  private String getMockSecret(String simulatedKeyValue) {
    return simulatedKeyValue;
  }
}
