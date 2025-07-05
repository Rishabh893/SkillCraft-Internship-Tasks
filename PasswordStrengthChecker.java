import java.util.Scanner;

public class PasswordStrengthChecker {
    public static String checkStrength(String password) {
        boolean upper = false, lower = false, digit = false, special = false;
        int length = password.length();

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) upper = true;
            else if (Character.isLowerCase(ch)) lower = true;
            else if (Character.isDigit(ch)) digit = true;
            else special = true;
        }

        int score = 0;
        if (length >= 8) score++;
        if (upper) score++;
        if (lower) score++;
        if (digit) score++;
        if (special) score++;

        switch (score) {
            case 5: return "Very Strong";
            case 4: return "Strong";
            case 3: return "Moderate";
            case 2: return "Weak";
            default: return "Very Weak";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Password Strength: " + checkStrength(password));
        sc.close();
    }
}
