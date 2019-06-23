import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String newName;
    private int newAge;
    private int mId;
    private String newSpecialPowers;
    private String newWeakness;
    private  static List<Hero> instances = new ArrayList<Hero>();

    public Hero(String name,int age,String specialPowers,String weakness){
        newName=name;
        newAge=age;
        newSpecialPowers=specialPowers;
        newWeakness=weakness;
        instances.add(this);
        mId= instances.size();
    }

    public String getNewName() {
        return newName;
    }

    public int getNewAge() {
        return newAge;
    }

    public String getNewSpecialPowers() {

        return newSpecialPowers;
    }

    public String getNewWeakness() {

        return newWeakness;
    }

    public static  List<Hero> all(){

        return instances;
    }

    public int getId() {

        return mId;
    }

    public static Hero find(int id) {

        return instances.get(id - 1);
    }


}