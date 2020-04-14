import java.util.Random;

public class BeerConsumer implements Runnable {
    private Integer beers;
    private BeerHouse Bh;

    public BeerConsumer(BeerHouse bh) {
        Bh = bh;
    }

    @Override
    public void run() {

        while (Bh.getStock() > 0) {
            try {
                if (Bh.getStock() == 1) {
                    System.out.println("La ultima cerveza!");
                    this.Bh.HandBeer(this, 1);
                }else{
                    int Beers = 1 + (int) (Math.random() * ((30 - 1) + 1));
                    this.Bh.HandBeer(this, Beers);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public Integer getBeers() {
        return beers;
    }

    public void setBeers(Integer beers) {
        this.beers = beers;
    }
}
