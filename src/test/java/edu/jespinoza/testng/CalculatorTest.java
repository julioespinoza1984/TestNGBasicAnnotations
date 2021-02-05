package edu.jespinoza.testng;

import java.lang.reflect.Method;

import edu.jespinoza.testng.impl.CalculatorImpl;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    private static final Logger logger = Logger.getLogger(CalculatorTest.class);

    private Calculator calculator;

    @BeforeClass
    public void beforeClass(){
        //Ideal place to perform some setup which is shared among all tests.
        //E.g. Initializing DB connection, setting environment properties
        logger.info("@BeforeClass: Se ejecuta una sola vez, antes de que el primer test empiece.\n");
        calculator = CalculatorImpl.getInstance();
    }

    @AfterClass
    public void afterClass(){
        //Ideal place to perform some cleanup of setup which is shared among all tests.
        logger.info("@AfterClass: Se ejecuta una sola vez, después que todos los test han sido ejecutados.\n");
        calculator = null;
    }

    @BeforeMethod
    public void beforeEachTestMethod(Method method){//Parameter are optional
        //May perform some initialization/setup before each test.
        //E.g. Initializing User whose properties may be altered by actual @Test
        logger.info("\n@BeforeMethod: Se ejecuta antes de cada método del test. El Test a ser ejecutado es : "+method.getName());
    }

    @AfterMethod
    public void afterEachTestMethod(Method method){//Parameter are optional
        //May perform cleanup of initialization/setup after each test.
        logger.info("@AfterMethod: Se ejecuta después de cada método del test. El Test que fue ejecutado era : "+method.getName()+"\n");
    }

    @Test
    public void testAdd(){
        logger.info("@Test add");
        Assert.assertEquals(calculator.add(2, 3), 5.0);
    }

    @Test
    public void testSubtract(){
        logger.info("@Test subtract");
        Assert.assertTrue(calculator.subtract(5, 3) > 1, "Subtract test failed");
    }

    @Test
    public void testMultiply(){
        logger.info("@Test multiply");
        Assert.assertEquals(calculator.multiply(5, 3) , 15.0);
    }
}