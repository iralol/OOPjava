package lab11;

public class Ellipse implements Shape {
    private double semiMajor;
    private double semiMinor;

    public Ellipse(double semiMajor, double semiMinor) {
        this.semiMajor = semiMajor;
        this.semiMinor = semiMinor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * semiMajor * semiMinor;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Ellipse");
        System.out.println("Tom hagas golch: " + semiMajor);
        System.out.println("Baga hagas golch: " + semiMinor);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
