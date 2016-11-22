package revunov.gleb.lab8;

import revunov.gleb.lab8.math.IMatrix;
import revunov.gleb.lab8.math.ParallelMatrixProduct;
import revunov.gleb.lab8.math.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Преимущества параллельной реализации видны только на больших матрицах
        // на маленьких вычисления обычным методам занимают меньше времени, чем создание потоков
        final int matrix_size = 1000;

        Random rand = new Random();

        // Создаем матрицу
        UsualMatrix m = new UsualMatrix(matrix_size, matrix_size);

        // Заполняем матрицу
        for(int i = 0; i < matrix_size; i++) {
            for(int j = 0; j < matrix_size; j++) {
                m.setElement(i, j, Math.abs(rand.nextInt() % 10));
            }
        }

        // Обычное усножение и замер времени
        System.out.print("Sequential product... ");
        long simpleTime = System.nanoTime();
        IMatrix result = m.product(m);
        simpleTime = System.nanoTime() - simpleTime;
        System.out.println("done.");

        ParallelMatrixProduct product = new ParallelMatrixProduct();

        // Параллельное умножение и замер времени
        System.out.print("Parallel product... ");
        long parallelTime = System.nanoTime();
        IMatrix parallelResult = product.parallelMatrixProduct(m, m);
        parallelTime = System.nanoTime() - parallelTime;
        System.out.println("done.");

        // Во сколько раз параллельная реализация быстрее
        double xFaster = simpleTime/(double)parallelTime;

        // Выводим результаты в консоль, если матрица небольшая
        if(matrix_size < 20) {
            System.out.println("");
            System.out.println("M*M:");
            System.out.println(result.toString());

            System.out.println("");
            System.out.println("M*M (parallel):");
            System.out.println(parallelResult.toString());

            System.out.println("");
        }

        // Проверка на правильность параллельной реализации
        // (правильность последовательной была доказана в прошлых заданиях)
        System.out.println("Parallel result equals sequential: " + result.equals(parallelResult));

        // Вывод времени и выводов
        System.out.println("Sequential time: " + simpleTime / 1000 + "ms");
        System.out.println("Parallel time:   " + parallelTime / 1000 + "ms");
        System.out.println("Parallel is " + String.format("%.2f", xFaster) + "x faster.");
    }

}