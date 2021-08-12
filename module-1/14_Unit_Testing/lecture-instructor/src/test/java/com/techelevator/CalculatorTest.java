package com.techelevator;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class...");
    }

    @After
    public void after() {
        System.out.println("After ...");
    }


    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Before...");
    }

    @Test
    public void add() {


        System.out.println("Test...");

        //Act and assert
        Assert.assertEquals(3,calc.add(2,1));
        Assert.assertEquals(-4, calc.add(-1, -3));
        Assert.assertEquals(4, calc.add(0, 4));
        Assert.assertEquals(3, calc.add(3, 0));
        Assert.assertEquals(-2, calc.add(-3, 1));

    }

    @Test
    public void returnNull() {

        System.out.println("Test...");
        //Arrange


        //Act and assert
        Assert.assertNull(calc.returnNull());
    }

    @Test
    public void testIfNumberDivisibleByTwo() {

        System.out.println("Test...");
        //Arrange


        //Act and Assert
        Assert.assertTrue(calc.isEvenNumber(8));
        Assert.assertFalse(calc.isEvenNumber(3));
        Assert.assertTrue(calc.isEvenNumber(0));
        Assert.assertTrue(calc.isEvenNumber(-2));



    }



//    public Result add (WrappedNumbers nums) {
//        return new Result(nums.getNumber1() + nums.getNumber2());
//    }
    @Test
    public void addWithObjects() {

        //Arrange
        WrappedNumbers testInts1 = new WrappedNumbers(7,1);

        //Act
        Result rs = calc.add(testInts1);

        //Assert
        Assert.assertEquals(8, rs.getResult() );

//       double a = 1.00008;
//
//       Assert.assertEquals(1.00, a, DELTA);

    }


    @Test
    public void testFizzBuzz() {

        //test for divisible by 3
        Assert.assertEquals("fizz", calc.fizzBuzz(6));

        //test for div by 5

        //test for both 3 and 5

        //none of the above

    }
}