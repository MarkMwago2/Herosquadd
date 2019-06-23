import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void Hero_instantiatesWithName_String() {
        Hero myHero = new Hero("Mike", 16, "fire", "cats");
        assertEquals("Mike", myHero.getNewName());
    }
    @Test
    public void Hero_instantiatesWithAge_Integer() {
        Hero myHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        assertEquals(16, myHero.getNewAge());
    }
    //    @Test
//    public void Hero_instantiatesWithId_Integer() {
//        Hero myHero = new Hero("Mike" ,16 ,"fire" ,"cats");
//        assertEquals(1, myHero.getmId());
//    }
    @Test
    public void Hero_instantiatesWithSpecialPowers_String() {
        Hero myHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        assertEquals("fire", myHero.getNewSpecialPowers());
    }
    @Test
    public void Hero_instantiatesWithWeakness_String() {
        Hero myHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        assertEquals("cats", myHero.getNewWeakness());
    }
    @Test
    public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        Hero secondHero = new Hero("cmfdbjk" ,4 ,"air" ,"dogs");
        assertEquals(true, Hero.all().contains(firstHero));
        assertEquals(true, Hero.all().contains(secondHero));
    }
    @Test
    public void find_returnsHeroWithSameId_secondHero() {
        Hero firstHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        Hero secondHero = new Hero("Mike" ,16 ,"fire" ,"cats");
        assertEquals(Hero.find(secondHero.getId()), secondHero);
    }
}
