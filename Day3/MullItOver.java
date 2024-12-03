import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class MullItOver {
  public static int mul(int x, int y) {
    return x*y;
  }

  private static int processSegment(String segment, Pattern mulPattern, boolean include) {
    int segmentSum = 0;
    if (include) {
      Matcher mulMatcher = mulPattern.matcher(segment);
      while (mulMatcher.find()) {
        int num1 = Integer.parseInt(mulMatcher.group(1));
        int num2 = Integer.parseInt(mulMatcher.group(2));

        segmentSum += num1 * num2;
      }
    }
    return segmentSum;
  }

  public static void main(String[] args) throws Exception {
    File file = new File("input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String regex = "mul\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*\\)";
    String commandRegex = "do\\(\\)|don't\\(\\)";

    Pattern commandPattern = Pattern.compile(commandRegex);
    Pattern pattern = Pattern.compile(regex); 

    boolean include = true;

    String st;
    String memory = "";

    while((st = br.readLine()) != null) {
      memory += st;
    }
    br.close();
    // System.out.println(memory);

    Matcher matcher = commandPattern.matcher(memory);

    int total = 0;
    int currentIndex = 0;

    while (matcher.find()) {
      String segment = memory.substring(currentIndex, matcher.start());
      total += processSegment(segment, pattern, include);

      String command = matcher.group();
      if (command.equals("do()")) {
        include = true;
      }
      else if(command.equals("don't()")) {
        include = false;
      }

      currentIndex = matcher.end();
    }

    total += processSegment(memory.substring(currentIndex), pattern, include);

    System.out.println(total);
  }
}
