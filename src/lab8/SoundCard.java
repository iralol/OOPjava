package lab8;

public class SoundCard {
    private int channels;
    private int sampleRate;   // kHz
    private String brand;
    private String interfaceType;

    public SoundCard(int channels, int sampleRate, String brand, String interfaceType) {
        this.channels = channels;
        this.sampleRate = sampleRate;
        this.brand = brand;
        this.interfaceType = interfaceType;
    }

    public void printInfo() {
        System.out.println("---Sound Card---");
        System.out.println("Indicator 1: " + channels + " Channels");
        System.out.println("Indicator 2: " + sampleRate + " kHz");
        System.out.println("Indicator 3: " + brand);
        System.out.println("Indicator 4: " + interfaceType);
        System.out.println();
    }
}
