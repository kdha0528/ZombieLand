package zombieLand;

public class SuperZombie extends Zombie {

    private String name;

    public SuperZombie() {
        super(1,1);
        this.name = "슈퍼 좀비";
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDesc() {
        return "크으와아ㅏ앙!!!\n";
    }
}
