package charles.sort.QuckSort;


public class QuickSort 
{
	private int[] array;
	public QuickSort(int[] array){
		this.array = array;
	}
	
	public void sort(){
		mainSort(0,array.length-1);
	}
	
	public int partition(int left,int right){
		int i = left;
		int j = right;
		int pivot = array[(left+right)/2];
		
		if(right>left){	
			while(i<=j){
				while(array[i]<pivot){
					i++;
				}
				
				while(array[j]>pivot){
					j--;
				}
				
				if(i<=j){
					swap(i,j);
					i++;
					j--;
				}
				
			}
		}
		return i;
	}
	
	public void mainSort(int left,int right){
		int index = partition(left,right);
		if(index>left){
			mainSort(left,index-1);
		}
		
		if(index<right){
			mainSort(index+1,right);
		}
	}
	
	public void swap(int i,int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public void print(){
		String result = "";
		for(int i=0;i<array.length;i++){
			result += array[i] + ",";
		}
		
		System.out.println(result);
	}
	
    public static void main( String[] args )
    {
    	int[] array = {22,9,2,5,4,3,1};
    	QuickSort quick = new QuickSort(array);
    	quick.sort();
    	quick.print();
    }
}
