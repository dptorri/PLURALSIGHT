package Java8;

import java.io.File;
import java.io.FileFilter;


public class FirstLambda {
    public static void main( String[] args) {

        FileFilter filter = new FileFilter() {
            /*The type new FileFilter(){} must implement 
            the inherited abstract method FileFilter.accept(File) */

            @Override
            public boolean accept(File pathname){
                return pathname.getName().endsWith(".md");
            }
        };

        File dir = new File("/workspaces/PLURALSIGHT");
        File[] files = dir.listFiles(filter);

        for (File f: files){
            System.out.println(f);
        }
    }
}
