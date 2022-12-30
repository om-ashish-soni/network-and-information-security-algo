package bitmasker;

import java.util.List;
import java.util.ArrayList;

public class Bitset {
	
	public static List<Byte> toBinary(long a) {
		List<Byte> bits=new ArrayList<>();
		while(a>0) {
			byte bit=(byte) (a&1);
			bits.add(bit);
			a>>=1;
		}
		return bits;
	}
	public static List<Byte> toBinary(int a) {
		return toBinary((long)a);
	}
}
