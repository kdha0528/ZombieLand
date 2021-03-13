package zombieLand;

public abstract class Hero {
    protected int life;
    protected int atk;
    protected int skillCnt;
    protected int specialSkillCnt;


    public Hero(int life, int atk, int skillCnt, int specialSkillCnt) {
        this.life = life;
        this.atk = atk;
        this.skillCnt = skillCnt;
        this.specialSkillCnt = specialSkillCnt;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getSkillCnt() {
        return skillCnt;
    }

    public void setSkillCnt(int skillCnt) {
        this.skillCnt = skillCnt;
    }

    public int getSpecialSkillCnt() {
        return specialSkillCnt;
    }

    public void setSpecialSkillCnt(int specialSkillCnt) {
        this.specialSkillCnt = specialSkillCnt;
    }

    public void attack(Hero h, zombieLand.Zombie z){
        System.out.println("Attack!!");
        z.setLife(z.getLife()-h.getAtk());
    }


    public void skill(Hero h, zombieLand.Zombie z){
        z.setLife(z.getLife()-2);
        h.setSkillCnt(h.getSkillCnt()-1);
    }

    public void specialSkill(Hero h, zombieLand.Zombie z){
        z.setLife(0);
        h.setSpecialSkillCnt(h.getSpecialSkillCnt()-1);
    }

    public abstract  String getSkillDesc();
    public abstract  String getSpecialSkillDesc();

}
