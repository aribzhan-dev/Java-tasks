import java.util.*;
import java.time.LocalDate;

//   ЧАСТЬ 1: GENERICS (УНИВЕРСАЛЬНЫЕ ТИПЫ)
// ЗАДАЧА 1

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

    // Статический метод для успешного ответа
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, "ОК", 200, true);
    }

    // Статический метод для ошибки
    public static <T> ApiResponse<T> error(String message, int statusCode) {
        return new ApiResponse<>(null, message, statusCode, false);
    }

    public T getData()         { return data; }
    public String getMessage() { return message; }
    public int getStatusCode() { return statusCode; }
    public boolean isSuccess() { return success; }

    @Override
    public String toString() {
        return "ОтветСервера{успех=" + success
                + ", код=" + statusCode
                + ", сообщение='" + message + "'"
                + ", данные=" + (data != null ? data.toString() : "пусто")
                + "}";
    }
}

class User {
    private final String name;
    private final int age;
    public User(String name, int age) { this.name = name; this.age = age; }
    @Override public String toString() { return "Пользователь{имя='" + name + "', возраст=" + age + "}"; }
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
        return "Заказ{id=" + id + ", статус='" + status + "', сумма=" + amount + "}";
    }
}

// ЗАДАЧА 2: Пара значений (Ключ и Значение)

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) { this.key = key; this.value = value; }

    public K getKey()   { return key; }
    public V getValue() { return value; }
    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    // swap() возвращает новую пару, где К и V поменялись местами
    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    @Override
    public String toString() {
        return "Пара{ключ=" + key + ", значение=" + value + "}";
    }
}


// ЗАДАЧА 3: Хранилище (Storage)

class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return "Человек{'" + name + "'}"; }
}

class Student extends Person {
    private final double gpa;
    public Student(String name, double gpa) { super(name); this.gpa = gpa; }
    public double getGpa() { return gpa; }
    @Override public String toString() { return "Студент{'" + getName() + "', средний_балл=" + gpa + "}"; }
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

    // Использование Wildcards (? extends T)
    public void addAll(List<? extends T> newItems) {
        items.addAll(newItems);
    }
}

// ЗАДАЧА 4: Утилиты поиска максимума

class MaxUtils {

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст, невозможно найти максимум");
        }
        T result = list.get(0);
        for (T item : list) {
            if (item.compareTo(result) > 0) result = item;
        }
        return result;
    }
}


// ЗАДАЧА 5: Фильтрация по условию

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


// ЗАДАЧА 6: Репозиторий (Имитация базы данных)

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
    @Override public String toString() { return "Товар{id='" + id + "', название='" + name + "'}"; }
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

// ЗАДАЧА 7: Обработка файлов

interface FileProcessor<T> {
    T parse(String line);
    String format(T obj);
}

class UserFileProcessor implements FileProcessor<User> {
    @Override
    public User parse(String line) {
        if (line == null || !line.contains(",")) {
            throw new IllegalArgumentException("Неверный формат: ожидалось 'имя,возраст', получено: " + line);
        }
        String[] parts = line.split(",", 2);
        return new User(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }

    @Override
    public String format(User user) {
        return user.toString();
    }
}

// ЗАДАЧА 8

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
    public int size()                 { return store.size(); }

    private void removeOldest() {
        K oldest = store.keySet().iterator().next();
        store.remove(oldest);
    }
}

// ЗАДАЧА 9

interface Mapper<F, T> {
    T map(F from);
}

class UserDto {
    private final String name;
    public UserDto(String name) { this.name = name; }
    @Override public String toString() { return "UserDto{имя='" + name + "'}"; }
}

