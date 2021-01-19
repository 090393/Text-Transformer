package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AbbreviationTransformerTest {

    AbbreviationTransformer at;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        at =new AbbreviationTransformer(transformer);
    }

    @Test
    void testCapitalize() {
        assertEquals("ALA MA ZWIERZĘTA NP. kota",at.abbreviate("ALA MA ZWIERZĘTA NA PRZYKŁAD kota"));
        assertEquals("NP.",at.abbreviate("NA PRZYKŁAD"));
        assertEquals("NANA PRZYKŁAD",at.abbreviate("NANA PRZYKŁAD"));
    }
    @Test
    void testLower() {
        assertEquals("ala ma zwierzęta np. kota",at.abbreviate("ala ma zwierzęta na przykład kota"));
        assertEquals("np.",at.abbreviate("na przykład"));
        assertEquals(" np. ",at.abbreviate(" na przykład "));
        assertEquals("na przykładoo",at.abbreviate("na przykładoo"));
    }
    @Test
    void testBegin() {
        assertEquals("m.in. kota",at.abbreviate("między innymi kota"));
        assertEquals("itp. kota",at.abbreviate("i tym podobne kota"));

    }
    @Test
    void testMiddle() {
        assertEquals("ala m.in. kota",at.abbreviate("ala między innymi kota"));
        assertEquals("kot itp. kota",at.abbreviate("kot i tym podobne kota"));
        assertEquals("ala amiędzy innymi kota",at.abbreviate("ala amiędzy innymi kota"));
        assertEquals("kot i tym podobnea kota",at.abbreviate("kot i tym podobnea kota"));
    }
    @Test
    void testEnd() {
        assertEquals("ala m.in.",at.abbreviate("ala między innymi"));
        assertEquals("kot itp.",at.abbreviate("kot i tym podobne"));
        assertEquals("ala amiędzy innymi",at.abbreviate("ala amiędzy innymi"));
        assertEquals("kot ai tym podobne",at.abbreviate("kot ai tym podobne"));

    }
    @Test
    void testHARDCORE() {
        assertEquals("NP. ala amiędzy innymiitak dalej POSIADA itp. kota np. na przykładi",
                at.abbreviate("NA PRZYKŁAD ala amiędzy innymiitak dalej POSIADA i tym podobne kota na przykład na przykładi"));
    }

}