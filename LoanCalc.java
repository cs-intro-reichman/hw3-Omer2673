public class LoanCalc {

    static double epsilon = 0.001;  
    static int iterationCounter;

    public static void main(String[] args) {		

        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // BRUTE FORCE
        System.out.print("\nPeriodical payment, using brute force: ");
        double brute = bruteForceSolver(loan, rate, n, epsilon);
        System.out.println((int) brute);
        System.out.println("number of iterations: " + iterationCounter);

        // BISECTION
        System.out.print("\nPeriodical payment, using bi-section search: ");
        double bis = bisectionSolver(loan, rate, n, epsilon);
        System.out.println((int) bis);
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) {	
        double balance = loan;
        double r = rate / 100.0;

        for (int i = 0; i < n; i++) {
            balance = (balance - payment) * (1 + r);
        }

        return balance;
    }

    // BRUTE FORCE
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;

        double g = loan / n;

        while (endBalance(loan, rate, n, g) > 0) {
            iterationCounter++;
            g += epsilon;
        }

        return g;
    }

    // BISECTION SEARCH
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;

        double L = loan / n;
        double H = loan;

        double g = (L + H) / 2;

        while ((H - L) > epsilon) {
            iterationCounter++;

            if (endBalance(loan, rate, n, g) > 0) {
                L = g;
            } else {
                H = g;
            }

            g = (L + H) / 2;
        }

        return g;
    }
}
