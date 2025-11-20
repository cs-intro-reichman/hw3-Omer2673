// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {

    public static void main(String args[]) {
        System.out.println(plus(2,3));  
        System.out.println(minus(7,2)); 
        System.out.println(minus(2,7)); 
        System.out.println(times(3,4)); 
        System.out.println(plus(2,times(4,2)));
        System.out.println(pow(5,3));
        System.out.println(pow(3,5));
        System.out.println(div(12,3)); 
        System.out.println(div(5,5));  
        System.out.println(div(25,7)); 
        System.out.println(mod(25,7)); 
        System.out.println(mod(120,6)); 
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    // -------------------------------
    // BASIC OPERATORS
    // -------------------------------

    // x1 + x2
    public static int plus(int x1, int x2) {
        if (x2 >= 0) {
            for (int i = 0; i < x2; i++) x1++;
        } else {
            for (int i = 0; i < -x2; i++) x1--;
        }
        return x1;
    }

    // x1 - x2
    public static int minus(int x1, int x2) {
        if (x2 >= 0) {
            for (int i = 0; i < x2; i++) x1--;
        } else {
            for (int i = 0; i < -x2; i++) x1++;
        }
        return x1;
    }

    // x1 * x2
    public static int times(int x1, int x2) {
        int result = 0;
        boolean neg = false;

        if (x1 < 0) { x1 = minus(0, x1); neg = !neg; }
        if (x2 < 0) { x2 = minus(0, x2); neg = !neg; }

        for (int i = 0; i < x2; i++)
            result = plus(result, x1);

        return neg ? minus(0, result) : result;
    }

    // x^n (n >= 0)
    public static int pow(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++)
            result = times(result, x);
        return result;
    }

    // integer division x1 / x2
    public static int div(int x1, int x2) {
        boolean neg = false;

        if (x1 < 0) { x1 = minus(0, x1); neg = !neg; }
        if (x2 < 0) { x2 = minus(0, x2); neg = !neg; }

        int count = 0;
        while (x1 >= x2) {
            x1 = minus(x1, x2);
            count++;
        }

        return neg ? minus(0, count) : count;
    }

    // remainder x1 % x2
    public static int mod(int x1, int x2) {
        boolean neg = x1 < 0;
        if (x1 < 0) x1 = minus(0, x1);
        if (x2 < 0) x2 = minus(0, x2);

        while (x1 >= x2)
            x1 = minus(x1, x2);

        return neg ? minus(0, x1) : x1;
    }

    // sqrt(x)
    public static int sqrt(int x) {
        int n = 0;
        int one = 1;

        int diff = minus(x, times(n, n));
        while (diff >= 0) {
            n = plus(n, one);
            diff = minus(x, times(n, n));
        }

        return minus(n, one);
    }
}
