public class PriorityQueue {
    public class EmptyException extends RuntimeException {}

    private int[] items = new int[10];
    int size = 0;

    static int leftChild (int index)  { return 2*index + 1; }
    static int rightChild (int index) { return 2*index + 2; }
    static int parent (int index)     { return (index-1)/2; }

     void swap (int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public void insert (int p) {
        if (size == items.length) {
            int[] newItems = new int[size*2];
            System.arraycopy (items, 0, newItems, 0, size);
            items = newItems;
        }

        int cur = size;

        items[size++] = p;
        while (cur > 0 && items[cur] < items[parent(cur)]) {
            swap (cur, parent(cur));
            cur = parent(cur);
        }
    }

    public int next () throws EmptyException {
        if (isEmpty())
            throw new EmptyException ();

        int next = items[0];
        size--;

        items[0] = items[size];
        int cur = 0;
        while (true) {
            if (smallestInFamily (cur) == rightChild (cur)) {
                swap (cur, rightChild (cur));
                cur = rightChild (cur);
            } else if (smallestInFamily (cur) == leftChild (cur)) {
                swap (cur, leftChild (cur));
                cur = leftChild (cur);
            } else
                break;
        }
        return next;
    }

    private int smallestInFamily (int index) {
        int lc = leftChild (index);
        int rc = rightChild (index);

        if (rc < size && items[rc] < items[index]
                && items[rc] < items[lc])
            return rc;
        if (lc < size && items[lc] < items[index])
            return lc;
        else
            return index;
    }

    public int size () { return size; }
    public boolean isEmpty () { return size == 0; }
}


