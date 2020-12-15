package pl.put.poznan.transformer.logic;

public class CaseTransformer extends TextTransformer {

    public CaseTransformer(String[] transforms){
        super(transforms);
    }

    public String transform(String text){ return text; }

}
