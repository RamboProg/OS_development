package Proccess;

import java.util.ArrayList;
import Proccess.*;

public class ProcS {

  private int id;
  private State state;
  private Priority priority;
  private int age;
  private int waitTIme;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public ProcS(int id, Priority priority, int waitTIme) {
    this.id = id;
    this.state = State.READY;
    this.priority = priority;
    this.waitTIme = waitTIme;
  }

  public ProcS(int id) {
    this.id = id;
    this.state = state.RUNNING;
    while (this.state == state.TERMINATED || this.state == state.FINISHED) {
      this.age++;
    }
  }

  @Override
  public String toString() {
    return "-----------------------------\n" + "Process has started, Process id: " + this.id + "\n  Wait time is: "
        + this.waitTIme
        + "\n The process state is: " + this.state + "\nThe priority of this process is: " + this.priority
        + "-----------------------------\n";
  }

  public int getWaitTime() {
    return this.waitTIme;
  }

  public void setWaitTIme(int n) {
    this.waitTIme = n;
  }

  public State getState() {
    return state;
  }

  public int getAge() {
    return age;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Priority gePriority() {
    return this.priority;
  }

  public void setPriority(Priority p) {
    this.priority = p;
  }
}
