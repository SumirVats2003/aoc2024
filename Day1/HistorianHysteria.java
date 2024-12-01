// import java.util.Scanner;
// import java.util.Collections;
// import java.util.ArrayList;
// import java.lang.Math;
// import java.util.HashMap;

// public class HistorianHysteria {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);

//     ArrayList<Integer> a1 = new ArrayList<>();
//     ArrayList<Integer> a2 = new ArrayList<>();

//     for (int i=0; i<1000; i++) {
//       a1.add(sc.nextInt());
//       a2.add(sc.nextInt());
//     }

//     sc.close();

//     // part 1

//     /*
//     Collections.sort(a1);
//     Collections.sort(a2);

//     int totSum = 0;

//     for(int i=0; i<1000; i++) {
//       totSum += Math.abs(a1.get(i) - a2.get(i));
//     }

//     System.out.println(totSum);
//     */

//     // part 2

//     // we need to maintain a count of the number of times a number appears in the second list. we can use a hashmap here

//     HashMap<Integer, Integer> map = new HashMap<>();

//     for(Integer i : a2) {
//       // if(map.get(i) == null) {
//       //   map.put(i, 1);
//       // }
//       // else {
//       //   map.put(i, map.get(i)+1);
//       // }
//       map.putIfAbsent(i, 0);
//       map.put(i, map.get(i) + 1);
//     }

//     int totSimilarity = 0;

//     for (Integer i : a1) {
//       // int similarity;
//       // if (map.get(i) == null) {
//       //   similarity = 0;
//       // }
//       // else {
//       //   similarity = i * (map.get(i));
//       // }

//       // totSimilarity += similarity;
//       totSimilarity += i * map.getOrDefault(i, 0);
//     }

//     System.out.println(totSimilarity);
//   }
// }

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Math;
import java.util.HashMap;

public class HistorianHysteria {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Integer> a1 = new ArrayList<>();
    ArrayList<Integer> a2 = new ArrayList<>();

    for (int i=0; i<1000; i++) {
      a1.add(sc.nextInt());
      a2.add(sc.nextInt());
    }

    sc.close();

    // part 1
    Collections.sort(a1);
    Collections.sort(a2);

    int totSum = 0;

    for(int i=0; i<1000; i++) {
      totSum += Math.abs(a1.get(i) - a2.get(i));
    }

    System.out.println(totSum);

    // part 2 
    HashMap<Integer, Integer> map = new HashMap<>();

    for(Integer i : a2) {
      map.putIfAbsent(i, 0);
      map.put(i, map.get(i) + 1);
    }

    int totSimilarity = 0;

    for (Integer i : a1) {
      totSimilarity += i * map.getOrDefault(i, 0);
    }

    System.out.println(totSimilarity);
  }
}
