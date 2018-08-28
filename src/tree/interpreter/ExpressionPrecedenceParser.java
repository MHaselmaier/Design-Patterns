package tree.interpreter;

import tree.binary.BinaryNode;
import tree.binary.INode;
import tree.binary.LeafNode;
import tree.utils.Tokenizer;

/**
 * Die Klasse <code>ExpressionPrecedenceParser</code> realisiert einen einfachen
 * Interpreter, der arithmetische Ausdrücke in eine Baumstruktur überführt
 *
 * Ausdrücke mit folgender Grammatik können verarbeitet werden
 *
 * <pre>
 * expr = term | term op expr
 * term = zahl | (expr)
 * zahl = [0-9]*
 * op   = + | - | * | /
 * </pre>
 *
 * Die Wertigkeit der Operatoren (Punkt vor Strichrechnung) wird berücksichtigt.
 * Bei den nicht-kommutativen Operatoren Minus(-) und Division(/) steht der
 * linke Operand im linken Kindkonten, der rechte im rechten Kindknoten.
 *
 * @see INode
 * @see Tokenizer
 *
 * @author Jörg Hettel
 */
public class ExpressionPrecedenceParser
{
  private String[] input;
  private int pos = -1; // Position des aktuellen Zeichens

  /**
   * Konstruktor
   *
   * @param input
   *          Der auszuwertende Ausdruck zerlegt in ein String-Array
   */
  public ExpressionPrecedenceParser(String[] input)
  {
    super();
    assert (input != null);
    this.input = input;
  }

  /**
   * Liefert den Syntaxbaum
   *
   * @return Syntaxbaum
   */
  public INode<String> getExpressionTree()
  {
    return this.readExpression(0);
  }

  private INode<String> readExpression(int prec)
  {
    // erstes Token muss ein Term sein
    INode<String> res = this.readTerm();

    while (true)
    {
      this.pos++; // nächstes Zeichen

      if (this.pos >= this.input.length) // ENDE (Eingabe wurde komplett
                                         // verarbeitet)
      {
        return res;
      }

      String operator = this.input[this.pos]; // Als nächstes Zeichen muss ein
                                              // Operator folgen

      int newPrec = this.getOperatorPrecedence(operator);

      // Prüfe "Punkt- vor Strichrechnung"
      if (newPrec <= prec)
      {
        // Teilauswertung wird abgeschlossen
        this.pos--; // Rücke ein Zeichen nach links (zurück), d.h. Operator wird "zurückgelegt"
        return res; // Teilbaum wird abgescglossen
      }
      else
      {
        // Neuer Teilauswertung (Teilbaum)
        INode<String> right = this.readExpression(newPrec);
        // Knoten entspricht: term op expr
        INode<String> binary = new BinaryNode<String>(operator, res, right);
        res = binary;
      }
    }
  }

  private INode<String> readTerm()
  {
    INode<String> res = null;

    this.pos++; // next token

    if (this.isDouble(input[this.pos])) // erster Fall: es ist eine Zahl
    {
      res = new LeafNode<String>(input[this.pos]);
    }
    else if (this.isAlgebraicSign(input[this.pos]))
    {
    	res = new LeafNode<String>(input[this.pos] + input[this.pos + 1]);
    	this.pos++; // advance position because of sign + number
    }
    else if (input[this.pos].equals("(")) // zweiter Fall: (expr)
    {
      res = this.readExpression(0); // Beginne neuen Teilbaum
      this.pos++;
      if (input[this.pos].equals(")") == false)
      {
        System.err.println("Unbalanced parantheses");
      }
    }
    else
    {
      System.err.println("Wrong token: " + input[this.pos]);
    }

    return res;
  }
  
  private boolean isDouble(String token)
  {
    try
    {
      Double.parseDouble(token);
      return true;
    }
    catch (NumberFormatException nfe)
    {
    }
    return false;
  }
  
  private boolean isAlgebraicSign(String token)
  {
	  switch(token)
	  {
	  case "+":
	  case "-":
		  return true;
	  default:
		  return false;
	  }
  }

  private int getOperatorPrecedence(String token)
  {
    if ((token == null) || (token.length() != 1))
      return 0;

    switch (token) {
    case "+":
    case "-":
      return 1;
    case "*":
    case "/":
      return 2;
    case "^":
    	return 3;
    default:
      return 0;
    }
  }
}
