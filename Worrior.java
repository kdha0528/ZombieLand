package zombieLand;

public class Worrior extends Hero{

    public Worrior(){
        super(3,1,1,1);
    }


    @Override
    public String getSkillDesc(){
        return "Power Strike!!\n";
    }

    @Override
    public String getSpecialSkillDesc() {
        return "Land Slash!!\n";
    }
}
