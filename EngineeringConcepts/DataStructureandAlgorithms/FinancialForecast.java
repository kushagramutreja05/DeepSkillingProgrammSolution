package EngineeringConcepts.DataStructureandAlgorithms;



public class FinancialForecast {

    
    public static double forecastRecursive(double presentValue, double rate, int years) {
        // Base case
        if (years == 0) return presentValue;

        
        return forecastRecursive(presentValue, rate, years - 1) * (1 + rate);
    }

    
    public static double forecastMemo(double presentValue, double rate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];

        memo[years] = forecastMemo(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 1000;   
        double rate = 0.05;           
        int years = 10;               

        double futureValueRecursive = forecastRecursive(presentValue, rate, years);
        System.out.printf("Future Value (Recursive): %.2f\n", futureValueRecursive);

        double[] memo = new double[years + 1];
        double futureValueMemo = forecastMemo(presentValue, rate, years, memo);
        System.out.printf("Future Value (Memoized): %.2f\n", futureValueMemo);
    }
}

