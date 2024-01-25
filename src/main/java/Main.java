import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.user.UserRepoData;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");

        UserRepoData bean = classPathXmlApplicationContext.getBean(UserRepoData.class);

        List<User> all = bean.findAll();

        System.out.println(all);

        System.out.println(bean.findByEmail("asdsad"));

//        System.out.println(all);

//        Robot robot =  classPathXmlApplicationContext.getBean(Robot.class);
//
//        robot.think();
//        robot.walk();
//        robot.hit();

    }
}
