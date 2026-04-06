import java.util.*;
import java.time.LocalDate;

//   PART 1
// TASK 1

class ApiResponse<T> {
    private final T data;
    private final String message;
    private final int statusCode;
    private final boolean success;

    private ApiResponse(T data, String message, int statusCode, boolean success) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
        this.success = success;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, "OK", 200, true);
    }

    public static <T> ApiResponse<T> error(String message, int statusCode) {
        return new ApiResponse<>(null, message, statusCode, false);
    }

    public T getData()         { return data; }
    public String getMessage() { return message; }
    public int getStatusCode() { return statusCode; }
    public boolean isSuccess() { return success; }

    @Override
    public String toString() {
        return "ApiResponse{success=" + success
                + ", statusCode=" + statusCode
                + ", message='" + message + "'"
                + ", data=" + (data != null ? data.toString() : "null")
                + "}";
    }
}

class User {
    private final String name;
    private final int age;
    public User(String name, int age) { this.name = name; this.age = age; }
    @Override public String toString() { return "User{name='" + name + "', age=" + age + "}"; }
}

class Order {
    private final int id;
    private String status;
    private double amount;
    public Order(int id, String status, double amount) {
        this.id = id; this.status = status; this.amount = amount;
    }
    public int getId()       { return id; }
    public String getStatus(){ return status; }
    public double getAmount(){ return amount; }
    @Override public String toString() {
        return "Order{id=" + id + ", status='" + status + "', amount=" + amount + "}";
    }
}

// TASK 2

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) { this.key = key; this.value = value; }

    public K getKey()   { return key; }
    public V getValue() { return value; }
    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    // swap() returns a brand-new Pair with types K and V swapped
    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}


// TASK 3 — Storage<T>  (universal entity container)

class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return "Person{'" + name + "'}"; }
}

class Student extends Person {
    private final double gpa;
    public Student(String name, double gpa) { super(name); this.gpa = gpa; }
    public double getGpa() { return gpa; }
    @Override public String toString() { return "Student{'" + getName() + "', gpa=" + gpa + "}"; }
}

class Storage<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item)    { items.add(item); }
    public void remove(T item) { items.remove(item); }
    public T get(int index)    { return items.get(index); }
    public List<T> getAll()    { return Collections.unmodifiableList(items); }
    public boolean isEmpty()   { return items.isEmpty(); }
    public int size()          { return items.size(); }

    public T findFirst() {
        return items.isEmpty() ? null : items.get(0);
    }

    public void addAll(List<? extends T> newItems) {
        items.addAll(newItems);
    }
}

// TASK 4

class MaxUtils {

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Cannot find max of an empty list");
        }
        T result = list.get(0);
        for (T item : list) {
            if (item.compareTo(result) > 0) result = item;
        }
        return result;
    }
}


// TASK 5

interface Condition<T> {
    boolean test(T item);
}

class FilterUtils {
    public static <T> List<T> filter(List<T> list, Condition<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) result.add(item);
        }
        return result;
    }
}


// TASK 6

interface Repository<T, ID> {
    void save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}

class UserRepository implements Repository<User, Integer> {
    private final Map<Integer, User> store = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(User user) {
        store.put(nextId++, user);
    }

    @Override public Optional<User> findById(Integer id) { return Optional.ofNullable(store.get(id)); }
    @Override public List<User> findAll() { return new ArrayList<>(store.values()); }
    @Override public void deleteById(Integer id) { store.remove(id); }
}

class Product {
    private final String id;
    private final String name;
    public Product(String id, String name) { this.id = id; this.name = name; }
    public String getId()   { return id; }
    public String getName() { return name; }
    @Override public String toString() { return "Product{id='" + id + "', name='" + name + "'}"; }
}

class ProductRepository implements Repository<Product, String> {
    private final Map<String, Product> store = new HashMap<>();

    @Override
    public void save(Product p) {
        store.put(p.getId(), p);
    }

    @Override public Optional<Product> findById(String id) { return Optional.ofNullable(store.get(id)); }
    @Override public List<Product> findAll() { return new ArrayList<>(store.values()); }
    @Override public void deleteById(String id) { store.remove(id); }
}

// TASK 7

interface FileProcessor<T> {
    T parse(String line);
    String format(T obj);
}

