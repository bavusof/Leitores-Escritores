package estrutura.threads;

import java.util.Random;

public class Reader implements Runnable {
    //private final Data data;
    private final Random random = new Random();

    public Reader() {
        
    }

    @Override
    public void run() {
        /*  for (int i = 0; i < 100; i++) {
            int index = random.nextInt(dataStorage.size());
            dataStorage.readData(index);
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/
        System.out.println("oi, sou um reader!");
        Thread.currentThread().interrupt();
    }
}
