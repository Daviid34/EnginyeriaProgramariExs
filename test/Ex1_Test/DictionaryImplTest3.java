package Ex1_Test;

import Ex1.DictionaryImpl;
import Ex1.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryImplTest3 {
    private DictionaryImpl dict;

    @BeforeEach
    public void initDictionary() {
        dict.defineWord("hola", "accion de saludar");
        dict.defineWord("hola", "declarar los buenos dias a una persona");
    }

    @Test
    public void wordWithMultipleDefinition() throws NotDefinedException {
        DictionaryImpl dictionary = new DictionaryImpl();
        dictionary.defineWord("hola", "accion de saludar");
        dictionary.defineWord("hola", "declarar los buenos dias a una persona");
        assertEquals(dict.getDefinitions("hola"), dictionary.getDefinitions("hola"));
    }
}