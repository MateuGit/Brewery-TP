import java.util.Random;

import static java.lang.Thread.sleep;

public class BeerProducer implements Runnable {
    private BeerHouse Bh;

    public BeerProducer(BeerHouse bh) {
        Bh = bh;
    }
    @Override
    public void run() {

        int totalBeersRefilled=0;
        int TimesToRefill=1+(int)(Math.random()*((3-1) + 1));

       while (Bh.getStock()>1){
           int RefillBeers=(int)(Math.random()*((10-1) + 1));
           totalBeersRefilled+=RefillBeers;
           Bh.refill(RefillBeers);
           try {
               sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println("No hay mas cervezas!");
    }
}
