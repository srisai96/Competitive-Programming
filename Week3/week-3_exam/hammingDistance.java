

public class hammingDistance{

	public static int HammingDistance(int x, int y){
	int xor = x ^ y;
	return Integer.bitCount(xor);
	}

	public static void main(String[] args) {
		int[] xarr = new int[]{25,1,25,100,1,0};
		int[] yarr = new int[]{30,4,30,250,30,255};
		int i = 0;
		while(i<6){
			System.out.println(HammingDistance(xarr[i],yarr[i]));
			i++;
		}
	}
}