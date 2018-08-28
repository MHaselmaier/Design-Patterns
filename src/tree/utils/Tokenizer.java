package tree.utils;

/**
 * Hilfklasse, die verschiedene Methoden bereit stellt.
 * 
 * @author Hettel
 *
 */
public final class Tokenizer
{

  // Es dürfen keine Objekte erzeugt werden
  private Tokenizer()
  {
    super();
  }

  /**
   * Zerlegt einen arithmetischen Ausdrick in Einzelteile (Tokens). Berücksichtigt werden die
   * Operatoren +,-,*,/,^ und Klammern ( ). Tokens entsprechen Zahlen, Operatoren oder Klammern.
   * 
   * @param str arithemtischer Ausdruck
   * @return String-Array mit einzelteilen
   */
  public static String[] tokenize(String str)
  {
    StringBuilder strBuilder = new StringBuilder();

    if ((str != null) && (str.length() > 0))
    {
      for (int i = 0; i < str.length(); i++)
      {
        char c = str.charAt(i);
        // Füge vor und nach jedem Operator und
        // vor und nach jedem Klammerzeichen ein Leerzeichen ein
        if ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '(') || (c == ')') || (c == '^'))
        {
          strBuilder.append(' ');
          strBuilder.append(c);
          strBuilder.append(' ');
        }
        else
        {
          strBuilder.append(c);
        }
      }
    }

    // Zerlege den String in einzelne Zeichen
    return strBuilder.toString().trim().split("\\s+");
  }

}
