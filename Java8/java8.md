#### Introduction to Lambda Expressions in Java 8

#### Java 8 Stream API and Collectors		
What is a lambda expression for?

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





#### Java 8 Date and Time API		
#### Strings, IO, and Other Bits and Pieces		
#### Introduction to Java FX 8		
#### Nashorn: A JavaScript Engine on the JVM