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
        text = text.replaceAll("^na przykład ", "np. ");
        text = text.replaceAll("^na przykład$", "np.");
        text = text.replaceAll(" na przykład ", " np. ");
        text = text.replaceAll(" na przykład$", " np.");

        text = text.replaceAll("^NA PRZYKŁAD ", "NP. ");
        text = text.replaceAll("^NA PRZYKŁAD$", "NP.");
        text = text.replaceAll(" NA PRZYKŁAD ", " NP. ");
        text = text.replaceAll(" NA PRZYKŁAD$", " NP.");

        text = text.replaceAll("^między innymi ", "m.in. ");
        text = text.replaceAll("^między innymi$", "m.in.");
        text = text.replaceAll(" między innymi ", " m.in. ");
        text = text.replaceAll(" między innymi$", " m.in.");


        text = text.replaceAll("^MIĘDZY INNYMI ", "M.IN. ");
        text = text.replaceAll("^MIĘDZY INNYMI$", "M.IN.");
        text = text.replaceAll(" MIĘDZY INNYMI ", " M.IN. ");
        text = text.replaceAll(" MIĘDZY INNYMI$", " M.IN.");

        text = text.replaceAll("^i tym podobne ", "itp. ");
        text = text.replaceAll("^i tym podobne$", "itp.");
        text = text.replaceAll(" i tym podobne ", " itp. ");
        text = text.replaceAll(" i tym podobne$", " itp.");

        text = text.replaceAll("^I TYM PODOBNE ", "ITP. ");
        text = text.replaceAll("^I TYM PODOBNE$", "ITP.");
        text = text.replaceAll(" I TYM PODOBNE ", " ITP. ");
        text = text.replaceAll(" I TYM PODOBNE$", " ITP.");


        text = text.replaceAll("^i tak dalej ", "itd.");
        text = text.replaceAll("^i tak dalej$", "itd. ");
        text = text.replaceAll(" i tak dalej ", " itd. ");
        text = text.replaceAll(" i tak dalej$", " itd.");

        text = text.replaceAll("^I TAK DALEJ ", "ITD. ");
        text = text.replaceAll("^I TAK DALEJ$", "ITD.");
        text = text.replaceAll(" I TAK DALEJ ", " ITD. ");
        text = text.replaceAll(" I TAK DALEJ$", " ITD.");
        return text;
    }
}
