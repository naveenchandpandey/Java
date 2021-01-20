import java.util.Scanner;

public class Atbash
{
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Atbash decoder!\n" +
                           "Enter a message to decode: ");
        String message = s.nextLine();
        System.out.println("\nENCRYPTED: " + encrypt(message).toUpperCase());
    }

    
    public static String encrypt( String message )
    {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
            	
                int newChar = ('Z' - c) + 'A';
                System.out.println((char)newChar);
                decoded.append((char) newChar);
            }
            else if (Character.isLowerCase(c)) {
            	
                int newChar = ('z' - c) + 'a';
                System.out.println((char)newChar);
                decoded.append((char) newChar);
            }
            else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}