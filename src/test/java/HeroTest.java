import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero= new Hero("Superman", 30, "flying", "Kryptonite");
        assertEquals(true, hero instanceof Hero);
    }
    public Hero setupNewHero(){
        return new Hero ("Superman", 30, "flying", "Kryptonite");
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("Superman", myHero.getName() );
    }

    @Test
    public void HeroInstantiatesWithAge_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals(30, myHero.getAge());
    }
    @Test
    public void HeroInstantiatesWithSpecialPowers_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("flying", myHero.getSpecialPowers() );
    }
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("Kryptonite", myHero.getWeakness() );
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllPosts();
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Hero myHero= setupNewHero();
        Hero otherHero = new Hero ("Joker", 50, "laughter", "light");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Hero myHero= setupNewHero();
        Hero otherHero = new Hero ("Joker", 50, "laughter", "light");
        assertTrue(Hero.getAll().contains(myHero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero myHero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }
    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Hero.clearAllPosts();
        Hero myHero = setupNewHero();
        assertEquals(1, myHero.getId());
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero myHero = setupNewHero();
        assertEquals(1, Hero.findById(myHero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Hero myHero = setupNewHero();
        Hero otherPost = new Hero("Thor",30,"Hammer", "flying");
        assertEquals(2, Hero.findById(otherPost.getId()).getId());
    }
    @Test
    public void updateChangesHeroContent() throws Exception {
        Hero myHero = setupNewHero();
        String formerName = myHero.getName();
        int formerAge = myHero.getAge();
        String formerSpecialPowers= myHero.getSpecialPowers();
        String formerWeakness= myHero.getWeakness();

        LocalDateTime formerDate = myHero.getCreatedAt();
        int formerId = myHero.getId();

        myHero.update("Ironman", 35, "bulletproof", "love");

        assertEquals(formerId, myHero.getId());
        assertEquals(formerDate, myHero.getCreatedAt());
        assertNotEquals(formerName, myHero.getName());
        assertNotEquals(formerAge, myHero.getAge());
        assertNotEquals(formerSpecialPowers, myHero.getSpecialPowers());
        assertNotEquals(formerWeakness, myHero.getWeakness());
    }

    @Test
    public void deleteDeletesASpecificHero() throws Exception {
        Hero myHero = setupNewHero();
        Hero otherHero = new Hero("Ironman", 35, "bulletproof", "love");
        myHero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);
    }@Test
    public void deleteAllHerosDeletesAllHeros() throws Exception {
        Hero myHero = setupNewHero();
        Hero otherHero = setupNewHero();

        Hero.clearAllPosts();
        assertEquals(0, Hero.getAll().size());
    }
}