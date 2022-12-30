package random;
import java.util.Random;
import modmath.ModuloArithmetic;  
public class RandomEngine {
	public static long generate() {
		return new Random().nextLong();
	}
	public static long get(long l,long r) {
		long window=(r-l+1);
		long num=generate();
		num=num%window;
		num=ModuloArithmetic.modPositive(num,window);
		num=num+l;
		return num;
	}
	
	public static long get() {
		long num=generate();
		return Math.max(num, -num);
	}
	public static long get(long l) {
		long num=get();
		if(num<l) num+=l;
		return num;
	}
	public static long getOdd(){
		long num=get();
		if((num&1L) > 0) return num;
		return (num|1L);
	}
	public static void main(String[] args) {
		System.out.println("Random odd number : "+getOdd()+" , "+get());
	}
	
	
}
