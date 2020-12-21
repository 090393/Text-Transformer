package pl.put.poznan.transformer.logic;

public class TextTransformerDecorator implements Transformer {

    private Transformer wrappee;

    public TextTransformerDecorator(Transformer transformer){
        this.wrappee = transformer;
    }

    @Override
    public String transform(String text) {
        return wrappee.transform(text);
    }
}
