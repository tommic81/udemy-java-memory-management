# udemy-java-memory-management

#### Links

#### Notes and Commands

- stack (stos) 
  - each thread has its own stack
  - very effective, jvm knows when it can be destroyed
  - methods, local variables, primitives
  - variables are poped out when the probram reaches the end of the block

- the heap (sterta)

  - objects, Strings
  - keep variables which needs longer lifetime
  - shared across threads
  - objects are stored on the heap but variables pointing those objecs are on the stack

- final - stops us from setting a new object to the already set variable

- String, Double, Integer, Bigdecimal are immutible

- Escaping references - references which escape from the class

  - it happens when we return references from the class ie. collections and we allow for changes made on those references from outside

- avoiding "Escaping references"

  - wrapping up returned collections in Collections.unmodifiable..
  - casting object to readonly base classes or interfaces 

- literal Strings are put onto the poll

- calculated Strings are on the heap. intern() method forces sending those String to a poll

- any object on the heap which cannot be reached through a reference from the stack is "eligible for garbage collection"

- information about the free memory

  ```java
  Runtime runtime = Runtime.getRuntime();
  long availableBytes = runtime.freeMemory();
  ```

- suggestion to run garbage collector

  ```java
  System.gc();
  ```

- `finalize()` method is called by GC when object is beiing garbage collected . It is not guaranteed that this method will be run

  ```java
  public void finalize(){
  	System.out.println("This object is being gc'd.");
  }
  ```

- Soft leaks - an object is referenced on the stack even though it will never be used again.

- Xms - starting heap size

- Xmx - max heap size

- Java VisualVM - monitoring memory, CPU, Threads

- Mark and sweep - gs stops program, than check references and its objects if they are alive, if so it marks them, ale the other will be removed

- Generational Garbage Collection - organizing the heap in sections young and old

- young section is small and fast. Objects which survives sweeping are moved to the old section which is bigger and slower 

- young (eden, s0, s1)

#### Instructions