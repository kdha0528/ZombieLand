package zombieLand;

public class Archer extends Hero{

    public Archer(){
        super(3,1,1,1);
    }

    @Override
    public String getSkillDesc(){
        return "Double Shot!!\n";
    }

    @Override
    public String getSpecialSkillDesc() {
        return "Dragon Shot!!\n";
    }
}
