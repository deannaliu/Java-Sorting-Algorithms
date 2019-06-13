import java.util.List;
/**
 * @author Deanna Liu
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T>{
    @Override
    public void sort(List<T> list, Order order) {
        if(list.size() < 2)
            return;
        if(order.equals(Order.ASCENDING)) {
            int index = 1;
            while (index < list.size())
            {
                insertSortingUp(list.get(index), list, index);
                index++;
            }
        }
        else {
            if(order.equals(Order.DESCENDING)) {
                int index = 1;
                while(index < list.size()){
                    insertSortingDown(list.get(index), list, index);
                    index++;
                }
            }
        }
    }

    public void insertSortingUp(T t1, List<T> list, int i){
        int temp = i - 1;
        while ((temp >= 0) && (t1.compareTo(list.get(temp)) <= 0)){
            list.set(temp + 1, list.get(temp));
            temp--;
        }
        list.set(temp + 1, t1);
    }

    public void insertSortingDown(T t1, List<T> list, int i) {
        int temp = i-1;
        while((temp >= 0) && (t1.compareTo(list.get(temp)) >= 0)){
            list.set(temp + 1, list.get(temp));
            temp--;
        }
        list.set(temp + 1, t1);
    }
}
