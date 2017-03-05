import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Lexer> lexems = new ArrayList<Lexer>();
	public static List<tokken> tokkenList = new ArrayList<tokken>();

	public static void main(String[] args) {
		source.Init();
		int i = 0;
		source.targetFunc(source.newStr);
		for (tokken l : tokkenList) {
			System.out.println("\n" + (i++) + ":");
			l.print();
		}
	}

}
