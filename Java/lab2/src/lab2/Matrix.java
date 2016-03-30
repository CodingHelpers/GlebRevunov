package lab2;

public class Matrix {
    // Конструктор, создающий еденичную матрицу
    Matrix(int _size) {
        this.size = _size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public Matrix sum (Matrix b) {
        Matrix new_matrix = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                new_matrix.setElement(i, j, getElement(i, j) + b.getElement(i, j));
            }
        }
        return new_matrix;
    }

    public Matrix product (Matrix b) {
        // Поскольку матрицы априори квадратные, возможно только умножение матриц одного размера
        Matrix new_matrix = new Matrix(size);

        // Перемножаем матрицы
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int c_ij = 0;
                for(int k = 0; k < size; k++) {
                    c_ij += getElement(i, k) + b.getElement(k, j);
                }
                new_matrix.setElement(i, j, c_ij);
            }
        }

        return  new_matrix;
    }

    public void setElement (int row, int collumn, int value) {
        matrix[row][collumn] = value;
    }

    public int getElement (int row, int collumn) {
        return matrix[row][collumn];
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                str += matrix[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    // Приватные поля
    private int     size;
    private int[][] matrix;

}
