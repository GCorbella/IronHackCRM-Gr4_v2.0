import Classes.Lead;
import Menu.Menu;
import com.CRM.CRM.models.Menu;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuTest {

    Lead lead1 = new Lead("Juan","684895932", "juan1234@test.com","Desatranques Jaen");
    Lead lead2= new Lead("Jose","68340253","jose123@test.com","Ironhack");
    Lead lead3 = new Lead("Maria","69492022", "mariantonia@test.com","Telefonica");

    @BeforeEach
    void setup(){

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    @DisplayName("Should accept valid phone")
    void setPhoneTest() {
        System.setIn(new ByteArrayInputStream("999999999".getBytes()));
        String validPhone = Menu.setPhone();
        assertEquals("999999999", validPhone);
    }

    @Test
    @DisplayName("Should accept valid company name")
    void setCompanyNameTest() {
        System.setIn(new ByteArrayInputStream("Burton Global".getBytes()));
        String validCompanyName = Menu.setCompanyName();
        assertEquals("Burton Global", validCompanyName);
    }

    @Test
    @DisplayName("List all leads")
    void testListAllLeads(){
        List<Lead> allLeads= new ArrayList<>();
        allLeads.add(lead1);
        allLeads.add(lead2);
        allLeads.add(lead3);
        assertEquals(allLeads,List.of(lead1,lead2,lead3));
    }

    @Test
    @DisplayName("Find a lead by his Id")
    void testFindLeadById(){
        assertEquals(0,lead3.getId());
    }
    @Test
    @DisplayName("Throw exception ID not match with any lead")
    void testIdNotFound(){
    }
}
