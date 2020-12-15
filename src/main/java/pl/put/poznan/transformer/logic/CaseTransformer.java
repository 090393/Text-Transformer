package pl.put.poznan.transformer.logic;

public class CaseTransformer extends TextTransformer {

    public CaseTransformer(String[] transforms){
        super(transforms);
    }

    public String transform(String text){ return caseTransform(text); }

    private String caseTransform(String text){
        return text;
    }
}
