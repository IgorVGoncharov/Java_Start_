import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 2 Пусть дан произвольный список целых чисел, удалить из него четные числа

public class Les_3_Task_2 {
        public static void main(String[] args) {
            try {
                List<Integer> numbers = listCreate(inputLength()); 
                System.out.println("Произвольный список: " + numbers);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i)%2 == 0){
                        numbers.remove(i);
                        i--;   
                    }
                }
                System.out.println("Список уже без четных чисел: " + numbers);            
            } catch (Exception e) {
                System.out.println("Ошибка! Введено не число!");
            }
            
            
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
