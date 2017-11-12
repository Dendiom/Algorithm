package TestOne.hundred_to_two;

import java.util.ArrayList;
import java.util.List;

public class Nineteen {

	public static List<Integer> getRow(int rowIndex) {    // 2 ms, refresh array from 0~rowIndex
		List<Integer> ans = new ArrayList<>();
		ans.add(1);
		if (rowIndex == 0)
			return ans;
		for (int i = 0; i < rowIndex; i++) {
			int temp = 0;
			int save = ans.get(0);
			for (int j = 1; j < i + 1; j++) {
				temp = ans.get(j);
				ans.set(j, save + ans.get(j));
				save = temp; // save
			}
			ans.add(1);
			// System.out.println(ans.size());
		}
		return ans;
	}
	
	public static List<Integer> getRowOnce(int rowIndex) {    // 0 ms, get the rowIndex array directly.
		List<Integer> list = new ArrayList<>(rowIndex+1);
        list.add(1);
        long prev = 1;
        long rowIndexPlusOne = rowIndex+1;
        for(int i=1;i<=rowIndex;i++){
            prev = (prev*(rowIndexPlusOne-i))/i;
            list.add((int)prev);
        }
        return list;
	}
	
	

	public static void main(String[] args) {
		System.out.println(getRow(0));
		System.out.println(getRow(1));
		System.out.println(getRow(2));
		System.out.println(getRow(3));
		System.out.println(getRow(4));
	}
}
