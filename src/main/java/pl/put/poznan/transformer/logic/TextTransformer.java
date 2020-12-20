package pl.put.poznan.transformer.logic;

/*
 * Klasa będąca szablonem dla pozostałych klas transformujących,
 * a jednocześnie obsługuje wywołanie odpowiednich metod na podanym
 * tekście, przy użyciu transformacji podanych jako argument w konstruktorze.
 */

public class TextTransformer implements Transformer{

    private String[] transforms;
    private String text;

    /*
     * Inicjalizacja z wybranymi formami transformacji
     *
     * @param transforms tablica wybranych transformacji
     */
    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    /*
     * Wykonanie zdeklarowanych w konstruktorze transformacji
     * na podanym jako argument tekście
     *
     * @param text Tekst do transformacji
     * @return Tekst po wykonaniu wszystkich transformacji
     */
    @Override
    public String transform(String text) {
        this.text = text;
        for (String tr : transforms) {
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
                    return "ERROR - Podano błędną transformację.";
            }
        }
        return this.text;
    }
}
