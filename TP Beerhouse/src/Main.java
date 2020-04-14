public class Main {
    public static void main(String[] args) throws InterruptedException {

BeerHouse Bh=new BeerHouse();
       Runnable Producer= new BeerProducer(Bh);
       Runnable Consumer= new BeerConsumer(Bh);

        Thread producer=new Thread(Producer);
        Thread consumer=new Thread(Consumer);
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();









}}
