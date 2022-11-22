package $03_Java8;

public class RunnableLambda {
    public static void main(String... args) throws InterruptedException {
       /*
        * The Runnable interface should be implemented by any 
        class whose instances are intended to be executed by a thread. 
        The class must define a method of no arguments called run.
        */
        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                for (int i=0; i< 3; i++){
                    System.out.println(
                        "Hello from thread [" +
                        Thread.currentThread().getName() +
                        "]"                
                    );
                };

            }            
        };

        Runnable runnableLambda = () -> {
            for (int i=0; i< 3; i++){
                System.out.println(
                    "Hello from thread [" +
                    Thread.currentThread().getName() +
                    "]"                
                );
            };
        };


        // Thread t = new Thread(runnable);
        // t.start();
        // t.join();

        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
/*
Hello from thread [Thread-0]
Hello from thread [Thread-0]
Hello from thread [Thread-0]
 */

    }
}
