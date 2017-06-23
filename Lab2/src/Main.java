import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Lexem> lexems = new ArrayList<Lexem>();
	public static List<Token> tokenList = new ArrayList<Token>();

	public static void main(String[] args) {
		Source.Init();
		int i = 0;
		Source.targetFunc(Source.newStr);
		for (Token l : tokenList) {
			System.out.println("\n" + (i++) + ":");
			l.print();
			System.out.println("\n");
		}
		new Parse();
		
	}

}
