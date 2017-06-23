import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class source {

	public static void Init() {
		Main.lexems.add(new Lexer("OPERATORS", Pattern
				.compile("^(for|while|if)$"), 0));
		Main.lexems.add(new Lexer("VAR_TYPE", Pattern
				.compile("^(int|bool|double|char)$"), 0));
		Main.lexems.add(new Lexer("DIGIT",
				Pattern.compile("^(0|[1-9][0-9]*)$"), 1));
		Main.lexems.add(new Lexer("OPERATIONS", Pattern
				.compile("^(==|-|\\+|>|<|\\*|\\/|=|<=|')$"), 0));
		Main.lexems.add(new Lexer("VAR_NAME", Pattern
				.compile("^([a-z][a-z0-9]*)$"), 1));
	}

	static String newStr = "if (int i == 10) char z = ' i '; while (count <= 21);";
	
	public static void targetFunc(String input) {
		System.out.println("Input:\n \"" + newStr + "\"\n");
		String currentWord = "";
		Lexer found = null;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i+1 ; j < input.length(); j++)
			{
				currentWord = input.substring(i, j);
				System.out.println(currentWord);
				Lexer newFind = findLexems(currentWord);
				if (newFind == null){
					if (found != null)				
					{
						Main.tokkenList.add(new tokken(currentWord.substring(0,currentWord.length()-1), found.getName()));
						System.out.println(found.getName());
						found = null;
					}
					i = j;
				}
				found = newFind;
			}
		}
	}
	static Lexer findLexems(String input)
	{
		for (Lexer l : Main.lexems)
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

