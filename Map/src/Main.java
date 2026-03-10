public class Main {
    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("   HASHMAP TESTI");
        System.out.println("=============================");

        SimpleHashMap map = new SimpleHashMap();

        map.put("Anna", 20);
        map.put("Ivan", 25);
        map.put("John", 30);

        System.out.println("\n--- put() dan keyin printMap() ---");
        map.printMap();

        System.out.println("\n--- get() testi ---");
        System.out.println("Anna → " + map.get("Anna"));   // 20
        System.out.println("Ivan → " + map.get("Ivan"));   // 25
        System.out.println("John → " + map.get("John"));   // 30
        System.out.println("Zara → " + map.get("Zara"));   // -1 (yo'q)

        System.out.println("\n--- remove('Ivan') dan keyin ---");
        map.remove("Ivan");
        map.printMap();

        System.out.println("Ivan → " + map.get("Ivan")); // -1 (o'chirildi)

        System.out.println("\n--- put('Anna', 99) - qiymat yangilash ---");
        map.put("Anna", 99);
        System.out.println("Anna → " + map.get("Anna")); // 99


        System.out.println("\n=============================");
        System.out.println("   TREEMAP TESTI");
        System.out.println("=============================");

        SimpleTreeMap tree = new SimpleTreeMap();

        tree.put("Mango", 1);
        tree.put("Apple", 2);
        tree.put("Banana", 3);
        tree.put("Orange", 4);

        System.out.println("\n--- printTree() - inorder (alfavit) ---");
        tree.printTree();


        System.out.println("\n--- get() testi ---");
        System.out.println("Mango → " + tree.get("Mango"));
        System.out.println("Apple → " + tree.get("Apple"));
        System.out.println("Banana → " + tree.get("Banana"));
        System.out.println("Orange → " + tree.get("Orange"));
        System.out.println("Grape → " + tree.get("Grape"));

        System.out.println("\n--- put('Apple', 100) - qiymat yangilash ---");
        tree.put("Apple", 100);
        System.out.println("Apple → " + tree.get("Apple"));
    }
}