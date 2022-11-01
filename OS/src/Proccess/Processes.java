package Proccess;

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
  public Object x;

  public Processes(){

}
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

  public void assign(Object x, String y){
      this.x=x;
      int a;
      String s;
      if(!isString(y)){
        a= Integer.parseInt(y);
        x=a;
      }else {
      s=y;
      x=s;
      }
      }
      


  
    public static boolean isString(String y){
      char x=y.charAt(0);
      if(x>=65 && x<=122)
        return true;
    else return false;
    }

    public static void main(String []args){
      Scanner sc= new Scanner(System.in);
      
      
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
