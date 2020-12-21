package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                      @RequestParam(value = "transforms", defaultValue = "upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation
        TransformationsMapping tm = new TransformationsMapping(transforms, logger);
        TextTransformationDecorator tt = tm.dynamicTransformation();

        if (tt == null)
            return "ERROR: Podano nieprawidłową transformację";
        else
            return tt.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                       @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation
        TransformationsMapping tm = new TransformationsMapping(transforms, logger);
        TextTransformationDecorator tt = tm.dynamicTransformation();

        if (tt == null) {
            logger.info("Given incorrect transformation");
            return "ERROR: Podano nieprawidłową transformację";
        } else
            return tt.transform(text);
    }
}
