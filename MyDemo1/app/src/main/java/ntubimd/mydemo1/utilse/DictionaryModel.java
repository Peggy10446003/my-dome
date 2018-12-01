package ntubimd.mydemo1.utilse;

/**
 * Created by User on 2018/8/16.
 */

public class DictionaryModel {
    private String id;
    private String word;
    private String definition;

    public DictionaryModel(String id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }
}
