public class SimpleHashMap {
    Node[] table;
    int size = 16;

    SimpleHashMap() {
        table = new Node[size];
    }

    int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }


    void put(String key, int value) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }


    int get(String key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }


    void remove(String key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }


    void printMap() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("bucket " + i + ": ");
            Node current = table[i];

            while (current != null) {
                System.out.print(current.key + "=" + current.value);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}