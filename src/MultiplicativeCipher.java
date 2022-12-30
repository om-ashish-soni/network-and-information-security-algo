import java.util.Scanner;

public class MultiplicativeCipher {
	public static String encrypt(String plainText,int key,int mod) {
		StringBuilder sb=new StringBuilder();
		char[] text=plainText.toCharArray();
		for(char ch:text) {
			int num=LangUtil.ctoi(ch);
			num=ModuloArithmetic.modMul(num,key,mod);
			char nch=LangUtil.itoc(num);
			sb.append(nch);
		}
		String cipherText=sb.toString();
		return cipherText;
	}
	public static String decrypt(String cipherText,int inv,int mod) {
		StringBuilder sb=new StringBuilder();
		char [] text=cipherText.toCharArray();
		for(char ch:text) {
			int num=LangUtil.ctoi(ch);
			num=ModuloArithmetic.modMul(num,inv,mod);
			char nch=LangUtil.itoc(num);
			sb.append(nch);
		}
		String decryptedText=sb.toString();
		return decryptedText;
	}
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int key=-1;
		int inv=-1;
		final int mod=26;
		while(inv == -1){
			System.out.print("enter a key : ");
			key=scanner.nextInt();
			inv=ModuloArithmetic.multiplicativeInverse(key,mod);
			if(inv == -1) {
				System.out.println("Multiplicative inverse does not exist for "+key+" with respect to "+mod+"\nplease enter another key");
			}
		}
		System.out.println("inverse of "+key+" mod "+mod+" = "+inv);
		
		UI.printLine();
		
		String plainText="hello";
		System.out.println("plainText : "+plainText);
		String cipherText=encrypt(plainText,key,mod);
		System.out.println("Cipther Text : "+cipherText);
		
		String decryptedText=decrypt(cipherText,inv,mod);
		System.out.println("Decrypted Text : "+decryptedText);
		
		UI.printLine();
	}
	
}
