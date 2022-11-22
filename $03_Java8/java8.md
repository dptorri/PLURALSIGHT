
# What's New in Java 8

## Introduction to Lambda Expressions in Java 8

### Java 8 Stream API and Collectors	
#### What is a lambda expression for?

Lets implement this interface:
```
// You can create a concrete clase and implement the interface to filter files
public class JavaFileFilter implements FileFilter {
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}
```
The most common way is to use an anonymous class.
```
FileFilter fileFilter = new FileFilter() {

    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
};

File dir = new File("d:/tmp);
File[] javaFiles = dir.listFiles(fileFilter);
```
Lambda is good to make instaces of Anonymus classes easier to read

```
FileFilter filter = (File file) -> file.getName().endsWith(".java");
```

#### 3 Questions about lambdas

- What is the type of a lambda expression
A functional interface: Interface with only one abstract method
Example
```
public interface Runnable {
    run();
}
```
Note: Method from the Object class do not count

A functional interface can be anotated, for convenience the compiler can tell where it is functional or not.
```
@FunctionalInterface
public interface MyFunctionalInterface {
    someMethod();

    /**
    * Some docs
    */
    equals(Object o);
}
```

- Can a lambda be put in a variable
```
        Comparator<String> compLambda = (String s1, String s2) ->
        Integer.compare(s1.length(), s2.length());
```
- Is a lambda expression an object?
No it is not as a typical java object but an object without its own identity.
(Should not be used as an object)
 
 #### Functional interfaces

* Supplier (Single interface does not take an object)
* Consumer (Single interface takes an object)
  Consumer/BiConsumer (Takes 2 Objedcts)
* Predicate (Takes an obj as a parameter and returns a boolean)
  Predicate/BiConsumer (takes 2 objects)

* Function / Unary, BinaryOperator

Note: Types can be omited when writing lambda expressions

#### Method References

This lambda expression:
`Consumer<String> c = s -> System.out.println(s)`
`Comparator<Integer> c = (i1, i2) ->  Integer.compare(i1, i2)`

Can be written:
`Consumer<Stirng> c = System.out::println`
`Comparator<Integer> c = Integer::compare`

#### How do we process data in java
- Where are our objects?
- Most of the time in a Collection (List, Set or Map)

By using `Default Methods` it allows to change the old interfaces without breaking the existing 
implementations, also Static methods are also allowed since Java 8

How can we add method to that forEach method without breaking all the existing 
```
public interface Iterable<E> {
    // the usual methods
    void forEach(Consumer<E> consumer);
}
```
Refactoring this is not an option!


### Java 8 Date and Time API		
### Strings, IO, and Other Bits and Pieces		
### Introduction to Java FX 8		
### Nashorn: A JavaScript Engine on the JVM