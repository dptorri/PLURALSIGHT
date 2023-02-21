### Debugging Java SE 17

#### Creating Correct Control Statements

`.equals()`
- Define equality for a Class
- Customizable
- Compare attribute values

`== operator`
- Only true if same instance
- Not typically used with Objects

```java
Bucket one = new Bucket(10, "red");
Bucket two = new Bucket(10, "red");

// always false unless same instance!!!
one == two
```

* Forgetting a `break;` statement in a `switch`
  * An alternative is to use `-> statements` execute once and no `break` needed 
* Off-by-1 errors
  * Forgetting to add equals
  * < vs <=
  * Start/Stop wrong index (0 or 1?)
* Infinite Loops
  * Incorrect control variable update
  * Increment vs Decrementing
  * Wrong test expression
  * Not initializing/ updating control variable
  
#### Find the Problem, Fix the Problem

Where not to look?
```java
// Application server packages
org.apache.tomcat.*
org.apache.coyote.*
org.apache.catalina.*
javax.servlet.*
// Spring framework packages
org.springframwork.*
// APIs for Java Platform
java.base.*
// Utility libraries
org.apache.commons.*
```

* Logging frameworks simplifies logging management (course)
* Managing Misconfigurations
  * Integrating with other systems 
    * Unique environments
  * Deploying changes
  * Memory management
    * Garbage collection
      * What is it? Heap: Mem available for Java execution (bigger heap)
      * Memory Leak: Objs cant be GC
      * Slow GC: More processing power
      * Stop the World GC: Suspend all execution until completes
      * How to fix it? resources stop leaking memory

* IDE Productivity: Compilers checks, autocomplete
  * Run / Debug Mode (Stores additional information)
  * Breakpoints: Static, conditional and exception based
  * Stepping Over, into, out of
  * Variable watch Expressions
  * Launch profiles
  * Reload
