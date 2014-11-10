/*************************************************************************
 *  Compilation:  javac UnicodeTest.java
 *  Execution:    java  UnicodeTest
 *
 *  This programs prints out all of the Unicode characters in the basic
 *  multilingual plane (U+0000 to U+FFFF) in a table. It skips the
 *  following types of characters:
 *    -  undefined
 *    -  control characters
 *    -  modifier symbols
 *    -  non-spacing marks
 *    -  Unicode formatting commands
 *    -  reserved for surrogate pairs
 *    -  reserved for private use
 *
 *
 *  % java UnicodeTest
 *  U+0020      !  "  #  $  %  &  '  (  )  *  +  ,  -  .  /  
 *  U+0030   0  1  2  3  4  5  6  7  8  9  :  ;  <  =  >  ?  
 *  U+0040   @  A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  
 *  U+0050   P  Q  R  S  T  U  V  W  X  Y  Z  [  \  ]     _  
 *  U+0060      a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  
 *  U+0070   p  q  r  s  t  u  v  w  x  y  z  {  |  }  ~     
 *  U+00A0      ¡  ¢  £  ¤  ¥  ¦  §     ©  ª  «  ¬     ®     
 *  U+00B0   °  ±  ²  ³     µ  ¶  ·     ¹  º  »  ¼  ½  ¾  ¿  
 *  U+00C0   À  Á  Â  Ã  Ä  Å  Æ  Ç  È  É  Ê  Ë  Ì  Í  Î  Ï  
 *  U+00D0   Ð  Ñ  Ò  Ó  Ô  Õ  Ö  ×  Ø  Ù  Ú  Û  Ü  Ý  Þ  ß  
 *  U+00E0   à  á  â  ã  ä  å  æ  ç  è  é  ê  ë  ì  í  î  ï  
 *  U+00F0   ð  ñ  ò  ó  ô  õ  ö  ÷  ø  ù  ú  û  ü  ý  þ  ÿ 
 *  U+0100   Ā  ā  Ă  ă  Ą  ą  Ć  ć  Ĉ  ĉ  Ċ  ċ  Č  č  Ď  ď
 *  ...
 *
 *  Depending on your system setup and font, not all of the Unicode
 *  characters may display properly.
 *
 *  Quirks: when printing certain Hebrew or Arabic characters, the
 *  table may print right-to-left instead of left-to-right.
 *
 *  For a description of Unicode terminology, see:
 *  http://docs.oracle.com/javase/tutorial/i18n/text/terminology.html
 *
 *  For the Character API, see:
 *  http://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 *  To see what each Unicode character should look like, see:
 *  http://www.fileformat.info/info/unicode/index.htm
 *  http://www.fileformat.info/info/unicode/char/05D0/index.htm
 *
 *
 *************************************************************************/


public class UnicodeTest {
    // number of Unicode characters to display per line
    private final static int CHARS_PER_LINE = 16;

    // number of Unicode characters to display (basic multilingual plane)
    private final static int MAX_CHAR = 65536;

    // Returns a string representation of the given codePoint, or a single
    // space if the codePoint should not be suppressed when printing.
    public static String toString(int codePoint) {
       if (!Character.isDefined(codePoint))             return " ";
       if (Character.isISOControl(codePoint))           return " ";
       if (Character.isWhitespace(codePoint))           return " ";
    // if (Character.isSurrogate(codePoint)             return " ";   // Java 1.7+ only
       if (Character.isLowSurrogate((char) codePoint))  return " ";   // Java 1.5+
       if (Character.isHighSurrogate((char) codePoint)) return " ";   // Java 1.5+

       switch(Character.getType(codePoint)) {
           case Character.MODIFIER_SYMBOL:              return " ";
           case Character.CONTROL:                      return " ";
           case Character.MODIFIER_LETTER:              return " ";
           case Character.NON_SPACING_MARK:             return " ";
           case Character.FORMAT:                       return " ";
           case Character.PRIVATE_USE:                  return " ";
           default: return new String(Character.toChars(codePoint));
       }
    }

    public static void main(String[] args) {
        for (int line = 0; line < 2*Character.MAX_VALUE / CHARS_PER_LINE; line++) {
            String output = "";
            for (int i = 0; i < CHARS_PER_LINE; i++) {
                int codePoint = CHARS_PER_LINE*line + i;
                output += toString(codePoint) + "  ";
            }
            if (!output.trim().equals("")) {
                // U+202D is the Unicode override to force left-to-right direction
                // but doesn't seem to work with Unix more
                StdOut.printf("U+%04X   %s\n", 16*line, output);
            }
        }
    }
}
