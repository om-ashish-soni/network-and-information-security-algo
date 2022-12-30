package cipher;

import java.util.ArrayList;
import java.util.List;

import mathutil.FastExponent;
import mathutil.PrimeEngine;
import modmath.ModuloArithmetic;
public class RSA {
	public static long decrypt(List<Long> privateKey,long c) {
		long d=privateKey.get(0);
		long n=privateKey.get(1);
		long decoded=FastExponent.get(c, d, n);
		return decoded;
	}
	public static char decryptChar(List<Long> privateKey,long c){
		long num=decrypt(privateKey,c);
		return (char)(num);
	}
	public static String decryptString(List<Long> privateKey,List<Long> lst){
		StringBuilder sb=new StringBuilder(lst.size());
		for(long num:lst){
			char ch=decryptChar(privateKey,num);
			sb.append(ch);
		}
		return sb.toString();
	}
	public static long encrypt(List<Long> publicKey,long m) {
		long e=publicKey.get(0);
		long n=publicKey.get(1);
		long encoded=FastExponent.get(m, e, n);
//		System.out.println("m , e, n : "+m+" , "+e+" , "+n);
//		System.out.println("ans : "+encoded);
		return encoded;
	}
	public static long encryptChar(List<Long> publicKey,char ch){
		long ascii=(long)(ch);
		return encrypt(publicKey,ascii);
	}
	public static List<Long> encryptString(List<Long> publicKey,String msg){
		char [] msgArray=msg.toCharArray();
		List<Long> lst=new ArrayList<>(msgArray.length);
		for(char ch:msgArray){
			long num=encryptChar(publicKey,ch);
			lst.add(num);
		}
		return lst;
	}
	public static List<Long> getDummyPrimes(){
		List<Long> lst=new ArrayList<>();
		lst.add(16067L);
		lst.add(15973L);
		return lst;
	}
	public static long pollDummyPrime() {
		return 13L;
	}
	public static List<Long> generateKey(){
//		List<Long> primes=PrimeEngine.getPrimes(2);
		List<Long> primes=getDummyPrimes();
		long p=primes.get(0);
		long q=primes.get(1);
		System.out.println("p : "+p+" , q : "+q);
		long n=p*q;
		long phi=(p-1)*(q-1);
		long e=PrimeEngine.pollCoprime(phi);
//		long e=pollDummyPrime();
		long d=ModuloArithmetic.multiplicativeInverse(e, phi);
		List<Long> lst=new ArrayList<Long>();
		lst.add(e);
		lst.add(d);
		lst.add(n);
		lst.add(phi);
		return lst;
	}
	private static List<Long> generateDummyKey(){
		List<Long> lst=new ArrayList<Long>();
		lst.add(7L);
		lst.add(11L);
		lst.add(77L);
		lst.add(60L);
		return lst;
	}
	public static void main(String[] args) {
		List<Long> lst=RSA.generateKey();
//		List<Long> lst=RSA.generateDummyKey();
		while(lst.get(1) == -1) {
			lst=RSA.generateKey();
		}
//		for(long num:lst) {
//			System.out.print(num+" ");
//		}
		System.out.println();
		long e=lst.get(0);
		long d=lst.get(1);
		long n=lst.get(2);
		long phi=lst.get(3);
		long ans=ModuloArithmetic.modMul(e,d,phi);
		System.out.println("ans : "+ans);
		System.out.println("e : "+e);
		System.out.println("d : "+d);
		System.out.println("n : "+n);
		
		List<Long> publicKey=new ArrayList<>();
		publicKey.add(e);
		publicKey.add(n);
		
		List<Long> privateKey=new ArrayList<>();
		privateKey.add(d);
		privateKey.add(n);

		System.out.print("Private key : {");
		for(long num:privateKey) {
			System.out.print(num+" , ");
		}
		System.out.println(" }");
		
		System.out.print("Public key : {");
		for(long num:publicKey) {
			System.out.print(num+" , ");
		}
		System.out.println(" }");
		
//		long num=5;
//		System.out.println("num : "+num);
//		long encoded=encrypt(publicKey,num);
//		System.out.println("encoded : "+encoded);
//		long decoded=decrypt(privateKey,encoded);
//		System.out.println("decoded : "+decoded);
//
//
//		System.out.println("encdecrypt : "+decryptChar(privateKey,encryptChar(publicKey,'a')));

		String s="Shree Ganeshay Namah";
		List<Long> encoded=encryptString(publicKey,s);
		System.out.print("Encoded : ");
		for(long num:encoded) System.out.print(num+" ");System.out.println();
		String decoded=decryptString(privateKey,encoded);
		System.out.println("decoded : "+decoded);
	}
}
