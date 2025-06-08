package algorithm.search;

public interface SortedSet {
    Integer first();

    Integer last();

    Integer index(int key);

    Integer at(int index);

    void insert(int k);

    boolean contains(int k);
}
