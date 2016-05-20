package revunov.gleb.lab5.math;

interface IMatrix {
    IMatrix sum (IMatrix b);
    IMatrix product (IMatrix b);
    void setElement(int row, int collumn, int value);
    int getElement(int row, int collumn);
    int getRows();
    int getCols();
    String toString();
    boolean equals(Object obj);
}