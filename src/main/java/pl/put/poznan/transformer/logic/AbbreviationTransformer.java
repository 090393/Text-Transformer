package pl.put.poznan.transformer.logic;

public class AbbreviationTransformer extends TextTransformer {

    public AbbreviationTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){
        return super.transform(abbreviate(text));
    }

    //Zamiana słów na skróty

    /**Zamaina słów na skróty
     *
     * @param text tekst wejściowy
     * @return teskt z zamienionymi słowami na stróty
     */
    private String abbreviate(String text){
        //TODO
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
