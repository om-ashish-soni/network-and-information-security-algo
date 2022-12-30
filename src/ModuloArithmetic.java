
public class ModuloArithmetic {
	public static int modAdd(int a,int b,int mod) {
		return (a%mod + b%mod)%mod;
	}
	public static int modSub(int a,int b,int mod) {
		return ((a%mod - b%mod)+mod)%mod;
	}
	public static int modMul(int a,int b,int mod) {
		return ((a%mod)*(b%mod))%mod;
	}
	public static int multiplicativeInverse(int a,int mod) {
		return ExtendedEuclidean.multiplicativeInverse(a, mod);
	}
}
