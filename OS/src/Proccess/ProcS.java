package Proccess;

import java.util.ArrayList;

public class ProcS {

  private int id;
  private State state;
  private int priority;
  private int age;



  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public ProcS(int id, State state, int priority) {
    this.id = id;
    this.state = state;
    this.priority = priority;
  }

  public ProcS(int id) {
    this.id = id;
    this.state = state.RUNNING;
    while (this.state == state.TERMINATED || this.state == state.FINISHED) {
      this.age++;
    }
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
}
