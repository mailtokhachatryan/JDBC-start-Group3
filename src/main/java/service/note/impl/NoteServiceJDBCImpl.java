package service.note.impl;

import lombok.RequiredArgsConstructor;
import model.Note;
import repository.note.NoteRepository;
import service.note.NoteService;

import java.sql.Connection;
import java.util.List;

@RequiredArgsConstructor
public class NoteServiceJDBCImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final Connection connection;

    @Override
    public void create(Note note, int userId) {

    }

    @Override
    public void update(Note note) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Note> getAll(int userId) {
        return noteRepository.getAll(userId);
    }

    @Override
    public Note getById(int userId) {
        return null;
    }
}
