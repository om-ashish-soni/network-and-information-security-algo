import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MonoalphabaticSubstitution {
	
	static char[] alphabet=new String("abcdefghijklmnopqrstuvwxyz").toCharArray();

	static void shuffle(char [] substitution) {
		Random random=new Random();
		random.setSeed((1L<<48)-1);
		int range=26;
		for(int i=0;i<26;i++) {
			int index=random.nextInt(range);
			//swapping (index) th char with (range-1) th char
			char temp=substitution[index];
			substitution[index]=substitution[range-1];
			substitution[range-1]=temp;
			//done swapping
			range--;
		}
	}
	static String encrypt(String msg,char [] substitution) {
		char[] arr=msg.toCharArray();
		StringBuilder sb=new StringBuilder();
		int n=arr.length;
		for(int i=0;i<n;i++) {
			char ch=arr[i];
			int ascii=(ch-'a');
//			System.out.println("ch:"+ch+",bool:"+(Character.isWhitespace(ch)));
			char nch=(Character.isWhitespace(ch) )?(ch):(substitution[ascii]);
			sb.append(nch);
		}
		return sb.toString();
	}
	static String decrypt(String msg,char [] substitution) {
		char[] arr=msg.toCharArray();
		int sz=substitution.length;
		char[] reverseSubstituition=new char[sz];
		StringBuilder sb=new StringBuilder();
		int n=arr.length;
		
		for(int i=0;i<sz;i++) {
			char ch=substitution[i];
			int ascii=(int)(ch-'A');
			reverseSubstituition[ascii]=alphabet[i];
		}
		for(int i=0;i<n;i++) {
			char ch=arr[i];
			int ascii=(int)(ch-'A');
			char nch=(Character.isWhitespace(ch))?(ch):(reverseSubstituition[ascii]);
			sb.append(nch);
		}
		
		return sb.toString();
	}
	static String readText(String filename) throws IOException {
		StringBuilder sb=new StringBuilder();
		File file=new File(filename);
		BufferedReader bf=new BufferedReader(new FileReader(file));
		String chunk;
		while((chunk=bf.readLine()) != null) {
			sb.append(chunk);
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		
		char[] substitution=new String("QBPXOILEZNUKTJCMGHWRSYVDAF").toCharArray();
		String filename="C:\\Users\\user1\\eclipse-workspace\\NIS_om_ashish_soni\\src\\sample_text.txt";
		String msg=readText(filename).toLowerCase();
		
		shuffle(substitution);
		
		System.out.println("\n+++++++++++++++ Message +++++++++++++++++");
		System.out.println();
		System.out.println("msg : "+msg);
		
		System.out.println("\n+++++++++++++++ Substitution +++++++++++++++++");
		System.out.println();
		System.out.print("substitution : ");
		for(char ch:substitution) {
			System.out.print(ch);
		}
		System.out.println();
		
		System.out.println("\n+++++++++++++++ Encryption +++++++++++++++++");
		System.out.println();
		
		String encoded=encrypt(msg,substitution);
		System.out.println("encoded : "+encoded);
		
		System.out.println("\n+++++++++++++++ Decryption +++++++++++++++++");
		System.out.println();
		String decoded=decrypt(encoded,substitution);
		System.out.println("decoded : "+decoded);
		
	}

}
