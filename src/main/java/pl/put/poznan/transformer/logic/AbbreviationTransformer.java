package pl.put.poznan.transformer.logic;

public class AbbreviationTransformer extends TextTransformer {

    public AbbreviationTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){
        return super.transform(abbreviate(text));
    }

    //Zamiana słów na skróty
    public String abbreviate(String text){
        //TODO
        text = text.replace("na przykład", "np.");
        return text;
    }
}
