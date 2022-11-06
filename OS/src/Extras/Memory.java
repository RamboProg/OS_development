package Extras;

public class Memory {

  private int heap;
  private int stack;
  private int Free;
  private int priveleged_memory;
  private int size ;
  private int Heapsize;
  private int StackSize;
  private int FreeSize;
  private Object mem[];

  public Memory(int size) {
    this.size = size;
    stack = 0;
    heap = (40 * 100) / size;
    Free = (80 * 100) / size;
    priveleged_memory = (90 * 100) / size;
    mem = new Object[size];
  }

  public boolean stackISFull() {
    int Stackcounter = 0;
    StackSize = size - (priveleged_memory + heap + Free);
    for (int i = stack; i < heap; i++) {
      if (mem[i] != null) Stackcounter++;
    }
    if (Stackcounter == StackSize) return true; else return false;
  }

  public void insertIntoStack(/* String x */) {
    if (heapISFull() && stackISFull() && FreeISFull()) {
      System.out.println("The memory is full, delete some files");
    } else if (stackISFull()) {
      insertIntoHeap();
    }/*
     * else if (!stackISFull()){
     * for(int i=stack; i<heap;i++){
     * if(mem[i]==null){
     * mem[i]=x;
     * break;
     * }
     */
  }

  public boolean stackISEmpty() {
    if (StackSize == 0) return true; else return false;
  }

  public boolean FreeISFull() {
    int c = 0;
    FreeSize = priveleged_memory - Free;
    for (int i = Free; i < priveleged_memory; i++) {
      if (mem[i] != null) c++;
    }
    if (c == FreeSize) return true; else return false;
  }

  public void insertIntoFree() { 
    if (heapISFull() && stackISFull() && FreeISFull()) {
      System.out.println("The memory is full, delete some files");
    } else if (FreeISFull()) {
      if (!heapISFull()) {
        insertIntoHeap();
      } else if (!stackISFull()) {
        insertIntoStack();
      }
    }
  }

  public void insertKEy(char x) {
    if (!FreeISFull()) {
      for (int i = Free; i < priveleged_memory; i++) {
        if (mem[i] == null) {
          mem[i] = x;
          break;
        }

        
      }
    }
  }

  public boolean heapISFull() {
    int counter = 0;
    Heapsize = ((priveleged_memory - (heap)) - (priveleged_memory - (Free)));
    for (int i = heap; i < Free; i++) {
      if (mem[i] != null) counter++;
    }
    if (counter == Heapsize) return true; else return false;
  }

  public boolean heapIsEmpty() {
    if (Heapsize == 0) return true; else return false;
  }

  public void insertIntoHeap(/* String x */) { // INCASE WE ADD A PARAMETER INTO THE HEAP
    if (heapISFull() && stackISFull() && FreeISFull()) {
      System.out.println("The memory is full, delete some files");
    } else if (heapISFull() && !stackISFull()) {
      Heapsize++;
      heap--;
    } else if (heapISFull() && stackISFull()) {
      Heapsize++;
      Free++;
    }
    /*
     * else if (!heapISFull()){
     * for(int i=heap; i<priveleged_memory;i++){
     * if(mem[i]==null){
     * mem[i]=x;
     * break;
     * }
     */

  }
  public int getPriv() {
    return priveleged_memory;
  }

  public int getStack() {
    return stack;
  }

  public int getHeap() {
    return heap;
  }

  public  int getSize() {
    return size;
  }
  public  void EmptyMEM(){
    for(int i = stack;i<priveleged_memory;i++){
      mem[i]=null;
    }
  }

}
