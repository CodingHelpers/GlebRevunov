package revunov.gleb.lab8;

import revunov.gleb.lab8.math.IMatrix;
import revunov.gleb.lab8.math.ParallelMatrixProduct;
import revunov.gleb.lab8.math.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int matrix_size = 2000;

        Random rand = new Random();

        // Создаем разреженную матрицу с зеркальными половинами
        UsualMatrix m = new UsualMatrix(matrix_size, matrix_size);

        // Заполняем матрицу
        for(int i = 0; i < matrix_size; i++) {
            for(int j = 0; j < matrix_size; j++) {
                m.setElement(i, j, Math.abs(rand.nextInt() % 10));
            }
        }

        System.out.print("Sequential product... ");
        long simpleTime = System.nanoTime();
        IMatrix result = m.product(m);
        simpleTime = System.nanoTime() - simpleTime;
        System.out.println("done.");

        ParallelMatrixProduct product = new ParallelMatrixProduct();

        System.out.print("Parallel product... ");
        long parallelTime = System.nanoTime();
        IMatrix parallelResult = product.parallelMatrixProduct(m, m);
        parallelTime = System.nanoTime() - parallelTime;
        System.out.println("done.");

        double xFaster = simpleTime/(double)parallelTime;

        if(matrix_size < 50) {
            System.out.println("");
            System.out.println("M*M:");
            System.out.println(result.toString());

            System.out.println("");
            System.out.println("M*M (parallel):");
            System.out.println(parallelResult.toString());

            System.out.println("");
        }

        System.out.println("Parallel result equals sequential: " + result.equals(parallelResult));

        System.out.println("Sequential time: " + simpleTime / 1000 + "ms");
        System.out.println("Parallel time:   " + parallelTime / 1000 + "ms");
        System.out.println("Parallel is " + String.format("%.2f", xFaster) + "x faster.");
    }

}