package pl.put.poznan.transformer.logic;

public class IntegerTransformer extends NumbersTransformer {

    public IntegerTransformer(String[] transforms) {
        super(transforms);
    }

    private String transformNumbers(String text){ return transformInteger(text); }

    /**Przeksztalcanie liczb calkowitych na slowa
     *
     * @param text zdanie do przeksztalcenia
     * @return zwraca zdanie z przeksztalconymi liczbami na slowa
     */
    public String transformInteger(String text){
        String tmp = "";
        String result = "";
        boolean number = false;
        for( int i =0; i<text.length();i++)
        {
            if(text.charAt(i)>=48 && text.charAt(i) <=57)
            {
                tmp += text.charAt(i);
                number = true;
            }
            else
            {
                number = false;
            }
            if(!tmp.isEmpty() && !number)
            {
                result += transform_number(tmp);
                tmp = "";
            }
            if(!number)
            {
                result += text.charAt(i);
            }
        }
        if(!tmp.isEmpty() && number) {
            result += transform_number(tmp);
            tmp = "";
        }
        return result;
    }

    /**
     * Przeksztalcenie liczby na slowa
     * @param text liczba na wejscie
     * @return zamieniona liczba na slowa
     */
    public String transform_number(String text)
    {
        String result = "";
        String[] hundreds = {"sto ", "dwiescie "," trzysta ","czterysta ","piecset ","szescset ","siedemset ","osiemset ","dziewiecset "};
        String[] teen = {"jedenascie","dwanascie","trzynascie","czternascie","pietnascie","szesnascie","siedemnascie","osiemnascie","dziewietnascie"};
        String[] dozen = {"", "dziesiec ","dwadziescia ","trzydziesci ","czterdziesci ","piecdziesiat ","szescdziesiat ","siedemdziesiat ","osiemdziesiat ","dziewiecdziesiat "};
        String[] unity = {"","jeden","dwa","trzy","cztery","piec ","szesc ","siedem","osiem","dziewiec"};
        if( text.length()==3)
        {
            result = hundreds[text.charAt(0)-49] + dozen[text.charAt(1)-48] + unity[text.charAt(2)-48];
            if(text.charAt(1) == 49 && text.charAt(2)>48)
            {
                result = hundreds[text.charAt(1)-49] + teen[text.charAt(2)-49];
            }
        }
        if( text.length()==2)
        {
            result = dozen[text.charAt(0) - 48] + unity[text.charAt(1) - 48];
            if(text.charAt(0) == 49 && text.charAt(1)>48)
            {
                result = teen[text.charAt(1)-49];
            }
        }
        if( text.length()==1)
        {
            result = unity[text.charAt(0)-48];
        }
        int x = result.length()-1;
        if(result.charAt(x) ==32)
        {

            result = result.substring(0,x);
        }
        return result;
    }
}
