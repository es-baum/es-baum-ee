package de.esbaum.ee.ejb.beans;

import de.esbaum.ee.ejb.entities.CommonEntity;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author martin.scholl@cismet.de
 * @version 1.0
 */
public class TestSessionBeanLocalNGTest {

    public TestSessionBeanLocalNGTest() {
    }
    
    @EJB
    private TestSessionBeanLocal tsb;
     
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(CommonEntity.class.getPackage())
            .addPackage(TestSessionBeanLocal.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    public void printCurrentTestName() {
        System.out.println("TEST " + new Throwable().getStackTrace()[1].getMethodName());
    }

    /**
     * Test of businessMethod method, of class TestSessionBeanLocal.
     */
    @Test
    public void testBusinessMethod() {
        System.out.println("businessMethod");
        
//        assertNotNull(tsb);
//        tsb.businessMethod();
    }
}