package Proccess;

import java.io.BufferedReader;
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
  public int n=0;
  public String attr[]= new String[50];
  public String values[]= new String[50];
 
  

  
  public Processes(int id,state state,int priority,String accountingInfo,int pc, String[] cpuRegisters,int[]pcbPointers,ArrayList<String>openFiles,String ioInfo){
    this.id=id;
    this.state=state;
    this.priority=priority;
    this.accountingInfo=accountingInfo;
    this.pc=pc;
    this.cpuRegisters=cpuRegisters;
    this.pcbPointers=pcbPointers;
    this.openFiles=openFiles;
    this.ioInfo=ioInfo;
    }

  public void assign(String x, String y){
      attr[n]=x;
      values[n]=y;
      n++;
      }
      
  public  void print(String x){
    if(n==0){
      System.out.println("There are no stored values");
    }
    else 
    for(int i =0;i<n;i++){
      if(attr[i]==x){
        System.out.println(values[i]);
      }
    }

  }
  public static void readFile(String filePath) throws IOException {
    String currentLine = "";
    FileReader fileReader = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fileReader);
    while ((currentLine = br.readLine()) != null) System.out.println(currentLine);
    br.close();
  }

  public static void writeFile(String filePath, String data)
    throws IOException {
    FileWriter fileWrite = new FileWriter(filePath);
    fileWrite.write(data);
    fileWrite.close();
  } 

  

    public static void main(String []args){
      
      
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
