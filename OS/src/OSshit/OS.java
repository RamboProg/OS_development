package OSshit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class OS {
  private Queue mem;

  public enum events {
    REQ_HEAP,
    DIV_ZERO,
    ACC_PMEM,
    KEY,
    DISK_READ_FINISH,
  }

  public static Enum generateRandomEvent() {
    Random r = new Random();
    List<events> event = Arrays.asList(
      events.REQ_HEAP,
      events.DIV_ZERO,
      events.ACC_PMEM,
      events.KEY,
      events.DISK_READ_FINISH
    );
    return event.get(r.nextInt(event.size()));
  }

  public static void assign(Object x, String y) {
    int a;

    String s = "";
    if (!isString(y)) {
      a = Integer.parseInt(y);
      x = a;
    } else s = y;
    x = s;
  }

  //Helper method to check if the parametre is string
  public static boolean isString(String y) {
    char x = y.charAt(0);
    if (x >= 65 && x <= 122) return true; else return false;
  }

  public static void readFile(String filePath) throws IOException {
    String currentLine = "";
    FileReader fileReader = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fileReader);
    while ((currentLine = br.readLine()) != null) System.out.println(
      currentLine
    );
    br.close();
  }

  public static void writeFile(String filePath, String data)
    throws IOException {
    FileWriter fileWrite = new FileWriter(filePath);
    fileWrite.write(data);
    fileWrite.close();
  }

  public void interruptHandler() {
    Enum e = generateRandomEvent();
    if (e == events.KEY) {
      mem.add("KEY");
    }
  }

  public void exceptionHandler() {}
}
