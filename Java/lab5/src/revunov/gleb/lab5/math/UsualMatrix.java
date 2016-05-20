package revunov.gleb.lab5.math;

public class UsualMatrix implements IMatrix {
    // Конструктор, создающий нулевую матрицу
    public UsualMatrix(int rows, int cols) {
        this.rows   = rows;
        this.cols   = cols;
        createMatrix();
    }

    public IMatrix sum (IMatrix b) {
        // Проверяем, если матрицы разного размера, кидаем исключение
        if(this.getRows() != b.getRows() || this.getCols() != b.getCols()) {
            throw new MatrixException("Невозможно сложить матрицы разного размера");
        }

        // Создаем новую матрицу-результат
        IMatrix result = new UsualMatrix(rows, cols);

        // Производим сложение матриц
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, getElement(i, j) + b.getElement(i, j));
            }
        }

        // Возвращаем результат
        return result;
    }

    public IMatrix product (IMatrix b) {
        // Проверяем, если количество строк матрицы не равно количеству столбцов b
        if(this.getRows() != b.getCols()) {
            throw new MatrixException("Невозможно произвести умножение: количество строк матрицы A не равно количеству столбцов матрицы B");
        }

        // Создаем новую матрицу-результат
        IMatrix result = new UsualMatrix(this.getRows(), b.getCols());

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
        matrix[row][collumn] = value;
    }

    public int getElement (int row, int collumn) {
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
                str += matrix[i][j] + " ";
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

        IMatrix b = (IMatrix) obj;
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

    protected void createMatrix() {
        this.matrix = new int[rows][cols];
    }

    // Приватные поля
    protected final int     rows;
    protected final int     cols;
    protected int[][] matrix;

}
