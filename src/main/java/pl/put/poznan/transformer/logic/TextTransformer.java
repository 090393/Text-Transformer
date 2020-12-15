package pl.put.poznan.transformer.logic;

public class TextTransformer implements Transformer{

    private String[] transforms;
    private String text;
    private Transformer transformer;

    public TextTransformer(String[] transforms){ this.transforms = transforms; }
    
    @Override
    public String transform(String text) {
        return transformer.transform(text);
    }
}
