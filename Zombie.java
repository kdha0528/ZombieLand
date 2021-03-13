package zombieLand;

public abstract class Zombie {

        protected int life;
        protected int atk;

    public Zombie() {
    }

    public Zombie(int life, int atk) {
        this.life = life;
        this.atk = atk;
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

    public abstract String getName();
    public abstract String getDesc();

}
