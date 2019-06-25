import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private LocalDateTime createdAt;
    private int id;


    public Hero (String name, int age, String specialPowers, String weakness){
        this.name = name;
        this.age= age;
        this.specialPowers= specialPowers;
        this.weakness = weakness;
        instances.add(this);
        this.createdAt = LocalDateTime.now();
        this.id = instances.size();

    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }

    public String getSpecialPowers(){
        return specialPowers;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }

    public String getWeakness(){
        return weakness;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public int getId(){
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }

    public void update(String name, int age, String specialPowers, String weakness) {
        this.name = name;
        this.age= age;
        this.specialPowers= specialPowers;
        this.weakness= weakness;
    }
    public void deleteHero(){
        instances.remove(id-1);
    }

}