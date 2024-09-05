// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        double[] array1 = new double[10000];
        double[] array2 = new double[10000];
        for (int i =0; i<10000; i++)
            array1[i]=i+1;
        for (int i  = 0; i<10000; i++){
            array2[i]=5*(i+1)*(i+1); // adding constant doesnt change the big O but the power of number effects
        }
        LinearRegression.reportBigO(array1,array2);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);

    }
}
