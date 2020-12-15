package pl.put.poznan.transformer.logic;

public class LowerTransformer extends TextTransformer {

    public LowerTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){ return lower(text); }

    private String lower(String text){
        text = text.toLowerCase();
        return text;
    }
}
