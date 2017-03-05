public class tokken {
	public tokken(String str, String lex) {
		this.lexema = lex;
		this.str = str;
	}

	private String str;
	private String lexema;

	public String getStr() {
		return str;
	}

	public String getLexema() {
		return lexema;
	}

	public void print() {
		System.out.println("Word: " + str + "             Lexema: " + lexema);
	}
}
