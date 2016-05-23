package revunov.gleb.lab4;

import java.util.Random;

public class Main {
    public static void main(String []args) {
        // Проверяем список на добавление чисел по возрастанию, дупликаты запрещены
        {
            SortedIntegerList list = new SortedIntegerList(false);
            list = fillList(list, false, false);
            System.out.println(list.toString());

            // Проверяем список
            System.out.println("0...9, no duplicates: " + (isAscending(list) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем список на добавление чисел по возрастанию, дупликаты разрешены
        {
            SortedIntegerList list = new SortedIntegerList(true);
            list = fillList(list, false, false);
            System.out.println(list.toString());

            // Проверяем список
            System.out.println("0...9, duplicates: " + (isAscending(list) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем список на добавление чисел по убыванию, дупликаты запрещены
        {
            SortedIntegerList list = new SortedIntegerList(false);
            list = fillList(list, true, false);
            System.out.println(list.toString());

            // Проверяем список
            System.out.println("9...0, no duplicates: " + (isAscending(list) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем список на добавление чисел по убыванию, дупликаты разрешены
        {
            SortedIntegerList list = new SortedIntegerList(true);
            list = fillList(list, true, false);
            System.out.println(list.toString());

            // Проверяем список
            System.out.println("9...0, duplicates: " + (isAscending(list) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем добавление в список случайных чисел, дупликаты запрещены
        {
            SortedIntegerList list = new SortedIntegerList(false);
            list = fillList(list, false, true);
            System.out.println(list.toString());

            // Проверяем список
            boolean pass = isAscending(list);

            if(list.size() > 7) {
                pass = false;
            }

            System.out.println("random, no duplicates: " + (pass ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем добавление в список случайных чисел, дупликаты разрешены
        {
            SortedIntegerList list = new SortedIntegerList(true);
            list = fillList(list, false, true);
            System.out.println(list.toString());

            // Проверяем список
            boolean pass = isAscending(list);

            if(list.size() != 20) {
                pass = false;
            }

            System.out.println("random, duplicates: " + (pass ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем удаление, дубликатов нет
        {
            SortedIntegerList list = new SortedIntegerList(false);
            list = fillList(list, false, false);
            System.out.println(list.toString());

            // Удаляем 5
            list.remove(5);
            System.out.println(list.toString());

            // Проверяем список
            boolean pass = true;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).equals(5)) {
                    pass = false;
                }
            }

            System.out.println("delete, no duplicates: " + (pass ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем удаление, дубликаты разрешены
        {
            SortedIntegerList list = new SortedIntegerList(true);
            list = fillList(list, false, false);
            System.out.println(list.toString());

            // Удаляем 5
            list.remove(5);
            System.out.println(list.toString());

            // Проверяем список
            System.out.println("delete, duplicates: " + (!contains(list, 5) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем метод equals
        {
            SortedIntegerList list1 = new SortedIntegerList(true);
            SortedIntegerList list2 = new SortedIntegerList(true);

            list1 = fillList(list1, true, false);
            list2 = fillList(list2, true, false);

            System.out.println(list1.toString());
            System.out.println(list2.toString());

            System.out.println("equals: " + (list1.equals(list2) ? "SUCCESS" : "FAILURE"));

            list1.remove(5);

            System.out.println(list1.toString());
            System.out.println(list2.toString());

            System.out.println("!equals: " + (!list1.equals(list2) ? "SUCCESS" : "FAILURE"));
        }

        // Проверяем бинарный поиск
        {
            SortedIntegerList list1 = new SortedIntegerList(true);

            list1 = fillList(list1, true, false);

            System.out.println(list1.toString());

            if(list1.find(100)) {
                System.out.println("list1.find(100): CONTAINS");
            } else {
                System.out.println("list1.find(100): NO");
            }

            if(list1.find(5)) {
                System.out.println("list1.find(5): CONTAINS");
            } else {
                System.out.println("list1.find(5): NO");
            }
        }

    }

    private static SortedIntegerList fillList(SortedIntegerList lst, boolean reverse, boolean random) {
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            if(random) {
                int r = rand.nextInt() % 4;
                lst.add(r);
                lst.add(r);
            } else {
                if(reverse) {
                    lst.add(9 - i);
                    lst.add(9 - i);
                } else {
                    lst.add(i);
                    lst.add(i);
                }
            }
        }

        return lst;
    }

    private static boolean isAscending(SortedIntegerList lst) {
        boolean pass = true;
        Integer last = lst.get(0);
        for(int i = 1; i < lst.size(); i++) {
            if(last > lst.get(i)) {
                pass = false;
            }
            last = lst.get(i);
        }
        return pass;
    }

    private static boolean contains(SortedIntegerList lst, Integer num) {
        for(int i = 0; i < lst.size(); i++) {
            if(lst.get(i).equals(num)) {
                return true;
            }
        }
        return false;
    }
}
