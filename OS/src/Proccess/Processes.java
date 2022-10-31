package Proccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

  public Processes() {}

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

  public static void print(String s) {
    System.out.println(s);
  }

  public static void readFile(String filePath) throws IOException {
    String currentLine = "";
    FileReader fileReader = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fileReader);
    while ((currentLine = br.readLine()) != null) print(currentLine);
    br.close();
  }

  public static void writeFile(String filePath, String data)
    throws IOException {
    FileWriter fileWrite = new FileWriter(filePath);
    fileWrite.write(data);
    fileWrite.close();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println(isString(sc.nextLine()));
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public state getState() {
    return state;
  }

  public void setState(state state) {
    this.state = state;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getAccountingInfo() {
    return accountingInfo;
  }

  public void setAccountingInfo(String accountingInfo) {
    this.accountingInfo = accountingInfo;
  }

  public int getPc() {
    return pc;
  }

  public void setPc(int pc) {
    this.pc = pc;
  }

  public String[] getCpuRegisters() {
    return cpuRegisters;
  }

  public void setCpuRegisters(String[] cpuRegisters) {
    this.cpuRegisters = cpuRegisters;
  }

  public int[] getPcbPointers() {
    return pcbPointers;
  }

  public void setPcbPointers(int[] pcbPointers) {
    this.pcbPointers = pcbPointers;
  }

  public ArrayList<String> getOpenFiles() {
    return openFiles;
  }

  public void setOpenFiles(ArrayList<String> openFiles) {
    this.openFiles = openFiles;
  }

  public String getIoInfo() {
    return ioInfo;
  }

  public void setIoInfo(String ioInfo) {
    this.ioInfo = ioInfo;
  }
}
