import Classes.Lead;
import Menu.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeadTest {

  @Test
    @DisplayName("Set a name to a lead")
    void testSetNameLead(){
       System.setIn(new ByteArrayInputStream("Pepito Perez".getBytes()));
       String validName = Menu.setName();
        assertEquals("Pepito Perez",validName);
    }
    @Test
    @DisplayName("Set a phone to a lead")
    void testSetPhoneLead(){
        System.setIn(new ByteArrayInputStream("693848205".getBytes()));
        String validPhone = Menu.setPhone();
        assertEquals("693848205",validPhone);
    }
    @Test
    @DisplayName("Set a email to a lead")
    void testSetEmailLead() {
        System.setIn(new ByteArrayInputStream("pepitoperez@test.com".getBytes()));
        String validEmail = Menu.setEmail();
        assertEquals("pepitoperez@test.com", validEmail);
    }
    @Test
    @DisplayName("Set a company to a lead")
    void testSetCompanyLead() {
        System.setIn(new ByteArrayInputStream("Ironhack".getBytes()));
        String validCompany = Menu.setCompanyName();
        assertEquals("Ironhack", validCompany);
    }


}
