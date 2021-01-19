package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InverseTransformerTest {
    Transformer transformer;
    Transformer transformer_mock;
    InverseTransformer test_mock;
    InverseTransformer test;

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
        test_mock = new InverseTransformer(transformer_mock);
        test = new InverseTransformer(transformer);
    }

    @Test
    void InverseTransformerTestMock()
    {
        assertEquals("Connect4 advanced", test_mock.transform("Decnavda 4tcennoc"));
        assertEquals("JoyStick", test_mock.transform("KciTsyoj"));
        assertEquals("Esuom dna draObyek", test_mock.transform("Keyboard and Mouse"));
        assertEquals("Elite_five", test_mock.transform("Evif_etile"));
    }

    @Test
    void InverseTest1SmallLetters()
    {
        assertEquals("volkswagen", test.inverse("negawsklov"));
        assertEquals("clio",test.inverse("oilc"));
        assertEquals("ford",test.inverse("drof"));

    }

    @Test
    void InverseTest2BigLetters()
    {
        assertEquals("VolkswageN", test.inverse("NegawskloV"));
        assertEquals("CliO",test.inverse("OilC"));
        assertEquals("ForD",test.inverse("DroF"));
    }

    @Test
    void InverseTest3Spaces()
    {
        assertEquals("Volk Golf", test.inverse("Flog Klov"));
        assertEquals("Clio Reno",test.inverse("Oner Oilc"));
        assertEquals("Forde Focus",test.inverse("Sucof Edrof"));
    }

    @Test
    void InverseTest4Numbers()
    {
        assertEquals("0123456789", test.inverse("9876543210"));
        assertEquals("01234 56789", test.inverse("98765 43210"));
        assertEquals("012345678 9", test.inverse("9 876543210"));
    }

    @Test
    void InverseTest5All()
    {
        assertEquals("volks Golf5", test.inverse("5flog Sklov"));
        assertEquals("voLvo v70", test.inverse("07V ovloV"));
    }

}
