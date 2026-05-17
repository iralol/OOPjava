package lab11;

public class Trapezoid implements Shape {
    private double base1;
    private double base2;
    private double height;

    public Trapezoid(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * (base1 + base2) * height;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Trapezoid");
        System.out.println("Dood suur: " + base1);
        System.out.println("Deed suur: " + base2);
        System.out.println("Ondor: " + height);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
