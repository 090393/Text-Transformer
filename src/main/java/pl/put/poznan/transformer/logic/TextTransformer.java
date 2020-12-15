package pl.put.poznan.transformer.logic;

public class TextTransformer implements Transformer{

    private String[] transforms;
    private String text;
    private Transformer transformer;

    public TextTransformer(String[] transforms){ this.transforms = transforms; }
    
    @Override
    public String transform(String text) {
        this.text = text;
/*
        for (String tform : transforms)
        {
            transformer = ??????
            this.text = transformer.transform(this.text) ?
        }
*/
        return this.text;
    }
}
