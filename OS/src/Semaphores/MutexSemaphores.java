package Semaphores;

import Proccess.*;
import java.util.*;

public class MutexSemaphores {
    public Value value;
    public Queue<ProcS> processQueue;
    // public Queue<ProcS> readyQueue;
    public int ownerID;

    public MutexSemaphores() {
        this.value = Value.ONE;
        this.processQueue = new LinkedList<ProcS>();
    }

    public void semSignalM(MutexSemaphores MS, ProcS a) {
        if (MS.value == Value.ONE) {
            MS.ownerID = a.getId();
            MS.value = Value.ZERO;
            System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + MS.value);
        } else {
            processQueue.add(a);
            a.setState(State.BLOCKED);
            System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + MS.value);
        }
    }

    public void semWaitM(MutexSemaphores MS, ProcS a) {
        if (MS.ownerID == a.getId()) {
            MS.value = Value.ONE;
            if (MS.processQueue.isEmpty()){
                System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + MS.value);
            }
            else {
                MS.processQueue.remove(a);
                // MS.readyQueue.add(a);
                a.setState(State.READY);
                MS.ownerID = a.getId();
                System.out.println("Process State: " + a.getState() + "Process ID: " + a.getId() + "Semaphore Value: " + MS.value);
            }

        }

    }
}