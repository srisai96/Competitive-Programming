import java.util.*;



public class productOfOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
        
        if (intArray.length <= 1)
        {
            throw new IllegalArgumentException("hello world");
        }

        // System.out.println(Arrays.toString(intArray));
        int[] front = new int[intArray.length];
        int[] reverse = new int[intArray.length];

        front[0] = 1;
        int frontProd = 1;

        for (int i = 1; i < intArray.length ; i++ ) {
            front[i] = frontProd * intArray[i-1];
            frontProd = front[i];
        }

        // System.out.println(Arrays.toString(front));

        int[] intArrayReverse = new int[intArray.length];

        for (int i = intArray.length-1; i >= 0 ; i-- ) {
            intArrayReverse[intArrayReverse.length-1-i] = intArray[i];
        }
        
        // System.out.println(Arrays.toString(intArrayReverse));

        reverse[0] = 1;
        int reverseProd = 1;

        for (int i = 1; i < intArray.length ; i++ ) {
            reverse[i] = reverseProd * intArrayReverse[i-1];
            reverseProd = reverse[i];
        }

        // System.out.println(Arrays.toString(reverse));

        int[] res = new int[intArray.length];

        for (int i = 0; i < intArray.length ; i++ ) {
            res[i] = front[i]*reverse[reverse.length-1-i];
        }

        // System.out.println(Arrays.toString(res));
        return res;
    }



    public static void main(String[] args) {
    	final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {5,2,1,10});
    }


}