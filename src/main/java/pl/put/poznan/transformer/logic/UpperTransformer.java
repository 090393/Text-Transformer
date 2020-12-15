package pl.put.poznan.transformer.logic;

public class UpperTransformer extends CaseTransformer{

    public UpperTransformer(String[] transforms) { super(transforms); }

    private String caseTransform(String text){ return upper(text); }

    private String upper(String text){
        //TODO
        return text;
    }
}
