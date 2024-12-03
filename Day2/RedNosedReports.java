import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

// the brute force solution :(

public class RedNosedReports {
  public static boolean isSorted(ArrayList<Integer> arr) {
    boolean increasing = true;
    boolean decreasing = true;

    for(int i=1; i<arr.size(); i++) {
      if (arr.get(i) > arr.get(i-1)) decreasing = false;
      if (arr.get(i) < arr.get(i-1)) increasing = false;
    }

    return increasing || decreasing;
  }

  public static boolean safe(ArrayList<Integer> arr) {
    boolean isSorted = isSorted(arr);
    boolean satisfiesCondition = true;

    for(int i=1; i<arr.size(); i++) {
      int diff = Math.abs(arr.get(i) - arr.get(i-1));
      if (diff < 1 || diff > 3) {
        satisfiesCondition = false;
        break;
      }
    }

    return isSorted && satisfiesCondition;
  }

  public static void main(String[] args) throws Exception {
    File file = new File("input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    int safeCount = 0;
    String st;

    while((st = br.readLine()) != null) {
      String[] numArray = st.split(" ");
      ArrayList<Integer> arr = new ArrayList<> ();

      // Make the ArrayList
      for (String num : numArray) {
        arr.add(Integer.parseInt(num));
      }

      // part 1
      if(safe(arr)) {
        safeCount++;
        // System.out.print("First time safe : ");
        // for(Integer i : arr) {
        //   System.out.print(i + " ");
        // }
        // System.out.println();
      }

      // part 2 
      // can the list be made safe by removing one of the items of the list?

      // check by removing every element of the list once and return true if it is good
      else {
        for(int i=0; i<arr.size();i++) {
          ArrayList<Integer> copy = new ArrayList<>();
          for(Integer k : arr) {
            copy.add(k);
          }
          copy.remove(i);
          if(safe(copy)) {
            safeCount++;
            break;
          }
        }
      }
    }

    System.out.println(safeCount);
  }
}
