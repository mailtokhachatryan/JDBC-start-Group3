package model;

import lombok.Getter;
import lombok.Setter;
import util.constants.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = Parameter.NOTES)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "user_id", nullable = false)
    private int userId;


    public Note() {
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
