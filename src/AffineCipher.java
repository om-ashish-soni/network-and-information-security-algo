import java.util.Scanner;

public class AffineCipher {
	
	public static String encrypt(String plainText,int key1,int key2,int mod) {
		String cipherText1=MultiplicativeCipher.encrypt(plainText, key1, mod);
		String cipherText2=AdditiveCipher.encryptWithoutLog(cipherText1, key2);
		return cipherText2;
	}
	public static String decrypt(String cipherText,int inv1,int key2,int mod) {

		String decryptedText1=AdditiveCipher.decryptWithoutLog(cipherText, key2);
		String decryptedText2=MultiplicativeCipher.decrypt(decryptedText1, inv1, mod);
		return decryptedText2;
	}
//	public static boolean attack(String plainText,String cipherText,int mod) {
//		int firstDiff=ModuloArithmetic.modSub(LangUtil.ctoi(plainText.charAt(1)),LangUtil.ctoi(plainText.charAt(0)),mod);
//		int secondDiff=ModuloArithmetic.modSub(LangUtil.ctoi(cipherText.charAt(1)),LangUtil.ctoi(cipherText.charAt(0)),mod);
//		
//		int inv=ModuloArithmetic.multiplicativeInverse(a, mod)
//		return false;
//	}
//	public static void cryptAnalysis() {
//		
//		
//	}
	public static void drive() {
		Scanner scanner=new Scanner(System.in);
		int key1=-1;
		int inv1=-1;
		final int mod=26;
		while(inv1 == -1){
			System.out.print("enter a key1 : ");
			key1=scanner.nextInt();
			inv1=ModuloArithmetic.multiplicativeInverse(key1,mod);
			if(inv1 == -1) {
				System.out.println("Multiplicative inv1erse does not exist for "+key1+" with respect to "+mod+"\nplease enter another key");
			}
		}
		System.out.println("inverse of "+key1+" mod "+mod+" = "+inv1);
		System.out.print("enter key2 : ");
		int key2=scanner.nextInt();
		
		String plainText="hello";
		
		UI.printLine();
		System.out.println("plainText : "+plainText);
		UI.printLine();
		
		String cipherText=encrypt(plainText,key1,key2,mod);
		System.out.println("cipherText : "+cipherText);
		UI.printLine();
		
		String decryptedText=decrypt(cipherText,inv1,key2,mod);
		System.out.println("decryptedText : "+decryptedText);
		
		UI.printLine();
	}
	public static void main(String[] args) {
		drive();
//		cryptAnalysis();
	}

}
