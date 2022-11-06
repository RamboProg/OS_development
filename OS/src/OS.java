import Exception_Handler.RandomEventGenerator;
import Extras.Memory;
import Proccess.Processes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OS {
  public Memory memory = new Memory(200);
  private char keys;
  private Disk_Status state = Disk_Status.BUSY;
  private int PID = (int) (Math.random() * (6000 - 1) + 1);
  private Processes Proc = new Processes(PID, Processes.state.RUNNING);
  private int readLength = (int) ((Math.random() * (888 - 1) + 1)); // generates the length

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

  public static void assign(Object x, String y) {
    int a;

    String s = "";
    if (!isString(y)) {
      a = Integer.parseInt(y);
      x = a;
    } else s = y;
    x = s;
  }

  // Helper method to check if the parametre is string
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
    Proc.setId(newID);
    Proc.setState(Processes.state.TERMINATED);

    System.out.println("An arthmctic error has occured : Division by Zero"); // exception
  }

  public void AttemptsPriv() {
    System.out.println(
      "You cant acces privileged memory. Reallocating a new space in memory"
    );
    // put the value in the stack or in the heap or in random location but not the
    // priveleged part if yes then look at the following shit
    if (memory.stackISFull()) {
      memory.insertIntoHeap();
    } else if (memory.heapISFull()) {
      memory.insertIntoStack();
    } else memory.insertIntoFree();
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
    if (rndEvent == 1) return Operation.READ;
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
  //  public static void main(String[] args) {
  //  OS WRZ = new OS();
  //  WRZ.CallsRandomEvents();
  //   }
}
