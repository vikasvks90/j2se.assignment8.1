/**
* <h1>Timer</h1>
* This program shows the functionality of a timer using thread concept in java
* it will print timeout message on regular interval
* @author  Vikas
* @version 1.0
* @since   2017-05-30 
*/
package assignment8.session1;

import java.util.concurrent.*;

public class Timer {

    private static class Updater implements Runnable {

        @Override
        public void run() {
            System.out.println("Timeout");
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	Updater r = new Updater();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        //service.scheduleAtFixedRate(command, initialDelay, period, unit)
        //we are using executor service to print the message at regular interval
        //it will run the job r in a interval of 3 seconds
        service.scheduleAtFixedRate(r, 0, 3, TimeUnit.SECONDS);
        //sleep method will be called by main thread and after 10000 ms the service will be shut down
        Thread.sleep(10000);
        service.shutdown();

    }
}
