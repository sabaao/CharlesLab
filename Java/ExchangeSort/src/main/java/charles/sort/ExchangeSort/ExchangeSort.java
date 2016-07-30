package charles.sort.ExchangeSort;

/**
 * Hello world!
 *
 */
public class ExchangeSort 
{
	private int[] array;
	
	public ExchangeSort(int[] array){
		this.array = array;
	}
	
	public void sort(){
		for(int i =0;i<array.length;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[i]>array[j]){
					swap(i, j);
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
        ExchangeSort sort = new ExchangeSort(array);
        sort.sort();
        sort.print();
    }
}
