package Exception_Handler;

import Extras.Memory;
import Proccess.Processes;
import Proccess.Processes.state;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomEventGenerator {

  public enum events {
    REQ_HEAP,
    DIV_ZERO,
    ACC_PMEM,
    KEY,
    READ_FINISH
    
  }


      public static Enum generateRandomEvent() {
        Random r = new Random();
        List<events> event = Arrays.asList(
          events.REQ_HEAP,
          events.DIV_ZERO,
          events.ACC_PMEM,
          events.READ_FINISH,
          events.KEY
          
        );
        return event.get(r.nextInt(event.size()));
      }
     
  

  public static char generateRandomKey() {
    char x = (char) (Math.random() * (126 - 32) + 32);
    return x;
  }
}
