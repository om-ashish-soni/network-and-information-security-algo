
public class UI {
	public static void printLine(char c,int n) {
		for(int i=0;i<n;i++) System.out.print(c);
		System.out.println();
	}
	public static void printLine(char c) {
		printLine(c,50);
	}
	public static void printLine() {
		printLine('=');
	}
}
