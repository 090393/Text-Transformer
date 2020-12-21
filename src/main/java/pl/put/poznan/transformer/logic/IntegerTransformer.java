package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do przekształcania zdania wejściowego w taki sposób,
 * aby na wyjściu zamiast liczb pojawił się zapis tych liczb w słowach.
 * @author Rollo
 */
public class IntegerTransformer extends TextTransformerDecorator {

    public IntegerTransformer(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){
        return super.transform(transformInteger(text));
    }

    /**
     * Metoda służąca do wyszukiwania liczb w zdaniu
     * @param text zdanie do przekształcenia
     * @return zwraca zdanie z przekształconymi liczbami na słowa
     */
    public String transformInteger(String text){
        String tmp = "";
        String result = "";
        boolean number = false;
        for( int i =0; i<text.length();i++)
        {
            if (text.charAt(i)>=48 && text.charAt(i) <=57)
            {
                tmp += text.charAt(i);
                number = true;
            }
            else
            {
                number = false;
            }
            if (!tmp.isEmpty() && !number)
            {
                result += transform_number(tmp);
                tmp = "";
            }
            if (!number)
            {
                result += text.charAt(i);
            }
        }
        if (!tmp.isEmpty() && number) {
            result += transform_number(tmp);
            tmp = "";
        }
        return result;
    }

    /**
     * Metoda służąca do zamieniania liczby na słowa
     * @param text liczba na wejście
     * @return zamieniona liczba na słowa
     */
    public String transform_number(String text)
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
        String[] hundreds = {"sto ", "dwieście ", "trzysta ","czterysta ","pięćset ", "sześćset ","siedemset ","osiemset ","dziewięćset "};
        String[] teen = {"jedenaście","dwanaście","trzynaście","czternaście","piętnaście","szesnaście","siedemnaście","osiemnaście","dziewiętnaście"};
        String[] dozen = {"", "dziesięć ","dwadzieścia ","trzydzieści ","czterdzieści ","pięśdziesiąt ","sześćdziesiąt ","siedemdziesiąt ","osiemdziesiąt ","dziewiećdziesiąt "};
        String[] unity = {"","jeden","dwa","trzy","cztery","pięć","sześć","siedem","osiem","dziewięć"};
        if ( text.length() == 3 )
        {
            result = hundreds[text.charAt(0)-49] + dozen[text.charAt(1)-48] + unity[text.charAt(2)-48];
            if(text.charAt(1) == 49 && text.charAt(2)>48)
            {
                result = hundreds[text.charAt(1)-49] + teen[text.charAt(2)-49];
            }
        }
        if ( text.length() == 2 )
        {
            result = dozen[text.charAt(0) - 48] + unity[text.charAt(1) - 48];
            if (text.charAt(0) == 49 && text.charAt(1) > 48 )
            {
                result = teen[text.charAt(1)-49];
            }
        }
        if ( text.length() == 1 )
        {
            result = unity[text.charAt(0)-48];
            if(text.charAt(0)==48) result = "zero";
        }
        int x = result.length()-1;
        if ( result.charAt(x) == 32 )
        {

            result = result.substring(0, x);
        }
        return result;
    }
}
