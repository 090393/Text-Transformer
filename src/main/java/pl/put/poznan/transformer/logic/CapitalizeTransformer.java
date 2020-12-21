package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do zamieniania pierwszej litery w słowie na wielką.
 * @author Krzychu
 */

public class CapitalizeTransformer extends TextTransformerDecorator {

    public CapitalizeTransformer(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){ return super.transform(capitalize(text)); }

    /** Zamiana pierwszej litery każdego wyrazu na wielką.
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    public String capitalize(String text){
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        for (int i = 0; i<text.length(); i++)
        {
            if (text.charAt(i) == ' ') {
                text = text.substring(0,i+1) + Character.toUpperCase(text.charAt(i + 1)) + text.substring(i+2);
            }
        }
        return text;
    }
}
