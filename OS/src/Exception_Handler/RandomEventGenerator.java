package Exception_Handler;

public class RandomEventGenerator {

  public enum SynchronousEvents {
    REQ_HEAP,
    DIV_ZERO,
    ACC_PMEM,
  }

  public enum AsynchronousEvents {
    KEY,
    READ_FINISH,
  }

  public static SynchronousEvents generateRandomEvent_S() {
    int rndEvent = (int) (Math.random() * 3) + 1;
    if (rndEvent == 1) return SynchronousEvents.REQ_HEAP; else if (
      rndEvent == 2
    ) return SynchronousEvents.DIV_ZERO; else return SynchronousEvents.ACC_PMEM;
  }

  public static AsynchronousEvents generateRandomEvent_A() {
    int rndEvent = (int) (Math.random() * 2) + 1;
    if (
      rndEvent == 1
    ) return AsynchronousEvents.KEY; else return AsynchronousEvents.READ_FINISH;
  }

  public static Enum generateRandomEvent() {
    int rndEvent = (int) (Math.random() * 2) + 1;
    if (rndEvent == 1) {
      return generateRandomEvent_S();
    } else return generateRandomEvent_A();
  }
}
