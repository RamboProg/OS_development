package OSshit;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomEventGenerator {

  public enum events {
    REQ_HEAP,
    DIV_ZERO,
    ACC_PMEM,
    KEY,
    DISK_READ_FINISH,
  }

  public static Enum generateRandomEvent() {
    Random r = new Random();
    List<events> event = Arrays.asList(
      events.REQ_HEAP,
      events.DIV_ZERO,
      events.ACC_PMEM,
      events.KEY,
      events.DISK_READ_FINISH
    );
    return event.get(r.nextInt(event.size()));
  }
}
