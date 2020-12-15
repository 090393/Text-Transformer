package pl.put.poznan.transformer.logic;

public class FloatTransformer extends NumbersTransformer {

    public FloatTransformer(String[] transforms) { super(transforms); }

    private String transformNumbers(String text){ return super.transform(transformFloat(text)); }

    //Przekształcanie liczb zmiennoprzecinkowych na słowa
    private String transformFloat(String text){
        //TODO
        return text;
    }
}