class UserFileProcessor implements FileProcessor<User> {
    // expected format: "Alice,30"
    @Override
    public User parse(String line) {
        if (line == null || !line.contains(",")) {
            throw new IllegalArgumentException("Bad format: expected 'name,age', got: " + line);
        }
        String[] parts = line.split(",", 2);
        return new User(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }

    @Override
    public String format(User user) {
        return user.toString();
    }
}

class ProductFileProcessor implements FileProcessor<Product> {
    @Override
    public Product parse(String line) {
        if (line == null || !line.contains(",")) {
            throw new IllegalArgumentException("Bad format: expected 'id,name', got: " + line);
        }
        String[] parts = line.split(",", 2);
        return new Product(parts[0].trim(), parts[1].trim());
    }

    @Override
    public String format(Product p) {
        return p.getId() + "," + p.getName();
    }
}


// TASK 8

class Cache<K, V> {
    private final int maxSize;
    private final LinkedHashMap<K, V> store;

    public Cache(int maxSize) {
        this.maxSize = maxSize;
        this.store = new LinkedHashMap<>();
    }

    public void put(K key, V value) {
        if (store.size() >= maxSize && !store.containsKey(key)) {
            removeOldest();
        }
        store.put(key, value);
    }

    public V get(K key) {
        return store.get(key);
    }

    public boolean containsKey(K key) { return store.containsKey(key); }
    public void remove(K key)         { store.remove(key); }
    public void clear()               { store.clear(); }
    public int size()                 { return store.size(); }

    private void removeOldest() {
        K oldest = store.keySet().iterator().next();
        store.remove(oldest);
    }
}

// TASK 9
interface Mapper<F, T> {
    T map(F from);
}

class UserDto {
    private final String name;
    public UserDto(String name) { this.name = name; }
    @Override public String toString() { return "UserDto{'" + name + "'}"; }
}

class ProductDto {
    private final String name;
    public ProductDto(String name) { this.name = name; }
    @Override public String toString() { return "ProductDto{'" + name + "'}"; }
}

class UserMapper implements Mapper<User, UserDto> {
    @Override
    public UserDto map(User user) {
        return new UserDto(user.toString());
    }
}

class ProductMapper implements Mapper<Product, ProductDto> {
    @Override
    public ProductDto map(Product product) {
        return new ProductDto(product.getName());
    }
}

class MapperUtils {
    public static <F, T> List<T> mapAll(List<F> source, Mapper<F, T> mapper) {
        List<T> result = new ArrayList<>();
        for (F item : source) {
            result.add(mapper.map(item));
        }
        return result;
    }
}


// TASK 10

interface Validator<T> {
    boolean isValid(T obj);
    String getErrorMessage();
}

class EmailValidator implements Validator<String> {
    @Override
    public boolean isValid(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    @Override public String getErrorMessage() { return "Invalid email address"; }
}

class AgeValidator implements Validator<Integer> {
    @Override
    public boolean isValid(Integer age) {
        return age != null && age >= 0 && age <= 120;
    }
    @Override public String getErrorMessage() { return "Age must be between 0 and 120"; }
}

class StudentValidator implements Validator<Student> {
    @Override
    public boolean isValid(Student s) {
        return s != null
                && s.getName() != null
                && !s.getName().isBlank()
                && s.getGpa() >= 0.0
                && s.getGpa() <= 4.0;
    }
    @Override public String getErrorMessage() { return "Student name must not be blank and GPA must be 0.0–4.0"; }
}

class ValidationService<T> {
    private final List<Validator<T>> validators;

    public ValidationService(List<Validator<T>> validators) {
        this.validators = validators;
    }

    public List<String> validate(T obj) {
        List<String> errors = new ArrayList<>();
        for (Validator<T> v : validators) {
            if (!v.isValid(obj)) {
                errors.add(v.getErrorMessage());
            }
        }
        return errors;
    }
}

//   PART 2



// TASK 1

class Task_II_1 {
    public static void run() {
        System.out.println("\n--- Part II Task 1: Safe removal of failing grades ---");
        List<Integer> scores = new ArrayList<>(Arrays.asList(45, 82, 30, 91, 55, 20, 73));

        Iterator<Integer> it = scores.iterator();
        while (it.hasNext()) {
            if (it.next() < 50) it.remove();
        }

        System.out.println("Passing scores: " + scores); // [82, 91, 55, 73]
    }
}

// TASK 2

class Task_II_2 {
    public static void run() {
        System.out.println("\n--- Part II Task 2: Comment list cleanup ---");
        List<String> comments = new ArrayList<>(Arrays.asList(
                "Great post!", null, "  ", "", "Thanks!", null, "Helpful!"
        ));

        Iterator<String> it = comments.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s == null || s.isBlank()) it.remove();
        }

