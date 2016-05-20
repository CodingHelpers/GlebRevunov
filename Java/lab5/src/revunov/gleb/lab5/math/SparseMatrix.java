package revunov.gleb.lab5.math;

import java.util.LinkedList;

public class SparseMatrix extends UsualMatrix {
    public SparseMatrix(int r, int c) {
        super(r, c);
    }

    public void setElement(int row, int collumn, int value) {
        // Ищем в списках полный  индекс
        for(Row r : sparce) {
            if(r.i == row) {
                for(Col c : r.cols) {
                    if(c.j == collumn) {
                        c.value = value;
                        return;
                    }
                }
                // Если в строке не нашлось колонки с нужным индексом, добавляем
                r.cols.add(new Col(collumn, value));
                return;
            }
        }
        // Если нет строки с нужным индексом, добавляем
        sparce.add(new Row(row));
        sparce.getLast().cols.add(new Col(collumn, value));
    }

    public int getElement(int row, int column) {
        // Ищем в связных списках нужный нам элемент
        for(Row r : sparce) {
            if(r.i == row) {
                for(Col c : r.cols) {
                    if(c.j == column) {
                        return c.value;
                    }
                }
            }
        }

        // Если в матрице нет запрашиваемого элемента, отдаем ноль
        return 0;
    }

    protected void createMatrix() {
        sparce = new LinkedList<Row>();
    }

    private class Row {
        Row(int i) {
            this.i = i;
            this.cols = new LinkedList<Col>();
        }
        public int i;
        public LinkedList<Col> cols;
    }

    private class Col {
        Col(int j, int v) {
            this.j = j;
            this.value = v;
        }
        public int j;
        public int value;
    }

    private LinkedList<Row> sparce;
}
