package pl.put.poznan.transformer.logic;

public class ExpandTransformer extends TextTransformer{

    public ExpandTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){
        return super.transform(expand(text));
    }

    //Rozwijanie skrótów
    private String expand(String text){
        //TODO
        return text;
    }
}
