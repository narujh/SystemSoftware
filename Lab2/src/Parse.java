
public class Parse {
	int i;
	public Parse()
	{
		System.out.println("\n\nParsing:\n");
		lang();
	}

	public void lang()	
	{
		expr();
	}
	
	public void expr()
	{
		for (i = 0; i < Main.tokenList.size(); i++)
		{
			switch (Main.tokenList.get(i).getLexema())
			{
			case "IF_KW": i++; IF_KW(); i--; break;
			case "WHILE_KW": i++; WHILE_KW(); i--; break;
			}
		}
			
		
	}
	
	public void WHILE_KW()
	{
		WHILE_COND();
		WHILE_BODY();
		EL();
	}

	public void WHILE_COND()
	{
		LB();
		VALUE();
		OPERATION();
		VALUE();
		RB();
	}
	
	public void WHILE_BODY()
	{
		VALUE();
		MATH();
		VALUE();
	}
	

	public void MATH()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("MATH")))
		{
			System.out.println("\nMust be math_op");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	public void IF_KW()
	{
		IF_COND();
		IF_BODY();	
		EL();
	}
	
	public void EL()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("EL")))
		{
			System.out.println("\nMust be ';'");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
		}
	}
	
	public void IF_BODY()
	{
		assign();
	}

	public void IF_COND()
	{
		LB();
		VALUE();
		OPERATION();
		VALUE();
		RB();
	}

	public void LB()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("LB")))
		{
			System.out.println("\nMust be left bracket");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
		
	}
	
	public void RB()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("RB")))
		{
			System.out.println("\nMust be right bracket");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
		
	}
	
	
	public void assign()
	{
		VAR_TYPE();
		VAR_NAME();
		ASSIGN_OP();
		VALUE();
	}
	

	public void VAR_TYPE()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("VAR_TYPE")))
		{
			System.out.println("\nMust be VAR_TYPE");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	public void VAR_NAME()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("VAR_NAME")))
		{
			System.out.println("\nMust be VAR_NAME");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk ");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	public void ASSIGN_OP()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("ASSIGN_OP")))
		{
			System.out.println("\nMust be ASSIGN_OP");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	public void VALUE()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("VAR_NAME")|Main.tokenList.get(i).getLexema().equals("DIGIT")))
		{
			System.out.println("\nMust be VAR_NAME or DIGIT");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	public void OPERATION()
	{
		if (!(Main.tokenList.get(i).getLexema().equals("OPERATIONS")))
		{
			System.out.println("\nMust be OPERATION");
			System.out.println(Main.tokenList.get(i).getLexema());
		}
		else
		{
			System.out.println("\nOk");
			System.out.println(Main.tokenList.get(i).getStr());
			i++;
		}
	}
	
	
	
}


