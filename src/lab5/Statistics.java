package lab5;

public class Statistics {
    // mean

    public static double mean(double a, double b) {
        return (a + b) / 2;
    }

    public static double mean(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static double mean(double a, double b, double c, double d) {
        return (a + b + c + d) / 4;
    }

    public static double mean(double a, double b, double c, double d, double e) {
        return (a + b + c + d + e) / 5;
    }

    // standard hemjee

    public static double sd(double a, double b) {
        double m = mean(a,b);
        return Math.sqrt((Math.pow(a-m,2) + Math.pow(b-m,2))/2);
    }

    public static double sd(double a, double b, double c) {
        double m = mean(a,b,c);
        return Math.sqrt((Math.pow(a-m,2)+Math.pow(b-m,2)+Math.pow(c-m,2))/3);
    }

    public static double sd(double a, double b, double c, double d) {
        double m = mean(a,b,c,d);
        return Math.sqrt((Math.pow(a-m,2)+Math.pow(b-m,2)+Math.pow(c-m,2)+Math.pow(d-m,2))/4);
    }

    public static double sd(double a, double b, double c, double d, double e) {
        double m = mean(a,b,c,d,e);
        return Math.sqrt((Math.pow(a-m,2)+Math.pow(b-m,2)+Math.pow(c-m,2)+Math.pow(d-m,2)+Math.pow(e-m,2))/5);
    }

    // varargs mean

    public static double meanVar(double... a) {
        double sum = 0;

        for(double x : a){
            sum += x;
        }

        return sum / a.length;
    }

    // varargs method

    public static double sdVar(double... a) {

        double mean = meanVar(a);
        double sum = 0;

        for(double x : a){
            sum += Math.pow(x - mean,2);
        }

        return Math.sqrt(sum / a.length);
    }
}
