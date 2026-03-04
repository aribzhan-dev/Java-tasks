interface NotificationService {
    void send(String message);
    int getSentCount();
}

class EmailNotification implements NotificationService {
    private int sentCount = 0;

    @Override
    public void send(String message) {
        sentCount++;
        System.out.println("LOG [" + sentCount + "]: Отправка Email...");
        System.out.println("EMAIL: " + message);
        System.out.println("    Email успешно отправлен!\n");
    }

    @Override
    public int getSentCount() {
        return sentCount;
    }
}

class SmsNotification implements NotificationService {
    private int sentCount = 0;

    @Override
    public void send(String message) {
        sentCount++;
        System.out.println("LOG [" + sentCount + "]: Отправка SMS...");
        System.out.println("SMS: " + message);
        System.out.println("    SMS успешно отправлен!\n");
    }

    @Override
    public int getSentCount() {
        return sentCount;
    }
}

class PushNotification implements NotificationService {
    private int sentCount = 0;

    @Override
    public void send(String message) {
        sentCount++;
        System.out.println("LOG [" + sentCount + "]: Отправка Push-уведомления...");
        System.out.println("PUSH: " + message);
        System.out.println("    Push-уведомление успешно отправлено!\n");
    }

    @Override
    public int getSentCount() {
        return sentCount;
    }
}

class NotificationManager {
    private NotificationService service;

    public NotificationManager(NotificationService service) {
        this.service = service;
    }

    public void notifyUser(String message) {
        service.send(message);
    }

    public void printStats() {
        System.out.println("Всего отправлено сообщений: " + service.getSentCount());
    }
}

public class Interface {
    public static void main(String[] args) {

        System.out.println("========== СИСТЕМА УВЕДОМЛЕНИЙ ==========\n");

        System.out.println("--- EMAIL МЕНЕДЖЕР ---");
        NotificationManager emailManager = new NotificationManager(new EmailNotification());
        emailManager.notifyUser("В ваш аккаунт вошли с нового устройства!");
        emailManager.notifyUser("Ваш пароль успешно изменён.");
        emailManager.printStats();

        System.out.println("--- SMS МЕНЕДЖЕР ---");
        NotificationManager smsManager = new NotificationManager(new SmsNotification());
        smsManager.notifyUser("Код подтверждения: 4782");
        smsManager.printStats();

        System.out.println("--- PUSH МЕНЕДЖЕР ---");
        NotificationManager pushManager = new NotificationManager(new PushNotification());
        pushManager.notifyUser("Специальное предложение только для вас!");
        pushManager.notifyUser("Ваш заказ уже в пути.");
        pushManager.notifyUser("Друг отправил вам сообщение.");
        pushManager.printStats();

        System.out.println("\n--- ПРЕИМУЩЕСТВО DI: Замена сервиса во время выполнения ---");

        NotificationService[] services = {
                new EmailNotification(),
                new SmsNotification(),
                new PushNotification()
        };

        for (NotificationService service : services) {
            NotificationManager manager = new NotificationManager(service);
            manager.notifyUser("Тестовое сообщение — проверка всех каналов");
        }
    }
}