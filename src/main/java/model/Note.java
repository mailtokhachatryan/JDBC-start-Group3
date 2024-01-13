package model;

import lombok.Getter;
import lombok.Setter;
import util.constants.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = Parameter.NOTES)
public class Note {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column(table = Parameter.USERS,nullable = false )
    private int userId;


    public Note() {
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
