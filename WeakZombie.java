package zombieLand;

public class WeakZombie extends Zombie{

    private String name;

    public WeakZombie() {
        super(1,1);
        this.name = "좀비";
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDesc() {
        return "그르르ㄹㄹ르ㄱ\n";
    }

}
