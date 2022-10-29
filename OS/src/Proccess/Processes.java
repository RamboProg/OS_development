package Proccess;

import java.util.ArrayList;

public class Processes {

  public enum state {
    NEW,
    READY,
    RUNNING,
    BLOCKED,
    FINISHED,
  }

  private int id;
  private state state;
  private int priority;
  private String accountingInfo;
  private int pc;
  private String[] cpuRegisters;
  private int[] pcbPointers;
  private ArrayList<String> openFiles;
  private String ioInfo;
}
