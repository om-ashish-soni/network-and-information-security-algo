package mathutil;

import java.util.ArrayList;
import java.util.List;

import random.RandomEngine;

public class PrimeEngine {
	static int iters=100;
	public static boolean fermatTest(long num) {
		if(num==2 || num==3) return true;
		if(num<=4) return false;
		while(iters-- > 0) {
			long key=RandomEngine.get(2L,num-2L);
			long expo=FastExponent.get(key, num-1, num);
			if(expo != 1) return false;
		}
		return true;
	}
	public static boolean fermatTest(int num) {
		return fermatTest((long)(num));
	}
	public static long pollPrime() {
		int left=(int)(1e3+7);
		int right=(int)(2e3+7);
		long random=RandomEngine.get(left,right);
		if(random%2==0) random++;
		boolean result=fermatTest(random);
		while(result==false) {
			random=RandomEngine.get(left,right);
			result=fermatTest(random);
		}
		return random;
	}
	public static long pollCoprime(long n){
		if(n==1){
			return 2;
		}
		if(n==2){
			return 3;
		}
		long num=-1;
		long hcf=1;
		do{
			num=RandomEngine.get(2,n-1);
			long [] extGcd=ExtendedEuclidean.extendedGcd(num,n);
			hcf=extGcd[2];
		}while(hcf != 1);
		return num;
	}
	public static List<Long> getPrimes(int n){
		List<Long> primeList=new ArrayList<>();
		for(int i=0;i<n;i++) {
			primeList.add(pollPrime());
		}
		return primeList;
	}
	public static void main(String[] args) {
		System.out.println("random : "+pollCoprime(100L));
	}
}
