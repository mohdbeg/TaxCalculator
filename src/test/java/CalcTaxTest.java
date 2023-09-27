import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycompany.calctax.CalcTax;


public class CalcTaxTest {
    public CalcTax calcTax;

    @BeforeEach
    public void setUp() {
        calcTax = new CalcTax();
    }

    @AfterEach
    public void tearDown() {
        calcTax = null;
    }
    
    @Test
    public void testInvalidSalary() {
        double amountSalary = -30; // Negative input
        boolean localEmployee = true;
        double expectedTax = -1; // Error expected
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01);
    }
    
    @Test
    public void testLocalSalaryLessThan18000_EP() {
        double amountSalary = 10000;
        boolean localEmployee = true;
        double expectedTax = 0;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryLocalSalaryLessThan18000_BVA() {
        double amountSalary = 17999;
        boolean localEmployee = true;
        double expectedTax = 0;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testLocalSalaryBetween18000and30000_EP() {
        double amountSalary = 22000;
        boolean localEmployee = true;
        double expectedTax = 2200;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryLocalSalaryBetween18000and30000_BVA() {
        double amountSalary = 18000;
        boolean localEmployee = true;
        double expectedTax = 1800;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryLocalSalaryBetween18000and30000_BVA() {
        double amountSalary = 30000;
        boolean localEmployee = true;
        double expectedTax = 3000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testLocalSalaryBetween30000and50000_EP() {
        double amountSalary = 40000;
        boolean localEmployee = true;
        double expectedTax = 3800;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryLocalSalaryBetween30000and50000_BVA() {
        double amountSalary = 30001;
        boolean localEmployee = true;
        double expectedTax = 2000.18;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryLocalSalaryBetween30000and50000_BVA() {
        double amountSalary = 50000;
        boolean localEmployee = true;
        double expectedTax = 5600;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testLocalSalaryBetween50000and100000_EP() {
        double amountSalary = 75000;
        boolean localEmployee = true;
        double expectedTax = 10000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryLocalSalaryBetween50000and100000_BVA() {
        double amountSalary = 50001;
        boolean localEmployee = true;
        double expectedTax = 5000.2;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    

    @Test
    public void testMaxBoundaryLocalSalaryBetween50000and100000_BVA() {
        double amountSalary = 100000;
        boolean localEmployee = true;
        double expectedTax = 15000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testLocalSalaryGreaterThen100000_EP() {
        double amountSalary = 150000;
        boolean localEmployee = true;
        double expectedTax = 25000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryLocalSalaryGreaterThen100000_EP() {
        double amountSalary = 100001;
        boolean localEmployee = true;
        double expectedTax = 10000.3;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.04); // Adjust delta as needed.
    }
    
    @Test
    public void testInvalidInternationalSalary() {
        double amountSalary = -20; // Negative input
        boolean localEmployee = false;
        double expectedTax = -1; // Error expected
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01);
    }
    
    @Test
    public void testInternationalSalaryLessThan18000_EP() {
        double amountSalary = 10000;
        boolean localEmployee = false;
        double expectedTax = 1000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryInternationalSalaryLessThan18000_BVA() {
        double amountSalary = 17999;
        boolean localEmployee = false;
        double expectedTax = 1799.9;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testInternationalSalaryBetween18000and30000_EP() {
        double amountSalary = 22000;
        boolean localEmployee = false;
        double expectedTax = 3300;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryInternationalSalaryBetween18000and30000_BVA() {
        double amountSalary = 18000;
        boolean localEmployee = false;
        double expectedTax = 2700;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryInternationalSalaryBetween18000and30000_BVA() {
        double amountSalary = 30000;
        boolean localEmployee = false;
        double expectedTax = 4500;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testInternationalSalaryBetween30000and50000_EP() {
        double amountSalary = 40000;
        boolean localEmployee = false;
        double expectedTax = 6000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryInternationalSalaryBetween30000and50000_BVA() {
        double amountSalary = 30001;
        boolean localEmployee = false;
        double expectedTax = 4000.2;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMaxBoundaryIntenationalSalaryBetween30000and50000_BVA() {
        double amountSalary = 50000;
        boolean localEmployee = false;
        double expectedTax = 8000;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testInternationalSalaryBetween50000and100000_EP() {
        double amountSalary = 75000;
        boolean localEmployee = false;
        double expectedTax = 16250;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryInternationalSalaryBetween50000and100000_BVA() {
        double amountSalary = 50001;
        boolean localEmployee = false;
        double expectedTax = 10000.25;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    

    @Test
    public void testMaxBoundaryInternationalSalaryBetween50000and100000_BVA() {
        double amountSalary = 100000;
        boolean localEmployee = false;
        double expectedTax = 22500;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testInternationalSalaryGreaterThen100000_EP() {
        double amountSalary = 150000;
        boolean localEmployee = false;
        double expectedTax = 37500;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.01); // Adjust delta as needed.
    }
    
    @Test
    public void testMinBoundaryInternationalSalaryGreaterThen100000_EP() {
        double amountSalary = 100001;
        boolean localEmployee = false;
        double expectedTax = 20000.35;
        double result = calcTax.computeIncomeTax(amountSalary, localEmployee);
        assertEquals(expectedTax, result, 0.04); // Adjust delta as needed.
    }
       
}
