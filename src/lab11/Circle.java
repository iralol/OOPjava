package lab11;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Circle");
        System.out.println("Radius: " + radius);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
