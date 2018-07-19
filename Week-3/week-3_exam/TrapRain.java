public class TrapRain {

	static int findWater(int arr[], int n)
	{

		int water = 0;
		int left_max = 0, right_max = 0;
		int low = 0, high = n-1;

		while(low <= high)
		{
			if(arr[low] < arr[high])
			{
				if(arr[low] > left_max)
					left_max = arr[low];
				else
					water += left_max - arr[low];
					low++;
			}
			else
			{
				if(arr[high] > right_max)
					right_max = arr[high];

				else
					water+= right_max - arr[high];
					high--;
			}
		}

		return water;
	}


	public static void main(String[] args)
	{
		int arr[] = {0, 1, 0, 2, 1, 0, 1};
		int arr1[]={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int arr2[]={0, 1, 0, 2, 1, 0, 5, 1, 0, 2};
		int arr3[]={0, 1, 0, 5, 1, 0, 2};
		int arr4[]={0, 5, 1, 3, 4, 0, 1};
		System.out.println(findWater(arr, arr.length));
		System.out.println(findWater(arr1, arr1.length));
		System.out.println(findWater(arr2, arr2.length));
		System.out.println(findWater(arr3, arr3.length));
		System.out.println(findWater(arr4, arr4.length));

	}
}