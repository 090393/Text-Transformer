package pl.put.poznan.transformer.logic;

public class InverseTransformer extends TextTransformer{

    public InverseTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){
        return super.transform(inverse(text));
    }

    //Odwracanie ciągu znaków z zachowaniem wielkości liter
    private String inverse(String text){

        return text;
    }
}
