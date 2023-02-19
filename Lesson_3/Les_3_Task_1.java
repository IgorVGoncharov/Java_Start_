import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 1 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.


public class Les_3_Task_1 {
    public static void main(String[] args) {
        try {   
            List<Integer> numbers = listCreate(inputLength()); 
            System.out.println("Начальный список: " + numbers);
            Collections.sort(numbers);
            System.out.println("Отсортированный список: " + numbers);
            System.out.println("Минимальное значение: " + numbers.get(0));
            System.out.println("Максимальное значение: " + numbers.get(numbers.size()-1));
            System.out.println("Среднее значение: " + midFind(numbers));
        } catch (Exception e) {
            System.out.println("Ошибка! Введено не число!");
        }
    }
    public static List<Integer> listCreate(int size){
        List<Integer> randNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randNumbers.add(random.nextInt(1, 100));
        }
        return randNumbers;
    }
    public static double midFind(List<Integer> list){
        double midSum = 0;
        for (Integer i : list) {
            midSum += i;
        }
        midSum = midSum/list.size();
        return midSum;
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
