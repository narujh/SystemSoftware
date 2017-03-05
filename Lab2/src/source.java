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

	/*
	 * public static void findLexems(String input) { String[] words =
	 * input.split(" "); for (Lexer l : lexems) { for (int i = 0; i <
	 * words.length; i++) { Pattern pat = l.getPattern(); Matcher m =
	 * pat.matcher(words[i]); if (m.find()) { System.out.println(i + ") " +
	 * l.toString() + "     Word: " + words[i]); } } } }
	 * 
	 * public static void findPriority(String input) { String[] words =
	 * input.split(" "); for (int i = 0; i < words.length; i++) { for (Lexer l :
	 * lexems) { Pattern pat = l.getPattern(); Matcher m =
	 * pat.matcher(words[i]); if (l.getPriority() == 0) { if (m.matches()) {
	 * System.out.println(i + ") " + l.toString() + "     Word: " + words[i]);
	 * break; } }
	 * 
	 * else { if (m.matches()) { System.out.println(i + ") " + l.toString() +
	 * "     Word: " + words[i]); } } } } }
	 */

	public static void targetFunc(String input) {
		System.out.println("Input:\n \"" + newStr + "\"\n");
		String buffer = "";
		String tmp = "";
		int j = 0;
		for (int i = 0; i < input.length(); i++) {
			while ((input.charAt(j) != ' ') && (input.charAt(j) != ';')) {
				buffer = input.substring(i, j);
				if (input.charAt(i) == '(') {
					buffer = input.substring(i++, j);
				}
				if (input.charAt(j) == ')') {
					tmp = buffer;
					buffer = tmp.substring(0, tmp.length() - 1);
					if (buffer.length() == 0) {
						j++;
						continue;
					}
				}
				j++;
				for (Lexer l : Main.lexems) {
					Pattern pat = l.getPattern();
					Matcher m = pat.matcher(input.substring(i, j));
					if (m.matches()) {
						Main.tokkenList.add(new tokken(input.substring(i, j), l
								.getName()));
						break;
					}
				}
			}

			j++;
			i = j - 1;

			/*
			 * for (int j = 0; j < input.length(); j++) { if ((input.charAt(j)
			 * != ' ')&&(input.charAt(j) != '\n')) { buffer = input.substring(i,
			 * j); } else { for (Lexer l : Main.lexems) { Pattern pat =
			 * l.getPattern(); Matcher m = pat.matcher(buffer); if (m.matches())
			 * { System.out.println(buffer); Main.tokkenList.add(new
			 * tokken(buffer, l.getName())); break; } } i = j + 1; j = 0 ; } }
			 */
		}
	}
}