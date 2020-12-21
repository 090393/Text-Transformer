package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do zamiany liter na małe.
 * @author Krzychu
 */
public class LowerTransformer extends TextTransformerDecorator {

    public LowerTransformer(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){ return super.transform(lower(text)); }

    /** Zamiana liter na małe
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    public String lower(String text){
        return text.toLowerCase();
    }
}
