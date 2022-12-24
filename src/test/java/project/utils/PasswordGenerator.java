package project.utils;

import java.util.Random;

public class PasswordGenerator {

    public static String generatePasswordForBooking() {
        StringBuilder password = new StringBuilder(10);
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < 8; i++) {
            password.append(random.nextInt(10));
        }
        return password.append("Aa").toString();
    }
}
