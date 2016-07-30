package charles.sort.SelectionSort;


public class SelectionSort 
{
	private int[] array;
	
	public SelectionSort(int[] array){
		this.array = array;
	}
	
	public void sort(){
		for(int i =0;i<array.length;i++){
			int temp = i;
			for(int j = i+1;j<array.length;j++){
				if(array[j]<array[temp]){
					temp = j;
				}
			}
			
			if(temp!=i){
				swap(i, temp);
			}
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
    	int[] array = {5,6,3,1,8,9,10};
    	SelectionSort selection = new SelectionSort(array);
    	selection.sort();
    	selection.print();
    }
}
