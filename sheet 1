import java.util.*;
public class MySpecialArrayUtils {
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
	public static void main(String[] args) {
		int n;
		Scanner a = new Scanner(System.in);
		n = a.nextInt();
		int [] arr = new int [n];
		for(int i=0; i<n; ++i) {
			arr[i] = a.nextInt();
			}
		int val;
		val = a.nextInt();
		for(int i=0; i<n; ++i) {
			System.out.print(arr[i]);
			System.out.print(' ');
			}
		System.out.println();
		MySpecialArrayUtils test = new MySpecialArrayUtils();
		test.moveValue(arr, val);
		for(int i=0; i<n; ++i) {
			System.out.print(arr[i]);
			System.out.print(' ');
			}
		

	}

}
