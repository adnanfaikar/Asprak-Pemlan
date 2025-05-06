class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Tambah node di akhir list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Sisipkan node pada posisi tertentu (0-based index)
    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Posisi di luar jangkauan.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Hapus node berdasarkan nilai data (hanya yang pertama ditemukan)
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        current.next = current.next.next;
    }

    // Cari data di dalam list, return true jika ditemukan
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    // Cetak semua node dalam list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Linked_ListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.printList(); // 10 -> 20 -> 30 -> null

        list.insert(15, 1);
        list.printList(); // 10 -> 15 -> 20 -> 30 -> null

        list.delete(20);
        list.printList(); // 10 -> 15 -> 30 -> null

        System.out.println("Apakah 15 ada di list? " + list.search(15)); // true
        System.out.println("Apakah 20 ada di list? " + list.search(20)); // false
    }
}
