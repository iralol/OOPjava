package lab11;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Square");
        System.out.println("Talbain urt: " + side);
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
