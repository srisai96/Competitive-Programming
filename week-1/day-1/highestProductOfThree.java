import java.util.*;

public class highestProductOfThree {

    public static int highestProductOf3(int[] intArray) {
        
        int len = intArray.length;
        if(len < 3)
        {
            throw new IllegalArgumentException("hello");
        }

        int positive,negative;
        Arrays.sort(intArray);
        positive = intArray[len-1]*intArray[len-2]*intArray[len-3];
        negative = intArray[0]*intArray[1]*intArray[len-1];
        System.out.println(Math.max(positive,negative));
        return Math.max(positive,negative);
        
    }

    

    public static void main(String[] args) {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int actual1 = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
    }
}