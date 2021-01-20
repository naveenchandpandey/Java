//import java.util.Arrays;
import java.util.*;
//import java.util.Scanner;

public class ProductCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = new String();
		String plain_text = new String();
		//List<Character>cipher_text = new ArrayList<Character>();
		StringBuilder cipher_text = new StringBuilder();
		int keylen,i,i1=0,j=0, k=0, ascii,pos, pos1;
		int ptext_len , ip_rows_len;
		int posr1=0,posr2=0,posc1=0,posc2=0;
		int[] alpha_occurence = new int[25];
		char letter;
		char[] key_array = new char[25];
		char[][] key_matrix = new char[5][5];
		char[][] ip_matrix;
		char[][] op_matrix;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Playfair cipher: ");
		System.out.println("Enter the plain text: ");
		plain_text = sc.next();
		plain_text = plain_text.toUpperCase();
		
		System.out.println("Enter the key: ");
		key = sc.next();
		key = key.toUpperCase();
		//System.out.println(key);
		keylen = key.length();
		
		for(i=0 ; i<25 ; )
		{
			if(j <keylen)
			{
			letter = key.charAt(j);
			ascii = (int)letter;
			//System.out.print(ascii + " ");
			pos = ascii - 65;
			if(pos> 8)
				   pos1 = pos - 1; 
			else
				   pos1 = pos;
			// System.out.print(pos1 + " ");
			if(alpha_occurence[pos1] == 0)
			   {
				key_array[i] = letter;
				alpha_occurence[pos1] = 1;
				i++;
			   }
			j++;
			}
			else
			{
				if(k <= 8)
				{
					if(alpha_occurence[k] == 0)
					{
						ascii = k + 65;
						letter = (char)ascii;
						key_array[i] = letter;
						alpha_occurence[k] = 1;
						i++;
					}
					k++;
				}
				else
				{
					int k1 = k-1;
					if(alpha_occurence[k1] == 0)
					{
						ascii = k + 65;
						letter = (char)ascii;
						key_array[i] = letter;
						alpha_occurence[k1] = 1;
						i++;
					}
					k++;
				}
			}
		}
		
		//System.out.println("Key Array: " + Arrays.toString(key_array));
		
		System.out.println("Key Matrix: ");
		k=0;
		for(i=0 ; i<5 ; i++)
		{	
			for(j=0; j<5 ; j++)
			{
				key_matrix[i][j] = key_array[k++];
				System.out.print(key_matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		ptext_len = plain_text.length();
		j = 0;
		ip_matrix = new char[ptext_len][2];
		op_matrix = new char[ptext_len][2];
		
		for(i=0; i<ptext_len ; i++)
		{
			if(j>=2)
			{
				i1++;
				j = 0;
			
			}
			
			ip_matrix[i1][j++] = plain_text.charAt(i);
			
			if(j == 2)
			{
				if(ip_matrix[i1][0] == ip_matrix[i1][1])
				{
					ip_matrix[i1][1] = 'X';
					i--;
				}
			}
			
			
		}
		
		ip_rows_len = i1+1;
		if(j == 1)
		{
			ip_matrix[i1][1] = 'X';
		}
		
		System.out.println("Plain Text: ");
		System.out.println(Arrays.deepToString(ip_matrix));
		
		for(i1=0 ; i1<ip_rows_len ; i1++ )
		{
			for(i=0 ; i<5 ; i++)
				for(j=0 ; j<5 ; j++)
				{
					if(key_matrix[i][j] == ip_matrix[i1][0])
					{
						posr1 = i;
						posc1 = j;
					}
					if(key_matrix[i][j] == ip_matrix[i1][1])
					{
						posr2 = i;
						posc2 = j;
					}
				}
			if(posr1 == posr2)
			{
				if(posc1 == 4)
					posc1 = 0;
				else
					posc1 = posc1+1;
				
				if(posc2 == 4)
					posc2 = 0;
				else
					posc2 = posc2+1;
				
				op_matrix[i1][0] = key_matrix[posr1][posc1];
				op_matrix[i1][1] = key_matrix[posr1][posc2];
			}
			else if(posc1 == posc2)
			{
				if(posr1 == 4)
					posr1 = 0;
				else
					posr1 = posr1+1;
				
				if(posr2 == 4)
					posr2 = 0;
				else
					posr2 = posr2+1;
				
				op_matrix[i1][0] = key_matrix[posr1][posc1];
				op_matrix[i1][1] = key_matrix[posr2][posc1];
			}
			else
			{
				op_matrix[i1][0] = key_matrix[posr1][posc2];
				op_matrix[i1][1] = key_matrix[posr2][posc1];
			}
		}
		
		System.out.println("Cipher Text: ");
		System.out.println(Arrays.deepToString(op_matrix));
		
		
		
		for(i1=0 ; i1<ip_rows_len ; i1++)
		{
			for(j=0 ; j<=1 ; j++)
			{
				if(Character.isAlphabetic(op_matrix[i1][j]))
					cipher_text.append(op_matrix[i1][j]);
			}
		}
		
		System.out.println("After encrypting using playfair cipher: " + cipher_text);
		System.out.println("Caesar Cipher:");
		int ns, c_len, x, x_mod, x_res;
		char ch;
		StringBuilder result = new StringBuilder();
		System.out.println("Enter the no. of shift positions: ");
		ns = sc.nextInt();
		
		c_len = cipher_text.length();
		
		for(i=0 ; i<c_len ; i++)
		{
			ch = cipher_text.charAt(i);
			x = (int)ch;
			x = x-65;
			x_mod = (x-ns)%26;
			if(x_mod< 0)
			{
				x_mod = x_mod + 26;
			}
			x_res = x_mod + 65;
			ch = (char)x_res;
			result.append(ch);
		}
		
		System.out.println("After encrpting using Caesar Cipher: "+result);
		
		
		
		
		sc.close();

	}

}
