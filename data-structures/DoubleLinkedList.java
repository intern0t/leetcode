import java.util.Stack;

public class DoubleLinkedList {

    static class Node {

        int value;
        Node next;
        Node previous;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    Node head, tail;

    public boolean add(int value) {
        if (head == null) {
            head = new Node(value);
            return true;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        if (current.next == null) {
            current.next = new Node(value, null, current);
            tail = current.next;
            return true;
        }

        return false;
    }

    public boolean remove(int value) {
        if (head == null) {
            return true;
        }

        if (head != null && head.value == value) {
            head = head.next;
        } else {
            Node current = head;
            while (current != null && current.value != value) {
                current = current.next;
            }
            // We have the node at current.
            current.previous.next = current.next;
            if (current.next != null) {
                current.next.previous = current.previous;
            }
            return true;
        }
        return false;
    }

    public void reverse() {
        if (tail == null) {
            System.out.println("Empty list.");
        }

        Node current = tail;
        while (current != null) {
            System.out.print(
                current.value + (current.previous != null ? " <-> " : "")
            );
            current = current.previous;
        }
        System.out.println();
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(
                current.value + (current.next == null ? "" : " <-> ")
            );
            current = current.next;
        }

        System.out.println();
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(
                current.value + (current.next == null ? "" : " <-> ")
            );
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList myList = new DoubleLinkedList();
        for (int i = 1; i < 10; i++) {
            myList.add(i);
        }

        myList.printList();
        System.out.println(
            "Head -> next -> next -> previous = " +
            myList.head.next.next.previous.value
        );

        myList.remove(5);
        myList.remove(1);
        myList.remove(9);
        myList.printList();
        myList.reverse();
    }
}
