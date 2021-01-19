package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CapitalizeTransformerTest {

    CapitalizeTransformer ct_mock;
    CapitalizeTransformer ct;
    Transformer transformer_mock;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        transformer_mock = mock(Transformer.class);
        when(transformer_mock.transform(anyString())).thenAnswer(
                (Answer<String>) invocationOnMock -> {
                    Object arg = invocationOnMock.getArguments()[0];
                    return (String) arg;
                });
        ct_mock = new CapitalizeTransformer(transformer_mock);
        ct =new CapitalizeTransformer(transformer);
    }

    @Test
    void CapitalizeTransformerTestMock()
    {
        assertEquals("Witam Państwa Bardzo Cieplutko, Bardzo Serdecznie, Marianczello Z Tej Strony",ct_mock.transform("Witam państwa bardzo cieplutko, Bardzo serdecznie, Marianczello z tej Strony"));
        assertEquals("Szneka Z Glancem",ct_mock.transform("szneka z glancem"));
        assertEquals("Telefon Samsung Galaxy S7",ct_mock.transform("Telefon samsung galaxy S7"));
    }
    @Test
    void testCapitalize()
    {
        assertEquals("Witam Panów",ct.capitalize("witam panów"));
        assertEquals("Witampanów",ct.capitalize("witampanów"));
        assertEquals("A B C D E",ct.capitalize("a b c d e"));
    }
}