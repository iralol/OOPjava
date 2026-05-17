package lab8;

public class Memory {
    private int size;      // GB
    private String type;
    private int speed;     // MHz
    private String brand;

    public Memory(int size, String type, int speed, String brand) {
        this.size = size;
        this.type = type;
        this.speed = speed;
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println("---RAM---");
        System.out.println("Indicator 1: " + size + " GB");
        System.out.println("Indicator 2: " + type);
        System.out.println("Indicator 3: " + speed + " MHz");
        System.out.println("Indicator 4: " + brand);
        System.out.println();
    }
}