        System.out.println("Valid comments: " + comments);
    }
}


// TASK 3

class Task_II_3 {
    public static void run() {
        System.out.println("\n--- Part II Task 3: Count orders by condition ---");
        List<Order> orders = Arrays.asList(
                new Order(1, "NEW",  5000),
                new Order(2, "DONE", 15000),
                new Order(3, "NEW",  12000),
                new Order(4, "NEW",  800),
                new Order(5, "DONE", 3000)
        );

        int newCount = 0, expensiveCount = 0;
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if ("NEW".equals(o.getStatus()))  newCount++;
            if (o.getAmount() > 10_000)       expensiveCount++;
        }

        System.out.println("NEW orders:            " + newCount);
        System.out.println("Orders over 10 000:    " + expensiveCount);
    }
}


// TASK 4

class Task_II_4 {
    public static void run() {
        System.out.println("\n--- Part II Task 4: Replace negative numbers with 0 ---");
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, -1, 7, -5, 0, -9, 4));

        ListIterator<Integer> it = nums.listIterator();
        while (it.hasNext()) {
            if (it.next() < 0) it.set(0);
        }

        System.out.println("After replacement: " + nums);
    }
}


// TASK 5

class Task_II_5 {
    public static void run() {
        System.out.println("\n--- Part II Task 5: Insert NEEDS_ATTENTION after ERROR ---");
        List<String> logs = new ArrayList<>(Arrays.asList(
                "INFO  server started",
                "ERROR null pointer at line 42",
                "INFO  request received",
                "ERROR timeout on DB connection",
                "ERROR disk full"
        ));

        ListIterator<String> it = logs.listIterator();
        while (it.hasNext()) {
            if (it.next().contains("ERROR")) {
                it.add("NEEDS_ATTENTION"); // inserted right after the ERROR line
            }
        }

        logs.forEach(System.out::println);
    }
}


// TASK 6

class Task_II_6 {
    public static void run() {
        System.out.println("\n--- Part II Task 6: Bidirectional traversal ---");
        List<String> tasks = new ArrayList<>(Arrays.asList(
                "Buy groceries", "Call dentist", "Fix bug #17", "Write tests"
        ));

        ListIterator<String> it = tasks.listIterator();

        System.out.println("Forward:");
        while (it.hasNext()) {
            System.out.println("  index " + it.nextIndex() + " → " + it.next());
        }

        System.out.println("Backward:");
        while (it.hasPrevious()) {
            System.out.println("  index " + it.previousIndex() + " ← " + it.previous());
        }
    }
}


// TASK 7

class Task_II_7 {
    public static void run() {
        System.out.println("\n--- Part II Task 7: Remove adjacent duplicates ---");
        List<String> list = new ArrayList<>(Arrays.asList("A", "A", "B", "B", "B", "C", "A"));

        Iterator<String> it = list.iterator();
        String prev = null;
        while (it.hasNext()) {
            String curr = it.next();
            if (curr.equals(prev)) {
                it.remove();
            } else {
                prev = curr;
            }
        }

        System.out.println("Result: " + list);
    }
}


// TASK 8

class Task_II_8 {
    public static void run() {
        System.out.println("\n--- Part II Task 8: Insert 'Core' after every 'Java' ---");
        List<String> words = new ArrayList<>(Arrays.asList(
                "I", "love", "Java", "and", "Java", "is", "great"
        ));

        ListIterator<String> it = words.listIterator();
        while (it.hasNext()) {
            if ("Java".equals(it.next())) {
                it.add("Core");
            }
        }

        System.out.println(words);
    }
}

// TASK 9
class Task_II_9 {
    public static void run() {
        System.out.println("\n--- Part II Task 9: Remove blacklisted users ---");
        List<String> users = new ArrayList<>(Arrays.asList(
                "alice", "spam_bot", "bob", "troll99", "carol", "hacker123"
        ));

        Set<String> blacklist = new HashSet<>(Arrays.asList("spam_bot", "troll99", "hacker123"));

        Iterator<String> it = users.iterator();
        while (it.hasNext()) {
            if (blacklist.contains(it.next())) it.remove();
        }

        System.out.println("Active users: " + users); // [alice, bob, carol]
    }
}

