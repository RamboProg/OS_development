package Semaphores;
import Proccess.*;
import java.util.*;
public class binary_Semaphore  {
    public Value value;
    public Queue<Object> processQueue;
    
     public enum Value {
        ZERO, ONE
    }
    public binary_Semaphore(Value value){
        this.value=value;
       
       this.processQueue= new LinkedList<Object>();
    }
    public  void semWaitB(binary_Semaphore BS, ProcS a){
        if(BS.value==Value.ONE){
          BS.value=Value.ZERO;
        }else 
          BS.processQueue.add(a);
          a.setState(State.BLOCKED);
    
      }
      void semSignalB(binary_Semaphore BS,ProcS a){
        if(BS.processQueue.isEmpty()){
          BS.value=Value.ONE;
        }
        else{
          BS.processQueue.remove(a);
          a.setState(State.READY);
        }
      }
    
}