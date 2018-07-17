package org.kubeflow.client.util;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class JobUtilTest {
  @Test
  public void testJoinCommands() {
    String[] commands = {"sh", "-c", "date"};
    String expected = "sh -c date";
    assertEquals(JobUtil.joinCommands(Arrays.asList(commands)), expected);

    assertEquals(JobUtil.joinCommands(null), "");

    String[] singleCommands = {"date"};
    expected = "date";
    assertEquals(JobUtil.joinCommands(Arrays.asList(singleCommands)), expected);
  }

  @Test
  public void testGenerateUUID() {
    String uuid = JobUtil.generateUUID();
    assertEquals(uuid.indexOf("-"), -1);
  }
}
