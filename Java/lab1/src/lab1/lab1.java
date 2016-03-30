package lab1;

/// Класс Random нужен для удобного получения рандомных интов
import org.jetbrains.annotations.Contract;

import java.util.Random;

public class lab1  {
    public static void main (String args[]) {

        /// Создаем новый целочисленный массив размером 16
        int[] Array = new int[16];

        /// Инициализируем массив случайными числами
        Random random = new Random();
        for(int i = 0; i < Array.length; i++) {
            Array[i] = random.nextInt(100);
        }

        /// Простая сортировка (пузырек)
        System.out.println("\nSimple sort (first 5 steps)");
        System.out.print("Step 0: ");
        PrintArray(Array);
        VisualizedSort.SetVisibleSteps(5);                      ///< Устанавливаем количество отображаемых шагов
        SimpleSort.Sort(Array);                                 ///< Сортируем массив

        /// Выводим отсортированный массив
        System.out.print("Sorted: ");
        PrintArray(Array);

        /// Инициализируем массив случайными числами перед следующей сортировкой
        for(int i = 0; i < Array.length; i++) {
            Array[i] = random.nextInt(100);
        }

        /// Быстрая сортировка
        System.out.println("\nQuicks sort");
        System.out.print("Step 0: ");
        PrintArray(Array);
        VisualizedSort.SetVisibleSteps(Integer.MAX_VALUE);
        QuickSort.Sort(Array);                                 ///< Сортируем массив

        /// Выводим отсортированный массив
        System.out.print("Sorted: ");
        PrintArray(Array);

        /// Инициализируем массив случайными числами перед следующей сортировкой
        for(int i = 0; i < Array.length; i++) {
            Array[i] = random.nextInt(100);
        }

        /// Сортировка слиянием
        System.out.println("\nMerge sort");
        System.out.print("Step 0: ");
        PrintArray(Array);
        MergeSort.Sort(Array);                                 ///< Сортируем массив

        /// Выводим отсортированный массив
        System.out.print("Sorted: ");
        PrintArray(Array);

        System.out.println("\nDone.");
    }

    /// Метод вывода массива на экран
    public static void PrintArray (int[] Array) {
        for(int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
        System.out.print("\n");
    }

    /// Базовый класс визуализированной сортировки, содержить общие поля и сеттеры, геттеры
    public static class VisualizedSort {
        public static int[] Sort(int[] Array) {
            return Array;
        }

        public static void SetVisibleSteps(int cnt) {
            StepsCnt = cnt;
        }
        
        public static int GetVisibleSteps() {
            return StepsCnt;
        }

        protected static int StepsCnt;
        protected static int Visualized;
    }

    /// Класс сортировки пузырьком
    public static class SimpleSort extends VisualizedSort {
        static public int[] Sort(int[] Array) {
            /// Количество визуализированных шагов, зануляем при старте
            Visualized = 0;

            for(int i = 0; i < Array.length-1; i++) {
                for(int j = i+1; j < Array.length; j++) {
                    /// Если  элемент под индексом i больше элемента j, меняем их местами
                    if(Array[i] > Array[j]) {
                        int temp = Array[i];
                        Array[i]    = Array[j];
                        Array[j]    = temp;

                        /// Выводим шаг, если не превысили количество выводимых шагов
                        if(Visualized++ < StepsCnt) {
                            System.out.print("Step " + Visualized + ": ");
                            PrintArray(Array);
                        }
                    }
                }
            }

            return Array;
        }
    }

    /// Класс быстрой сортировки
    public static class QuickSort extends VisualizedSort {
        public static int[] Sort(int[] Array) {
            Visualized = 0;
            array = Array;                  ///< Сохраняем в приватную пемеренную массив
            int spos = 0;                   ///< Инициализируем границы
            int epos = Array.length - 1;
            doQuickSort(spos, epos);        ///< Сортируем массив
            return array;
        }

        private static void doQuickSort(int spos, int epos) {
            /// Если остался один элемент, возвращаемся
            if(spos >= epos) {
                return;
            }

            int i = spos, j = epos;
            int cur = i - ( i - j) / 2;

            /// Магия
            while (i < j) {
                while (i < cur && (array[i] <=  array[cur])) {
                    i++;
                }

                while (j > cur && (array[cur] <= array[j])) {
                    j--;
                }

                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    if (i == cur)
                        cur = j;
                    else if (j == cur)
                        cur = i;

                    if(Visualized++ < StepsCnt) {
                        System.out.print("Step " + Visualized + ": ");
                        PrintArray(array);
                    }
                }
            }

            /// Рекурсивно сортируем получившиеся отрезки
            doQuickSort(spos, cur);
            doQuickSort(cur+1, epos);
        }

        /// Статическое поле для более удобного хранения массива
        private static int[] array;
    }

    /// Класс сортировки слиянием
    public static class MergeSort extends VisualizedSort {
        public static int[] Sort(int[] Array) {
            Visualized = 0;                     ///< Количество визуализированных шагов, зануляем при старте
            array      = Array;                 ///< Сохраняем массив во внутреннюю переменную для удобства
            tempArray  = new int[array.length]; ///< Резервируем временный массив
            doMergeSort(0, array.length - 1);   ///< Выполняем сортировку
            return array;
        }

        private static void doMergeSort(int spos, int epos) {
            if(spos < epos) {
                int middle = spos + (epos - spos) / 2;
                /// Сортируем лувую часть
                doMergeSort(spos, middle);
                /// Сортируем правую часть
                doMergeSort(middle+1, epos);
                /// Склеиваем части
                Merge(spos, middle, epos);
            }
        }

        private static void Merge(int spos, int middle, int epos) {
            for (int i = spos; i <= epos; i++) {
                tempArray[i] = array[i];
            }

            int i = spos;
            int j = middle + 1;
            int k = spos;

            /// При склеивании сортируем -- если меньше элемент из первой половины, пишем его в массив,
            /// иначе пишем элемент из второй половины
            while (i <= middle && j <= epos) {
                if(tempArray[i] <= tempArray[j]) {
                    array[k] = tempArray[i];
                    i++;
                } else {
                    array[k] = tempArray[j];
                    j++;
                }
                k++;
            }

            /// Записываем остальные элементы (они уже рекурсивно отсортированы)
            while (i <= middle) {
                array[k] = tempArray[i];
                k++;
                i++;
            }

            /// Выводим шаг
            if(Visualized++ < StepsCnt) {
                System.out.print("Step " + Visualized + ": ");
                PrintArray(array);
            }
        }

        private static int[] array;
        private static int[] tempArray;
    }
}