package Scheduling;

import java.util.LinkedList;
import java.util.Queue;

import Proccess.*;

public class Scheduling {
    Queue<ProcS> q = new LinkedList<ProcS>();
    Queue<ProcS> qHi = new LinkedList<ProcS>();
    Queue<ProcS> qMed = new LinkedList<ProcS>();
    Queue<ProcS> qLo = new LinkedList<ProcS>();

    public Scheduling(Queue<ProcS> queue) {
        this.q = queue;

        // Filling up the queues
        for (int i = 0; i < q.size(); i++) {
            if (q.peek().gePriority() == Priority.HIGH) {
                qHi.add(q.peek());
                q.add(q.remove());
            }

            if (q.peek().gePriority() == Priority.MEDIUM) {
                qMed.add(q.peek());
                q.add(q.remove());
            }

            if (q.peek().gePriority() == Priority.LOW) {
                qLo.add(q.peek());
                q.add(q.remove());
            }
            q.add(q.remove());
        }

    }

    public void Scheduler_RR() {
        int quantum = 2;
        int arrivalTime;
        int nProcs = 0;
        int count, i = 0;
        int sq = 0;
        int awt = 0;
        int atat = 0;
        int bt[] = new int[q.size()];
        int wt[] = new int[q.size()];
        int tat[] = new int[q.size()];
        int rem_bt[] = new int[q.size()];

        ProcS pArray[] = new ProcS[q.size()];
        for (i = 0; i < q.size(); i++) {
            pArray[i] = q.peek();
            nProcs++;
            bt[i] = pArray[i].getWaitTime();

        }

        int temp;
        while (true) {
            for (i = 0, count = 0; i < q.size(); i++) {
                temp = quantum;
                if (rem_bt[i] == 0) {
                    count++;
                    continue;
                }

                if (rem_bt[i] > quantum)
                    rem_bt[i] -= quantum;
                else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if (nProcs == count)
                break;
        }

        System.out.println("-------------------------------------------");
        System.out.println("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.println("--------------------------------------------");

        for (int j = 0; j < nProcs; j++) {
            wt[i] -= bt[i];
            awt += wt[i];
            atat += tat[i];
            System.out.print("\n " + (i + 1) + "\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i] + "\n");
        }
        awt = awt / nProcs;
        atat = atat / nProcs;
        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
    }

    public void Scheduler_MLQS() {

    }

    public void Scheduler_FCFS() {

    }
}
