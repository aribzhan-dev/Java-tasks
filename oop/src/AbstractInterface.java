class InsufficientFundsException extends Exception {
    private double required;
    private double available;

    public InsufficientFundsException(double required, double available) {
        super("Недостаточно средств! Требуется: " + required + ", Доступно: " + available);
        this.required = required;
        this.available = available;
    }

    public double getRequired() { return required; }
    public double getAvailable() { return available; }
}

interface PaymentMethod {
    void pay(double amount);
    String getMethodName();
}

class CardPayment implements PaymentMethod {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата картой: " + amount + " тенге");
        System.out.println("Карта: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Оплата прошла успешно!");
    }

    @Override
    public String getMethodName() {
        return "Карта";
    }
}

class CryptoPayment implements PaymentMethod {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Крипто-оплата: " + amount + " тенге (эквивалент)");
        System.out.println("Кошелёк: " + walletAddress.substring(0, 8) + "...");
        System.out.println("Записано в блокчейн!");
    }

    @Override
    public String getMethodName() {
        return "Крипто";
    }
}

class BankTransfer implements PaymentMethod {
    private String bankName;

    public BankTransfer(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Банковский перевод: " + amount + " тенге");
        System.out.println("Банк: " + bankName);
        System.out.println("Перевод выполнен успешно!");
    }

    @Override
    public String getMethodName() {
        return "Банковский перевод";
    }
}

abstract class User {
    protected int id;
    protected String name;
    protected double balance;

    public User(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    abstract String getUserType();

    void deposit(double amount) {
        balance += amount;
        System.out.println("На счёт " + name + " зачислено " + amount + " тенге. Новый баланс: " + balance);
    }

    void printInfo() {
        System.out.println("ID        : " + id);
        System.out.println("Имя       : " + name);
        System.out.println("Баланс    : " + balance);
    }

    public void deduct(double amount) {
        balance -= amount;
    }

    public double getBalance() { return balance; }
    public String getName() { return name; }
}

class IndividualUser extends User {
    public IndividualUser(int id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public String getUserType() {
        return "Физическое лицо";
    }
}

class BusinessUser extends User {
    private String companyName;

    public BusinessUser(int id, String name, String companyName, double balance) {
        super(id, name, balance);
        this.companyName = companyName;
    }

    @Override
    public String getUserType() {
        return "Юридическое лицо (" + companyName + ")";
    }
}

class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(User user, double amount) throws InsufficientFundsException {
        System.out.println("\nЗапрос на оплату: " + user.getName() +
                " → " + amount + " тенге (" + paymentMethod.getMethodName() + ")");

        if (user.getBalance() < amount) {
            throw new InsufficientFundsException(amount, user.getBalance());
        }

        user.deduct(amount);
        paymentMethod.pay(amount);
        System.out.printf("Остаток на балансе: %.0f тенге%n", user.getBalance());
    }
}

public class AbstractInterface {
    public static void main(String[] args) {

        System.out.println("========== ПЛАТЁЖНАЯ СИСТЕМА ==========\n");

        IndividualUser ali = new IndividualUser(1, "Али Валиев", 500_000);
        IndividualUser vali = new IndividualUser(2, "Вали Тошев", 100_000);
        BusinessUser techCorp = new BusinessUser(3, "Сардор Каримов", "TechCorp LLC", 5_000_000);

        System.out.println("СПИСОК ПОЛЬЗОВАТЕЛЕЙ:");
        ali.printInfo();
        vali.printInfo();
        techCorp.printInfo();

        PaymentProcessor cardProcessor = new PaymentProcessor(new CardPayment("1234567890123456"));
        PaymentProcessor cryptoProcessor = new PaymentProcessor(new CryptoPayment("0xABCDEF1234567890"));
        PaymentProcessor bankProcessor = new PaymentProcessor(new BankTransfer("Капиталбанк"));

        System.out.println("\n========== ПЛАТЕЖИ ==========");

        System.out.println("\nУСПЕШНЫЕ ПЛАТЕЖИ:");

        try {
            cardProcessor.processPayment(ali, 200_000);
        } catch (InsufficientFundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        try {
            bankProcessor.processPayment(techCorp, 2_000_000);
        } catch (InsufficientFundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        try {
            cryptoProcessor.processPayment(ali, 100_000);
        } catch (InsufficientFundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println("\nНЕУСПЕШНЫЕ ПЛАТЕЖИ:");

        try {
            cardProcessor.processPayment(vali, 500_000);
        } catch (InsufficientFundsException e) {
            System.out.println("Платёж отклонён: " + e.getMessage());
            System.out.printf("Не хватает: %.0f тенге%n", e.getRequired() - e.getAvailable());
        }

        try {
            bankProcessor.processPayment(vali, 200_000);
        } catch (InsufficientFundsException e) {
            System.out.println("Платёж отклонён: " + e.getMessage());
        }

        System.out.println("\nПОПОЛНЕНИЕ БАЛАНСА И ПОВТОРНАЯ ПОПЫТКА:");
        vali.deposit(300_000);

        try {
            cardProcessor.processPayment(vali, 200_000);
        } catch (InsufficientFundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println("\nИТОГОВЫЕ БАЛАНСЫ:");
        ali.printInfo();
        vali.printInfo();
        techCorp.printInfo();
    }
}