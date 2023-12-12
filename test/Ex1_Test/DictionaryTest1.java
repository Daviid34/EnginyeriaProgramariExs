package Ex1_Test;

import Ex1.DictionaryImpl;
import Ex1.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryTest1 {
    private DictionaryImpl dict;
    private DictionaryImpl dictionary;

    @BeforeEach
    public void initDictionary() {
        dict = new DictionaryImpl();
        dict.defineWord("hola", "accion de saludar");
        dictionary = new DictionaryImpl();
    }

    @Test
    public void addNewWord() throws NotDefinedException {
        dictionary.defineWord("hola", "accion de saludar");
        assertEquals(dictionary.getDefinitions("hola"), dict.getDefinitions("hola"));
    }

    @Test
    public void getDefinitions() throws NotDefinedException {
        dictionary.defineWord("hola", "accion de saludar");
        List<String> def = new ArrayList<>();
        def.add("accion de saludar");
        assertEquals(def, dictionary.getDefinitions("hola"));
    }
}