import java.util.ArrayList;

public class Squad {
    private String name;
    private int squadSize;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, int squadSize, String cause) {
        this.name = name;
        this.squadSize = squadSize;
        this.cause = cause;
        instances.add(this);

    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public String getName(){
        return name;
    }
    public int getSquadSize(){
        return squadSize;
    }
    public String getCause(){
        return cause;
    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }
}
