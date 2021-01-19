package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExpandTransformerTest {
    ExpandTransformer et;
    ExpandTransformer et_mock;
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
        et_mock = new ExpandTransformer(transformer_mock);
        et =new ExpandTransformer(transformer);
    }

    @Test
    void ExpandTransformerTestMock()
    {
        {
            assertEquals("NA PRZYKŁAD czy na przykład oto jest pytanie.",et_mock.transform("NP. czy np. oto jest pytanie."));
            assertEquals("Jestem między innymi studentem",et_mock.transform("Jestem m.in. studentem"));
            assertEquals("Łęcka to postać z książki Bolesława Prusa i tak dalej",et_mock.transform("Łęcka to postać z książki Bolesława Prusa itd."));
        }
    }

    @Test
    void testCapitalize() {
        assertEquals("ALA MA ZWIERZĘTA NA PRZYKŁAD kota",et.expand("ALA MA ZWIERZĘTA NP. kota"));
        assertEquals("NA PRZYKŁAD",et.expand("NP."));
        assertEquals("NNP.",et.expand("NNP."));
    }
    @Test
    void testLower() {
        assertEquals("Proszę Państwa, Wysoki Sądzie, to jest profesor Rafał Wilczur",et.expand("Proszę Państwa, Wysoki Sądzie, to jest prof. Rafał Wilczur"));
        assertEquals("myszka , klawiatura i tak dalej",et.expand("myszka , klawiatura itd."));
        assertEquals("myszka , klawiatura aitd.",et.expand("myszka , klawiatura aitd."));
    }
    @Test
    void testBegin() {
        assertEquals("i tak dalej witam ",et.expand("itd. witam "));
        assertEquals("profesor Mirosław Ochodek",et.expand("prof. Mirosław Ochodek"));
        assertEquals("aprof. Mirosław Ochodek",et.expand( "aprof. Mirosław Ochodek"));


    }
    @Test
    void testMiddle() {
        assertEquals("daniel I TYM PODOBNE mokito",et.expand("daniel ITP. mokito"));
        assertEquals("najlepszy matematyk to doktor Walczak",et.expand("najlepszy matematyk to dr Walczak"));
        assertEquals("najlepszy matematyk to dr. Walczak",et.expand( "najlepszy matematyk to dr. Walczak"));

    }
    @Test
    void testEnd() {
        assertEquals("kupiłem MIĘDZY INNYMI",et.expand("kupiłem M.IN."));
        assertEquals("kupiłem M.IN",et.expand("kupiłem M.IN"));
        assertEquals("kupiłem między innymi",et.expand("kupiłem m.in."));

    }
    @Test
    void testHARDCORE() {
        assertEquals("DOKTOR Dr dro to prawie PROFESOR profesor Prof. profe. na przykład NA PRZYKŁAD TO między innymi m.in.. Amen",
                et.expand("DR Dr dro to prawie PROF. prof. Prof. profe. np. NP. TO m.in. m.in.. Amen"));
    }


}