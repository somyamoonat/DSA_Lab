import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        int x = sc.nextInt();

        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy;
        while (curr.next != null) {
            if (curr.next.data == x) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        head = dummy.next;

        if (head == null) {
            System.out.println("Empty");
        } else {
            StringBuilder sb = new StringBuilder();
            Node p = head;
            while (p != null) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(p.data);
                p = p.next;
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
