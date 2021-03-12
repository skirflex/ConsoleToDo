import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleTodo {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("Тест");
        Scanner scanner = new Scanner(System.in);
        Integer index;
        String text;
        String comm;
        String inexIndex;
        todoList.add("Тест2");
        System.out.println("Добро пожаловать!");

        while (true) {
            System.out.println("\nВведите команду");
            String command = scanner.nextLine();
            if (command.indexOf(" ") <= 0)
            {
                comm = command.toUpperCase(Locale.ROOT).trim();
            }
            else {
                comm = command.substring(0, command.indexOf(" ")).toUpperCase(Locale.ENGLISH).trim();

            }

            switch (comm)
            {
                case "ADD" :
                    if (command.replaceAll("[\\D]", "") == "")
                    {
                        index = todoList.size();
                        text = command.substring(comm.length()).trim();
                    }
                    else
                    {
                        index = Integer.parseInt(command.replaceAll("[\\D]", "").trim());
                        inexIndex = command.replaceAll("[\\D]" , "").trim();
                        text = command.substring(command.indexOf(inexIndex) + inexIndex.length()).trim();

                    }
                    if (todoList.size() < index) {
                        index = todoList.size();
                        System.out.println("Элемент перемещён на последнее место");
                    }
                    todoList.add(index, text);
                    System.out.println("Выполнено");
                    break;

                case "DELETE" :
                    int indexDelete = Integer.parseInt(command.replaceAll("[\\D]", "").trim());
                    if (todoList.size() < indexDelete) {
                        System.out.println("Такого элемента не существует");
                        break;
                    }
                    todoList.remove(indexDelete);
                    System.out.println("Успешно");
                    break;

                case "LIST" :
                    if (todoList.size() == 0)
                    {
                        System.out.println("Пусто");
                    }
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + " - " + todoList.get(i));
                    }
                    break;

                case "EDIT" :

                    int indexEdit = Integer.parseInt(command.replaceAll("[\\D]", "").trim());
                    if (todoList.size() < indexEdit) {
                        System.out.println("Такого элемента не существует");
                        break;
                    }
                    todoList.remove(indexEdit);
                    inexIndex = command.replaceAll("[\\D]" , "").trim();
                    text = command.substring(command.indexOf(inexIndex) + inexIndex.length()).trim();
                    todoList.add(indexEdit, text);
                    System.out.println("Выполнено");

                    break;


                default:
                    System.out.println("Команда введена неверно");
            }


        }
    }


}




