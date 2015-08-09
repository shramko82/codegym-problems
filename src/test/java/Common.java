
public class Common {

  public static final String START = "[codegym-test]";
  public static final String END = "[/codegym-test]";

  public static String error(String msg) {
    return new StringBuilder().append(START).append(msg).append(END).toString();
  }

  public static boolean hasError(String msg) {
    return msg.contains(START);
  }

  public static String printArray(int[] arr) {
    return printArray(arr, new StringBuilder()).toString();
  }

  public static StringBuilder printArray(int[] arr, StringBuilder res) {
    res.append("[ ");
    int length = Math.min(1000, arr.length);

    for (int i = 0; i < length; i++) {
      res.append(arr[i]).append(", ");
    }
    if (length < arr.length) {
      res.append("...");
    }
    return res.append(']');
  }

  public static String printMatrix(int[][] m) {
    return printMatrix(m, new StringBuilder()).toString();
  }

  public static StringBuilder printMatrix(int[][] m, StringBuilder buf) {
    buf.append('[');
    for (int[] row : m) {
      printArray(row, buf);
    }
    return buf.append(']');
  }

  public static StringBuilder printChars(char[] input, StringBuilder buf) {
    buf.append('[');
    int minLen = Math.min(1000, input.length);
    for (int i = 0; i < minLen; i++) {
      buf.append('\'').append(input[i]).append("', ");
    }
    if (minLen < input.length) {
      buf.append("...");
    }
    return buf.append(']');
  }
}
