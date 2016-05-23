package revunov.gleb.lab3.math;

public class Matrix {
    // Конструктор, создающий нулевую матрицу
    public Matrix(int rows, int cols) {
        if(cols % 2 != 0) {
            throw new MatrixException("Количество столбцов должно быть четным");
        }
        this.rows   = rows;
        this.cols   = cols;
        this.matrix = new int[rows/2][cols];
    }

    public Matrix sum (Matrix b) {
        // Проверяем, если матрицы разного размера, кидаем исключение
        if(this.getRows() != b.getRows() || this.getCols() != b.getCols()) {
            throw new MatrixException("Невозможно сложить матрицы разного размера");
        }

        // Создаем новую матрицу-результат
        Matrix result = new Matrix(rows, cols);

        // Производим сложение матриц
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, getElement(i, j) + b.getElement(i, j));
            }
        }

        // Возвращаем результат
        return result;
    }

    public Matrix product (Matrix b) {
        // Проверяем, если количество строк матрицы не равно количеству столбцов b
        if(this.getRows() != b.getCols()) {
            throw new MatrixException("Невозможно произвести умножение: количество строк матрицы A не равно количеству столбцов матрицы B");
        }

        // Создаем новую матрицу-результат
        Matrix result = new Matrix(this.getRows(), b.getCols());

        // Перемножаем матрицы
        for (int row = 0; row < this.getRows(); row++) {
            for (int col = 0; col < b.getCols(); col++) {
                int temp = 0;
                for(int inner = 0; inner < b.getRows(); inner++) {
                    temp += getElement(row, inner) * b.getElement(inner, col);
                }
                result.setElement(row, col, temp);
            }
        }

        return result;
    }

    public void setElement (int row, int collumn, int value) {
        if(row >= rows / 2) {
            matrix[rows-row-1][collumn] = value;
            return;
        }
        matrix[row][collumn] = value;
    }

    public int getElement (int row, int collumn) {
        if(row >= rows / 2) {
            return matrix[rows-row-1][collumn];
        }
        return matrix[row][collumn];
    }

    public final int getRows() {
        return rows;
    }

    public final int getCols() {
        return cols;
    }

    public final String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += getElement(i, j) + " ";
            }
            str += "\n";
        }
        return str;
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if(obj.getClass() != this.getClass()) {
            return false;
        }

        Matrix b = (Matrix) obj;
        if(this.getRows() != b.getRows() || this.getCols() != b.getCols()) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(getElement(i, j) != b.getElement(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Приватные поля
    protected final int     rows;
    protected final int     cols;
    protected int[][] matrix;

}
