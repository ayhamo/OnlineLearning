package Ideas_Test;

import java.util.concurrent.TimeUnit;

public class DelayTest {
    public static void main(String[] args) {

        int timeToWait = 10; //second
        System.out.print("Scanning");
        try {
            for (int i=0; i<timeToWait ; i++) {
                Thread.sleep(1000);
                // or  TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
            System.out.println(" Done");
        } catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }



}
