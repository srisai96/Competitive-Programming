class parentheses
{
	public static int count=0;

	static void printParen(char str[], int pos, int n, int open, int close)
	{
		if(close == n)
		{
			for(int i=0;i<str.length;i++)
			System.out.print(str[i]);
			count++;
			System.out.print(" ");
			return;
		}

		else
		{
			if(open > close) 
			{
				str[pos] = ')';
				printParen(str, pos+1, n, open, close+1);
			}
			if(open < n) 
			{
				str[pos] = '(';
				printParen(str, pos+1, n, open+1, close);
			}
		}
	}


	static void printParen(char str[], int n)
	{
		if(n > 0)
		printParen(str, 0, n, 0, 0);
		return;
	}


	public static void main (String[] args)
	{
		int[] n = {2,3,5,4,1,6};
		for(int i=0;i<n.length;i++) 
		{
			char[] str = new char[2 * n[i]];
			printParen(str, n[i]);
			System.out.println("\n" + count);
			count = 0;
		}
	}
}