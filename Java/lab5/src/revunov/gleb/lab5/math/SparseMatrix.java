package revunov.gleb.lab5.math;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SparseMatrix extends UsualMatrix {
    public SparseMatrix(int r, int c) {
        super(r, c);
        rowComparator = new Comparator<Row>() {
            @Override
            public int compare(Row row, Row t1) {
                return Integer.compare(row.i, t1.i);
            }
        };

        colComparator = new Comparator<Col>() {
            @Override
            public int compare(Col col, Col t1) {
                return Integer.compare(col.j, t1.j);
            }
        };

        sorted = false;
    }

    public void setElement(int row, int column, int value) {
        // Ищем в списках полный  индекс
        Row r = lookupRow(row);
        if(r == null) {
            sparce.add(new Row(row));
            sparce.getLast().cols.add(new Col(column, value));
            Collections.sort(sparce.getLast().cols, colComparator);
            Collections.sort(sparce, rowComparator);
            return;

        }

        Col c = lookupCol(r, column);
        if(c == null) {
            // Если в строке не нашлось колонки с нужным индексом, добавляем
            r.cols.add(new Col(column, value));
            Collections.sort(r.cols, colComparator);
            return;
        }

        c.value = value;

    }

    public int getElement(int row, int column) {
        // Ищем в связных списках нужный нам элемент
        Row r = lookupRow(row);
        if(r == null) {
            return 0;
        }

        Col c = lookupCol(r, column);
        if(c == null) {
            return 0;
        }

        return c.value;
    }

    // Метод поиска строк двоичным поиском
    private Row lookupRow(int i) {
        int l = -1;
        int r = sparce.size();
        while(l < r - 1) {
            int m = (l + r) / 2;
            if(sparce.get(m).i < i) {
                l = m;
            } else {
                r = m;
            }
        }

        if(r < sparce.size() && sparce.get(r).i == i) {
            return sparce.get(r);
        }
        return null;
    }

    // Метод поиска столбцов двоичным поиском
    private Col lookupCol(Row row, int j) {
        int l = -1;
        int r = row.cols.size();
        while(l < r - 1) {
            int m = (l + r) / 2;
            if(row.cols.get(m).j < j) {
                l = m;
            } else {
                r = m;
            }
        }

        if(r < row.cols.size() && row.cols.get(r).j == j) {
            return row.cols.get(r);
        }
        return null;
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
    private Comparator<Row> rowComparator;
    private Comparator<Col> colComparator;
    private boolean         sorted;
}
