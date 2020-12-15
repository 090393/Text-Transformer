package pl.put.poznan.transformer.logic;

public class UpperTransformer extends CaseTransformer{

    public UpperTransformer(String[] transforms) { super(transforms); }

    private String caseTransform(String text){ return super.transform(upper(text)); }

    private String upper(String text){
        //TODO
        text = text.toUpperCase();
        return text;
    }
}
