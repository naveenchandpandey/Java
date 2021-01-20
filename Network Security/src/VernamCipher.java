import java.util.Scanner;

public class VernamCipher {

	public static void main(String[] args){
		
			String plain_text = new String();
			String key = new String();
			int plain_len,key_len,i;
			char result[];
						
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the plain text: ");
			plain_text = sc.next();
			System.out.println("Enter the key: ");
			key = sc.next();
			
			plain_len = plain_text.length();
			key_len = key.length();
			
			if(plain_len != key_len)
			{
				System.out.println("Length of plain text and key are not equal.");
				System.exit(0);
			}
			result = new char[plain_len];
			int res = 0;
			for(i=0 ; i<plain_len ; i++)
			{
				int ascii=(int)(plain_text.charAt(i));
				int keyb=(int)(key.charAt(i));
				res=ascii^keyb;
		}
					result[i] = (char)res;
			System.out.print(result[i]);	
	}

}