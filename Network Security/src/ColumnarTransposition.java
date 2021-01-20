import java.util.Arrays;
import java.util.Scanner;

public class ColumnarTransposition {
public static String plain_text = new String();
	public static String key,key2 = new String();
	public static String cipher_text1 = new String();
	public static StringBuilder cipher_text = new StringBuilder();
	public static StringBuilder cipher_text_final = new StringBuilder();
	public static StringBuilder Transposition(String plain_text,String key)
	{
		char key_ascii[],key_array[];
		char matrix[][];
		int flag[];
		int key_len, r, text_len, i, j, k=0, pos=0;
		char asc;
		StringBuilder cipher_text = new StringBuilder();		
		key_len = key.length();
		text_len = plain_text.length();
		r = (text_len/key_len) + 1;
		matrix = new char[r][key_len];
		for(i=0 ; i<r ; i++)
		{
			for(j = 0; (j<key_len) && (k<text_len) ; j++)
			{
				matrix[i][j] = plain_text.charAt(k);
				k++;
			}
		}
		key_ascii = new char[key_len];
		key_array = new char[key_len];
		flag = new int[key_len];
		key_array = key.toCharArray();
		System.out.println(Arrays.deepToString(matrix));
		for(i=0 ; i<key_len ; i++)
		{
			asc = key.charAt(i);
			key_ascii[i] = asc;
		}
		Arrays.sort(key_ascii);
		//System.out.println(key_ascii);
		//System.out.println(key_array);
	
		for(i=0 ; i<key_len ; i++)
		{
			
			//pos = Arrays.binarySearch(key_array, key_ascii[i]);
			for(k=0; k<key_len ; k++)
			{
				if((key_array[k] == key_ascii[i]) && (flag[k] != 1))
				{
					pos = k;
					flag[pos] = 1;
					
				}
			}
			//System.out.println(pos);
			for(j=0 ; (j<r)  ; j++)
			{
				if(Character.isAlphabetic(matrix[j][pos]))
					cipher_text.append(matrix[j][pos]);
			}
			
		}
		
		
		

		return cipher_text;
	}
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Single Transposition:");
		System.out.println("Enter the plain text: ");
		plain_text = sc.nextLine();
		plain_text = plain_text.replaceAll(" ","");
		System.out.println("Enter the key1: ");
		key = sc.next();
		key = key.toUpperCase();
		cipher_text = Transposition(plain_text, key);
		System.out.println("Cipher Text after single columnar transposition: "+cipher_text);
		cipher_text1 = cipher_text.toString();
		System.out.println("Double Transposition:");
		System.out.println("Enter the key2:");
		key2 = sc.next();
		key2 = key2.toUpperCase();
		cipher_text_final = Transposition(cipher_text1, key2);
		System.out.println("Final ciphered text after double columnar transposition: "+cipher_text_final);
		sc.close();

	}

}
