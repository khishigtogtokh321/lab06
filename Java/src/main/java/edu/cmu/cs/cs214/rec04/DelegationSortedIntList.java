package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList innerList = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        totalAdded++;
        return innerList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return innerList.addAll(list);
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    public int get(int index) {
        return innerList.get(index);
    }

    public boolean remove(int num) {
        return innerList.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return innerList.removeAll(list);
    }

    public int size() {
        return innerList.size();
    }
}
