
import java.util.*;

public class AdditiveCipher {
	public static String encryptWithoutLog(String s,int k) {
		int n=s.length();
		char [] arr=s.toCharArray();
		int [] asciiArray=new int[n];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			asciiArray[i]=(arr[i]-'a');
		}
		for(int i=0;i<n;i++) {
			asciiArray[i]+=k;
		}
		for(int i=0;i<n;i++) {
			asciiArray[i]%=26;
		}
		for(int i=0;i<n;i++) {
			char nch=(char)(asciiArray[i]+'a');
			sb.append(nch);
		}
		
		return sb.toString();
	}
	static String encrypt(String s,int k) {
		int n=s.length();
		char [] arr=s.toCharArray();
		int [] asciiArray=new int[n];
		StringBuilder sb=new StringBuilder();
		
		
		System.out.print("Plain Text :               ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		System.out.print("Mapping :                  ");
		for(int i=0;i<n;i++) {
			asciiArray[i]=(arr[i]-'a');
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("Key :                      ");
		for(int i=0;i<n;i++) {
			
			System.out.print(k+" ");
		}
		System.out.println();
		
		System.out.print("Plain Text + Key :         ");
		for(int i=0;i<n;i++) {
			asciiArray[i]+=k;
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("(Plain Text + Key) mod 26 : ");
		for(int i=0;i<n;i++) {
			asciiArray[i]%=26;
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("Cipher Text :               ");
		for(int i=0;i<n;i++) {
			char nch=(char)(asciiArray[i]+'a');
			System.out.print(nch+" ");
			sb.append(nch);
		}
		System.out.println();
		
		
		
		return sb.toString();
	}
	static String decryptWithoutLog(String s,int k) {
		int n=s.length();
		char [] arr=s.toCharArray();
		int [] asciiArray=new int[n];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			asciiArray[i]=(arr[i]-'a');
		}
		for(int i=0;i<n;i++) {
			asciiArray[i]-=k;
		}
		for(int i=0;i<n;i++) {
			asciiArray[i]=(asciiArray[i]+26)%26;
		}
		for(int i=0;i<n;i++) {
			char nch=(char)(asciiArray[i]+'a');
			sb.append(nch);
		}
		
		return sb.toString();
	}
	static String decrypt(String s,int k) {
		int n=s.length();
		char [] arr=s.toCharArray();
		int [] asciiArray=new int[n];
		StringBuilder sb=new StringBuilder();
		
		
		System.out.print("Cipher Text :               ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		System.out.print("Mapping :                  ");
		for(int i=0;i<n;i++) {
			asciiArray[i]=(arr[i]-'a');
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("Key :                      ");
		for(int i=0;i<n;i++) {
			
			System.out.print(k+" ");
		}
		System.out.println();
		
		System.out.print("Cipher Text - Key :         ");
		for(int i=0;i<n;i++) {
			asciiArray[i]-=k;
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("(Cipher Text - Key) mod 26 : ");
		for(int i=0;i<n;i++) {
			asciiArray[i]=(asciiArray[i]+26)%26;
			System.out.print(asciiArray[i]+" ");
		}
		System.out.println();
		
		System.out.print("Plain Text :                ");
		for(int i=0;i<n;i++) {
			char nch=(char)(asciiArray[i]+'a');
			System.out.print(nch+" ");
			sb.append(nch);
		}
		System.out.println();
		
		
		
		return sb.toString();
	}
	static void cryptAnalysis(String msg,String encoded) {
		for(int k=1;k<=25;k++) {
			StringBuilder sb=new StringBuilder();
			char [] arr=encoded.toCharArray();
			for(char ch:arr) {
				int ascii=(int)(ch-'a');
				ascii=(ascii-k+26)%26;
				char nch=(char)('a'+ascii);
				sb.append(nch);
			}
			String decoded=sb.toString();
			System.out.println("k : "+k+" , decoded : "+decoded);
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String msg="welcome";
		int k=5;
		
		System.out.println("\n+++++++++++++++ Encryption +++++++++++++++++");
		String encoded=encrypt(msg,k);
		
		System.out.println("\n+++++++++++++++ Decryption +++++++++++++++++");
		String decoded=decrypt(encoded,k);
		
		System.out.println("\n+++++++++++++++ CryptAnalysis +++++++++++++++++");
		cryptAnalysis(msg,encoded);
		
	}

}
