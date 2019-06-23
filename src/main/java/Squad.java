import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mName;
    private int mMaxSize;
    private String mCause;
    private static List<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeros;

    public Squad(String name, int maxSize, String cause) {
        mName = name;
        mMaxSize = maxSize;
        mCause = cause;
        instances.add(this);
        mId = instances.size();
        mHeros = new ArrayList<Hero>();
    }

    public String getmName() {
        return mName;
    }

    public int getmMaxSize() {
        return mMaxSize;
    }

    public String getmCause() {

        return mCause;
    }

    public static List<Squad> all() {

        return instances;
    }

    public int getmId() {

        return mId;
    }

    public static Squad find(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static void clear()
    {
        instances.clear();
    }
    public List<Hero> getHeroes() {

        return mHeros;
    }
    public void addHero(Hero hero) {
        mHeros.add(hero);
    }
}