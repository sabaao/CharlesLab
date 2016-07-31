package charles.sort.BubbleSort;


public class BubbleSort 
{
private int[] array;
	
	public BubbleSort(int[] array){
		this.array = array;
	}
	
	public void sort(){
		for(int i =array.length-1;i>0;i--){
			for(int j = 0;j<i;j++){
				if(array[j]>array[j+1]){
					swap(j,j+1);
				}
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
    	BubbleSort bubble = new BubbleSort(array);
    	bubble.sort();
    	bubble.print();
    }
}
