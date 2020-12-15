package pl.put.poznan.transformer.logic;

public class LowerTransformer extends TextTransformer {

    public LowerTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){ return lower(text); }

    /** Zammiana liter na małe
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */

    private String lower(String text){
        return text.toLowerCase();
    }
}
