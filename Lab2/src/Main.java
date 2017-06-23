import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
	public static List<Lexem> lexems = new ArrayList<Lexem>();
	public static List<Token> tokenList = new ArrayList<Token>();

	public static void main(String[] args) throws IOException
	{
		Source.Init();

        File f = new File("qwe.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;
        while ((line = fin.readLine()) != null) 
        	{
        	System.out.println(line);

    		Source.targetFunc(line);
        	}
        
        
		int i = 0;
		for (Token l : tokenList) {
			System.out.println("\n" + (i++) + ":");
			l.print();
			System.out.println("\n");
		}
		new Parse();
		
		new Interpreter();
        fin.close();
		
	}

}
