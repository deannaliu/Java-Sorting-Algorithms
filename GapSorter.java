import java.util.List;

/**
 * @author Deanna Liu
 */
public class GapSorter<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(List<T> list, Order order) {
        if(list.size() < 1)
            return;
        int gap = list.size() / 2;
        while (gap >= 1) {
            //System.out.print(list.toString() + " ");
            for (int i = gap; i < list.size(); i++) {
                int j = i;
                T k = list.get(i);
                if (order.equals(Order.ASCENDING)) {
                    while (j >= gap && list.get(j - gap).compareTo(k) > 0) {
                        list.set(j, list.get(j - gap));
                        j -= gap;
                    }
                } else {
                    if (order.equals(Order.DESCENDING)) {
                        while (j >= gap && list.get(j - gap).compareTo(k) <= 0) {
                           // System.out.println(list.get(i).compareTo(list.get(j - gap)));
                            list.set(j, list.get(j - gap));
                            j -= gap;
                        }
                    }
                }
                list.set(j, k);
            }
            gap = (gap / 2);
            //System.out.print("(gap: " + gap + ") ");
        }
    }
}
