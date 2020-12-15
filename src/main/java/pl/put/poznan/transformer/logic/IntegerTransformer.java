package pl.put.poznan.transformer.logic;

public class IntegerTransformer extends NumbersTransformer {

    public IntegerTransformer(String[] transforms) {
        super(transforms);
    }

    private String transformNumbers(String text){ return super.transform(transformInteger(text)); }

    //Przekształcanie liczb całkowitych na słowa
    private String transformInteger(String text){
        //TODO
        return text;
    }
}
