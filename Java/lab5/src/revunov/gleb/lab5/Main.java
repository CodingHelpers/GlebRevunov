package revunov.gleb.lab5;

import revunov.gleb.lab5.math.SparseMatrix;
import revunov.gleb.lab5.math.UsualMatrix;
import revunov.gleb.lab5.math.IMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int matrix_size = 10;

        // Создаем разреженную матрицу с зеркальными половинами
        SparseMatrix m = new SparseMatrix(matrix_size, matrix_size);

        // Заполняем одну половину
        for(int i = 0; i < matrix_size / 2; i++) {
            for(int j = 0; j < matrix_size; j++) {
                m.setElement(i, j, i+j);
            }
        }

        // Выводим матрицу
        System.out.println(m.toString());
    }

}