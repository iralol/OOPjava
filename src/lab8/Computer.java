package lab8;

public class Computer {
    private Processor processor;
    private Memory memory;
    private DisplayCard displayCard;
    private SoundCard soundCard;

    public Computer() {
        // Composition: Computer creates and owns its components
        this.processor = new Processor("Intel", 8, 3.6, 16);
        this.memory = new Memory(16, "DDR4", 3200, "Corsair");
        this.displayCard = new DisplayCard(8, "GeForce RTX 4060", "NVIDIA", 1830);
        this.soundCard = new SoundCard(8, 192, "Realtek", "PCIe");
    }
    public void showInfo() {
        System.out.println("Computer specifications:");
        System.out.println();
        processor.printInfo();
        memory.printInfo();
        displayCard.printInfo();
        soundCard.printInfo();
    }
}
