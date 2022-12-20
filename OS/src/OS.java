import Exception_Handler.RandomEventGenerator;
import Extras.*;
import Proccess.*;
import Semaphores.BinarySemaphore;
import Semaphores.CountingSemaphores;
import Semaphores.MutexSemaphores;
import Semaphores.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class OS {
  public Memory memory = new Memory(200);
  private char keys;
  private Disk_Status state = Disk_Status.BUSY;
  private int PID = (int) (Math.random() * (6000 - 1) + 1);
  private int readLength = (int) ((Math.random() * (888 - 1) + 1)); // generates the length
  private ProcS p;
  private Queue<ProcS> readyQueue;
  BinarySemaphore bsRead = new BinarySemaphore();
  CountingSemaphores csWrite = new CountingSemaphores();
  MutexSemaphores msAssign = new MutexSemaphores();
  BinarySem2 bs2_Print = new BinarySem2();

  public enum Disk_Status {
    BUSY,
    IDLE,
  }

  public enum events {
    REQ_HEAP,
    DIV_ZERO,
    ACC_PMEM,
    KEY,
    DISK_READ_FINISH,
  }

  public void assign(Object x, String y) {
    ProcS a = new ProcS(0);
    if (msAssign.value == Value.ONE) {
      x = y;
      msAssign.semSignalM(msAssign, a);
    } else {
      msAssign.processQueue.add(a);
    }
  }

  public void assign(Object x, int y) {
    ProcS a = new ProcS(9);
    if (msAssign.value == Value.ONE) {
      x = y;
      msAssign.semSignalM(msAssign, a);
    } else {
      msAssign.processQueue.add(a);
    }
  }

  public void readFile(String filePath) throws IOException {
    ProcS a = new ProcS(90);
    if (bsRead.value == Value.ONE) {
      bsRead.semWaitB(bsRead, a); // sem set to zero

      String currentLine = "";
      FileReader fileReader = new FileReader(filePath);
      BufferedReader br = new BufferedReader(fileReader);
      while ((currentLine = br.readLine()) != null) {
        print(currentLine);
        System.out.println(currentLine);
      }
      br.close();
      bsRead.semSignalB(bsRead, a);
    } else {
      bsRead.processQueue.add(a);
    }

  }

  public void writeFile(String filePath, String data) throws IOException {
    ProcS a = new ProcS(7);
    if (csWrite.count < 80) {

      FileWriter fileWrite = new FileWriter(filePath);
      fileWrite.write(data);
      fileWrite.close();
      csWrite.semSignalC(csWrite, a);
    } else {
      csWrite.processQueue.add(a);
    }
  }

  public void print(String ahmed) {
    ProcS a = new ProcS(2);
    if (bs2_Print.value == Value.ONE) {

      System.out.println(ahmed);
      bs2_Print.semSignalB(bs2_Print, a);
    }
    bs2_Print.processQueue.add(a);
  }

  public void KeyPress() {
    keys = RandomEventGenerator.generateRandomKey();
    System.out.println("They key that has been pressed is : " + keys); // randomly generated
    memory.insertKEy(keys); // simulates the users input and it puts it in the memory
  }

  public void ReqHeap() { // Store in free and check il stack
    memory.insertIntoHeap();
    System.out.println("REQ was called");
  }

  public void DIV_ZERO() {
    int newID = (int) (Math.random() * (6000 - 1) + 1);
    while (newID == PID) {
      newID = (int) (Math.random() * (6000 - 1) + 1);
    }
    p.setId(newID);
    p.setState(State.TERMINATED);

    System.out.println("An arthmctic error has occured : Division by Zero"); // exception
  }

  public void AttemptsPriv() {
    System.out.println(
        "You cant acces privileged memory. Reallocating a new space in memory");
    // put the value in the stack or in the heap or in random location but not the
    // priveleged part if yes then look at the following shit
    if (memory.stackISFull()) {
      memory.insertIntoHeap();
    } else if (memory.heapISFull()) {
      memory.insertIntoStack();
    } else
      memory.insertIntoFree();
  }

  public void DiskController() {
    System.out.println("DISl was called");
    state = Disk_Status.IDLE; // changes teh status of the disk form running to idle because it finished
    // reading from the disk
    Enum Operation = generatesOperation(); // generates Operation by calling the method generatesOperation
    int LengthinBits = readLength * 4; // to make it in bits
  }

  public enum Operation {
    READ,
    WRITE,
  }

  public Enum generatesOperation() {
    int rndEvent = (int) (Math.random() * 2) + 1;
    if (rndEvent == 1)
      return Operation.READ;
    return Operation.WRITE;
  }

  public void CallsRandomEvents() {
    Enum EVE = RandomEventGenerator.generateRandomEvent(); // gets the enum of the event
    String Event = EVE.toString(); // changes the enum to a string to be used in the switch cases
    switch (Event) {
      case "DIV_ZERO":
        DIV_ZERO();
        break;
      case "READ_FINISH":
        DiskController();
        break;
      case "KEY":
        KeyPress();
        break;
      case "ACC_PMEM":
        AttemptsPriv();
        break;
      case "REQ_HEAP":
        ReqHeap();
        break;
      default:
        CallsRandomEvents();
    }
  }

  public void create(int id) {
    ProcS p = new ProcS(PID);
  }

  public void destroy() {
    // Destroys a process
  }

  public String getProcStatus(ProcS p) {
    int age = p.getAge();
    String state = p.getState().toString();

    return "The process's age is: " + age + "\n" + "The process's state is: " + state;
  }

  public void processA() {
    Scanner sc = new Scanner(System.in);
    String filePath = sc.nextLine();
    try {
      readFile(filePath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    sc.close();
  }

  public void processB() {
    Scanner sc = new Scanner(System.in);
    String filePath = sc.nextLine();
    String data = sc.nextLine();
    try {
      writeFile(filePath, data);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    sc.close();
  }

  // public static void main(String[] args) {
  // OS WRZ = new OS();
  // WRZ.CallsRandomEvents();
  // }
}
