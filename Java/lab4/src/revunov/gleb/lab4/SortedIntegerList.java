package revunov.gleb.lab4;

import java.util.LinkedList;

public class SortedIntegerList {
    SortedIntegerList(boolean duplicates) {
        allowDuplicates = duplicates;

        // Создаем список
        list = new LinkedList<Integer>();
    }

    public void add(Integer num) {
        // Флажок, чтобы установить, если после прохода по списку, число не было вставлено
        boolean inserted = false;

        // Проходим по списку и ищем, куда нужно вставить число
        for(int i = 0; i < list.size(); i++) {
            // Если найден дупликат и они не разрешены, ставим флажок и выходим из цикла
            if(list.get(i).equals(num) && !allowDuplicates) {
                inserted = true;
                break;
            }

            // Если найдено число большее, чем то, которое надо вставить, занимаем его позицию
            // Число передвинется вперед
            if(list.get(i) >= num) {
                list.add(i, num);
                inserted = true;
                break;
            }
        }

        // Если после прохода по списку, не было найдено место, куда можно вставить число,
        // ставим его в конец
        if(!inserted) {
            list.add(num);
        }
    }

    public void remove(Integer num) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(num)) {
                list.remove(i);
                i--;
            }
        }
    }

    public boolean equals(SortedIntegerList lst) {
        if(size() != lst.size()) {
            return false;
        }

        for(int i = 0; i < size(); i++) {
            if(!get(i).equals(lst.get(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean find(int num) {
        int l = -1;
        int r = list.size();
        while(l < r - 1) {
            int m = (l + r) / 2;
            if(list.get(m) < num) {
                l = m;
            } else {
                r = m;
            }
        }

        if(r < list.size() && list.get(r) == num) return true;
        return false;
    }

    public Integer get(int i) {
        return list.get(i);
    }

    public String toString() {
        return list.toString();
    }

    public int size() {
        return list.size();
    }


    private LinkedList<Integer> list;
    private boolean allowDuplicates;
}
