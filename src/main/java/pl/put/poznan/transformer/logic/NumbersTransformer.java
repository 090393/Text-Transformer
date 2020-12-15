package pl.put.poznan.transformer.logic;

public class NumbersTransformer extends TextTransformer{

    public NumbersTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){
        return transformNumbers(text);
    }

    private String transformNumbers(String text){
        return text;
    }
}
