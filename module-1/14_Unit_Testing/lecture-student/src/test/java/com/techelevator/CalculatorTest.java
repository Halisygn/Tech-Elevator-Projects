package com.techelevator;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class ....");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class ....");
    }
    @After
    public void afterTest(){
        System.out.println("After ....");

    }
    @Before
    public void setUp(){// apply every single test
        calc=new Calculator();
        System.out.println("Before ....");
    }
    @Test
    public void add() {
        System.out.println("Test1 ....");

        //Arrange
        Calculator calc=new Calculator();
        //Act and assert
        Assert.assertEquals(3,calc.add(2,1));
        Assert.assertEquals(-4,calc.add(-1,-3));
        Assert.assertEquals(4,calc.add(0,4));
        Assert.assertEquals(3,calc.add(3,0));
        Assert.assertEquals(-2,calc.add(-3,1));


    }

    @Test
    public void returnNull() {
        System.out.println("Test2 ....");

        //Arrange
        Calculator calc=new Calculator();
        //Act and assert
        Assert.assertNull(calc.returnNull());
    }

    @Test
    public void testIfNUmberDivisibleByTwo(){
        System.out.println("Test3 ....");

        //Arrange
        Calculator calc= new Calculator();

        //Assert
        Assert.assertTrue(calc.isEvenNumber(8));
        Assert.assertFalse(calc.isEvenNumber(3));
        Assert.assertTrue(calc.isEvenNumber(0));
        Assert.assertTrue(calc.isEvenNumber(-2));
    }
    @Test
    public void addWithObjects(){
        //Arrange
        WrappedNumbers testInts1=new WrappedNumbers(1,7);

        //Act
        Result rs=calc.add(testInts1);

        //Assert
        Assert.assertEquals(8,rs.getResult());
    }

    @Test
    public void testFuzzBuzz(){
        Assert.assertEquals("fizz", calc.fizzBuzz(6));
        Assert.assertEquals("buzz", calc.fizzBuzz(10));
        Assert.assertEquals("fizzbuzz", calc.fizzBuzz(15));
        Assert.assertEquals("8",calc.fizzBuzz(8));

    }

}