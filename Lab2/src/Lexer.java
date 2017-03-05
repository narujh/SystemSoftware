import java.util.regex.Pattern;

public class Lexer {
	public Lexer(String name, Pattern p, int priority) {
		this.name = name;
		this.p = p;
		this.priority = priority;
	}

	private String name;
	private Pattern p;
	private int priority;

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public Pattern getPattern() {
		return p;
	}

	public String toString() {
		return "Lexem: " + this.name;
	}

}
