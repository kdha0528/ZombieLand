package zombieLand;

public class ZombieKing extends Zombie {

    private String name;

    public ZombieKing() {
        super(3,1);
        this.name = "좀비 킹";
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDesc() {
        return "구워어어어ㅓㄱ!!!\n";
    }
}