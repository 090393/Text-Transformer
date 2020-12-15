package pl.put.poznan.transformer.logic;

public class TextTransformer implements Transformer{

    private String[] transforms;
    private String text;
    //private Transformer transformer;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }
    
    @Override
    public String transform(String text) {
        this.text = text;
        //System.out.println(this.text);
        for (String tr : transforms) {
            System.out.println(this.text);
            switch (tr)
            {
                case "upper":
                    this.text = new UpperTransformer(transforms).transform(this.text);
                    break;

                case "lower":
                    this.text = new LowerTransformer(transforms).transform(this.text);
                    break;

                case "abbreviate":
                    this.text = new AbbreviationTransformer(transforms).transform(this.text);
                    break;

                case "capitalize":
                    this.text = new CapitalizeTransformer(transforms).transform(this.text);
                    break;

                case "expand":
                    this.text = new ExpandTransformer(transforms).transform(this.text);
                    break;

                case "float":
                    this.text = new FloatTransformer(transforms).transform(this.text);
                    break;

                case "integer":
                    this.text = new IntegerTransformer(transforms).transform(this.text);
                    break;

                case "inverse":
                    this.text = new InverseTransformer(transforms).transform(this.text);
                    break;

                default:
                    return "ERROR :)";
            }
        }
        System.out.println(this.text);
        return this.text;
    }
}
