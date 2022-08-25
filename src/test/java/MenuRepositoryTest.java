import com.CRM.CRM.models.*;
import com.CRM.CRM.models.enums.Product;
import com.CRM.CRM.models.enums.Status;
import com.CRM.CRM.repositories.OpportunityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.Id;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MenuRepositoryTest {
    private Opportunity opportunity1;
    private Opportunity opportunity2;
    private Opportunity opportunity3;
    private SalesRep salesRep = new SalesRep();
    private Contact contact = new Contact();
    private Account account = new Account();
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {
        opportunity1 = new Opportunity(Product.FLATBED, contact, Status.OPEN, account, salesRep);
        opportunity2 = new Opportunity(Product.BOX, contact, Status.CLOSED_WON, account, salesRep);
        opportunity3 = new Opportunity(Product.HYBRID, contact, Status.CLOSED_LOST, account, salesRep);
        opportunityRepository.saveAll(List.of(opportunity1, opportunity2, opportunity3));


        @Test
        @DisplayName("A count of all Opportunities by SalesRep insert a correct value")
        public List<Objects>findOpportunitiesBySalesRepCV(){
            System.setIn((InputStream) salesRep.getOpportunities()) ;
            Assertions.assertEquals(1,findOpportunitiesBySalesRepCV.size());

        }
        @Test
        @DisplayName("A count of all Opportunities by SalesRep insert a incorrect value")
        public List<Objects> findOpportunitiesBySalesRepIV(){
            System.setIn((InputStream) salesRep.getOpportunities()) ;
            Assertions.assertEquals(0, findOpportunitiesBySalesRepIV.size());

        }

        @Test
        @DisplayName("A count of all Hook by SalesRep insert a correct value")
        public List<Objects> findHooksBySalesRepCV(){
            System.setIn((InputStream) salesRep.getHooks()) ;
            Assertions.assertEquals(1, findHooksBySalesRepCV.size());

        }

        @Test
        @DisplayName("A count of all Hook by SalesRep insert a incorrect value")
        public List<Objects> findHooksBySalesRepIV(){
            System.setIn((InputStream) salesRep.getHooks()) ;
            Assertions.assertEquals(0, findHooksBySalesRepIV.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesBySalesRepCV() {
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesBySalesRep.size());

        }

        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesBySalesRepIV() {
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesBySalesRepCV() {
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesBySalesRepIV() {
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesBySalesRep.size());

        }
        //5
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesBySalesRepCV (){
            Assertions.assertEquals(1, findAllOpenOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesBySalesRepIV(){
            Assertions.assertEquals(0, findAllOpenOpportunitiesBySalesRep.size());

            //------------------------------------------------------
        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByProductCV () {
            Assertions.assertEquals(1, findAllOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByProductIV () {
            Assertions.assertEquals(0, findAllOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByProductCV () {
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByProductIV () {
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByProductCV () {
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesByProduct.size());

        }

        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByProductIV () {
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesByProduct.size());

        }

        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesByProductCV () {
            Assertions.assertEquals(1, findAllOpenOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesByProductIV () {
            Assertions.assertEquals(0, findAllOpenOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByCountryCV () {
            Assertions.assertEquals(1, findAllOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByCountryIV () {
            Assertions.assertEquals(0, findAllOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByCountrycV () {
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByCountryIV () {
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByCountryCV () {
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByCountryIV () {
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesByCountryCV () {
            Assertions.assertEquals(1, findAllOpenOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesByCountryIV () {
            Assertions.assertEquals(0, findAllOpenOpportunitiesByCountry.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByCityCV() {
            Assertions.assertEquals(1, findAllOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpportunitiesByCityIV () {
            Assertions.assertEquals(0, findAllOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByCityCV () {
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesByCity.size());

        }

        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedWonOpportunitiesByCityIV () {
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByCityCV () {
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllClosedLostOpportunitiesByCityIV () {
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects> findAllOpenOpportunitiesByCityCV () {
            Assertions.assertEquals(1, findAllOpenOpportunitiesByCity.size());

        }
        @Test
        @DisplayName("A ")
        public List<Objects>findAllOpenOpportunitiesByCityIV () {
            Assertions.assertEquals(0, findAllOpenOpportunitiesByCity.size());

        }



    }
}



