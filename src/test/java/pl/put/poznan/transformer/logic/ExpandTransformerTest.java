package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ExpandTransformerTest {
    ExpandTransformer et;
    Transformer transformer;

    @BeforeEach
    void setUp() {
        transformer= mock(Transformer.class);
        et =new ExpandTransformer(transformer);
    }

    @Test
    void testCapitalize() {
        assertEquals("ALA MA ZWIERZĘTA NP. kota",et.expand("ALA MA ZWIERZĘTA NA PRZYKŁAD kota"));
        assertEquals("NP.",et.expand("NA PRZYKŁAD"));
        assertEquals("NANA PRZYKŁAD",et.expand("NANA PRZYKŁAD"));
    }
    @Test
    void testLower() {
        assertEquals("ala ma zwierzęta np. kota",et.expand("ala ma zwierzęta na przykład kota"));
        assertEquals("np.",et.expand("na przykład"));
        assertEquals(" np. ",et.expand(" na przykład "));
        assertEquals("na przykładoo",et.expand("na przykładoo"));
    }
    @Test
    void testBegin() {
        assertEquals("m.in. kota",et.expand("między innymi kota"));
        assertEquals("itp. kota",et.expand("i tym podobne kota"));

    }
    @Test
    void testMiddle() {
        assertEquals("ala m.in. kota",et.expand("ala między innymi kota"));
        assertEquals("kot itp. kota",et.expand("kot i tym podobne kota"));
        assertEquals("ala amiędzy innymi kota",et.expand("ala amiędzy innymi kota"));
        assertEquals("kot i tym podobnea kota",et.expand("kot i tym podobnea kota"));
    }
    @Test
    void testEnd() {
        assertEquals("ala m.in.",et.expand("ala między innymi"));
        assertEquals("kot itp.",et.expand("kot i tym podobne"));
        assertEquals("ala amiędzy innymi",et.expand("ala amiędzy innymi"));
        assertEquals("kot ai tym podobne",et.expand("kot ai tym podobne"));

    }
    @Test
    void testHARDCORE() {
        assertEquals("NP. ala amiędzy innymiitak dalej POSIADA itp. kota np. na przykładi",
                et.expand("NA PRZYKŁAD ala amiędzy innymiitak dalej POSIADA i tym podobne kota na przykład na przykładi"));
    }


}