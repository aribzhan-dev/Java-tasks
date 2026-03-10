public class Main {
    public static void main(String[] args) {

        System.out.println("=============================");
        System.out.println("   ТЕСТ HASHMAP");
        System.out.println("=============================");

        SimpleHashMap map = new SimpleHashMap();

        map.put("Anna", 20);
        map.put("Ivan", 25);
        map.put("John", 30);

        System.out.println("\n--- printMap() после put() ---");
        map.printMap();

        System.out.println("\n--- Тест get() ---");
        System.out.println("Anna → " + map.get("Anna"));
        System.out.println("Ivan → " + map.get("Ivan"));
        System.out.println("John → " + map.get("John"));
        System.out.println("Zara → " + map.get("Zara"));

        System.out.println("\n--- После remove('Ivan') ---");
        map.remove("Ivan");
        map.printMap();

        System.out.println("Ivan → " + map.get("Ivan"));

        System.out.println("\n--- put('Anna', 99) - обновление значения ---");
        map.put("Anna", 99);
        System.out.println("Anna → " + map.get("Anna"));



        System.out.println("\n=============================");
        System.out.println("   ТЕСТ TREEMAP");
        System.out.println("=============================");

        SimpleTreeMap tree = new SimpleTreeMap();


        tree.put("Mango", 1);
        tree.put("Apple", 2);
        tree.put("Banana", 3);
        tree.put("Orange", 4);

        System.out.println("\n--- printTree() - обход inorder (по алфавиту) ---");
        tree.printTree();

        System.out.println("\n--- Тест get() ---");
        System.out.println("Mango → " + tree.get("Mango"));
        System.out.println("Apple → " + tree.get("Apple"));
        System.out.println("Banana → " + tree.get("Banana"));
        System.out.println("Grape → " + tree.get("Grape"));

        System.out.println("\n--- put('Apple', 100) - обновление значения ---");
        tree.put("Apple", 100);
        System.out.println("Apple → " + tree.get("Apple"));
    }
}