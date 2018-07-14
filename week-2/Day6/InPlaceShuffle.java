import java.util.Arrays;
import java.util.Random;

public class InPlaceShuffle {
    Random rand=new Random();
    public int getRandom(int low,int high)
    {
        return rand.nextInt((high-low)+1)+low;
    }
    public void shuffle(int[] arr)
    {
        int j;
        for(int i=0;i<arr.length;i++)
        {
            j=getRandom(i,arr.length-1);
            if(i!=j)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    public static void main(String[] args)
    {
        int arr[] ={1,4,7,13,99,34,97};
        InPlaceShuffle obj = new InPlaceShuffle();
        obj.shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}
