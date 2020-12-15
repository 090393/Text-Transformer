package pl.put.poznan.transformer.logic;

import org.springframework.util.StringUtils;

public class CapitalizeTransformer extends TextTransformer {

    public CapitalizeTransformer(String[] transforms) {
        super(transforms);
    }

    public String transform(String text){ return capitalize(text); }

    private String capitalize(String text){
        text = StringUtils.capitalize(text);
        return text;
    }
}
