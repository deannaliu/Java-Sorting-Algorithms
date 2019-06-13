import java.util.*;

/**
 * @author Deanna Liu
 */
public interface Sorter<E extends Comparable<E>> {
    void sort(List<E> eList, Order order);
}