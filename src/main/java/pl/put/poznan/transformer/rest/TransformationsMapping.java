package pl.put.poznan.transformer.rest;

import pl.put.poznan.transformer.logic.*;

import org.slf4j.Logger;

public class TransformationsMapping {

    private String[] transforms;
    private Logger logger;

    public TransformationsMapping(String[] transforms, Logger logger){
        this.transforms = transforms;
        this.logger = logger;
    }

    public TextTransformerDecorator dynamicTransformation(){
        Transformer transformer = new TransformerDefault();
        return map(transforms, transformer);
    }

    public TextTransformerDecorator map(String[] transforms, Transformer transformer){

        TextTransformerDecorator tt = null;
        String transformation;

        for(int i=transforms.length-1; i>=0; i--){
            if(i==transforms.length-1){
                transformation = transforms[i].toLowerCase();
                switch (transformation) {
                    case "upper":
                        logger.info("Upper transformation");
                        tt = new UpperTransformer(transformer);
                        break;
                    case "lower":
                        logger.info("Lower transformation");
                        tt = new LowerTransformer(transformer);
                        break;
                    case "abbreviate":
                        logger.info("Abbreviation transformation");
                        tt = new AbbreviationTransformer(transformer);
                        break;
                    case "capitalize":
                        logger.info("Capitalize transformation");
                        tt = new CapitalizeTransformer(transformer);
                        break;
                    case "expand":
                        logger.info("Expand transformation");
                        tt = new ExpandTransformer(transformer);
                        break;
                    case "float":
                        logger.info("Float transformation");
                        tt = new FloatTransformer(transformer);
                        break;
                    case "integer":
                        logger.info("Integer transformation");
                        tt = new IntegerTransformer(transformer);
                        break;
                    case "inverse":
                        logger.info("Inverse transformation");
                        tt = new InverseTransformer(transformer);
                        break;
                    default:
                        return tt;
                }
            } else{
                switch (transforms[i]) {
                    case "upper":
                        logger.info("Upper transformation");
                        tt = new UpperTransformer(tt);
                        break;
                    case "lower":
                        logger.info("Lower transformation");
                        tt = new LowerTransformer(tt);
                        break;
                    case "abbreviate":
                        logger.info("Abbreviation transformation");
                        tt = new AbbreviationTransformer(tt);
                        break;
                    case "capitalize":
                        logger.info("Capitalize transformation");
                        tt = new CapitalizeTransformer(tt);
                        break;
                    case "expand":
                        logger.info("Expand transformation");
                        tt = new ExpandTransformer(tt);
                        break;
                    case "float":
                        logger.info("Float transformation");
                        tt = new FloatTransformer(tt);
                        break;
                    case "integer":
                        logger.info("Integer transformation");
                        tt = new IntegerTransformer(tt);
                        break;
                    case "inverse":
                        logger.info("Inverse transformation");
                        tt = new InverseTransformer(tt);
                        break;
                    default:
                        return tt;
                }
            }
        }

        return tt;
    }
}
