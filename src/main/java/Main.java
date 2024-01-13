import model.Note;
import model.User;
import org.hibernate.SessionFactory;
import repository.note.NoteRepository;
import repository.note.impl.NoteRepositoryJDBCImpl;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import repository.user.impl.UserRepositoryJPAImpl;
import service.note.NoteService;
import service.note.impl.NoteServiceJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.DataSource;
import util.HibernateDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
//        Connection connection = DataSource.getConnection();
//        NoteRepository noteRepository=new NoteRepositoryJDBCImpl(connection);
//        NoteServiceJDBCImpl noteService=new NoteServiceJDBCImpl(noteRepository,connection);


        UserRepository userRepository = new UserRepositoryJPAImpl();

//        userRepository.create(new User("Aghasi","Khachatryan","mailtokhachatradyan96@gmail.com","password",27));

        userRepository.delete(3);


        HibernateDataSource.getSessionFactory().close();
    }
}
