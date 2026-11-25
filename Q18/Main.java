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
        int k = sc.nextInt();

        if (head != null && head.next != null && k > 0) {
            int len = 1;
            Node last = head;
            while (last.next != null) {
                last = last.next;
                len++;
            }

            k = k % len;
            if (k != 0) {
                last.next = head;
                Node newTail = head;
                for (int i = 1; i < len - k; i++) {
                    newTail = newTail.next;
                }
                head = newTail.next;
                newTail.next = null;
            }
        }

        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(curr.data);
            curr = curr.next;
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
