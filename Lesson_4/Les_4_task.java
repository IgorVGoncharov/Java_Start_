//1 Реализовать телефонный справочник
//HashMap<Login, Список телефонов>
//- добалять телефон
//- удалять телефон
//- находить по логину телефон/список телефонов

package Lesson_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class Les_4_task {
    public static void main(String[] args) {
        System.out.printf("Добро пожаловать в телефонный справочник!");
        Map<String, HashSet<String>> phoneBook = new HashMap<>();
        choice(phoneBook);
    }   
    public static void addNumber(Map<String, HashSet<String>> Phonebook){
        HashSet<String> value = new HashSet<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите логин: ");
        String login = iScanner.nextLine();
        System.out.print("Введите телефон: ");
        String tel = iScanner.nextLine();
        value = Phonebook.getOrDefault(login, value); 
        value.add(tel);
        Phonebook.put(login, value);
    }
    public static void nextMove(Map<String, HashSet<String>> Phonebook){
        try {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("\nЧтобы вернуться в основное меню нажмите '1', выйти - '2': ");
            int input = Integer.parseInt(iScanner.nextLine());
            if (input == 1){
                choice(Phonebook);
            }   
            else if (input == 2){
                iScanner.close();
                System.out.println("До скорых встреч!");
            }
            else{
                iScanner.close();
                System.out.println("Ошибка! Введено не верное число!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка! Введено не число!");
        }   
    }
    public static void choice(Map<String, HashSet<String>> Phonebook){
        
        try {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf("\n\nМеню телефонного справочника:\n");
            System.out.println("1. Добавить телефон.\n2. Удалить телефон.\n3. Найти телефон.\n4. Показать весь список.\n5. Выйти\n");
            System.out.print("Введите значение: ");
            Integer choice = Integer.parseInt(iScanner.nextLine());
            if (choice == 1){
                addNumber(Phonebook);
                nextMove(Phonebook);
            }
            else if (choice == 2){
                remove(Phonebook);
                nextMove(Phonebook);
            }
            else if (choice == 3){
                numbersListShow(Phonebook);
                nextMove(Phonebook);
            }
            else if (choice == 4){
                show(Phonebook);
                nextMove(Phonebook);
            }
            else if (choice == 5){
                iScanner.close();
                System.out.println("До скорых встреч!");
            }
            else{
                iScanner.close();
                System.out.println("Введено не верное число!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка! Введено не число!");
        }
    }
    public static void show(Map<String, HashSet<String>> Phonebook){
        for (String key: Phonebook.keySet()) {
            System.out.println("\nДля логина '" + key + "' найдены следующие телефоны: ");
            for (String value : Phonebook.get(key)) {
                System.out.println(value);
            }
        }
    }
    public static void remove(Map<String, HashSet<String>> Phonebook){
        HashSet<String> value = new HashSet<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите логин для поиска: ");
        String input = iScanner.nextLine();
        if (Phonebook.get(input) == null){
            System.out.println("Логин не найден!");
            nextMove(Phonebook);
        }
        else{
            System.out.println("Для логина '" + input + "' найдены следующие телефоны: ");
            value = Phonebook.getOrDefault(input, value);
            for (String string : value) {
                System.out.println(string);
            }
        }
        System.out.print("\nДля удаления телефона, введите его номер\nили введите '0', чтобы удалить все: ");
        String del = iScanner.nextLine();
        if (Integer.parseInt(del) == 0){
            Phonebook.remove(input);
            System.out.println("Все номера удалены!");
        }
        else{
            int temp = 0;
            for (String i : value) {
                if (i.equals(del)){
                    value.remove(del);
                    System.out.println("Телефон " + del + " удален!");
                    temp = 1;
                    break;
                }
            }
            if (temp == 0){
                System.out.println("Такого телефона у '" + input + "' нет");
            }
        }
    }
    public static void numbersListShow(Map<String, HashSet<String>> Phonebook){
        HashSet<String> value = new HashSet<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите логин для поиска: ");
        String input = iScanner.nextLine();
        if (Phonebook.get(input) == null){
            System.out.println("Логин не найден!");
        }
        else{
            System.out.println("Для логина '" + input + "' спиcок телефонов: ");
            value = Phonebook.getOrDefault(input, value);
            for (String string : value) {
                System.out.println(string);
            }
        }
    }
}