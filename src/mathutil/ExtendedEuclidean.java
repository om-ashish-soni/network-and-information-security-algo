package mathutil;

import java.util.Scanner;
public class ExtendedEuclidean {

	public static int[] extendedGcd(int a,int b) {
		int r,r1,r2,s1,s2,s,t1,t2,t;
		r1=a;
		r2=b;
		s1=1;
		s2=0;
		t1=0;
		t2=1;
		while(r2 != 0) {
			int q=r1/r2;
			r=r1-q*r2;
			r1=r2;
			r2=r;
			
			s=s1-q*s2;
			s1=s2;
			s2=s;
			
			t=t1-q*t2;
			t1=t2;
			t2=t;
		}
		r=r1;
		s=s1;
		t=t1;
		return new int[] {s,t,r};
	}
	public static int multiplicativeInverse(int a,int mod) {
		a=(a+mod)%mod;
		
		int[] ans=extendedGcd(mod,a);
		int s=ans[0];
		int t=ans[1];
		int r=ans[2];
		int gcd=mod*s + a*t;
//		System.out.println(s+" , "+t+" , "+r);
//		System.out.println(gcd+" vs "+r);
		t=(t+mod)%mod;
		if(gcd == 1) return t;
		return -1;
	}
	public static long[] extendedGcd(long a,long b) {
		long r,r1,r2,s1,s2,s,t1,t2,t;
		r1=a;
		r2=b;
		s1=1;
		s2=0;
		t1=0;
		t2=1;
		while(r2 != 0) {
			long q=r1/r2;
			r=r1-q*r2;
			r1=r2;
			r2=r;
			
			s=s1-q*s2;
			s1=s2;
			s2=s;
			
			t=t1-q*t2;
			t1=t2;
			t2=t;
		}
		r=r1;
		s=s1;
		t=t1;
		return new long[] {s,t,r};
	}
	public static long multiplicativeInverse(long a,long mod) {
		a=(a+mod)%mod;
		
		long[] ans=extendedGcd(mod,a);
		long s=ans[0];
		long t=ans[1];
		long r=ans[2];
		long gcd=mod*s + a*t;
//		System.out.println(s+" , "+t+" , "+r);
//		System.out.println(gcd+" vs "+r);
		t=(t+mod)%mod;
		if(gcd == 1) return t;
		return -1;
	}
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int a=26;
		int b=5;
		int[] ans=extendedGcd(a,b);
		int s=ans[0];
		int t=ans[1];
		int r=ans[2];
		int gcd=(a*s + b*t);
//		System.out.println("a : "+a+" , b : "+b);
//		System.out.println("s : "+s+" , t : "+t+" , r : "+r);
//		System.out.println("gcd("+a+","+b+") = "+gcd);
		
		
		final int mod=26;
		int num=-1;
		int inv=-1;
		while(inv == -1){
			System.out.print("enter a number : ");
			num=scanner.nextInt();
			inv=multiplicativeInverse(num,mod);
			if(inv == -1) {
				System.out.println("Multiplicative inverse does not exist for "+num+" with respect to "+mod+"\n please enter another number");
			}
		}
		System.out.println("inverse of "+num+" mod "+mod+" = "+inv);
		
	}
}
