package pl.put.poznan.transformer.logic;

public class UpperTransformer extends TextTransformer{

    public UpperTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){ return caseTransform(text); }

    private String caseTransform(String text){ return upper(text); }

    /** Zamaiana liter na wielkie
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    private String upper(String text){
        text = text.toUpperCase();
        return text;
    }
}