// TASK 10

class BrowserHistory {
    private final List<String> history = new ArrayList<>();
    private ListIterator<String> cursor;
    private String currentPage;

    public BrowserHistory(String startUrl) {
        history.add(startUrl);
        cursor = history.listIterator(1); // cursor sits after the first element
        currentPage = startUrl;
    }

    public void goBack() {
        if (cursor.hasPrevious()) {
            currentPage = cursor.previous();
            System.out.println("Back → " + currentPage);
        } else {
            System.out.println("Already at the beginning");
        }
    }

    public void goForward() {
        if (cursor.hasNext()) {
            currentPage = cursor.next();
            System.out.println("Forward → " + currentPage);
        } else {
            System.out.println("Already at the latest page");
        }
    }

    public void openPage(String url) {
        while (cursor.hasNext()) {
            cursor.next();
            cursor.remove();
        }
        cursor.add(url);
        currentPage = url;
        System.out.println("Opened → " + currentPage);
    }

    public void printHistory() {
        System.out.println("History: " + history + "  [current: " + currentPage + "]");
    }
}

class Task_II_10 {
    public static void run() {
        System.out.println("\n--- Part II Task 10: Browser history ---");
        BrowserHistory browser = new BrowserHistory("google.com");
        browser.openPage("github.com");
        browser.openPage("stackoverflow.com");
        browser.printHistory();

        browser.goBack();
        browser.goBack();
        browser.openPage("youtube.com");

        browser.printHistory();
        browser.goForward();
        browser.goBack();
    }
}

//   MAIN

