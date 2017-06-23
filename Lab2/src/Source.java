import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Source {

	public static void Init() {
		Main.lexems.add(new Lexem("FOR_KW", Pattern
				.compile("^for$")));
		Main.lexems.add(new Lexem("WHILE_KW", Pattern
				.compile("^while$")));
		Main.lexems.add(new Lexem("IF_KW", Pattern
				.compile("^if$")));
		Main.lexems.add(new Lexem("VAR_TYPE", Pattern
				.compile("^(int|bool|double|char)$")));
		Main.lexems.add(new Lexem("DIGIT",
				Pattern.compile("^(0|[1-9][0-9]*)$")));
		Main.lexems.add(new Lexem("OPERATIONS", Pattern
				.compile("^(==|>|<|<=|>=')$")));
		Main.lexems.add(new Lexem("MATH", Pattern
				.compile("^(-|\\+|\\*|\\/')$")));
		Main.lexems.add(new Lexem("ASSIGN_OP", Pattern
				.compile("^=$")));
		Main.lexems.add(new Lexem("VAR_NAME", Pattern
				.compile("^([a-z][a-z0-9]*)$")));
		Main.lexems.add(new Lexem("LB", Pattern
				.compile("^\\($")));
		Main.lexems.add(new Lexem("RB", Pattern
				.compile("^\\)$")));
		Main.lexems.add(new Lexem("EL", Pattern
				.compile("^;$")));
	}

	static String newStr = "if ( o == 10 ) char z = i ; while ( count <= 21 ) i + 1 ;  ";
	
	public static void targetFunc(String input) {
		System.out.println("Input:\n \"" + newStr + "\"\n");
		String currentWord = "";
		Lexem found = null;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i ; j < input.length(); j++)
			{
				currentWord = input.substring(i, j);
				System.out.println(currentWord);
				Lexem newFind = findLexems(currentWord);
				if (newFind == null){
					if (found != null)				
					{
						Main.tokenList.add(new Token(currentWord.substring(0,currentWord.length()-1), found.getName()));
						System.out.println(found.getName());
						found = null;
					}
					i = j;
				}
				found = newFind;
			}
		}
	}
	
	static Lexem findLexems(String input)
	{
		for (Lexem l : Main.lexems)
		{
			Pattern pat = l.getPattern();
			Matcher m = pat.matcher(input);
			if (m.matches()) {
				return l;
			}
			
		}
		return null;
	}
	
}

