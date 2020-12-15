package pl.put.poznan.transformer.logic;

public class IntegerTransformer extends NumbersTransformer {

    public IntegerTransformer(String[] transforms) {
        super(transforms);
    }

    private String transformNumbers(String text){ return super.transform(transformInteger(text)); }

    //Przekształcanie liczb całkowitych na słowa
    private String transformInteger(String text){
        String result = "";
        String[] hundreds = {"sto ", "dwiescie ","trzysta ","czterysta ","piecset ","szescset ","siedemset ","osiemset ","dziewiecset "};
        String[] dozen = {"", "dziesiec ","dwadziescia ","trzydziesci ","czterdziesci ","piecdziesiat ","szescdziesiat ","siedemdziesiat ","osiemdziesiat ","dziewiecdziesiat "};
        String[] unity = {"","jeden","dwa","trzy","cztery","piec","szesc","siedem","osiem","dziewiec"};
        if( text.length()==3)
        {
            result = hundreds[text.charAt(0)-48] + dozen[text.charAt(1)-48] + unity[text.charAt(2)-48];
        }
        if( text.length()==2)
        {
            result = dozen[text.charAt(0)-48] + unity[text.charAt(1)-48];
        }
        if( text.length()==1)
        {
            result = unity[text.charAt(0)-48];
        }
        return result;
    }
}
