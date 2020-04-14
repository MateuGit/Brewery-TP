public class BeerHouse {
    public static Integer stock = 100;

    public synchronized void refill(Integer quantity) {
            try {
                while (stock >= 100) {
                    System.out.println("Esperando recargar");
                    wait();
                }

                    System.out.println("Aumentando al stock de: " + stock + " - Le agrego: " + quantity);
                    BeerHouse.stock += quantity;
                    notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public synchronized void HandBeer(BeerConsumer consumer, Integer Beers) throws InterruptedException {
        notifyAll();
        while (stock < Beers) {
            System.out.println("Esperando consumir");
            wait();
        }
        System.out.println("Consumiendo: " + Beers);
        BeerHouse.stock -= Beers;
        consumer.setBeers(Beers);

    }


    public static Integer getStock() {
        return stock;
    }

    public static void setStock(Integer stock) {
        BeerHouse.stock = stock;
    }
}

