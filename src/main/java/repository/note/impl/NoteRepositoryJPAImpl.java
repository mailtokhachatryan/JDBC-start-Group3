package repository.note.impl;

import model.Note;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import repository.note.NoteRepository;
import util.HibernateDataSource;
import util.constants.Parameter;

import java.util.List;

public class NoteRepositoryJPAImpl implements NoteRepository {

    private SessionFactory sessionFactory = HibernateDataSource.getSessionFactory();

    @Override
    public void create(Note note, int userId) {
        Session session = sessionFactory.openSession();
        session.save(note);
        session.close();
    }

    @Override
    public void update(Note note) {
        Session session = sessionFactory.openSession();
        session.update(note);
        session.close();

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Note note = getById(id);
        session.delete(note);
        session.close();

    }

    @Override
    public List<Note> getAll(int userId) {
        Session session = sessionFactory.openSession();
        NativeQuery<Note> nativeQuery = session.createNativeQuery("SELECT * FROM notes where user_id=: userId", Note.class);
        List<Note> listNote = nativeQuery.setParameter("userId", userId).getResultList();
        session.close();
        return listNote;

    }

    @Override
    public Note getById(int userId) {
        Session session = sessionFactory.openSession();
        Note note = session.get(Note.class, userId);
        session.close();
        return note;
    }
}
