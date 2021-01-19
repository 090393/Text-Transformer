package pl.put.poznan.transformer.logic;

public class CaesarDecryption extends TextTransformerDecorator {

    public CaesarDecryption(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){ return super.transform(decode(text)); }

    public String decode(String text){
        //TODO
        return text;
    }
}
