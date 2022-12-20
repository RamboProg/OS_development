package Semaphores;

import java.util.LinkedList;
import java.util.Queue;

import Proccess.ProcS;
import Proccess.State;

public class BinarySem2 {
    public Value value;
    public Queue<ProcS> processQueue;

  

  public BinarySem2() {
    this.value = Value.ONE;
    this.processQueue = new LinkedList<ProcS>();
  }

  public void semWaitB(BinarySem2 BS, ProcS a) {
    if (BS.value == Value.ONE) {
      BS.value = Value.ZERO;
      System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
    } else
      BS.processQueue.add(a);
    a.setState(State.BLOCKED);
    System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + BS.value);
  }

  public void semSignalB(BinarySem2 BS, ProcS a) {
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
