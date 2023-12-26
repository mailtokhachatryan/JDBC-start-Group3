package repository.note;

import model.Note;

import java.util.List;

public interface NoteRepository {

    void create(Note note,int userId);

    void update(Note note);

    void delete(int id);

    List<Note> getAll(int userId);

    Note getById(int userId);

}
