package contests.c20221113;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/13 10:24
 */
public class P1 {
    public double[] convertTemperature(double celsius) {
        double k = celsius + 273.15;
        double f = celsius * 1.80 + 32.0;
        return new double[]{k, f};
    }
}
