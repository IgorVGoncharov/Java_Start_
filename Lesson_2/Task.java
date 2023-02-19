// Написать метод который приводит сторку к нормальному виду
// строка на вход:
// Добрый день Как дела Все хорошо
// выход:
// Добрый день. Как дела. Все хорошо.



public class Task {
    public static void main(String[] args) {
        String str = "Добрый       день  Как      дела   Все      хорошо";
        System.out.println("Заданный текст: " + str);
        System.out.println("Откорректированный текст: " + correctStr(str));
    }
   public static StringBuilder correctStr(String text){
        StringBuilder resultStr = new StringBuilder();
        String[] words = text.replaceAll("\\s+", " ").split("\\s");
        resultStr.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (Character.isUpperCase(words[i].charAt(0))){
                resultStr.append(". " + words[i]);
            }
            else{
                resultStr.append(" " + words[i]);
            }
        }
        resultStr.append(".");
        return resultStr;
    }
}
