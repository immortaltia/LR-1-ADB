public class Deque {
    private static class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public Deque() {
        front = null;
        rear = null;
    }

    public void pushFront(String value) {
        Node node = new Node(value);
        if (isEmpty()) {
            front = rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
    }

    public void pushBack(String value) {
        Node node = new Node(value);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
    }

    public String popFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        String val = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        return val;
    }

    public String popBack() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        String val = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        return val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        Node cur = front;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
