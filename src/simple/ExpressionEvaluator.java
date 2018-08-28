package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.binary.INode;
import tree.utils.Tokenizer;

/**
 * Die Klasse <code>ExpressionEvaluator</code> realisiert einen
 * einfachen Interpreter, der arithmetische Ausdrücke auswertet.
 * 
 * Ausgangspunkt ist der Ausdruck, dessen Einzelteilen (Tokens) in eine
 * Liste abgelegt werden. Danach werden sukzessive die Operatoren angewendet
 * und die verbrauchten Elemente aus der Liste eliminiert. Dies wird solange gemacht,
 * bis das Ergebnis vorliegt. 
 * <p/>
 * Verwendungsbeispiel: <br/>
 * <pre>
 *   String   expr   = "4 + 2*(7-1)"; 
 *   String[] tokens = Tokenizer.tokenize(expr);
 *   double   value  = ExpressionEvaluator.getValue(tokens);
 * </pre>
 * 
 * @see INode
 * @see Tokenizer
 * 
 * @author Jörg Hettel
 */
public class ExpressionEvaluator 
{
	private ExpressionEvaluator() 
	{
		super();
	}
	

	/**
	 * Liefert den Wert eines arithmetischen Ausdrucks. Zulässige Operatoren sind
	 * +,-,*,/ und Klammern ( ).
	 * 
	 * @param tokens Der auszuwertende Ausdruck zerlegt in ein String-Array
	 * @return Ergebnis
	 */
	public static double getValue(String[] tokens)
	{
	  List<String> exprTokens = new ArrayList<>();
	  for( String s : tokens )
	  {
	    exprTokens.add(s);
	  }
	  
	  List<String> res = evaluate(exprTokens);
	  return Double.parseDouble( res.get(0) );
	}
	
