package lab11;

public class Sector implements Shape {
    private double radius;
    private double angle; // in degrees

    public Sector(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public double calculateArea() {
        return (angle / 360.0) * Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Talbain ner: Sector");
        System.out.println("Radius: " + radius);
        System.out.println("Angle: " + angle + "°");
        System.out.printf("Talbain S = %.2f\n\n", calculateArea());
    }
}
