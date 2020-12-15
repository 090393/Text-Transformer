package pl.put.poznan.transformer.logic;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

public class AbbreviationTransformerTest {

    String[] str = {"cos"};
    AbbreviationTransformer text=new AbbreviationTransformer(str);



    @Test
    public void testAbbreviate()
    {
        assertEquals("ryba to np. okoń",text.abbreviate("ryba to na przykład okoń"));
        assertEquals("RYBA TO NP. OKOŃ",text.abbreviate("RYBA TO NA PRZYKŁAD OKOŃ"));
        assertEquals("ryba to m.in. okoń",text.abbreviate("ryba to między innymi okoń"));



    }



}