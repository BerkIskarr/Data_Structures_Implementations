import java.util.*;
public class DoublyLinkedList {

    public DoublyLinkedList sort() {
        DoublyLinkedList output = new DoublyLinkedList();

        Item cur = head;

        while (cur != null) {

            if (output.isEmpty() || cur.value.compareTo(output.head.value) <= 0) {
                output.addToHead(cur.value);
            }
            else if (cur.value.compareTo(output.tail.value) >= 0) {
                output.addToTail(cur.value);
            }
            else {
                Item current = output.head;

                while (current != null && cur.value.compareTo(current.value) > 0) {
                    current = current.next;
                }

                Item newitem = new Item(cur.value, current.prev, current);

                if (current != null) {
                    current.prev.next = newitem;
                    current.prev = newitem;
                } else {
                    output.tail = newitem;
                }
            }

            cur = cur.next;
        }

        return output;
    }


    /*
     *  Everything below here is the linked list class.
     */
    private class Item {
        String value;
        Item next;
        Item prev;

        Item (String value, Item prev, Item next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Item head = null;
    private Item tail = null;
    private int length = 0;

    public String get (int index) {
        if (index < 0 || index >= length)
            return null;
        else
            return getItem(index).value;
    }

    public void insert (int index, String value) {
        if (index <= 0)
            addToHead (value);
        else if (index >= length)
            addToTail (value);
        else {
            Item cur = getItem(index-1);
            Item e = new Item(value, cur, cur.next);
            e.prev.next = e;
            e.next.prev = e;

            length++;
        }
    }

    public void addToHead (String value) {
        Item e = new Item(value, null, head);
        head = e;
        if (e.next == null)
            tail = e;
        else
            e.next.prev = e;

        length++;
    }

    public void addToTail (String value) {
        Item e = new Item(value, tail, null);
        tail = e;
        if (e.prev == null)
            head = e;
        else
            e.prev.next = e;

        length++;
    }

    public void delete (int index) {
        if (index < 0 || index >= length)
            return;

        if (length == 1)
            head = tail = null;
        else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == length-1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Item e = getItem(index);
            e.prev.next = e.next;
            e.next.prev = e.prev;
        }
        length--;
    }

    private Item getItem (int index) {
        Item cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur;
    }

    private Item cur = null;

    public void rewind () { cur = null; }

    public String getNext () {
        if (cur == null) cur = head;
        else cur = cur.next;
        return cur == null ? null : cur.value;
    }

    public boolean hasNext () {
        if (cur == null) return head != null;
        else return cur.next != null;
    }

    public boolean isEmpty () { return head == null; }
    public int length ()      { return length; }

    public String toString() {
        String s = "";
        Item cur = head;
        while (cur != null) {
            s += cur.value;
            cur = cur.next;
            if (cur != null)
                s += ", ";
        }
        return s;
    }
}
