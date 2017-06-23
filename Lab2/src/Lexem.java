import java.util.regex.Pattern;

public class Lexem {
	public Lexem(String name, Pattern p) {
		this.name = name;
		this.p = p;
	}

	private String name;
	private Pattern p;

	public String getName() {
		return name;
	}

	public Pattern getPattern() {
		return p;
	}

	public String toString() {
		return "Lexem: " + this.name;
	}

}
