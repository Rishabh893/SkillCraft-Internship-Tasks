import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char)((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Encrypt or Decrypt (e/d): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("e")) {
            System.out.println("Encrypted: " + encrypt(message, shift));
        } else {
            System.out.println("Decrypted: " + decrypt(message, shift));
        }

        sc.close();
    }
}
