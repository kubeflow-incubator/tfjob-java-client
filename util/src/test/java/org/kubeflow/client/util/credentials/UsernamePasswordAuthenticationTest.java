package org.kubeflow.client.util.credentials;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.common.base.Charsets;
import okio.ByteString;
import org.junit.Test;
import org.kubeflow.client.ApiClient;
import org.kubeflow.client.util.TestUtils;

public class UsernamePasswordAuthenticationTest {

  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  public static final byte[] USERNAME_PASSWORD_BYTES =
      (USERNAME + ":" + PASSWORD).getBytes(Charsets.ISO_8859_1);

  @Test
  public void testUsernamePasswordProvided() {
    final ApiClient client = new ApiClient();
    new UsernamePasswordAuthentication(USERNAME, PASSWORD).provide(client);
    assertThat(TestUtils.getApiKeyAuthFromClient(client).getApiKeyPrefix(), is("Basic"));
    assertThat(
        TestUtils.getApiKeyAuthFromClient(client).getApiKey(),
        is(ByteString.of(USERNAME_PASSWORD_BYTES).base64()));
  }
}
