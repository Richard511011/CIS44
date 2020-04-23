
public class LabSeven {
	public static int findMissing(int[] a) {
		int answer = ((a.length+1)*(a.length+2))/2;
		for(int i =0; i<a.length;i++) {
			answer-=a[i];
		}
		return answer;
	}
	public static void countingSort(int a[],int n) {
		int[] count = new int[n];
		int front =0;
		for(int i =0;i<a.length;i++) {//generating count array values
			count[a[i]-1]++;	
		}
//		for(int i =0;i<count.length;i++) {
//			System.out.print(count[i]+" ");
//		}
//		System.out.println();
		for(int i =0;i<count.length;i++) { //sorting a[] based on the data from count array 
			if(count[i]!=0) {
				for(int j=0;j<count[i];j++) {
					a[front]=i+1;
					front++;
				}
			}
		}
	
	}
}
