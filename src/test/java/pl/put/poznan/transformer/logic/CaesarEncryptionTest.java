package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CaesarEncryptionTest {

    CaesarEncryption ce;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        ce =new CaesarEncryption(transformer);
    }
    @Test
    void testLower()
    {
        assertEquals("cdefg",ce.encode("abcde"));
        assertEquals(" cdefg ",ce.encode(" abcde "));


    }
    @Test
    void testUpper()
    {
        assertEquals("CDEFG",ce.encode("ABCDE"));
        assertEquals("CdEfg",ce.encode("AbCde"));
        assertEquals("CdEfg ",ce.encode("AbCde "));

    }

}