package revunov.gleb.lab5;

import revunov.gleb.lab5.math.SparseMatrix;
import revunov.gleb.lab5.math.UsualMatrix;
import revunov.gleb.lab5.math.IMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int matrix_size = 100;
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

        // Производим операции сложения
        IMatrix sum1 = usualMatrix1.sum(usualMatrix2);
        System.out.println("sum1 = usual1 + usual2");
        IMatrix sum2 = usualMatrix1.sum(sparseMatrix2);
        System.out.println("sum2 = usual1 + sparse2");

        // Находим разность результатов
        System.out.println("checksum = sum1 - sum2");
        IMatrix checksum1 = sum1.diff(sum2);
        System.out.println("Сумма элементов checksum равна " + checksum1.elements_sum());

        // Проводим операции умножения
        IMatrix prod1 = usualMatrix1.product(usualMatrix2);
        System.out.println("prod1 = usual1 * usual2");
        IMatrix prod2 = usualMatrix1.product(sparseMatrix2);
        System.out.println("prod2 = usual1 * sparse2");

        // Находим разность результатов
        System.out.println("checksum = prod1 - prod2");
        IMatrix checksum2 = prod1.diff(prod2);
        System.out.println("Сумма элементов checksum равна " + checksum2.elements_sum());


    }
}
