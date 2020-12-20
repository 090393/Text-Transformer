package pl.put.poznan.transformer.logic;
/**
 * Klasa słuzaca do zamiany liter na wielkie.
 * @author Krzychu
 */
public class UpperTransformer extends TextTransformer{

    public UpperTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){ return upper(text); }

    /** Zamaiana liter na wielkie
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    private String upper(String text){
        return text.toUpperCase();
    }
}
