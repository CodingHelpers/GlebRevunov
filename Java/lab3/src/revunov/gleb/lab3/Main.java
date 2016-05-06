package revunov.gleb.lab3;

import revunov.gleb.lab3.math.Matrix;
import revunov.gleb.lab3.math.MatrixException;
import revunov.gleb.lab3.math.SquareMatrix;

public class Main {
    public static void main(String[] args) {
        // Тестируем Matrix
        Matrix m1 = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 3);
        Matrix m3 = new Matrix(4, 4);

        // Тестируем сумму
        m1.setElement(0, 1, 10);
        m2.setElement(0, 1, 5);
        m1 = m1.sum(m2);
        System.out.print("Sum 3x3+3x3: ");
        if(m1.getElement(0, 1) == 15) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }

        // Тестируем сумму двух матриц разного размера
        System.out.print("Sum 4x4+3x3: ");
        try {
            m1 = m1.sum(m3);
        } catch (MatrixException e) {
            System.out.println("FAILED: " + e.getMessage());
        }

        // Тестируем произведение
        m1.product(m2);
        System.out.print("Product 3x3*3x3: ");
        if(m1.getElement(0, 1) == 15) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }

        // Тестируем произведение двух матриц разного размера
        System.out.print("Product 4x4*3x3: ");
        try {
            m1 = m1.product(m3);
        } catch (MatrixException e) {
            System.out.println("FAILED: " + e.getMessage());
        }

        // Тестируем квадратные матрицы
        // Создаем единичные матрицы
        SquareMatrix sm1 = new SquareMatrix(5);
        SquareMatrix sm2 = new SquareMatrix(5);

        // Тестируем сумму
        System.out.print("Sum 5x5+5x5 square: ");
        sm1 = sm1.sum(sm2);
        if(sm1.getElement(0, 0) == 2) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }

        // Тестируем equals
        // Cоздаем одинаковые Matrix
        Matrix me1 = new Matrix(5, 2);
        Matrix me2 = new Matrix(5, 2);

        System.out.print("Matrix 5x5==5x5: ");
        if(me1.equals(me2)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }

        // Создаем одинаковые SquareMatrix
        SquareMatrix sme1 = new SquareMatrix(5);
        SquareMatrix sme2 = new SquareMatrix(5);

        System.out.print("SquareMatrix 5x5==5x5: ");
        if(sme1.equals(sme2)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }
    }
}
