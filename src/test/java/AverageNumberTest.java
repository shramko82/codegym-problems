import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RunWith(Parameterized.class)
public class AverageNumberTest extends AbstractTest {

  static Set<String> classes = new HashSet<String>() {{
    add("AverageNumber");
  }};
  int firstArg, secondArg;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new AverageNumber().average(firstArg, secondArg);
      if (actual != expected) {
        Assert.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public AverageNumberTest(int firstArg, int secondArg, int expected) {
    this.firstArg = firstArg;
    this.secondArg = secondArg;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {2, 4, 3},
        {1, 4, 2},
        {-10, -20, -15},
        {-2, -3, -2},
        {1<<30, 1<<30, 1<<30},
        {1<<30, -(1<<30), 0},
        {-(1<<30), 1<<30, 0},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
        {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
        {Integer.MIN_VALUE, -2, -1073741825},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected Set<String> getTestClasses() {
    return classes;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Input: ")
        .append(firstArg)
        .append(", ")
        .append(secondArg)
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
