package Semaphores;

import Proccess.*;
import java.util.*;

public class CountingSemaphores {
    public int count;
    public Queue<ProcS> processQueue;

    public CountingSemaphores() {
        this.count = 80; // Max Value
        this.processQueue = new LinkedList<ProcS>();
    }

    public void semWaitC(CountingSemaphores cs, ProcS a) {
        cs.count--;
        if (cs.count < 0) {
            processQueue.add(a);
            a.setState(State.BLOCKED);
            System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + cs.count);
        }
    }

    public void semSignalC(CountingSemaphores cs, ProcS a) {
        cs.count++;
        if (cs.count <= 0) {
            processQueue.remove(a);
            a.setState(State.READY);
            System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + cs.count);
        }

    }
}
