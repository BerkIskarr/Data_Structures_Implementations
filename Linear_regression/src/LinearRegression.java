public class LinearRegression {
    private static double mean (double[] xs) {
        double total = 0;
        for (double x : xs)
            total += x;
        return total / xs.length;
    }

    public static double getSlope (double[] xs, double[] ys) {
        double xMean = mean (xs);
        double yMean = mean (ys);

        double numerator = 0;
        double denominator = 0;
        for (int i = 0; i < xs.length; i++) {
            double dx = xs[i] - xMean;
            double dy = ys[i] - yMean;
            numerator += dx * dy;
            denominator += dx * dx;
        }
        return numerator/denominator;
    }

    public static double getExponent (double[] xs, double[] ys) {
        if (xs.length != ys.length)
            throw new IllegalArgumentException("xs and ys must have the same length.");
        if (xs.length < 2)
            throw new IllegalArgumentException("Must have at least two coordinates.");

        double[] logxs = new double[xs.length];
        double[] logys = new double[ys.length];

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] <= 0 || ys[i] <= 0)
                throw new IllegalArgumentException("all coordinate values must be positive.");
            logxs[i] = Math.log (xs[i]);
            logys[i] = Math.log (ys[i]);
        }
        return getSlope (logxs, logys);
    }

    public static void reportBigO (double[] xs, double[] ys) {
        System.out.println("This function appears to be O(x^" + getExponent(xs, ys) + ")");
    }
}