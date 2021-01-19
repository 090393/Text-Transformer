package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do przekształcania zdania wejściowego w taki sposób,
 * aby na wyjściu zamiast liczb zmiennoprzecinkowych pojawił się zapis tych liczb w słowach.
 * @author Rollo
 */
public class FloatTransformer extends TextTransformerDecorator {

    public FloatTransformer(Transformer transformer) { super(transformer); }

    public String transform(String text){
        return super.transform(transformFloat(text));
    }

    /**
     * Metoda wyszukująca liczby zmiennoprzecinkowe
     * @param text zdanie do przekształcenia
     * @return przekształcone zdanie
     */
    public String transformFloat(String text){
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
            if(tmp.isEmpty() && text.charAt(i) ==',')
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
     * Metoda zamieniająca liczbę zmiennoprzecinkową na słowa
     * @param text liczba zmiennoprzecinkowa do przekształcenia
     * @return liczba zmiennoprzecinkowa zapisana w słowach
     */
    public String transform_float(String text)
    {
        String result = "";
        boolean isFloat = false;
        boolean isNumber = true;
        for (int i=0; i<text.length();i++)
        {
            if(text.charAt(0)==',')
            {
                result += ",";
                isNumber = false;
                break;
            }
            if(text.charAt(i)==',')
            {
                isFloat = true;
                result = transform_number(text.substring(0,i)) + " i ";

                result += transform_number(text.substring(i+1,text.length()));

                int x = text.length() - i-1;

                if(x == 1)
                {
                    result += " dziesiątych";
                }

                if(x == 2)
                {
                    result += " setnych";
                }
                if(x == 3)
                {
                    result += " tysięczne";
                }

                break;

            }
        }
        if(!isFloat && isNumber)
        {
            result += transform_number(text);
        }

        return result;
    }

    /**
     * Metoda służaca do zamieniania liczby na słowo
     * @param text liczba do przekształcenia
     * @return liczba zapisana słowami
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
        String[] dozen = {"", "dziesięć ","dwadzieścia ","trzydzieści ","czterdzieści ","pięćdziesiąt ","sześćdziesiąt ","siedemdziesiąt ","osiemdziesiąt ","dziewięćdziesiąt "};
        String[] unity = {"","jeden","dwa","trzy","cztery","pięć","sześć","siedem","osiem","dziewięć"};
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
            if(text.charAt(0)==48) result = "zero";
        }
        int x = result.length()-1;
        if(result.charAt(x) ==32)
        {

            result = result.substring(0,x);
        }
        return result;
    }

}
