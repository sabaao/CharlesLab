package charles.sort.MergeSort;

public class TopDown 
{
private int[] array;
	
	public TopDown(int[] array){
		this.array = array;
	}
	
	public void sort(){
		sort(array,0,array.length);
	}
	
	public void sort(int[] array,int start,int count){
		if(count<2){
			return;
		}
		
		sort(array,start,count/2);
		sort(array,start+count/2,count-count/2);
		merge(array,start,count/2,start+count/2,count-count/2);
		
	}
	
	public void merge(int[] array,int leftStart,int leftCount,int rightStart,int rightCount){
		int[] workArray = new int[array.length];
		int index = 0;
		int i = leftStart;
		int j = rightStart;
		int leftBound = leftStart+leftCount;
		int rightBound = rightStart + rightCount;
		while(i<leftBound || j<rightBound){
			if(i<leftBound && j<rightBound){
				if(array[i]<array[j]){
					workArray[index] = array[i];
					index++;
					i++;
				}else{
					workArray[index] = array[j];
					index++;
					j++;
				}
			}else if(i<leftBound){
				workArray[index] = array[i];
				index++;
				i++;
			}else{
				//j<rightBound
				workArray[index] = array[j];
				index++;
				j++;
			}
		}
		
		for(int k = leftStart;k<leftStart+leftCount+rightCount;k++){
			array[k] = workArray[k-leftStart];
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
    	TopDown topDown = new TopDown(array);
    	topDown.sort();
    	topDown.print();
    }
}
