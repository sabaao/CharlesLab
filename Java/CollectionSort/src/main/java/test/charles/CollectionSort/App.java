package test.charles.CollectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<User> userList = new ArrayList<User>();
        //add user name and age
        userList.add(new User("user1",19));
        userList.add(new User("user2",40));
        userList.add(new User("user3",3));
        userList.add(new User("user4",27));
        userList.add(new User("user5",10));
        userList.add(new User("user6",70));
        
        //sort by user age
        Collections.sort(userList, new Comparator<User>() {
			public int compare(User o1, User o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
		});
        
        //print information
        for(User s :userList){
        	System.out.println("name:" + s.getName() + ",age:" + s.getAge());
        }
    }
}
