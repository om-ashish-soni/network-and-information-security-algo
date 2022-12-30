package modmath;
import mathutil.ExtendedEuclidean;

public class ModuloArithmetic {
	public static long modAdd(long a,long b,long mod) {
		return (a%mod + b%mod)%mod;
	}
	public static int modAdd(int a,int b,int mod) {
		return (a%mod + b%mod)%mod;
	}
	public static long modSub(long a,long b,long mod) {
		return (a%mod - b%mod + mod)%mod;
	}
	public static int modSub(int a,int b,int mod) {
		return ((a%mod - b%mod)+mod)%mod;
	}
	public static long modMul(long a,long b,long mod) {
		return ((long)((long)a%mod)*((long)b%mod))%mod;
	}
	public static int modMul(int a,int b,int mod) {
		return (int)modMul((long)a,(long)b,mod);
	}
	public static long multiplicativeInverse(long a,long mod) {
		return ExtendedEuclidean.multiplicativeInverse(a, mod);
	}
	public static int multiplicativeInverse(int a,int mod) {
		return (int)multiplicativeInverse((long)a, (long)mod);
	}
	public static long modPositive(long a,long mod) {
		long rem=a%mod;
		long ans=modSub(rem,0,mod);
		return ans;
	}
	public static int modPositive(int a,int mod) {
		return (int)modPositive((long)(a),(long)(mod));
	}
	public static void main(String[] args) {
		long a=-8;
		long mod=5;
		long ans=modPositive(a,mod);
		System.out.println(ans);
	}
}
