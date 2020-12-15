package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer extends TextTransformer {

    public CapitalizeTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){ return capitalize(text); }

    private String capitalize(String text){
        for(int i = 0;i<text.length();i++)
        {
            if(text.charAt(i) == ' ') {
                text = text.substring(0,i)+Character.toLowerCase(text.charAt(i + 1))+ text.substring(i+1);
            }
        }
        return text;
    }
}
