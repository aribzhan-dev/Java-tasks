interface NotificationService {
    void send(String message);

    int getSentCount();
}


class EmailNotification implements NotificationService {
    private int sentCount = 0;

    @Override
    public void send(String message) {
        sentCount++;
        System.out.println("LOG [" + sentCount + "]: Email sent...");
        System.out.println("EMAIL: " + message);
        System.out.println("    Email successfully send!\n");
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
        System.out.println("📋 LOG [" + sentCount + "]: SMS yuborilmoqda...");
        System.out.println("📱 SMS: " + message);
        System.out.println("   ✅ SMS muvaffaqiyatli yuborildi!\n");
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
        System.out.println("📋 LOG [" + sentCount + "]: Push notification yuborilmoqda...");
        System.out.println("🔔 PUSH: " + message);
        System.out.println("   ✅ Push notification muvaffaqiyatli yuborildi!\n");
    }

    @Override
    public int getSentCount() {
        return sentCount;
    }
}



public class Interface {
}
