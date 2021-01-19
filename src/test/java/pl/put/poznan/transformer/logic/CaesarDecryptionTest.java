package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CaesarDecryptionTest {
    CaesarDecryption ce;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        ce =new CaesarDecryption(transformer);
    }
    @Test
    void testLower()
    {
        assertEquals("abcde",ce.decode("cdefg"));
        assertEquals(" abcde ",ce.decode(" cdefg "));


    }
    @Test
    void testUpper()
    {
        assertEquals("ABCDE",ce.decode("CDEFG"));
        assertEquals("AbCde",ce.decode("CdEfg"));
        assertEquals("AbCde ",ce.decode("CdEfg "));

    }

}