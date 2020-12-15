package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer extends CaseTransformer {

    public CapitalizeTransformer(String[] transforms) {
        super(transforms);
    }

    private String caseTransform(String text){ return super.transform(capitalize(text)); }

    private String capitalize(String text){
        for(int i = 0;i<text.length();i++)
        {
            if(text.substring(i, i+1) == " ") {
                text = text.substring(0,i)+Character.toLowerCase(text.charAt(i + 1))+ text.substring(i+1);
            }
        }
        return text;
    }
}
