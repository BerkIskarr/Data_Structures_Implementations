// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int idx = 0;
        String[] strings = {"golf", "alfa", "bravo", "hotel", "india", "foxtrot", "juliett", "echo", "charlie", "delta"};
        DoublyLinkedList list = new DoublyLinkedList();
        for (String s: strings)
            list.addToTail (s);
        System.out.println (list.sort());
    }
}