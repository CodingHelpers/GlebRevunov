package revunov.gleb.lab5.math;

public interface IMatrix {
    IMatrix sum (IMatrix b);
    IMatrix diff(IMatrix b);
    IMatrix product (IMatrix b);
    int elements_sum();
    void setElement(int row, int collumn, int value);
    int getElement(int row, int collumn);
    int getRows();
    int getCols();
    String toString();
    boolean equals(Object obj);
}