
public class AppearsTwice {

    public int appearedTwice(int []arr,int n){
        int sum = (n*(n+1))/2;
        int arrSum = 0;
        for (int i : arr) {
            arrSum+=i;
        }
        return arrSum-sum;
    }
    public int appearsTwice(int[] arr,int n)
    {
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            arr[arr[i]%(n+1)]+=(n+1);
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]/(n+1)==2) {
                ans = i;
            }
            arr[i]=arr[i]%(n+1);
        }

       return ans;

    }
    public static void main(String[] args) {
        int n = 10;
        //given n+1 array arr[11];
        int [] arr = {1,3,2,3,4,6,5,8,9,7,10};
        AppearsTwice obj = new AppearsTwice();
        System.out.println("Element that appeared twice is : "+obj.appearedTwice(arr,n));
        System.out.println("Element that appeared twice is : "+obj.appearsTwice(arr,n));
    }
}
