import java.util.ArrayList;
import java.util.List;

public class Interpreter {
	public static List<Token> buffer = new ArrayList<Token>();
	public static List<Token> buffer1 = new ArrayList<Token>();
	public static List<Token> buffer2 = new ArrayList<Token>();
	public static List<String> rpn = new ArrayList<String>();
	public static List<Integer> labels = new ArrayList<>();

	public Interpreter() {
		func();
		for (String l : rpn) {
			System.out.println(l);
		}
	}

	public List<String> func() {
		for (int i = 0; i < Main.tokenList.size(); ++i) {
			if (Main.tokenList.get(i).getLexema() == "IF_KW" | Main.tokenList.get(i).getLexema() == "WHILE_KW") {
				buffer2.add(Main.tokenList.get(i));
			} else {
				if (Main.tokenList.get(i).getLexema() == "LB") {
					buffer1.add(Main.tokenList.get(i));
				} else {
					if (Main.tokenList.get(i).getLexema() == "DIGIT" | Main.tokenList.get(i).getLexema() == "VAR_NAME"
							| Main.tokenList.get(i).getLexema() == "VAR_TYPE") {
						rpn.add(Main.tokenList.get(i).getStr());
					} else {
						if (buffer.isEmpty() & Main.tokenList.get(i).getStr() != "="
								& Main.tokenList.get(i).getStr() != ";" & Main.tokenList.get(i).getStr() != "end") {
							buffer.add(Main.tokenList.get(i));
						} else {
							if (Main.tokenList.get(i).getStr() == "+" | Main.tokenList.get(i).getStr() == "-"
									| Main.tokenList.get(i).getStr() == ">" | Main.tokenList.get(i).getStr() == "<"
									| Main.tokenList.get(i).getStr() == "==" | Main.tokenList.get(i).getStr() == "!="
									| Main.tokenList.get(i).getStr() == "<=" | Main.tokenList.get(i).getStr() == ">=") {
								while (!buffer.isEmpty()) {
									if (buffer.get(buffer.size() - 1).getLexema() == "MATH"
											| buffer.get(buffer.size() - 1).getLexema() == "OPERATIONS") {
										rpn.add(buffer.get(buffer.size() - 1).getStr());
										buffer.remove(buffer.size() - 1);
									} else
										break;
								}
								buffer.add(Main.tokenList.get(i));
							}
							if (Main.tokenList.get(i).getStr() == "*" | Main.tokenList.get(i).getStr() == "/") {
								if (buffer.get(buffer.size() - 1).getStr() == "*"
										|| buffer.get(buffer.size() - 1).getStr() == "/") {
									rpn.add(buffer.get(buffer.size() - 1).getStr());
									buffer.remove(buffer.size() - 1);
								} else {
									buffer.add(Main.tokenList.get(i));
								}
							}
							if (Main.tokenList.get(i).getStr() == ")") {
								while (buffer.get(buffer.size() - 1).getStr() != "(") {
									rpn.add(buffer.get(buffer.size() - 1).getStr());
									buffer.remove(buffer.get(buffer.size() - 1));
								}
								if (buffer.get(buffer.size() - 1).getStr() == "(") {
									buffer.remove(buffer.get(buffer.size() - 1));
								}
								if (buffer2.get(buffer.size() - 1).getStr() == "if" & buffer2.size() > labels.size()) {
									labels.add(rpn.size());
									rpn.add("void_label");
									rpn.add("!F");
								}
								if (!buffer1.isEmpty() & buffer1.get(buffer1.size() - 1).getStr() != "{") {
									buffer1.remove(buffer1.size() - 1);
								}
							}
							if (Main.tokenList.get(i).getStr() == "(")
							{
								buffer.add(Main.tokenList.get(i));
							}
							if (Main.tokenList.get(i).getStr() == "=")
							{
								buffer1.add(Main.tokenList.get(i));
							}
							if (Main.tokenList.get(i).getStr() == ";")
							{
								while (!buffer.isEmpty() & buffer.get(buffer.size()-1).getStr() != "(")
								{
									rpn.add(buffer.get(buffer.size()-1).getStr());
									buffer.remove(buffer.size()-1);
								}								
							}
							if (Main.tokenList.get(i).getStr() == "end") {
								while (!buffer.isEmpty()) {
									rpn.add(buffer.get(buffer.size() - 1).getStr());
									buffer.remove(buffer.size() - 1);
								}
								while (!buffer2.isEmpty()) {
									if (buffer2.get(buffer.size() - 1).getLexema() == "IF_KW") {
										rpn.add(labels.get(labels.size() - 1), "@" + rpn.size() + 1);
										labels.remove(labels.size() - 1);
										buffer2.remove(buffer2.size() - 1);
									}
								}
							}
						}
					}
				}
			}
		}
		return rpn;
	}
}
