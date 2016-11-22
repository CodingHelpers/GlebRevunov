package revunov.gleb.lab8.math;

public class SquareMatrix extends UsualMatrix {
    public SquareMatrix(int size) {
        super(size, size);
        this.size = size;

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public IMatrix sum (IMatrix b) {
        // Проверяем, если матрицы разного размера, кидаем исключение
        if(this.size != b.getRows() || this.size != b.getCols()) {
            throw new MatrixException("Невозможно сложить матрицы разного размера");
        }

        // Создаем новую матрицу-результат
        IMatrix result = new SquareMatrix(size);

        // Производим сложение матриц
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.setElement(i, j, getElement(i, j) + b.getElement(i, j));
            }
        }

        // Возвращаем результат
        return result;
    }

    // Переопределение equals не требуется, базовый equals отработает и для квадратной матрицы.

    private final int size;
}
