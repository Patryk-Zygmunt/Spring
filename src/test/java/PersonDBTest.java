import com.example32.DB.Demo32Application;
import com.example32.DB.Person;
import com.example32.DB.PersonDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by Linus on 06.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDBTest {
    @Autowired
    private Demo32Application demo;
    @Autowired
    private PersonDB personDB;

    @Test
    public void findByName(){

        Person person= new Person("Patryk","pass","Zygmunt",1234);
        personDB.save(person);
     Person FindPerson= personDB.findByName("Patryk");
        org.junit.Assert.assertEquals(person.getPassword(),FindPerson.getPassword());
    }


}
