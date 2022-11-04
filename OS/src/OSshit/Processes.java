package OSshit;

import java.util.Scanner;

public class Processes {

  public enum state {
    NEW,
    READY,
    RUNNING,
    BLOCKED,
    FINISHED,
  }

  private int processID;
  private state state;
  private int mode;

  public Processes(int id) {
    processID = id;
    this.state = state.NEW;
    this.mode = 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  }
}
