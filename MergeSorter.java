import java.util.ArrayList;
import java.util.List;

/**
 * @author Deanna Liu
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(List<T> list, Order order) {
        if (list.size() < 1)
            return;
        if (list.size() > 1) {
            List left = new ArrayList<>();
            List right = new ArrayList<>();
            int middle = list.size() / 2;
            for (int i = 0; i < middle; i++)
                left.add(list.get(i));
            for (int i = middle; i < list.size(); i++)
                right.add(list.get(i));
            sort(left, order);
            sort(right, order);
            mergeSort(left, right, list, order);
        }
    }

    private void mergeSort(List<T> left, List<T> right, List<T> list, Order order) {
        List<T> result = new ArrayList<>();
            while (!left.isEmpty() && !right.isEmpty() && order.equals(Order.ASCENDING)) {
                if (left.get(0).compareTo(right.get(0)) <= 0) {
                    result.add(left.get(0));
                    left.remove(0);
                } else {
                    result.add(right.get(0));
                    right.remove(0);
                }
            }
        while (!left.isEmpty() && !right.isEmpty() && order.equals(Order.DESCENDING)) {
            if (left.get(0).compareTo(right.get(0)) >= 0) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        while(!left.isEmpty()) {
            result.add(left.get(0));
            left.remove(0);
        }
        while(!right.isEmpty()) {
            result.add(right.get(0));
            right.remove(0);
        }
        for(int i = 0; i < result.size(); i++)
            list.set(i, result.get(i));
    }
}
