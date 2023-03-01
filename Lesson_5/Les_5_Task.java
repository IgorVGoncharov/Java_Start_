//Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.
//Example 1:
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
//Example 2:
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
//Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

package Lesson_5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Les_5_Task {
    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1,2,3,2,1));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(3,2,1,4,7));
        System.out.println("Массив 1: " + nums1);
        System.out.println("Массив 2: " + nums2);
        searchFunc(nums1, nums2, 5);
    }
    public static void searchFunc(List<Integer> nums1, List<Integer> nums2, int number){
        for (int n = number; n > 0; n--) {
            HashSet<ArrayList<Integer>> list1 = new HashSet<>();
            HashSet<ArrayList<Integer>> list2 = new HashSet<>();
            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            boolean result = false;
            for (int i = 0; i <= nums1.size()-n; i++) {
                for (int j = i; j < n+i; j++) {
                    temp1.add(nums1.get(j));
                    temp2.add(nums2.get(j));
                }
                list1.add(temp1);
                list2.add(temp2);
                temp1 = new ArrayList<>();
                temp2 = new ArrayList<>();
            }
            for (ArrayList<Integer> firstArr : list1) {
                for (ArrayList<Integer> secArr : list2) {
                    if (firstArr.equals(secArr)){                
                        System.out.println("Повторяющийся подмассив с максимальной длиной " + n + " равен " + firstArr);
                        result = true;
                    }
                }
            }
            if (result){
                break;
            }   
        }
    }
}