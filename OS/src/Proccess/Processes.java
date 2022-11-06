package Proccess;

import java.util.ArrayList;

public class Processes {

  private int id;
  private state state;
  private int priority;
  private String accountingInfo;
  private int pc;
  private String[] cpuRegisters;
  private int[] pcbPointers;
  private ArrayList<String> openFiles;
  private String ioInfo;

  public enum state {
    NEW,
    READY,
    RUNNING,
    BLOCKED,
    TERMINATED,
    FINISHED,
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public Processes(
    int id,
    state state,
    int priority,
    String accountingInfo,
    int pc,
    String[] cpuRegisters,
    int[] pcbPointers,
    ArrayList<String> openFiles,
    String ioInfo
  ) {
    this.id = id;
    this.state = state;
    this.priority = priority;
    this.accountingInfo = accountingInfo;
    this.pc = pc;
    this.cpuRegisters = cpuRegisters;
    this.pcbPointers = pcbPointers;
    this.openFiles = openFiles;
    this.ioInfo = ioInfo;
  }

  public Processes(int id, state running) {
    this.id = id;
    this.state = state.RUNNING;
  }

  public state getState() {
    return state;
  }

  public void setState(state state) {
    this.state = state;
  }
}
