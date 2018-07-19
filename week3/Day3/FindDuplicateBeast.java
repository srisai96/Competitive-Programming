public class FindDuplicateBeast {
    public Integer findDuplicate(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[arr[i]%arr.length]+=arr.length;
        }
        int ans=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]/arr.length>1)
            {
                ans=i;
            }
            arr[i]=arr[i]%arr.length;
        }

        return ans;
    }
    public int findDup(int arr[]){


        int repeat= Integer.MIN_VALUE;

        for (int i =0; i<arr.length; i++) {
            if (arr[Math.abs(arr[i])]>=0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                repeat = i;
            }
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return arr[repeat];
    }
    public static void main(String[] args)
    {
        FindDuplicateBeast obj=new FindDuplicateBeast();
        int arr[] = {1,2,5,3,4,5};
        System.out.println(obj.findDuplicate(arr));
        System.out.println(obj.findDup(arr));

    }
}
