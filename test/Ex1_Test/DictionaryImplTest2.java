package Ex1_Test;

import Ex1.DictionaryImpl;
import Ex1.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DictionaryImplTest2 {
    private DictionaryImpl dict;

    @BeforeEach
    public void initDictionary() {
        dict = new DictionaryImpl();
    }

    @Test
    public void getDefinition() throws NotDefinedException {
        assertThrows(NotDefinedException.class ,() -> {dict.getDefinitions("a");});
    }

    @Test
    void defineNewWord() throws NotDefinedException {
        dict.defineWord("chamba", "mi primera chamba");
        List<String> def = new ArrayList<>();
        def.add("mi primera chamba");
        assertEquals( def, dict.getDefinitions("chamba"));
    }
}