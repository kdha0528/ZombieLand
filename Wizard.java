package zombieLand;

public class Wizard extends Hero {
    public Wizard(){
        super(3,1,1,1);
    }

    @Override
    public String getSkillDesc(){
        return "Fire Ball!!\n";
    }

    @Override
    public String getSpecialSkillDesc() {
        return "Meteor!!\n";
    }
}
