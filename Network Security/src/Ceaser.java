import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Ceaser {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		FileInputStream fin=new FileInputStream("myfile.txt");
		FileOutputStream fout=new FileOutputStream("myfile.txt");
		
		String st=new String();
		int a[]=new int[2];
		st=s.nextLine();
		
		byte[] b=st.getBytes();
		fout.write(b);
		int f=0;
		while((f=fin.read())!=-1){
			System.out.print((char)f);
		}
		s.nextLine();
		a[0]=st.length();
		a[1]=s.nextInt();
		a[1]=a[1]%26;
		char[] str=new char[a[0]];
		str=st.toCharArray();
		for(int j=0;j<a[0];j++){
			boolean flag=true;
			if(str[j]>=65 && str[j]<90){
				str[j]+=a[1];
				if(str[j]>90)
					str[j]=(char)(65+str[j]-91);
				flag=false;
			}
			else if(str[j]>=97 && str[j]<122 && flag){
				str[j]+=a[1];
				if(str[j]>122)
					str[j]=(char)(97+str[j]-123);
				flag=false;
			}
			else if(str[j]==90 && flag)
				str[j]=(char)(65+a[1]-1);
			else if(str[j]==122 && flag)
				str[j]=(char)(97+a[1]-1);
		}
		s.close();
		System.out.print(str);
		String strr=str.toString();
		byte b1[]=strr.getBytes();
		fout.write(b1);
		//int f=0;
		//while((f=fin.read())!=-1){
		//	System.out.print((char)f);
		//}
		
	}
}
