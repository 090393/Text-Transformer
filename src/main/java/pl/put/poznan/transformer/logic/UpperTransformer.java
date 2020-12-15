package pl.put.poznan.transformer.logic;

public class UpperTransformer extends TextTransformer{

    public UpperTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){ return upper(text); }

    private String upper(String text){
        return text.toUpperCase();
    }
}
