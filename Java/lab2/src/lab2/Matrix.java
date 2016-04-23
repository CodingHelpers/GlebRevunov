package lab2;

public class Matrix {
    // Конструктор, создающий еденичную матрицу
    Matrix(int _size) {
        this.size = _size;
        matrix = new long[size][size];
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
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                long temp = 0;
                for(int inner = 0; inner < size; inner++) {
                    temp += getElement(row, inner) * b.getElement(inner, col);
                }
                new_matrix.setElement(row, col, temp);
            }
        }

        return  new_matrix;
    }

    public void doSortRows() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size; j++) {
                if(rowSum(i) < rowSum(j)) {
                    swapRows(i, j);
                }
            }
        }
    }

    long rowSum(int row) {
        long sum = 0;
        for(int i = 0; i < size; i++) {
            sum += matrix[row][i];
        }
        return sum;
    }

    void swapRows(int row1, int row2) {
        long temp;
        for(int i = 0; i < size; i++) {
            temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
    }

    public void setElement (int row, int collumn, long value) {
        matrix[row][collumn] = value;
    }

    public long getElement (int row, int collumn) {
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
    private int      size;
    private long[][] matrix;

}
