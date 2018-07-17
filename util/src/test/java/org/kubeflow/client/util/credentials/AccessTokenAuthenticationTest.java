package org.kubeflow.client.util.credentials;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.kubeflow.client.ApiClient;
import org.kubeflow.client.util.TestUtils;

public class AccessTokenAuthenticationTest {

  @Test
  public void testTokenProvided() {
    final ApiClient client = new ApiClient();
    new AccessTokenAuthentication("token").provide(client);
    assertThat(TestUtils.getApiKeyAuthFromClient(client).getApiKeyPrefix(), is("Bearer"));
    assertThat(TestUtils.getApiKeyAuthFromClient(client).getApiKey(), is("token"));
  }

  @Test(expected = NullPointerException.class)
  public void testTokenNonnull() {
    new AccessTokenAuthentication(null);
  }
}
