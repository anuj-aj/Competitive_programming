package data_structures;
import java.util.ArrayList;
public class arraylist {

	public static void main(String[] args) {
		ArrayList<Integer> list1 =new ArrayList<>();
		System.out.println(list1.size());
		list1.add(3);
		list1.add(6);
		list1.add(9);
		list1.add(12);
		list1.add(15);
		list1.add(18);
		list1.add(21);
		System.out.println(list1.size());
		System.out.println(list1.get(0));
		System.out.println(list1.get(6));
		list1.set(3,0);
		System.out.println(list1.get(3));
		for(int elem : list1) {
			System.out.print( elem + "  " ) ;
}
		}
	}
