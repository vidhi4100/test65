import org.testng.annotations.*;

public class TestNGAnnotation {


    @BeforeSuite
    public void testBeforeSuite(){
        System.out.println("@Before-Suite...India");
    }

    @AfterSuite
    public void testAfterSuite(){
        System.out.println("@After-Suite...India");
    }

    @BeforeTest
    public void testBeforeTest(){
        System.out.println("@Before-Test...Gujarat");
    }

    @AfterTest
    public void testAfterTest(){
        System.out.println("@After-Test...Gujarat");
    }

    @BeforeClass
    public void testBeforeClass(){
        System.out.println("@Before-Class...GandhiNagar");
    }

    @AfterClass
    public void testAfterClass(){
        System.out.println("@After-Class...GandhiNagar");
    }

    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("@Before-Method...Sargasan");
    }

    @AfterMethod
    public void testAfterMethod(){
        System.out.println("@After-Method...Sargasan");
    }

    @BeforeGroups
    public void testBeforeGroups(){
        System.out.println("..@..Before..Groups");
    }

    @AfterGroups
    public void testAfterGroups(){
        System.out.println("..@..After..Groups");
    }

    @Test
    public void Test01(){
        System.out.println(">.................Test....................<");
    }
}
