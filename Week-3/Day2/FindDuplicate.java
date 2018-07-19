/*
We have an array of integers, where:

The integers are in the range 1....n
The array has a length of n+1
It follows that our array has at least one integer which appears at least twice.
But it may have several duplicates, and each duplicate may appear more than twice.
*/

public class FindDuplicate {
    //O(nlogn) method
    public Integer findDuplicate(int arr[]){

        int low = 1;
        int high = arr.length-1;

        while(low<high){
            int mid = low+(high-low)/2;
            int lowerRangeLowerBound = low;
            int lowerRangeUpperBound = mid;
            int upperRangeLowerBound = mid+1;
            int upperRangeUpperBound = high;

            int elementsInLowerRange = 0;
            int distinctElementsInLowerRange = lowerRangeUpperBound - lowerRangeLowerBound + 1;

            for (int i =0; i<arr.length; i++) {
                if (arr[i] >= lowerRangeLowerBound && arr[i] <= lowerRangeUpperBound) {
                    elementsInLowerRange+=1;
                }
            }

            if (distinctElementsInLowerRange < elementsInLowerRange) {
                high = lowerRangeUpperBound;
            }
            else{
                low = upperRangeLowerBound;
            }

        }

        return low;
    }
    //O(n) method
    public Integer findDuplicate1(int[] arr)
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
    public static void main(String[] args)
    {
        FindDuplicate obj=new FindDuplicate();
        int arr[] = {1,2,5,3,4,5};
        System.out.println(obj.findDuplicate(arr));
        System.out.println(obj.findDuplicate1(arr));
    }
}
