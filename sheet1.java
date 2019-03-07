public static void reverse(int[] arr) {
		int temp;
		int sz = arr.length;
		for(int i=0; i < sz/2; ++i) {
			temp = arr[i];
			arr[i] = arr[sz-i-1];
			arr[sz-i-1]=temp;
			return;
		}
	}
	public static int[] sumEvenOdd(int[] arr) {
		int ans[] = new int[] {0,0};
		int sz = arr.length;
		if(sz==0)
			return ans;
		for(int i=0; i<sz; i++) {
			if(arr[i]%2==0)
				ans[0]+=arr[i];
			else
				ans[1] += arr[i];
		}
		return ans;
	}
	public static double average(int [] arr) {
		double average=0;
		int sz = arr.length;
		for(int i=0; i<sz; ++i) 
			average+=arr[i];
		return average/(sz*1.0);
	}
	public static void moveValue(int[] arr, int val) {
		int sz = arr.length;
		for(int i=0; i<sz; ++i) {
			if(arr[i]==val) {
				for(int j=i; j<sz-1; ++j)
					arr[j] = arr[j+1];
				arr[sz-1]=val;
				sz--;
				i--;
			}
		}
	}
	public static int [][] transpose(int[][] arr){
		int r = arr.length;
		int c = arr[0].length;
		int [][] temp = new int[c][r];
		for(int i=0; i<r; ++i){
			for(int j=0; j<c; ++j){
				temp[j][i] = arr[i][j];
			}
		}
		return temp;
	}
	public static long fibonacci(int n) {
	long ans=1, temp1=0, temp2=1;
	if (n==0)
		return 0;
	for(int i = 0; i<n-3; ++i) {
		temp1 =temp2;
		temp2 = ans;
		ans = temp1+temp2;
	}
	return ans;
}