class UserMapper implements Mapper<User, UserDto> {
    @Override
    public UserDto map(User user) {
        // Упрощенное преобразование
        return new UserDto(user.toString());
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


// ЗАДАЧА 10

interface Validator<T> {
    boolean isValid(T obj);
    String getErrorMessage();
}

class EmailValidator implements Validator<String> {
    @Override
    public boolean isValid(String email) {
        return email != null && email.contains("@") && email.contains(".");//@.
    }
    @Override public String getErrorMessage() { return "Некорректный email адрес"; }
}

class StudentValidator implements Validator<Student> {
    @Override
    public boolean isValid(Student s) {
        return s != null && !s.getName().isBlank() && s.getGpa() >= 0.0 && s.getGpa() <= 4.0;//123456yui ';]\]\]\]\
    }
    @Override public String getErrorMessage() { return "GPA должен быть от 0.0 до 4.0, имя не пустое"; }
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

//   ЧАСТЬ 2: ITERATOR И LISTITERATOR

// ЗАДАЧА II.1
class Task_II_1 {
    public static void run() {
        System.out.println("\n--- Задача II.1: Безопасное удаление плохих оценок ---");
        List<Integer> scores = new ArrayList<>(Arrays.asList(45, 82, 30, 91, 55, 20, 73));

        Iterator<Integer> it = scores.iterator();
        while (it.hasNext()) {
            if (it.next() < 50) it.remove();
        }

        System.out.println("Проходные баллы: " + scores);
    }
}

// ЗАДАЧА II.5
class Task_II_5 {
    public static void run() {
        System.out.println("\n--- Задача II.5: Вставка 'НУЖНО_ВНИМАНИЕ' после ERROR ---");
        List<String> logs = new ArrayList<>(Arrays.asList(
                "INFO  сервер запущен",
                "ERROR ошибка в строке 42",
                "INFO  запрос получен"
        ));

        ListIterator<String> it = logs.listIterator();
        while (it.hasNext()) {
            if (it.next().contains("ERROR")) {
                it.add(">>> НУЖНО_ВНИМАНИЕ");
            }
        }
        logs.forEach(System.out::println);
    }
}

// ЗАДАЧА II.10
class BrowserHistory {
    private final List<String> history = new ArrayList<>();
    private ListIterator<String> cursor;
    private String currentPage;

    public BrowserHistory(String startUrl) {
        history.add(startUrl);
        cursor = history.listIterator(1);
        currentPage = startUrl;
    }

    public void goBack() {
        if (cursor.hasPrevious()) {
            currentPage = cursor.previous();
            System.out.println("Назад ← " + currentPage);
        } else {
            System.out.println("Вы в самом начале истории");
        }
    }

    public void goForward() {
        if (cursor.hasNext()) {
            currentPage = cursor.next();
            System.out.println("Вперед → " + currentPage);
        } else {
            System.out.println("Вы на самой последней странице");
        }
    }

    public void openPage(String url) {
        while (cursor.hasNext()) {
            cursor.next();
            cursor.remove();
        }
        cursor.add(url);
        currentPage = url;
        System.out.println("Открыто → " + currentPage);
    }

    public void printHistory() {
        System.out.println("История: " + history + "  [сейчас на: " + currentPage + "]");
    }
}

class Task_II_10 {
    public static void run() {
        System.out.println("\n--- Задача II.10: История браузера ---");
        BrowserHistory browser = new BrowserHistory("google.com");
        browser.openPage("github.com");
        browser.openPage("stackoverflow.com");
        browser.printHistory();

        browser.goBack();
        browser.goBack();
        browser.openPage("youtube.com");

        browser.printHistory();
    }
}

// ГЛАВНЫЙ КЛАСС ДЛЯ ЗАПУСКА
public class Main {
    public static void main(String[] args) {

        System.out.println("========== ЧАСТЬ I: GENERICS (УНИВЕРСАЛЬНЫЕ ТИПЫ) ==========");

        // Задача 1: Ответ от сервера
        ApiResponse<User> userResp = ApiResponse.success(new User("Алибек", 20));
        System.out.println(userResp);

        // Задача 8: Кэш
        Cache<String, Integer> cache = new Cache<>(2);
        cache.put("Студент1", 90);
        cache.put("Студент2", 80);
        cache.put("Студент3", 100);
        System.out.println("Есть ли Студент1 в кэше? " + cache.containsKey("Студент1"));

        // Задача 10: Валидация
        EmailValidator ev = new EmailValidator();
        System.out.println("Проверка почты 'test@mail': " + ev.isValid("test@mail"));

        System.out.println("\n========== ЧАСТЬ II: ITERATOR И LISTITERATOR ==========");
        Task_II_1.run();
        Task_II_5.run();
        Task_II_10.run();
    }
}