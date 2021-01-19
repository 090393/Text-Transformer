package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FloatTransformerTest {
    Transformer transformer;
    Transformer transformer_mock;
    FloatTransformer test_mock;
    FloatTransformer test;

    @BeforeEach
    void setup()
    {
        transformer = mock(Transformer.class);
        transformer_mock = mock(Transformer.class);
        when(transformer_mock.transform(anyString())).thenAnswer(
                (Answer<String>) invocationOnMock -> {
                    Object arg = invocationOnMock.getArguments()[0];
                    return (String) arg;
                });
        test_mock = new FloatTransformer(transformer_mock);
        test = new FloatTransformer(transformer);
    }

    @Test
    void FloatTransformerTestMock()
    {
        assertEquals("Powietrze zawiera zero i siedemdziesiąt osiem setnych azotu, zero i dwadzieścia jeden setnych tlenu", test_mock.transform("Powietrze zawiera 0,78 azotu, 0,21 tlenu"));
        assertEquals("zero i trzy dziesiątych + zero i dziewięćdziesiąt trzy setnych = jeden i dwadzieścia trzy setnych", test_mock.transform("0,3 + 0,93 = 1,23"));
        assertEquals("Mniej niż zero i pięć dziesiątych ale więcej niż zero i zero dziesiątych", test_mock.transform("Mniej niż 0,5 ale więcej niż 0,0"));
        assertEquals("temperatura oscyluje wokół dwanaście i sto dwadzieścia trzy tysięczne stopni Celsjusza", test_mock.transform("temperatura oscyluje wokół 12,123 stopni Celsjusza"));

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