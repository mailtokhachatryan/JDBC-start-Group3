package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Note {

    private int id;
    private String title;
    private String description;


    public Note() {
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
