package revunov.gleb.lab3;

import revunov.gleb.lab3.math.Matrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Тестируем Matrix
        Matrix m1 = new Matrix(4, 4);
        Matrix m2 = new Matrix(4, 4);

        // Доп задание
        // Заполнение половины матриц случайным числами
        Random rand = new Random();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++) {
                m1.setElement(i, j, rand.nextInt() % 5);
                m2.setElement(i, j, rand.nextInt() % 5);
            }
        }

        // Вывод матриц как они хранятся
        System.out.println(m1.toString());
        System.out.println(m2.toString());

        Matrix sum = m1.sum(m2);
        System.out.println(sum.toString());
    }
}
