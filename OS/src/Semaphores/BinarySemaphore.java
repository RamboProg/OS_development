package Semaphores;

import Proccess.*;
import java.util.*;

public class BinarySemaphore {
  public Value value;
  public Queue<ProcS> processQueue;

  public enum Value {
    ZERO, ONE
  }

  public BinarySemaphore() {
    this.value = Value.ONE;
    this.processQueue = new LinkedList<ProcS>();
  }

  public void semWaitB(BinarySemaphore BS, ProcS a) {
    if (BS.value == Value.ONE) {
      BS.value = Value.ZERO;
      System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
    } else
      BS.processQueue.add(a);
    a.setState(State.BLOCKED);
    System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
  }

  public void semSignalB(BinarySemaphore BS, ProcS a) {
    if (BS.processQueue.isEmpty()) {
      BS.value = Value.ONE;
      System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
    } else {
      BS.processQueue.remove(a);
      a.setState(State.READY);
      System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
    }
  }
 
}