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
        int p = sc.nextInt();

        if (head != null) {
            if (p == 1) {
                head = head.next;
            } else {
                Node curr = head;
                for (int i = 1; i < p - 1 && curr.next != null; i++) {
                    curr = curr.next;
                }
                if (curr.next != null) {
                    curr.next = curr.next.next;
                }
            }
        }

        if (head == null) {
            System.out.println("Empty");
        } else {
            StringBuilder sb = new StringBuilder();
            Node curr = head;
            while (curr != null) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(curr.data);
                curr = curr.next;
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
