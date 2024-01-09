import model.Note;
import model.User;
import repository.note.NoteRepository;
import repository.note.impl.NoteRepositoryJDBCImpl;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import service.note.NoteService;
import service.note.impl.NoteServiceJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
//        Connection connection = DataSource.getConnection();
//        NoteRepository noteRepository=new NoteRepositoryJDBCImpl(connection);
//        NoteServiceJDBCImpl noteService=new NoteServiceJDBCImpl(noteRepository,connection);





    }
}
