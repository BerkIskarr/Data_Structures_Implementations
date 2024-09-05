import java.util.*;



    public class PriorityQueueSorter {
        /*
         *  A couple of symbolic constants so we don't have to remember
         *  what the second parameter of sort() does.
         */
        public static final boolean ASCENDING_ORDER  = true;
        public static final boolean DESCENDING_ORDER = false;

        public static void sort(int[] ints, boolean ascending) {
            PriorityQueue pq = new PriorityQueue();
            for (int num : ints) {
                pq.insert(num);
            }

            if (ascending) {
                for (int i = 0; i < ints.length; i++) {
                    ints[i] = pq.next();
                }
            } else {
                for (int i = ints.length - 1; i >= 0; i--) {
                    ints[i] = pq.next();
                }
            }

        }}
