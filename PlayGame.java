package zombieLand;

import java.util.*;

public class PlayGame {
    Scanner sc = new Scanner(System.in);

    public void play(Hero hero) {
        Zombie zombie = null;
        boolean i = true;

        System.out.println("Stage 1-1");
        zombie = new WeakZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        System.out.println(zombie.getDesc());

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 1-2");
        zombie = new WeakZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 1-3");
        zombie = new SuperZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("1스테이지를 클리어 하였습니다. 스킬 사용 가능 횟수가 1 증가합니다.\n");
        hero.setSkillCnt(hero.getSkillCnt()+1);

        System.out.println("Stage 2-1");
        zombie = new SuperZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 2-2");
        zombie = new SuperZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 2-3");
        zombie = new GeneralZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("2스테이지를 클리어 하였습니다. 스킬 사용 가능 횟수가 1 증가합니다.\n");
        hero.setSkillCnt(hero.getSkillCnt()+1);


        System.out.println("Stage 3-1");
        zombie = new GeneralZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 3-2");
        zombie = new GeneralZombie();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        i = true;

        System.out.println("Stage 3-3");
        zombie = new ZombieKing();
        System.out.println(zombie.getName() + "가(이) 나타났다!");
        zombie.getDesc();

        while (i) {
            i = fight(hero, zombie);

            if (hero.getLife() == 0) {
                System.out.println("히어로가 사망하였습니다!!\n");
                return;
            }
        }

        return;
    }

    public boolean fight(Hero h, Zombie z) {
        int select;
        boolean ans;


        while (true) {
            System.out.println("1. Attack");
            System.out.println("2. Skill");
            System.out.println("3. Special Skill");
            System.out.print("입력 : ");
            select = sc.nextInt();
            System.out.println("");

            if (select == 2 && h.getSkillCnt() <= 0) {
                System.out.println("스킬 사용횟수를 모두 소모하셨습니다.\n");
            } else if (select == 3 && h.getSpecialSkillCnt() <= 0) {
                System.out.println("필살기 사용횟수를 모두 소모하셨습니다.\n");
            } else {
                break;
            }

        }

        if (z.getName() == "좀비") {
            ans = easyQ();
        } else if (z.getName() == "슈퍼 좀비" || z.getName() == "좀비 사령관") {
            ans = hardQ();
        } else {
            ans = crazyQ();
        }


        if (ans == true) {
            switch (select) {
                case 1 -> {
                    h.attack(h, z);
                    break;
                }
                case 2 -> {
                    h.skill(h, z);
                    System.out.println(h.getSkillDesc());
                    break;
                }
                case 3 -> {
                    h.specialSkill(h, z);
                    System.out.println(h.getSpecialSkillDesc());
                    break;
                }
                default -> System.out.println("잘못 입력하셨습니다.\n");
            }
        } else {
            System.out.println("틀렸습니다!!\n");
            h.setLife(h.getLife() - 1);
        }

        if (z.getLife() <= 0) {
            System.out.println("좀비를 해치웠습니다.\n");
            return false;
        }

        return true;
    }

    public boolean easyQ() {
        Random ran = new Random();
        int o = ran.nextInt(4);
        char operator;
        int a;
        int b;
        int ans;
        int playerAns;

        if (o == 0) {
            a = ran.nextInt(40) + 10;
            b = ran.nextInt(40) + 10;
            operator = '+';
            ans = a + b;
        } else if (o == 1) {
            a = ran.nextInt(50) + 50;
            b = ran.nextInt(40) + 10;
            operator = '-';
            ans = a - b;
        } else if (o == 2) {
            a = ran.nextInt(15) + 1;
            b = ran.nextInt(15) + 1;
            operator = '*';
            ans = a * b;
        } else {
            a = ran.nextInt(50) + 50;
            b = ran.nextInt(10) + 1;
            operator = '/';
            ans = a / b;
        }
        System.out.println(a + " " + operator + " " + b + " = ? \n");
        System.out.print("정답을 입력하시오 : ");
        playerAns = sc.nextInt();

        if (playerAns == ans) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hardQ() {
        Random ran = new Random();
        int o = ran.nextInt(4);
        char operator;
        int a;
        int b;
        int ans;
        int playerAns;

        if (o == 0) {
            a = ran.nextInt(400) + 100;
            b = ran.nextInt(400) + 100;
            operator = '+';
            ans = a + b;
        } else if (o == 1) {
            a = ran.nextInt(500) + 500;
            b = ran.nextInt(400) + 100;
            operator = '-';
            ans = a - b;
        } else if (o == 2) {
            a = ran.nextInt(90) + 10;
            b = ran.nextInt(9) + 2;
            operator = '*';
            ans = a * b;
        } else {
            a = ran.nextInt(90) + 10;
            b = ran.nextInt(9) + 2;
            operator = '/';
            ans = a / b;
        }
        System.out.println(a + " " + operator + " " + b + " = ? \n");
        System.out.print("정답을 입력하시오 : ");
        playerAns = sc.nextInt();

        if (playerAns == ans) {
            return true;
        } else {
            return false;
        }

    }

    public boolean crazyQ() {
        Random ran = new Random();
        int o = ran.nextInt(4);
        char operator;
        int a;
        int b;
        int ans;
        int playerAns;

        if (o == 0) {
            a = ran.nextInt(4900) + 100;
            b = ran.nextInt(4900) + 100;
            operator = '+';
            ans = a + b;
        } else if (o == 1) {
            a = ran.nextInt(5000) + 5000;
            b = ran.nextInt(4000) + 1000;
            operator = '-';
            ans = a - b;
        } else if (o == 2) {
            a = ran.nextInt(90) + 10;
            b = ran.nextInt(90) + 10;
            operator = '*';
            ans = a * b;
        } else {
            a = ran.nextInt(9000) + 1000;
            b = ran.nextInt(9) + 2;
            operator = '/';
            ans = a / b;
        }
        System.out.println(a + " " + operator + " " + b + " = ? \n");
        System.out.print("정답을 입력하시오 : ");
        playerAns = sc.nextInt();

        if (playerAns == ans) {
            return true;
        } else {
            return false;
        }
    }
}