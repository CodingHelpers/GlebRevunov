package revunov.gleb.lab8.math;

import java.util.ArrayList;
import java.util.List;

public class ParallelMatrixProduct {
    // Объявляем исходные матрицы как final чтобы убедиться, что туда не будет ничего записано
    public UsualMatrix parallelMatrixProduct(final UsualMatrix a, final UsualMatrix b) {
        // Проверяем, если количество строк матрицы не равно количеству столбцов b
        if(a.getRows() != b.getCols()) {
            throw new MatrixException("Невозможно произвести умножение: количество строк матрицы A не равно количеству столбцов матрицы B");
        }

        // Создаем новую матрицу-результат
        UsualMatrix result = new UsualMatrix(a.getRows(), b.getCols());

        // Выбираем количество потоков для перемножения
        int numThreads = 4;

        // Список потоков
        List<ProductThread> threads = new ArrayList<>(numThreads);

        // Каждый поток будет работать со своими строками в результирующей матрице, синхронизация доступа не требуется
        int step = a.getRows() / numThreads;
        for(int i = 0; i < a.getRows(); i += step) {
            int from_row = i;
            int to_row = i + step;
            if(to_row >= a.getRows()) {
                to_row = a.getRows();
            }

            // Создаем поток
            threads.add(new ProductThread(from_row, to_row, a, b, result));
        }

        // Запускаем потоки
        threads.forEach(Thread::start);

        // Ждем завершения
        try {
            for(Thread thr: threads) {
                thr.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return result;
    }

    // Класс рабочего потока для нескольких строк матрицы
    private class ProductThread extends Thread {
        int from_row, to_row;
        UsualMatrix a, b, result;

        ProductThread(int from_row, int to_row, UsualMatrix a, UsualMatrix b, UsualMatrix result) {
            this.from_row = from_row;
            this.to_row = to_row;
            this.result = result;
            this.a = a;
            this.b = b;
        }

        // Запуск потока
        public void run() {
            // Перемножение части матрицы
            for(int row = from_row; row < to_row; row++) {
                for (int col = 0; col < b.getCols(); col++) {
                    int temp = 0;
                    for (int inner = 0; inner < b.getRows(); inner++) {
                        temp += a.getElement(row, inner) * b.getElement(inner, col);
                    }
                    result.setElement(row, col, temp);
                }
            }
        }
    }

}

