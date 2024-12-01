import java.io.*;
import java.util.Collections;
import java.util.ArrayList;

public class Example {
  public static void main(String[] args) throws Exception {
    File file = new File("input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    ArrayList<Integer> arr = new ArrayList<>();

    int sum = 0;
    String st;

    while((st = br.readLine()) != null) {
      if(!st.trim().isEmpty()) {
        try {
          sum += Integer.parseInt(st.trim());
        } catch (NumberFormatException e) {
          System.out.println("invalid");
        }
      }
      else {
        arr.add(sum);
        sum = 0;
      }
    }

    if (sum > 0) {
      arr.add(sum);
    }

    br.close();

    for(Integer i : arr) {
      System.out.println(i);
    }

    Collections.sort(arr);
    System.out.println(arr.get(arr.size() - 1));
  }
}
