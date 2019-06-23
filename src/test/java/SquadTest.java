import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad mySquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals(true, mySquad instanceof Squad);
    }
    @Test
    public void Squad_instantiatesWithName_String() {
        Squad mySquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals("Panthers", mySquad.getmName());
    }
    @Test
    public void Squad_instantiatesWithMaxSize_Integer() {
        Squad mySquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals(5, mySquad.getmMaxSize());
    }
    @Test
    public void Squad_instantiatesWithCause_String() {
        Squad mySquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals("fighting", mySquad.getmCause());
    }
    @Test
    public void all_returnsAllInstancesOfSquad_true() {
        Squad firstSquad = new Squad( "Panthers" ,5 ,"fighting");
        Squad secondSquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
    }
    @Test
    public void Squad_instantiatesWithId_1() {
        Squad.clear();
        Squad mySquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals(1, mySquad.getmId());
    }
    @Test
    public void getHero_initiallyReturnsEmptyList_ArrayList() {
        Squad.clear();
        Squad testSquad = new Squad( "Panthers" ,5 ,"fighting");
        assertEquals(0, testSquad.getHeroes().size());
    }
    @Test
    public void find_returnsNullWhenNoSquadFound_null() {
        assertTrue(Squad.find(999) == null);
    }
    @Test
    public void addHero_addsHeroToList_true() {
        Squad testSquad = new Squad( "Panthers" ,5 ,"fighting");
        Hero testHero = new Hero( "Mike" ,16 ,"fire" ,"cats");
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
    }


}
