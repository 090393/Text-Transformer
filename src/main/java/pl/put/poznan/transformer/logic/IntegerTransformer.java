package pl.put.poznan.transformer.logic;
import java.lang.*;

/**
 * Klasa służąca do zamiany zdania wejściowego w taki sposób,
 * aby na wyjściu pojawiło się to samo zdanie w odwróconej kolejności
 * i z zachowaniem wielkości liter na danym miejscu.
 * @author Rollo
 */
public class InverseTransformer extends TextTransformerDecorator{

    public InverseTransformer(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){
        return super.transform(inverse(text));
    }

    /**
     * Metoda służąca do odwracania ciągu znaków z zachowaniem wielkości liter
     * @param text tekst do zamiany
     * @return odwrócony tekst z zachowaniem kolejności wielkich liter
     */
    public String inverse(String text){
        boolean[] upper = new boolean[text.length()];

        for (int i =0; i<text.length();i++)
        {
            if(text.charAt(i)>='A' && text.charAt(i)<= 'Z')
            {
                upper[i] = true;
            }
            else
            {
                upper[i] = false;
            }
        }
        String result = "";
        for(int i = text.length()-1; i>=0;i--)
        {
            result += text.charAt(i);
        }
        String result1 = "";
        for(int i=0 ; i < text.length();i++)
        {
            if(upper[i]== true)
            {
                result1 += Character.toUpperCase(result.charAt(i));
            }
            else
            {
                result1+= Character.toLowerCase(result.charAt(i));
            }
        }
        return result1;
    }
}
