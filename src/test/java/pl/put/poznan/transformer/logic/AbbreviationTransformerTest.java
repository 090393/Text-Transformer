package pl.put.poznan.transformer.logic;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

public class AbbreviationTransformerTest {

    AbbreviationTransformer text;

    @BeforeEach
     public void setUp()
    {
        String[] str = {"abbreviation"};
        text = new AbbreviationTransformer(str);
    }

    @Test
    public void testAbbreviate()
    {
        assertEquals("ryba to np. okoń ",text.transform("ryba to na przykład  okoń"));
    }



}