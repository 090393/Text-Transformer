package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CapitalizeTransformerTest {

    CapitalizeTransformer ct;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        ct =new CapitalizeTransformer(transformer);
    }
    @Test
    void testCapitalize()
    {
        assertEquals("Witam Panów",ct.capitalize("witam panów"));
        assertEquals("Witampanów",ct.capitalize("witampanów"));
        assertEquals("A B C D E",ct.capitalize("a b c d e"));
        assertEquals("A B C D E ",ct.capitalize("a b c d e "));

    }
}