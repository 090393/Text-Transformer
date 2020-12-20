package pl.put.poznan.transformer.logic;

/**
 * Klasa słuzaca do przeksztalcania zdania wejsciowego w taki sposob,
 * aby na wyjsciu zamiast liczb zmiennoprzecinkowych pojawil sie zapis tych liczb w slowach
 * @author Rollo
 */
public class FloatTransformer extends TextTransformer {

    public FloatTransformer(String[] transforms) { super(transforms); }

    public String transform(String text){
        return transformFloat(text);
    }

    /**
     * Metoda wuszukujaca liczby zmiennoprzecinkowe
     * @param text zdanie do przeksztalcenia
     * @return przeksztalcone zdanie
     */

    private String transformFloat(String text){
        String tmp = "";
        String result = "";
        boolean number = false;
        for( int i =0; i<text.length();i++)
        {
            if((text.charAt(i)>=48 && text.charAt(i) <=57) || text.charAt(i) ==',')
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
                result += transform_float(tmp);
                tmp = "";
            }
            if(!number)
            {
                result += text.charAt(i);
            }
        }
        if(!tmp.isEmpty() && number) {
            result += transform_float(tmp);
            tmp = "";
        }
        return result;
    }

    /**
     * Metoda zamieniajaca liczbe zmiennoprzecinkowa na slowa
     * @param text liczba zmiennoprzecinkowa do przeksztalcenia
     * @return liczba zmiennoprzecinkowa zapisana w slowach
     */
    private String transform_float(String text)
    {
        String result = "";

        for (int i=0; i<text.length();i++)
        {
            if(text.charAt(i)==',')
            {
                result = transform_number(text.substring(0,i)) + " i ";

                result += transform_number(text.substring(i+1,text.length()));

                int x = text.length() - i-1;

                if(x == 1)
                {
                    if(result.charAt(result.length()-1) <=52)
                    {
                        result += " dziesiate";

                    }
                    else
                    {
                        result += " dziesiatych";

                    }
                }
                if(x == 2)
                {
                    result += " setnych";
                }
                if(x == 3)
                {
                    result += " tysieczne";
                }

                break;

            }
        }

        return result;
    }

    /**
     * Metoda słuzaca do zamieniania liczby na slowo
     * @param text liczba do przeksztalcenia
     * @return liczba zapisana slowami
     */
    private String transform_number(String text)
    {
        int erase=0, len = text.length();
        String tmp = text;
        for(int i = 0 ; i<len-1;i++)
        {
            if(text.charAt(i) == 48)
            {
                erase = i+1;
            }
            else
            {

                break;
            }
        }
        text = tmp.substring(erase,len);

        if (text.length() > 3) return text;
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
