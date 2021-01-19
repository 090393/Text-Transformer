package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IntegerTransformerTest {
    IntegerTransformer test;
    Transformer transformer;

    @BeforeEach
    void setup()
    {
        transformer = mock(Transformer.class);
        test = new IntegerTransformer(transformer);
    }

    @Test
    void transform_numberTestHundreds()
    {
        assertEquals("sto dwadzieścia trzy",test.transform_number("123"));
        assertEquals("dwieście jedenaście",test.transform_number("211"));
        assertEquals("sto jedenaście",test.transform_number("111"));
        assertEquals("dziewięćset dziewięćdziesiąt dziewięć",test.transform_number("999"));
    }


    @Test
    void transform_numberTestDozenTeens()
    {
        assertEquals("dwadzieścia",test.transform_number("20"));
        assertEquals("jedenaście",test.transform_number("11"));
        assertEquals("dwadzieścia pięć",test.transform_number("25"));
        assertEquals("pięćdziesiąt pięć",test.transform_number("55"));


    }

    @Test
    void transform_numberTestUnity()
    {
        assertEquals("zero",test.transform_number("0"));
        assertEquals("pięć",test.transform_number("5"));
        assertEquals("dziewięć",test.transform_number("9"));
    }

    @Test
    void transform_numberTestWrongNumber()
    {
        assertEquals("dwadzieścia",test.transform_number("00020"));
        assertEquals("sto trzydzieści pięć",test.transform_number("0135"));
        assertEquals("zero",test.transform_number("00000"));
        assertEquals("dziewięćset dziewięćdziesiąt dziewięć",test.transform_number("00999"));
    }

    @Test
    void transformIntegerTest()
    {
        assertEquals("Mam sto dwadzieścia trzy złoty",test.transformInteger("Mam 123 złoty"));
        assertEquals("Kot ma szesnaście godzin snu dziennie",test.transformInteger("Kot ma 16 godzin snu dziennie"));
        assertEquals("hehtrzysta dwadzieścia jedenhah",test.transformInteger("heh00321hah"));
        assertEquals("sto jedenaście jedenaście jeden jedenaście sto jedenaście",test.transformInteger("0111 11 0001 11 00111"));
    }

}