package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer extends CaseTransformer {

    public CapitalizeTransformer(String[] transforms) {
        super(transforms);
    }

    private String caseTransform(String text){ return super.transform(capitalize(text)); }

    private String capitalize(String text){
        //TODO
        return text;
    }
}
