package org.kubeflow.client.util;

import java.util.List;
import java.util.UUID;

public class JobUtil {

  /**
   * same usage with Strings.join() in Java8
   *
   * @param commands list of splitted command
   * @return a command joined by given list
   */
  public static String joinStrings(List<String> commands) {
    if (commands == null) {
      return "";
    }
    String delim = " ";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < commands.size(); i++) {
      sb.append(commands.get(i));
      if (i != (commands.size() - 1)) {
        sb.append(delim);
      }
    }

    return sb.toString();
  }

  public static String generateUUID() {
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    return str.toLowerCase().replace("-", "_");
  }

  public static String generateScriptPath(String namespace, String uuid) {
    return "";
  }
}
