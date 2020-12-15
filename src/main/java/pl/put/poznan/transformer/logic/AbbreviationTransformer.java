package pl.put.poznan.transformer.logic;

public class AbbreviationTransformer extends TextTransformer {

    public AbbreviationTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){ return abbreviate(text); }

    //Zamiana słów na skróty
    private String abbreviate(String text){
        //TODO
        return text;
    }
}
