
# What's New in Java 8

## Introduction to Lambda Expressions in Java 8
#### What is a lambda expression for?

You can create a concrete clase and implement the interface to filter files
Lets implement this interface:
```
public class JavaFileFilter implements FileFilter {
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}

// And use it:
JavaFileFilter fileFilter = new JavaFileFilter();
File dir = new File("d:/tmp");
File[] javaFiles = dir.listFiles(fileFilter);
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

##### What is a Lambda Expression for?
Lambda is good to make instaces of Anonymus classes easier to read / write
Lets rewrite it in Lambda way.
```
FileFilter filter = (File file) -> file.getName().endsWith(".java");
```
Example `RunnableLambda.java`

##### Several ways of writing a Lambda Expression
- Row one liner
- More than 1 line
`````
Comparator<String> c =
    (String s1, String s2) ->
        Integer.compare(s1.length(), s2.length());
```

#### 3 Questions about lambdas

##### What is the type of a lambda expression?
It is a functional interface this means it is an interface with only one abstract method.

Example:
```
public interface Runnable {
    run();
}
```

Note: Method from the Object class do not count, so the funcional interface can have those.

A functional interface can be anotated, for convenience the compiler can tell where it is functional or not.
```
@FunctionalInterface
public interface MyFunctionalInterface {
    someMethod();

    /**
    * Some docs "this method does not count"
    */
    equals(Object o);
}
```

- Can a lambda be put in a variable?
```
Comparator<String> compLambda = 
    (String s1, String s2) ->
        Integer.compare(s1.length(), s2.length());
```
- Is a lambda expression an object?
No it is not as a typical java object but an object without its own identity. Also it is used without the keyword "new". Less work for the JVM.
(Should not be used as an object)
 
 #### Functional interfaces

* Supplier (Single interface does not take an object)
* Consumer (Single interface takes an object)
  Consumer/BiConsumer (Takes 2 Objects)
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

#### How do we process data in Java ?

##### Where are our objects?
- Most of the time they are in a Collection (List, Set or Map)

##### Can I process this data with Lambdas?

With the method reference looks like this:
````
List<Customer> list : ...
list.forEach(customer -> System.out::println)
````
So yes!

Where does this forEach method come from?

You could add a forEach method to the JVM but
there is a simpler way.

##### How can we add method to that forEach method without breaking all the existing???
```
public interface Iterable<E> {
    // the usual methods
    void forEach(Consumer<E> consumer);

    default void forEach(Consumer<E> consumer) {
        for (E e : this) {
            consumer.accept(e);
        }
    }
}
```
Refactoring this is not an option!

By using `Default Methods` it allows to change the old interfaces without breaking the existing 
implementations, also Static methods are also allowed since Java 8.

#### Examples of new patterns

* Predicates
```
Predicate<String> p1 = s -> s.length() < 20;
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }
}



```
### Java 8 Stream API and Collectors	
#### Map / filter / reduce

`1st step mapping:`
- takes a `List<Person>` and return as `List<Integer>`
- both lists have same size

`2nd step filter:`
- takes ages `List<Integer>` and returns `List<Integer>` e.g. greater than 20
- some elements are sorted out in the process

`3rd step: average`

#### What is a Stream

- A java typed interface
and a new concept (not a collection)

- process data in parallel efficiently inside the JVM
Pipelined to avoid unnecessary intermediary computations
(Several operations are completed in one pass of the data)

- object that does not holds data
- object that does not change the data in the process

#### Patterns for Streams

* We can chain consumers


### Java 8 Date and Time API		
### Strings, IO, and Other Bits and Pieces		
### Introduction to Java FX 8		
### Nashorn: A JavaScript Engine on the JVM