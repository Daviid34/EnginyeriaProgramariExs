package Ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DictionaryImpl implements Dictionary{
    HashMap<String, List<String>> dict;
    public DictionaryImpl() {
        dict = new HashMap<>();
    }

    public void defineWord (String word, String definition) {
        List<String> definitions;
        if (dict.containsKey(word)) {
            definitions = dict.get(word);
            definitions.add(definition);
            dict.replace(word, definitions);
        } else {
            definitions = new ArrayList<>();
            definitions.add(definition);
            dict.put(word, definitions);
        }
    }
    public List<String> getDefinitions(String word) throws NotDefinedException {
        if (dict.containsKey(word)) {
            return dict.get(word);
        }
        throw new NotDefinedException("Error");
    }
}

