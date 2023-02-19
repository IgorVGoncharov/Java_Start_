import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 3* Реализовать алгоритм сортировки слиянием

public class Les_3_Task_3 {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = listCreate(inputLength()); 
            System.out.println("Произвольный список: " + numbers);
            merge_sort(numbers, 0, numbers.size());
            System.out.println("Отсортированный список: " + numbers);
        } catch (Exception e) {
            System.out.println("Ошибка! Введено не число!");
        }
        
        
        
    }
    public static void merge_sort(List<Integer> myList, int start, int end){
        if (end - start > 1){
            int midle = (start + end)/2;
            merge_sort(myList, start, midle);
            merge_sort(myList, midle, end);
            merge_list(myList, start, midle, end);
        }
    }
    public static List<Integer> merge_list(List<Integer> myList, int start, int mid, int end){
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        for (int l = start; l < mid; l++) {
            leftArr.add(myList.get(l));
        }
        for (int g = mid; g < end; g++) {
            rightArr.add(myList.get(g));
        }
        int k = start;
        int i = 0;
        int j = 0;
        while (start + i < mid && mid + j < end){
            if (leftArr.get(i) <= rightArr.get(j)){
                myList.set(k, leftArr.get(i));
                i++;
            }
            else{
                myList.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }
        if (start + i < mid){
            while (k < end){
                myList.set(k, leftArr.get(i));
                i++;
                k++;
            }               
        }
        else{
            while (k < end){
                myList.set(k, rightArr.get(j));
                j++;
                k++;
            }
        }
    return myList;
    } 
    public static List<Integer> listCreate(int size){
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randNumbers.add(random.nextInt(1, 20));
        }
        return randNumbers;
    }
    public static int inputLength(){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите длину списка: ");
        String val = iScanner.nextLine();
        int len = Integer.parseInt(val);
        iScanner.close();
        return len;
    }
}
