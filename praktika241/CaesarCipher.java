import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char shifted = (char) (Character.toUpperCase(c) + key);
                if (shifted > 'Z') {
                    shifted -= 26;
                }
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char shifted = (char) (Character.toUpperCase(c) - key);
                if (shifted < 'A') {
                    shifted += 26;
                }
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Зашифровать текст");
        System.out.println("2. Расшифровать текст");
        System.out.println("3. Выход");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            String message;
            int key;
            if (choice == 1) {
                System.out.println("Введите текст для шифрования: ");
                message = scanner.nextLine();
                System.out.println("Введите ключ для шифрования: ");
                key = scanner.nextInt();
                String encrypted = encrypt(message, key);
                System.out.println("Зашифрованный текст: " + encrypted);
            } else if (choice == 2) {
                System.out.println("Введите текст для расшифрования: ");
                message = scanner.nextLine();
                System.out.println("Введите ключ для расшифрования: ");
                key = scanner.nextInt();
                String decrypted = decrypt(message, key);
                System.out.println("Расшифрованный текст: " + decrypted);
            } else if (choice != 3) {
                System.out.println("Ошибка: неверный выбор действия.");
            }
        } while (choice != 3);

        scanner.close();
    }
}