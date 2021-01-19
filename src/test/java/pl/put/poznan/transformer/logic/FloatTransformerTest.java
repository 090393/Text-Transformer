package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FloatTransformerTest {
    Transformer transformer;
    FloatTransformer test;

    @BeforeEach
    void setup()
    {
        transformer = mock(Transformer.class);
        test = new FloatTransformer(transformer);
    }

    @Test
    void transform_numberTest()
    {
        assertEquals("sto dwadzieścia trzy",test.transform_number("123"));
        assertEquals("dwadzieścia pięć",test.transform_number("25"));
        assertEquals("dziewięć",test.transform_number("9"));
        assertEquals("sto trzydzieści pięć",test.transform_number("0135"));
    }

    @Test
    void transform_floatTest()
    {
        assertEquals("jeden i trzydzieści pięć setnych",test.transform_float("01,35"));
        assertEquals("dwadzieścia pięć i trzynaście tysięczne",test.transform_float("25,013"));
        assertEquals("jeden",test.transform_float("001"));
        assertEquals("dwa i dwa dziesiątych",test.transform_float("2,2"));
    }

    @Test
    void transformFloatTest()
    {
        assertEquals("Ala ma jeden i dwadzieścia trzy setnych kota, a kot ma dwa i trzy dziesiątych Ali",test.transformFloat("Ala ma 1,23 kota, a kot ma 2,3 Ali"));
        assertEquals("Najpopuralniejszym alkoholem w Polsce jest o zawartości zero i cztery dziesiątych alkoholu",test.transformFloat("Najpopuralniejszym alkoholem w Polsce jest o zawartości 0,4 alkoholu"));

    }

}