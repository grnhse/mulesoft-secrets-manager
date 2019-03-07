package org.mule.extension.secretsmanager.internal;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public final class SecretsManager {

  private SecretsManagerClient sm;

  public SecretsManager() {
    this(Region.US_EAST_1);
  }

  public SecretsManager(Region region) {
    this.sm = SecretsManagerClient.builder().region(region).build();
  }

  public String getSecretString(String secretId) {
    GetSecretValueRequest req = GetSecretValueRequest.builder().secretId(secretId).build();
    GetSecretValueResponse secret = this.sm.getSecretValue(req);

    return secret.secretString();
  }

  public SdkBytes getSecretBinary(String secretId) {
    GetSecretValueRequest req = GetSecretValueRequest.builder().secretId(secretId).build();

    GetSecretValueResponse secret = this.sm.getSecretValue(req);

    return secret.secretBinary();
  }
}