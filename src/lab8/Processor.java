package lab8;

public class Processor {
    private String brand;
    private int cores;
    private double speed; // GHz
    private int cache;    // MB

    public Processor(String brand, int cores, double speed, int cache) {
        this.brand = brand;
        this.cores = cores;
        this.speed = speed;
        this.cache = cache;
    }

    public void printInfo() {
        System.out.println("---CPU---");
        System.out.println("Indicator 1: " + brand);
        System.out.println("Indicator 2: " + cores + " Cores");
        System.out.println("Indicator 3: " + speed + " GHz");
        System.out.println("Indicator 4: " + cache + " MB Cache");
        System.out.println();
    }
}
