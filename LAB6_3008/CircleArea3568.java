class Circle {
    double centerX;
    double centerY;
    double radius;

    // Constructor to initialize the variables
    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    // Instance method to calculate the area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Static method to compare areas
    public static String compareArea(Circle circle1, Circle circle2) {
        double area1 = circle1.calculateArea();
        double area2 = circle2.calculateArea();

        if (area1 < area2) {
            return "Circle 1 has a smaller area than Circle 2.";
        } else if (area1 > area2) {
            return "Circle 1 has a larger area than Circle 2.";
        } else {
            return "Circle 1 and Circle 2 have equal areas.";
        }
    }
}

public class CircleArea3568 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(0, 0, 5);
        Circle circle2 = new Circle(3, 4, 7);

        System.out.println("Circle 1 - Center: (" + circle1.centerX + ", " + circle1.centerY + "), Radius: " + circle1.radius);
        System.out.println("Circle 2 - Center: (" + circle2.centerX + ", " + circle2.centerY + "), Radius: " + circle2.radius);

        System.out.println("Area of Circle 1: " + circle1.calculateArea());
        System.out.println("Area of Circle 2: " + circle2.calculateArea());

        System.out.println(Circle.compareArea(circle1, circle2));
    }
}
