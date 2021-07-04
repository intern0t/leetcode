import java.util.HashMap;

public class LinkedList {

    public static class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head = null;

    public LinkedList() {}

    public Node lastNode() {
        if (head == null) {
            return head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }
    }

    public boolean add(int value) {
        Node lastNode = lastNode();

        if (lastNode != null) {
            lastNode.next = new Node(value, null);
            return true;
        } else {
            // last node is null.
            head = new Node(value, null);
            return true;
        }
    }

    public boolean remove(int value) {
        if (head == null) {
            return true;
        }

        if (head.value == value && head.next == null) {
            head = null;
            return true;
        } else if (head.value == value && head.next != null) {
            head = head.next;
            return true;
        } else {
            Node current = head;
            while (current != null) {
                if (current.next != null && current.next.value == value) {
                    break;
                }
                current = current.next;
            }

            current.next = current.next.next;
            return true;
        }
    }

    public void reverse() {
        // [0] -> 1 -> 2 -> 4
        // Keep track of previous, current and current's next.

        Node previous, current, next;
        previous = null;
        current = next = head;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        printList(previous);
    }

    public boolean hasCycle() {
        HashMap<Node, Integer> map = new HashMap<>();
        Node current = head;

        while (current != null) {
            if (map.containsKey(current)) {
                return true;
            } else {
                map.put(current, 1);
            }
            current = current.next;
        }
        return false;
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(
                current.value + (current.next == null ? "" : " -> ")
            );
            current = current.next;
        }
        System.out.println();
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(
                current.value + (current.next == null ? "" : " -> ")
            );
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        myList.printList();
        // myList.remove(0);
        // myList.remove(5);
        // myList.remove(9);
        // myList.printList();
        myList.reverse();

        // Cycle test.
        myList.head.next = new Node(5, myList.head);
        System.out.println("Cycle exists? : " + myList.hasCycle());
    }
}
