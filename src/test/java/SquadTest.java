import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }
    private Squad setupNewSquad(){
        return new Squad ("avengers", 5, "help the poor");
    }

    @Test
    public void SquadInstantiatesWithName_true() throws Exception{
        Squad mySquad= setupNewSquad();
        assertEquals("avengers", mySquad.getName() );
    }

    @Test
    public void HeroInstantiatesWithAge_true() throws Exception{
        Squad mySquad= setupNewSquad();
        assertEquals(5, mySquad.getSquadSize());
    }
    @Test
    public void HeroInstantiatesWithSpecialPowers_true() throws Exception{
        Squad mySquad= setupNewSquad();
        assertEquals("help the poor", mySquad.getCause() );
    }

    @After
    public void tearDown() throws Exception {
    }
}
