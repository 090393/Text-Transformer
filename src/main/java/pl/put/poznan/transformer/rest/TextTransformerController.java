package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformerDecorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@RestController
@RequestMapping("")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    private String toHtml(String text) {
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File("src\\main\\java\\pl\\put\\poznan\\transformer\\rest\\template.html");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                sb.append(data);
                sb.append("\n");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return sb.toString().replace("xxxxx", text);
    }

    public static class Data {

        private String text;
        private String tt;

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTt() {
            return this.tt;
        }

        public void setTt(String text) {
            this.tt = text;
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String get() { return toHtml(""); }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String post(@ModelAttribute("Data") Data data, Model model) {

        // perform the transformation
        TransformationsMapping tm = new TransformationsMapping(data.getTt().split(","), logger);
        TextTransformerDecorator tt = tm.dynamicTransformation();
        if (tt == null) {
            logger.info("Given incorrect transformation");
            return "ERROR: Podano nieprawidłową transformację";
        } else {
            String result = data.getText();
            if (result == null)
            {
                logger.info("Text is null");
                return toHtml("");
            }
            return toHtml(tt.transform(result));
        }
    }
}
