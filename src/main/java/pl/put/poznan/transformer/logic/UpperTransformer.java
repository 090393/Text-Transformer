package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do zamiany liter na wielkie.
 * @author Krzychu
 */
public class UpperTransformer extends TextTransformerDecorator{

    public UpperTransformer(Transformer transformer) { super(transformer); }

    public String transform(String text){ return super.transform(upper(text)); }

    /** Zamiana liter na wielkie
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    public String upper(String text){
        return text.toUpperCase();
    }
}