	private static List<String> evaluate(List<String> exprTokens)
	{
	  // ----------------------------------------------
    // Liste enthält nur noch ein Element
	  // Der Inhalt entspricht dem Ergebnis
	  // Der Fall wird benötigt, falls nur eine Zahl eingegeben wird
    // ----------------------------------------------
		if( exprTokens.size() == 1 )
		{
			List<String> res = new LinkedList<>();
			res.add(exprTokens.get(0));
			return res;
		}
		
	  
		if( exprTokens.size() < 2 )
		{
			System.err.println("Zu wenig Zeichen");
			throw new RuntimeException("Falsches Format");
		}
		
		// ----------------------------------------------
	    // Liste enthält nur noch zwei Elemente
		// Format: Vorzeichen Zahl
	    // ----------------------------------------------
		if( exprTokens.size() == 2 )
		{
			String operator = exprTokens.get(0);
			if( !operator.equals("-") && !operator.equals("+") )
			{
			  throw new RuntimeException("Falsches Format");
			}
			
			List<String> res = new LinkedList<String>();
			res.add(operator + exprTokens.get(1));
			return res;
		}
		
	  // ----------------------------------------------
    // Liste enthält nur noch drei Elemente
		// Format: Zahl operator Zahl
    // ----------------------------------------------
		if( exprTokens.size() == 3 )
		{
			double a = Double.parseDouble( exprTokens.get(0) );
			double b = Double.parseDouble( exprTokens.get(2) );
			
			double value = 0;
			String operator = exprTokens.get(1);
			if ( operator.equals("^") )
			{
				value = Math.pow(a, b);
			}
			else if( operator.equals("*") )
			{
				value = a*b;
			}
			else if( operator.equals("/") )
			{
				value = a/b;
			}
			else if( operator.equals("-") )
			{
				value = a-b;
			}
			else if( operator.equals("+") )
			{
				value = a+b;
			}
			else
			{
			  throw new RuntimeException("Falsches Format");
			}
			
			List<String> res = new LinkedList<String>();
			res.add(String.valueOf(value));
			return res;
		}
		
		// ----------------------------------------------
		// Jetzt werden alle Klammern ausgewertet und die
		// entsprechende Teilliste durch den ermittelten 
		// Wert erstetzt
	  // ----------------------------------------------
		if( exprTokens.contains("(") )
		{
			int startPos = exprTokens.indexOf("(");
			int endPos = -1;
			int count = 0;
			
			// Suche zugehörige schließende Klammer
			for( int i = startPos+1; i < exprTokens.size(); i++ )
			{
				if( exprTokens.get(i).equals(")") && count == 0 )
				{
					endPos = i;
					break;
				}
				else if( exprTokens.get(i).equals("(") )
				{
					count++;
				}
				else if( exprTokens.get(i).equals(")") )
				{
					count--;
				}
			} // End Klammersuche
			
			
			// Erzeuge neue Liste: newList
			// Kopiere Inhalt bis zur öffnenden Klammer
			List<String>  newList = new LinkedList<>();
			for( int i=0; i < startPos; i++ )
			{
				newList.add( exprTokens.get(i) );
			}
			
			// Rekursive Auswertung des Klammerinhalts
			// Ergebnis wird in newList eingefügt
			newList.addAll( evaluate(exprTokens.subList(startPos+1,endPos) ) );
			
		  // Kopiere den Inhalt, der nach der schließenden Klammer steht
			for(int i = endPos+1; i < exprTokens.size(); i++ )
			{
				newList.add( exprTokens.get(i) );
			}
			
			// Suche nach weiteren Klammern
			return evaluate( newList );
		} // End Klammer-Evaluation
		
	  // ----------------------------------------------
    // Jetzt sind keine Klammern mehr vorhanden
		// Es wird nun nach dem Verfahren "Punkt vor Strichrechnung"
		// weiter (rekursiv) vorgegangen.
		// Verarbeitung erfolgt von rechts nach links.
    // ----------------------------------------------
		
		
		// Vorzeichen werden hier behandelt:
		
		List<String> newList = new LinkedList<>();
		int start = 1;
		if (!isDouble(exprTokens.get(0)))
		{
			newList.add(exprTokens.get(0) + exprTokens.get(1));
			start++;
		}
		else
		{
			newList.add(exprTokens.get(0));
		}
		for (int i = start; exprTokens.size() > i; ++i)
		{
			if (exprTokens.size() - 1 != i)
			{
				String current = exprTokens.get(i);
				String next = exprTokens.get(i + 1);
				
				newList.add(current);
				if (!isDouble(current) && !isDouble(next))
				{
					newList.add(next + exprTokens.get(i + 2));
					i += 2;
				}
			}
			else
			{
				newList.add(exprTokens.get(i));
			}
		}
		exprTokens = newList;
		
		// Vorzeichen Ende
		
		List<String> left = null, right = null;
		newList = new LinkedList<>();
		int pos = 0;
		
		// Suche Operattoren:
		// Zuerst Strichrechnung (+,-), dann Punktrechnung (*,/)
		if( exprTokens.contains("+") )
		{
			pos = exprTokens.lastIndexOf("+");
		} 
		else if( exprTokens.contains("-") )
		{
			pos = exprTokens.lastIndexOf("-");
		} 
		else if( exprTokens.contains("*") )
		{
			pos = exprTokens.lastIndexOf("*");	
		} 
		else if( exprTokens.contains("/") )
		{
			pos = exprTokens.lastIndexOf("/");
		}
		else if( exprTokens.contains("^") )
		{
			pos = exprTokens.lastIndexOf("^");
		}
		else
		{
			throw new RuntimeException("Falsches Format");
		}
		
		// Schneide linken Teil der Liste aus
		// (Bem.: Es wird nur ein Fenster auf die Liste gesetzt!)
		left = exprTokens.subList(0, pos );		
		// Evaluiere diesen Teil und füge Ergebnis newList hinzu
		if( left.size() >  1)
		{
			newList.addAll( evaluate(left) ); // rekursiver Aufruf
		}
		else
		{
			newList.addAll(left);
		}
		
		// Füge Operator zu newList hinzu
		newList.add( exprTokens.get(pos) );
		
	  // Schneide rechten Teil der Liste aus
    // (Bem.: Es wird nur ein Fenster auf die Liste gesetzt!)
		right  = exprTokens.subList(pos+1, exprTokens.size() );
	  // Evaluiere diesen Teil und füge Ergebnis newList hinzu
		if( right.size() >  1)
		{
			newList.addAll( evaluate(right) );  // rekursiver Aufruf
		}
		else
		{
			newList.addAll(right);
		}
		
	  // rekursiver Aufruf mit dem Inhalt, der noch bleibt
		return evaluate( newList );
	}
	
	private static boolean isDouble(String token)
	{
		try
		{
			Double.parseDouble(token);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
