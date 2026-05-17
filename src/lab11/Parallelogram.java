package lab11;

public class Parallelogram implements Shape {
    private double base;
    private double height;

    public Parallelogram(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Parallelogram");
        System.out.println("Suuri: " + base);
        System.out.println("Ondor: " + height);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
