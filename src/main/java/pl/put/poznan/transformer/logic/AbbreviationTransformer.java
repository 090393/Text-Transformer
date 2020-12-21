package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do zamiany zwrotów słownych na skróty.
 * @author Krzychu
 */
public class AbbreviationTransformer extends TextTransformerDecorator {

    public AbbreviationTransformer(Transformer transformer) { super(transformer); }

    public String transform(String text){ return super.transform(abbreviate(text)); }

    /**Zamiana słów na skróty
     *
     * @param text tekst wejściowy
     * @return teskt z zamienionymi słowami na stróty
     */
    public String abbreviate(String text){
        text = text.replace("na przykład", "np.");
        text = text.replace("NA PRZYKŁAD", "NP.");
        text = text.replace("między innymi", "m.in.");
        text = text.replace("MIĘDZY INNYMI", "M.IN.");
        text = text.replace("i tym podobne", "itp.");
        text = text.replace("I TYM PODOBNE", "ITP.");
        text = text.replace("i tak dalej", "itd.");
        text = text.replace("I TAK DALEJ", "ITD.");
        return text;
    }
}
