package pl.put.poznan.transformer.app;

import pl.put.poznan.transformer.logic.*;

public class TemporaryClass {

    //Klasa tymczasowa do testowania działania metod
    public static void main(String[] args){
        String str = "np. Tekst testowy";
        String[] transforms = {"lower","capitalize"};
        str = new ExpandTransformer(transforms).transform(str);
        str = new LowerTransformer(transforms).transform(str);
        System.out.println(str);
    }
}