public class Main {
    public static void main(String[] args) {

        // ── PART I ────────────────────────────────────────────
        System.out.println("========== PART I: GENERICS ==========");

        // Task 1 — ApiResponse<T>
        System.out.println("\n--- Task 1: ApiResponse<T> ---");
        ApiResponse<User>         userResp  = ApiResponse.success(new User("Alice", 25));
        ApiResponse<Order>        orderResp = ApiResponse.success(new Order(7, "NEW", 4500));
        ApiResponse<List<String>> listResp  = ApiResponse.success(Arrays.asList("apple", "banana"));
        ApiResponse<User>         errResp   = ApiResponse.error("User not found", 404);
        System.out.println(userResp);
        System.out.println(orderResp);
        System.out.println(listResp);
        System.out.println(errResp);

        // Task 2 — Pair<K, V>
        System.out.println("\n--- Task 2: Pair<K, V> ---");
        Pair<Integer, String> p1 = new Pair<>(1, "admin");
        System.out.println("Original: " + p1);
        System.out.println("Swapped:  " + p1.swap());

        Pair<String, Double> p2 = new Pair<>("price", 99.99);
        System.out.println("Original: " + p2 + "  Swapped: " + p2.swap());

        Pair<LocalDate, String> p3 = new Pair<>(LocalDate.of(2024, 1, 15), "deadline");
        System.out.println("Original: " + p3 + "  Swapped: " + p3.swap());

        // Task 3 — Storage<T>
        System.out.println("\n--- Task 3: Storage<T> ---");
        Storage<Person> storage = new Storage<>();
        storage.add(new Person("Bob"));
        storage.add(new Person("Carol"));
        List<Student> students = Arrays.asList(new Student("Dave", 3.8), new Student("Eve", 3.2));
        storage.addAll(students); // works because Student extends Person
        System.out.println("All: " + storage.getAll());
        System.out.println("First: " + storage.findFirst());
        System.out.println("Size: " + storage.size());

        // Task 4 — max()
        System.out.println("\n--- Task 4: max() ---");
        System.out.println("max(3, 7) = "                + MaxUtils.max(3, 7));
        System.out.println("max(\"apple\",\"mango\") = " + MaxUtils.max("apple", "mango"));
        System.out.println("max(list of dates) = "       + MaxUtils.max(
                Arrays.asList(LocalDate.of(2023,1,1), LocalDate.of(2025,6,15), LocalDate.of(2024,3,3))
        ));

        // Task 5 — FilterUtils + Condition<T>
        System.out.println("\n--- Task 5: FilterUtils ---");
        List<Integer> nums = Arrays.asList(1, 5, 12, 3, 17, 8, 20);
        System.out.println("Numbers > 10: " + FilterUtils.filter(nums, n -> n > 10));

        List<String> words = Arrays.asList("hello", "world", "java", "hi");
        System.out.println("Words with length > 4: " + FilterUtils.filter(words, w -> w.length() > 4));

        List<Student> allStudents = Arrays.asList(
                new Student("Anna", 3.9), new Student("Tim", 2.1), new Student("Lena", 3.5)
        );
        System.out.println("GPA >= 3.5: " + FilterUtils.filter(allStudents, s -> s.getGpa() >= 3.5));

        // Task 6 — Repository<T, ID>
        System.out.println("\n--- Task 6: Repository<T, ID> ---");
        UserRepository    userRepo    = new UserRepository();
        ProductRepository productRepo = new ProductRepository();

        userRepo.save(new User("Alice", 25));
        userRepo.save(new User("Bob",   30));
        System.out.println("All users: "    + userRepo.findAll());
        System.out.println("findById(1): "  + userRepo.findById(1));

        productRepo.save(new Product("P001", "Laptop"));
        productRepo.save(new Product("P002", "Mouse"));
        productRepo.save(new Product("P001", "Laptop Pro"));
        System.out.println("All products: " + productRepo.findAll());

        // Task 7 — FileProcessor<T>
        System.out.println("\n--- Task 7: FileProcessor<T> ---");
        UserFileProcessor    ufp = new UserFileProcessor();
        ProductFileProcessor pfp = new ProductFileProcessor();

        User    parsedUser    = ufp.parse("Alice,25");
        Product parsedProduct = pfp.parse("P003,Keyboard");
        System.out.println("Parsed user:    " + parsedUser    + "  → formatted: " + ufp.format(parsedUser));
        System.out.println("Parsed product: " + parsedProduct + "  → formatted: " + pfp.format(parsedProduct));

        try { ufp.parse("bad-input"); }
        catch (IllegalArgumentException e) { System.out.println("Error caught: " + e.getMessage()); }

        // Task 8 — Cache<K, V>
        System.out.println("\n--- Task 8: Cache<K, V> ---");
        Cache<String, Integer> cache = new Cache<>(3);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        System.out.println("get(a)=" + cache.get("a") + "  size=" + cache.size());
        cache.put("d", 4); // "a" is evicted (oldest)
        System.out.println("After adding d — contains a? " + cache.containsKey("a")
                + "  contains d? " + cache.containsKey("d"));

        // Task 9 — Mapper<F, T>
        System.out.println("\n--- Task 9: Mapper<F, T> ---");
        List<User>       userList = Arrays.asList(new User("Alice", 25), new User("Bob", 30));
        List<UserDto>    dtos     = MapperUtils.mapAll(userList, new UserMapper());
        System.out.println("User DTOs: " + dtos);

        List<Product>    productList = Arrays.asList(new Product("P1","Laptop"), new Product("P2","Phone"));
        List<ProductDto> pdtos       = MapperUtils.mapAll(productList, new ProductMapper());
        System.out.println("Product DTOs: " + pdtos);

        // Task 10 — Validator<T>
        System.out.println("\n--- Task 10: Validator<T> ---");
        ValidationService<String> emailService = new ValidationService<>(
                Collections.singletonList(new EmailValidator())
        );
        System.out.println("'alice@example.com' errors: " + emailService.validate("alice@example.com"));
        System.out.println("'not-an-email' errors:       " + emailService.validate("not-an-email"));

        ValidationService<Student> studentService = new ValidationService<>(
                Collections.singletonList(new StudentValidator())
        );
        System.out.println("Valid student errors:   " + studentService.validate(new Student("Anna", 3.9)));
        System.out.println("Invalid student errors: " + studentService.validate(new Student("", 5.0)));

        // ── PART II ───────────────────────────────────────────
        System.out.println("\n========== PART II: ITERATOR & LISTITERATOR ==========");
        Task_II_1.run();
        Task_II_2.run();
        Task_II_3.run();
        Task_II_4.run();
        Task_II_5.run();
        Task_II_6.run();
        Task_II_7.run();
        Task_II_8.run();
        Task_II_9.run();
        Task_II_10.run();
    }
}