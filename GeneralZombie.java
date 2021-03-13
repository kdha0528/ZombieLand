package zombieLand;

public class GeneralZombie extends Zombie {

    private String name;

    public GeneralZombie() {
        super(2,1);
        this.name = "좀비 사령관";
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDesc() {
        return "끼에에에ㅔㅔㅔ엑!!\n";
    }
}
