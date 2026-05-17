package lab11;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Talbain tootsolol - Polymorpizsm \n");

        // Test with Rectangle (as shown in your image)
        Shape rect = new Rectangle(30, 20);
        rect.display();

        // You can test other shapes here:
        Shape square = new Square(25);
        square.display();

        Shape circle = new Circle(10);
        circle.display();

        // Polymorphism example - using interface reference
        Shape[] shapes = {
            new Triangle(10, 15),
            new Trapezoid(10, 6, 8),
            new Ellipse(10, 6),
            new Parallelogram(15, 8),
            new Sector(10, 90)
        };

        for (Shape shape : shapes) {
            shape.display();
        }
    }
}
