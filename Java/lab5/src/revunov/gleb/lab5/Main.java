package revunov.gleb.lab5;

import revunov.gleb.lab5.math.SparseMatrix;
import revunov.gleb.lab5.math.SquareMatrix;
import revunov.gleb.lab5.math.UsualMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int matrix_size = 1000;
        // Создаем две квадратные матрицы
        UsualMatrix usualMatrix1 = new UsualMatrix(matrix_size, matrix_size);
        UsualMatrix usualMatrix2 = new UsualMatrix(matrix_size, matrix_size);

        // Создаем две разрженые матрицы
        SparseMatrix sparseMatrix1 = new SparseMatrix(matrix_size, matrix_size);
        SparseMatrix sparseMatrix2 = new SparseMatrix(matrix_size, matrix_size);

        Random rand = new Random();

        // Заполняем матрицы попарно случайными числами, считаем нули, чтобы их количество не превысило 1000
        int zero_cnt = 0;
        for (int i = 0; i < matrix_size; i++) {
            for (int j = 0; j < matrix_size; j++) {
                int value = rand.nextInt() % 2;
                if(value == 0) {
                    if(zero_cnt == 1000) {
                        value = 1;
                    } else {
                        zero_cnt++;
                    }
                }
                usualMatrix1.setElement(i, j, value);
                sparseMatrix1.setElement(i, j, value);
            }
        }

        zero_cnt = 0;
        for (int i = 0; i < matrix_size; i++) {
            for (int j = 0; j < matrix_size; j++) {
                int value = rand.nextInt() % 2;
                if(value == 0) {
                    if(zero_cnt == 1000) {
                        value = 1;
                    } else {
                        zero_cnt++;
                    }
                }
                usualMatrix2.setElement(i, j, value);
                sparseMatrix2.setElement(i, j, value);
            }
        }

        // Сравниваем результаты операций сложения с разными типами матриц
        Object sum1 = usualMatrix1.sum(usualMatrix2);
        System.out.println("usual1 + usual2");
        Object sum2 = usualMatrix1.sum(sparseMatrix2);
        System.out.println("usual1 + sparse2");

        if(sum1.equals(sum2)) {
            System.out.println("+: SUCCESS");
        } else {
            System.out.println("+: FAIL");
        }

        // Сравниваем результаты операций сложения с разными типами матриц
        Object prod1 = usualMatrix1.product(usualMatrix2);
        System.out.println("usual1 * usual2");
        Object prod2 = usualMatrix1.product(sparseMatrix2);
        System.out.println("usual1 * sparse2");

        if(sum1.equals(sum2)) {
            System.out.println("*: SUCCESS");
        } else {
            System.out.println("*: FAIL");
        }
    }
}
