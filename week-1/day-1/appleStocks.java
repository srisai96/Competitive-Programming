// import org.junit.Test;
// import org.junit.runner.JUnitCore;
// import org.junit.runner.Result;
// import org.junit.runner.notification.Failure;

import java.util.*;

// import static org.junit.Assert.*;

public class appleStocks {

public static int getMaxProfit(int[] stockPrices){
    

    if (stockPrices.length < 2) {
    throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
    }


        int min = stockPrices[0];
        int max = Integer.MIN_VALUE;


        for (int i = 1; i < stockPrices.length ; i++) {
            
            int tempDiff = stockPrices[i] - min;
            if (tempDiff > max)
            {
                max = tempDiff;
            }
            if (stockPrices[i] < min) {
                min = stockPrices[i];
            }
        }
        return max;
}

}