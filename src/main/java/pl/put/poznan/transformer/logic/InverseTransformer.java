package pl.put.poznan.transformer.logic;
import java.lang.*;

/**
 * Klasa sluzaca do zamiany zdania wejsciowego w taki sposob,
 * aby na wyjsciu pojawilo sie to samo zdanie w odwroconej kolejnosci
 * i z zachowaniew wielkosci liter na danym miejscu
 * @author Rollo
 */
public class InverseTransformer extends TextTransformer{

    public InverseTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){
        return inverse(text);
    }

    /**
     * Metoda sluzaca do odwracania ciagu znaków z zachowaniem wielkości liter
     * @param text tekst do zamiany
     * @return odwrocony tekst z zachowana kolejnosca duzych liter
     */
    private String inverse(String text){
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
