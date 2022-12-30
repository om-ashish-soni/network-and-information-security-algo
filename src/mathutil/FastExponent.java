package mathutil;
import java.util.Collections;
import java.util.List;
import modmath.ModuloArithmetic;
import bitmasker.Bitset;

public class FastExponent {
	private static long squareAndMultiply(long a,long b,long mod) {
		List<Byte> bits=Bitset.toBinary(b);
		Collections.reverse(bits);
		long res=1;
		
		for(byte bit:bits) {
			res=ModuloArithmetic.modMul(res,res,mod);
			if(bit==1) {
				res=ModuloArithmetic.modMul(res, a, mod);
			}
		}
		
		return res;
	}
	public static long get(long a,long b,long mod) {
//		System.out.println("in long");
		long res=squareAndMultiply(a,b,mod);
		return res;
	}
	public static int get(int a,int b,int mod) {
//		System.out.println("in int");
		long res=squareAndMultiply((long)a,(long)b,(long)mod);
		int finalResult=(int)(res%mod);
		return finalResult;
	}
	public static void main(String[] args) {
		long res=FastExponent.get(26L, 37L, 77L);
		System.out.println(res);
	}
}
