package pl.put.poznan.transformer.logic;

/**
 * Klasa służąca do rozwijania wybranych skrótów do pełnych postaci.
 * @author Krzychu
 */
public class ExpandTransformer extends TextTransformerDecorator{

    public ExpandTransformer(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){
        return super.transform(expand(text));
    }

    /** Rozwijanie wybranych skrótów do pełnych postaci
     *
     * @param text Tekst wejściowy
     * @return Wynikowy tekst
     */
    public String expand(String text){
        text = text.replaceAll("^np.$ ", "na przykład");
        text = text.replaceAll("^np. ", "na przykład ");
        text = text.replaceAll(" np.$", " na przykład");
        text = text.replaceAll(" np. ", " na przykład ");

        text = text.replaceAll("^NP.$", "NA PRZYKŁAD");
        text = text.replaceAll("^NP. ", "NA PRZYKŁAD ");
        text = text.replaceAll(" NP.$", " NA PRZYKŁAD");
        text = text.replaceAll(" NP. ", " NA PRZYKŁAD ");

        text = text.replaceAll("^m.in.$", "między innymi");
        text = text.replaceAll("^m.in. ", "między innymi ");
        text = text.replaceAll(" m.in.$", " między innymi");
        text = text.replaceAll(" m.in. ", " między innymi ");

        text = text.replaceAll("^M.IN.$", "MIĘDZY INNYMI");
        text = text.replaceAll("^M.IN. ", "MIĘDZY INNYMI ");
        text = text.replaceAll(" M.IN.$", " MIĘDZY INNYMI");
        text = text.replaceAll(" M.IN. ", " MIĘDZY INNYMI ");

        text = text.replaceAll("^itp.$", "i tym podobne");
        text = text.replaceAll("^itp. ", "i tym podobne ");
        text = text.replaceAll(" itp.$", " i tym podobne");
        text = text.replaceAll(" itp. ", " i tym podobne ");

        text = text.replaceAll("^ITP.$", "I TYM PODOBNE");
        text = text.replaceAll("^ITP. ", "I TYM PODOBNE ");
        text = text.replaceAll(" ITP.$", " I TYM PODOBNE");
        text = text.replaceAll(" ITP. ", " I TYM PODOBNE ");

        text = text.replaceAll("^itd.$", "i tak dalej");
        text = text.replaceAll("^itd. ", "i tak dalej ");
        text = text.replaceAll(" itd.$", " i tak dalej");
        text = text.replaceAll(" itd. ", " i tak dalej ");

        text = text.replaceAll("^ITD.$", "I TAK DALEJ");
        text = text.replaceAll("^ITD. ", "I TAK DALEJ ");
        text = text.replaceAll(" ITD.$", " I TAK DALEJ");
        text = text.replaceAll(" ITD. ", " I TAK DALEJ ");

        text = text.replaceAll("^prof.$", "profesor");
        text = text.replaceAll("^prof. ", "profesor ");
        text = text.replaceAll(" prof.$", " profesor");
        text = text.replaceAll(" prof. ", " profesor ");

        text = text.replaceAll("^PROF.$", "PROFESOR");
        text = text.replaceAll("^PROF. ", "PROFESOR ");
        text = text.replaceAll(" PROF.$", " PROFESOR");
        text = text.replaceAll(" PROF. ", " PROFESOR ");

        text = text.replaceAll("^dr$", "doktor");
        text = text.replaceAll("^dr ", "doktor ");
        text = text.replaceAll(" dr$", " doktor");
        text = text.replaceAll(" dr ", " doktor ");

        text = text.replaceAll("^DR$", "DOKTOR");
        text = text.replaceAll("^DR ", "DOKTOR ");
        text = text.replaceAll(" DR$", " DOKTOR");
        text = text.replaceAll(" DR ", " DOKTOR ");
        return text;
    }
}
