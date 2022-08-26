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

    }
        @Test
        @DisplayName("A count of all Opportunities by SalesRep insert a correct value")
        public void findOpportunitiesBySalesRepCV(){
            System.setIn((InputStream) salesRep.getOpportunities()) ;
            Assertions.assertEquals(1,findOpportunitiesBySalesRepCV.size());

        }
        @Test
        @DisplayName("A count of all Opportunities by SalesRep insert a incorrect value")
        public void findOpportunitiesBySalesRepIV(){
            System.setIn((InputStream) salesRep.getOpportunities()) ;
            Assertions.assertEquals(0, findOpportunitiesBySalesRepIV.size());

        }

        @Test
        @DisplayName("A count of all Hook by SalesRep insert a correct value")
        public void findHooksBySalesRepCV(){
            System.setIn((InputStream) salesRep.getHooks()) ;
            Assertions.assertEquals(1, findHooksBySalesRepCV.size());

        }

        @Test
        @DisplayName("A count of all Hook by SalesRep insert a incorrect value")
        public void  findHooksBySalesRepIV(){
            System.setIn((InputStream) salesRep.getHooks()) ;
            Assertions.assertEquals(0, findHooksBySalesRepIV.size());

        }
        @Test
        @DisplayName("A count closed won opportunities by saleRep  ")
        public void findAllClosedWonOpportunitiesBySalesRepCV() {
            System.setIn((InputStream) Opportunities.getSalesRep());
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesBySalesRep.size());

        }

        @Test
        @DisplayName("A count closed won opportunities by saleRep ")
        public void findAllClosedWonOpportunitiesBySalesRepIV() {
            System.setIn((InputStream) Opportunities.getSalesRep().StatusClosedWon);
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName("A count closed lost opportunities by saleRep ")
        public void findAllClosedLostOpportunitiesBySalesRepCV() {
            System.setIn((InputStream) opportunity1.getSalesRep().Status.CLOSED.lost);
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName(" Invalid A count closed lost opportunities by saleRep ")
        public void findAllClosedLostOpportunitiesBySalesRepIV() {
            System.setIn((InputStream) opportunity1.getSalesRep().Status.CLOSED.lost);
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesBySalesRep.size());

        }
        //5
        @Test
        @DisplayName("A count open opportuniyies by saleRep  ")
        public void findAllOpenOpportunitiesBySalesRepCV (){
            System.setIn((InputStream) opportunity1.getSalesRep().Status.OPEN);
            Assertions.assertEquals(1, findAllOpenOpportunitiesBySalesRep.size());

        }
        @Test
        @DisplayName("Invalid A count open opportuniyies by saleRep  ")
        public void findAllOpenOpportunitiesBySalesRepIV(){
            System.setIn((InputStream) opportunity1.getSalesRep().Status.OPEN);
            Assertions.assertEquals(0, findAllOpenOpportunitiesBySalesRep.size());

            //------------------------------------------------------
        }
        @Test
        @DisplayName("A count of all Opportunities by Product insert a correct value ")
        public void findAllOpportunitiesByProductCV () {
            System.setIn((InputStream) Product.getAllOpportunities()) ;
            Assertions.assertEquals(1, findAllOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName(" Invalid count of all Opportunities by Product insert a incorrect value ")
        public void findAllOpportunitiesByProductIV () {
            System.setIn((InputStream) Product.getAllOpportunities()) ;
            Assertions.assertEquals(0, findAllOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("A count closed won opportunities by Product ")
        public void findAllClosedWonOpportunitiesByProductCV () {
            System.setIn((InputStream) Opportunities.getProduct().StatusClosedWon);
            Assertions.assertEquals(1, findAllClosedWonOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName("Invalid A count closed won opportunities by Product \"")
        public void findAllClosedWonOpportunitiesByProductIV () {
            System.setIn((InputStream) Opportunities.getProduct().StatusClosedWon);
            Assertions.assertEquals(0, findAllClosedWonOpportunitiesByProduct.size());

        }
        @Test
        @DisplayName(" A count closed lost opportunities by Product ")
        public void findAllClosedLostOpportunitiesByProductCV () {
            System.setIn((InputStream) opportunity1.getProduct().Status.CLOSED.lost);
            Assertions.assertEquals(1, findAllClosedLostOpportunitiesByProduct.size());

        }

        @Test
        @DisplayName("A ")
        public void findAllClosedLostOpportunitiesByProductIV () {
            System.setIn((InputStream) opportunity1.getProduct().Status.CLOSED.lost);
            Assertions.assertEquals(0, findAllClosedLostOpportunitiesByProduct.size());

        }
}
