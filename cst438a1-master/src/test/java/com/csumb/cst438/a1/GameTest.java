package com.csumb.cst438.a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of Game class
 * @author david wisneski
 * @veraion 1.0
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getState method, of class Game.
     * at start of game, state should be 1.
     * a correct guess will not change the state
     * an incorrect guess will increase state by 1
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Game instance = new Game();
        int expResult = 1;
        int result = instance.getState();
        assertEquals(expResult, result);
        String word = instance.getWord();
        instance.playGame(word.charAt(0));
        result = instance.getState();
        assertEquals(expResult, result);
        instance.playGame(getWrongLetter(word));
        result = instance.getState();
        assertEquals(expResult+1, result);
    }

    /**
     * Test of getWord method, of class Game.
     */
    @org.junit.Test
    public void testGetWord() {
        System.out.println("getWord");
        Game instance = new Game();
        String expResult = instance.getWord();
        String result = instance.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayWord method, of class Game.
     */
    @org.junit.Test
    public void testGetDisplayWord() {
        System.out.println("getDisplayWord");
        Game instance = new Game();
        String expResult = instance.getDisplayWord();
        String result = instance.getDisplayWord();
        assertEquals(expResult, result);
        instance.playGame('r');
        expResult = instance.getDisplayWord();
        result = instance.getDisplayWord();
        assertEquals(expResult, result);

    }

    /**
     * Test of startNewGame method, of class Game.
     */
    @org.junit.Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        Game instance = new Game();
        instance.startNewGame();
        instance.playGame('c');
        instance.playGame('d');
        instance.startNewGame();
        int result = instance.getState();
        assertEquals(1,result);
 
    }

    /**
     * Test of playGame method, of class Game.
     *   correct guess should return 0 , or 1 when game is won
     *   incorrect guess should return 2, or 3 when game is lost
     */
    @org.junit.Test
    public void testPlayGame() {
        System.out.println("playGame");
        
        Game instance = new Game();
        int result = 0;
        int expResult = 0;
        String word = instance.getWord();
        result = instance.playGame(word.charAt(0));
        assertEquals(expResult, result);
        char wrongLetter = getWrongLetter(word);
        result = instance.playGame(wrongLetter);
        assertEquals(2, result);
        result = instance.playGame(wrongLetter);
        assertEquals(2, result);
        result = instance.playGame(wrongLetter);
        assertEquals(2, result);
        result = instance.playGame(wrongLetter);
        assertEquals(2,result);
        result = instance.playGame(wrongLetter);
        assertEquals(2,result);
        result = instance.playGame(wrongLetter);
        assertEquals(3,result);
        
        instance.startNewGame();
        word = instance.getWord();
        result = instance.playGame(word.charAt(0));
        assertEquals(0, result);
        for(int i = 1; i < word.length(); i++)
        {
            if (!word.equals(instance.getDisplayWord()))
            {
                result = instance.playGame(word.charAt(i));
            }
        }
        assertEquals(1, result);
       
    }
    
    /**
     * Test of isValid method, of class Game.
     */
    @org.junit.Test
    public void testIsValid() {
        System.out.println("isValid");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isValid("1"); //test special inputs
        assertEquals(expResult, result);
        result = instance.isValid("as"); //test multiple input
        assertEquals(expResult, result);
        result = instance.isValid(" "); //test empty input
        assertEquals(expResult, result);
        expResult = true;
        result = instance.isValid("a"); //test lowercase
        assertEquals(expResult, result);
        result = instance.isValid("A"); //test uppercase
        assertEquals(expResult, result);
    }
    
    /**
     * provide a wrong letter for guess to check
     */
    private char getWrongLetter(String word)
    {
        char[] wrongLetter = {'x', 'y', 'z'};
        boolean exist;
        int place = 0;
        for (int i = 0; i < 3; i++)
        {
            exist = false;
            for (int j = 0; j < word.length(); j++)
            {
                if (word.charAt(j)== wrongLetter[i])
                {
                    exist = true;
                }
            }
            if (!exist)
            {
                place = i;
            }
        }
        
        return wrongLetter[place];
    }
    
}
