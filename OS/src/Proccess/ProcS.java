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

  public ProcS(int id, State state, Priority priority, int waitTIme) {
    this.id = id;
    this.state = state;
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
