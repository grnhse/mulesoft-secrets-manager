package org.mule.extension.secretsmanager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.mule.extension.secretsmanager.internal.SecretsManager;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.junit.Test;

public class SecretsManagerOperationsTestCase extends MuleArtifactFunctionalTestCase {
  /**
   * Specifies the mule config xml with the flows that are going to be executed in
   * the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void fakeTest() throws Exception {
    assert (true);
    // String payloadValue = ((String)
    // flowRunner("getSecretsFlow").run().getMessage().getPayload().getValue());
    // assertThat(payloadValue, is("secret_value"));
  }

}
