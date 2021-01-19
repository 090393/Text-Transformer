package pl.put.poznan.transformer.logic;

public class CaesarEncryption extends TextTransformerDecorator {

    public CaesarEncryption(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){ return super.transform(encode(text)); }

    public String encode(String text){
        //TODO
        return text;
    }
}
