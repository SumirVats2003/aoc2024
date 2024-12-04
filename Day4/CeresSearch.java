import java.io.*;
import java.util.ArrayList;

public class CeresSearch {
  public static int xmasCount(ArrayList<String> list) {
    int count = 0;
    int rows = list.size();
    int cols = list.get(0).length();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (list.get(i).charAt(j) == 'X') {
                // Check horizontal (right)
          if (j + 3 < cols &&
            list.get(i).charAt(j + 1) == 'M' &&
            list.get(i).charAt(j + 2) == 'A' &&
            list.get(i).charAt(j + 3) == 'S') {
            count++;
          }

                // Check horizontal (left)
          if (j - 3 >= 0 &&
            list.get(i).charAt(j - 1) == 'M' &&
            list.get(i).charAt(j - 2) == 'A' &&
            list.get(i).charAt(j - 3) == 'S') {
            count++;
          }

                // Check vertical (down)
          if (i + 3 < rows &&
            list.get(i + 1).charAt(j) == 'M' &&
            list.get(i + 2).charAt(j) == 'A' &&
            list.get(i + 3).charAt(j) == 'S') {
            count++;
          }

                // Check vertical (up)
          if (i - 3 >= 0 &&
            list.get(i - 1).charAt(j) == 'M' &&
            list.get(i - 2).charAt(j) == 'A' &&
            list.get(i - 3).charAt(j) == 'S') {
            count++;
          }

                // Check diagonal (down-right)
          if (i + 3 < rows && j + 3 < cols &&
            list.get(i + 1).charAt(j + 1) == 'M' &&
            list.get(i + 2).charAt(j + 2) == 'A' &&
            list.get(i + 3).charAt(j + 3) == 'S') {
            count++;
          }

                // Check diagonal (up-left)
          if (i - 3 >= 0 && j - 3 >= 0 &&
            list.get(i - 1).charAt(j - 1) == 'M' &&
            list.get(i - 2).charAt(j - 2) == 'A' &&
            list.get(i - 3).charAt(j - 3) == 'S') {
            count++;
          }

                // Check diagonal (down-left)
          if (i + 3 < rows && j - 3 >= 0 &&
            list.get(i + 1).charAt(j - 1) == 'M' &&
            list.get(i + 2).charAt(j - 2) == 'A' &&
            list.get(i + 3).charAt(j - 3) == 'S') {
            count++;
          }

                // Check diagonal (up-right)
          if (i - 3 >= 0 && j + 3 < cols &&
            list.get(i - 1).charAt(j + 1) == 'M' &&
            list.get(i - 2).charAt(j + 2) == 'A' &&
            list.get(i - 3).charAt(j + 3) == 'S') {
            count++;
          }
        }
      }
    }

    return count;
  }

  public static int partTwoCount(ArrayList<String> list) {
    int count = 0;
    int rows = list.size();
    int cols = list.get(0).length();

    for (int i = 1; i < rows - 1; i++) {
      for (int j = 1; j < cols - 1; j++) {
        if (list.get(i).charAt(j) == 'A') {
          if (list.get(i - 1).charAt(j - 1) == 'M' &&
            list.get(i - 1).charAt(j + 1) == 'S' &&
            list.get(i + 1).charAt(j - 1) == 'M' &&
            list.get(i + 1).charAt(j + 1) == 'S') {
            count++;
          }

          if (list.get(i - 1).charAt(j - 1) == 'S' &&
            list.get(i - 1).charAt(j + 1) == 'M' &&
            list.get(i + 1).charAt(j - 1) == 'S' &&
            list.get(i + 1).charAt(j + 1) == 'M') {
            count++;
          }

          if (list.get(i - 1).charAt(j - 1) == 'M' &&
            list.get(i - 1).charAt(j + 1) == 'M' &&
            list.get(i + 1).charAt(j - 1) == 'S' &&
            list.get(i + 1).charAt(j + 1) == 'S') {
            count++;
          }

          if (list.get(i - 1).charAt(j - 1) == 'S' &&
            list.get(i - 1).charAt(j + 1) == 'S' &&
            list.get(i + 1).charAt(j - 1) == 'M' &&
            list.get(i + 1).charAt(j + 1) == 'M') {
            count++;
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) throws Exception {
    File file = new File("input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    ArrayList<String> list = new ArrayList<>();

    String st;
    while((st = br.readLine()) != null) {
      list.add(st);
    }
    br.close();

    System.out.println(partTwoCount(list));    
  } 
}

/*
XMAS
SAMX

X
M
A
S

S
A
M
X

X
 M
  A
   S

   S
  A
 M
X

S
 A
  M
   X

   X
  M
 A
S
*/