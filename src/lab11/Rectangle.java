package lab11;

public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Rectangle");
        System.out.println("Urt tal (a): " + length);
        System.out.println("Orgon tal (b): " + width);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
