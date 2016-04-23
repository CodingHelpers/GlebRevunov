package lab2;

public class Main {
    public static void main(String args[]) {
        /// Создаем нужную матрицу
        Matrix matrix = new Matrix(2);
        matrix.setElement(1,0,1);
        matrix.setElement(1,1,0);
        matrix.setElement(0,1,1);

        /// Первая степень уже есть, просто выводим ее
        System.out.println("Power " + 1);
        System.out.println(matrix.toString());

        /// Вычисляем и выводим остальные степени
        for(int i = 2; i <= 10; i++) {
            matrix = matrix.product(matrix);
            System.out.println("Power " + i);
            System.out.println(matrix.toString());
        }

        /// Создаем еще одну матрицу
        Matrix matrix2 = new Matrix(2);
        matrix2.setElement(1, 0, 5);
        matrix2.setElement(1, 1, 5);

        /// Выводим вторую матрицу
        System.out.println("Not sorted: ");
        System.out.println(matrix2.toString());

        /// Сортиируем и выводим еще раз
        matrix2.doSortRows();
        System.out.println("Sorted: ");
        System.out.println(matrix2.toString());
    }
}
