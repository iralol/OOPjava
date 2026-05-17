package lab8;

public class DisplayCard {
    private int memory;       // GB
    private String chipset;
    private String brand;
    private int clockSpeed;   // MHz

    public DisplayCard(int memory, String chipset, String brand, int clockSpeed) {
        this.memory = memory;
        this.chipset = chipset;
        this.brand = brand;
        this.clockSpeed = clockSpeed;
    }

    public void printInfo() {
        System.out.println("---Display Card---");
        System.out.println("Indicator 1: " + memory + " GB");
        System.out.println("Indicator 2: " + chipset);
        System.out.println("Indicator 3: " + brand);
        System.out.println("Indicator 4: " + clockSpeed + " MHz");
        System.out.println();
    }
}
