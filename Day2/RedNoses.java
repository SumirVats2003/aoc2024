import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class RedNoses {
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

  public static boolean problemDampnerDifferences(ArrayList<Integer> arr) {
    int errorCount = 0;
    int index;

    for (int i=1; i < arr.size(); i++) {
      int diff = Math.abs(arr.get(i) - arr.get(i-1));
      if(diff > 3) {
        return false;
      }
      if(diff == 0) {
        errorCount++;
        index = i-1;
      }
      if(errorCount > 1) return false;
    }

    return true;
  }

  public static boolean problemDampnerSorting(ArrayList<Integer> arr) {
    int asc = 0;
    int dsc = 0;
    int indexa = 0, indexd = 0;

    for(int i=1; i<arr.size(); i++) {
      if(arr.get(i-1) > arr.get(i)) {
        dsc++;
        indexd = i-1;
      }
      if(arr.get(i-1) < arr.get(i)) {
        asc++;
        indexa = i-1;
      }

      if(dsc > 1 && asc > 1) return false;
    }

    if(dsc == 1) {
      // if(indexd == arr.size()-2) {indexd++;}
      arr.remove(indexd);
    }
    else if(asc == 1) {
      // if(indexa == arr.size()-2) {indexa++;}
      arr.remove(indexa);
    }

    return safe(arr);
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
        System.out.print("First time safe : ");
        for(Integer i : arr) {
          System.out.print(i + " ");
        }
        System.out.println();
      }
      // part 2 
      // can the list be made safe by removing one of the items of the list?

      // if the error happens for the first time, we can eliminate it
      else {
        if(isSorted(arr)) {
          safeCount += problemDampnerDifferences(arr) ? 1 : 0;

          if(problemDampnerDifferences(arr)) {
            System.out.print("Second time safe : ");
            for(Integer i : arr) {
              System.out.print(i + " ");
            }
            System.out.println();
          }
        }
        else {
          safeCount += problemDampnerSorting(arr) ? 1 : 0;

          if(problemDampnerSorting(arr)) {
            System.out.print("Third time safe : ");
            
          }
          else {
            System.out.print("Unsafe : ");
          }

          for(Integer i : arr) {
            System.out.print(i + " ");
          }
          System.out.println();
        }
      }
    }

    System.out.println(safeCount);
  }
}
