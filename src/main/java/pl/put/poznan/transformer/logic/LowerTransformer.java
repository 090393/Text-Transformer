package pl.put.poznan.transformer.logic;

public class LowerTransformer extends CaseTransformer {

    public LowerTransformer(String[] transforms) {
        super(transforms);
    }

    private String caseTransform(String text){ return super.transform(lower(text)); }

    private String lower(String text){
        //TODO
        return text;
    }
}
