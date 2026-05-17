package lab11;

public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Triangle");
        System.out.println("Suuri: " + base);
        System.out.println("Ondor: " + height);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
