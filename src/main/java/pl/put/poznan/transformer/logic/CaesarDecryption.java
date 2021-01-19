package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CaesarDecryption extends TextTransformerDecorator {

    public CaesarDecryption(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){ return super.transform(decode(text)); }

    public String decode(String text){
        List<Character> alfabet = Arrays.asList('a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł' ,'m', 'n', 'ń' ,'o', 'ó' ,'p' ,'r' ,'s', 'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż');
        List<Character> alfabetUpper = Arrays.asList('A', 'Ą', 'B' ,'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł', 'M', 'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S', 'Ś', 'T', 'U', 'W', 'Y' ,'Z', 'Ź', 'Ż');

        for (int i = 0; i<text.length(); i++)
        {
                int index =alfabet.indexOf(text.charAt(i));
                if(index ==-1)
                    index =alfabetUpper.indexOf(text.charAt(i));
                if(index ==-1)
                    continue;
                index = (alfabet.size()+index -3)%alfabet.size();
                text = text.substring(0,i) + alfabet.get(index) + text.substring(i+1);



        }
        return text;
    }
}
