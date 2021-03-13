package zombieLand;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class GameManager {
    Scanner sc = new Scanner(System.in);
    private final ArrayList<User> userLists = new ArrayList<>();

    public GameManager() {
    }

    public void run() {
        int select;
        int index = 0;
        User player = null;

        loadData();

        while (true) {
            if (index == 0) {
                System.out.println("---------메뉴---------");
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 종료");
                System.out.println("---------------------\n");
                System.out.print("메뉴를 고르십시오 : ");
                select = sc.nextInt();
                switch (select) {
                    case 1 -> signUp();
                    case 2 -> {
                        player = logIn();
                        if (player.isLogIn()) index = 1;
                    }
                    case 3 -> {
                        System.out.println("게임을 종료합니다.");
                        saveData(userLists);
                        return;
                    }
                    default -> System.out.println("잘못 입력하셨습니다.");
                }
            }

            if (index == 1) {
                System.out.println("---------메뉴---------");
                System.out.println("1. 개인정보");
                System.out.println("2. 게임시작");
                System.out.println("3. 랭킹보드");
                System.out.println("4. 로그아웃");
                System.out.println("5. 게임종료");
                System.out.println("---------------------\n");
                System.out.print("메뉴를 고르십시오 : ");
                select = sc.nextInt();
                switch (select) {
                    case 1 -> index = 2;
                    case 2 -> gameStart(player);

                    case 3 -> showRankingBoard();

                    case 4 -> {
                        logout(player);
                        index = 0;
                    }
                    case 5 -> {
                        System.out.println("게임을 종료합니다.");
                        saveData(userLists);
                        return;
                    }
                    default -> System.out.println("잘못 입력하셨습니다.");
                }
            }

            if (index == 2) {
                System.out.println("---------메뉴---------");
                System.out.println("1. 회원정보 보기");
                System.out.println("2. 회원정보 수정");
                System.out.println("3. 회원삭제");
                System.out.println("4. 뒤로가기");
                System.out.println("---------------------\n");
                System.out.print("메뉴를 고르십시오 : ");
                select = sc.nextInt();
                switch (select) {
                    case 1 -> viewMyInfo(player);
                    case 2 -> {
                        modifyMyInfo(player);
                        logout(player);
                        index=0;
                    }
                    case 3 -> {
                        deleteUser(player);
                        index = 0;
                    }
                    case 4 -> index = 1;
                    default -> System.out.println("잘못 입력하셨습니다.");
                }
            }
        }
    }

    public void signUp() {
        System.out.println("\n---------회원가입---------\n");
        sc.nextLine();
        String id = getStrInput("ID   : ");
        String pw = getStrInput("PW   : ");
        String name = getStrInput("Name : ");

        if (checkID(id)) {
            System.out.println("아이디가 중복됩니다.");
        } else {
            add(new User(id, pw, name, 0, false));
        }

    }

    public void add(User user) {
        this.userLists.add(user);
    }

    public boolean checkID(String id) {

        for (User temp : userLists) {
            if (temp.getId().equals(id)) return true;
        }
        return false;
    }

    public boolean checkPW(String pw) {

        for (User temp : userLists) {
            if (temp.getPw().equals(pw)) return true;
        }
        return false;
    }

    public String getStrInput(String a) {
        System.out.print(a);
        return sc.nextLine();
    }

    public User logIn() {
        int i = 5;

        System.out.println("\n---------로그인---------\n");
        sc.nextLine();
        while (i != 0) {
            String id = getStrInput("ID   : ");
            String pw = getStrInput("PW   : ");

            if (checkID(id) && checkPW(pw)) {
                User user = findID(id);
                user.setLogIn(true);
                System.out.println("로그인에 성공하셨습니다.");
                return user;
            } else {
                System.out.println(6 - i + "번 로그인에 실패하였습니다.");
                System.out.println(i - 1 + "번 로그인을 시도할 수 있습니다.\n");
            }

            i--;
        }
        return null;
    }

    public User findID(String id) {

        for (User temp : userLists) {
            if (temp.getId().equals(id)) return temp;
        }
        return null;
    }

    public void logout(User user) {
        user.setLogIn(false);
    }

    public void viewMyInfo(User user) {
        System.out.println("ID : " + user.getId());
        System.out.println("Name : " + user.getName());
        System.out.println("Record : " + user.getRecord());
    }

    public void modifyMyInfo(User user) {
        sc.nextLine();
        String id = getStrInput("변경할 아이디를 입력하시오   : ");
        String pw = getStrInput("변경할 비밀번호를 입력하시오 : ");
        String name = getStrInput("변경할 이름을 입력하시오     : ");

        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        System.out.println("개인정보수정이 완료되었습니다.");

    }

    public void deleteUser(User user) {
        userLists.remove(user);
        System.out.println("회원탈퇴가 완료되었습니다.");

    }

    public void showRankingBoard() {
        ArrayList<User> deepCopy = new ArrayList<>(userLists.size());
        Iterator<User> iterator = userLists.iterator();

        while(iterator.hasNext()){
            deepCopy.add(iterator.next().clone());
        }

        int j = 1;
        sort(deepCopy, 0, deepCopy.size() - 1);

        System.out.println("***Ranking Board***");
        for (int i = 0; i < deepCopy.size(); i++) {
            if (deepCopy.get(i).getRecord() != 0) {
                System.out.println(j + "등 " + deepCopy.get(i).getName() + " : " + deepCopy.get(i).getRecord() + "초");
                j++;
            }
        }
        System.out.println("***Ranking Board***\n");
    }

    public void sort (ArrayList<User> arr, int l, int r) {
        int left = l;
        int right = r;
        int pivot = arr.get((l + r) / 2).getRecord();


        while (left <= right) {
            while (arr.get(left).getRecord() < pivot) left++;
            while (arr.get(right).getRecord() > pivot) right--;
            if (left <= right) {
                int temp = arr.get(left).getRecord();
                arr.get(left).setRecord(arr.get(right).getRecord());
                arr.get(right).setRecord(temp);
                left++;
                right--;
            }

            if (l < right) sort(arr, l, right);
            if (r > left) sort(arr, left, r);
        }
    }

    public void gameStart(User player) {
        int select;
        boolean i = true;
        zombieLand.Hero hero = null;

        while (i) {
            System.out.println("1. Worrior");
            System.out.println("2. Wizard");
            System.out.println("3. Archer");
            System.out.println("4. 뒤로가기");
            System.out.print("직업을 선택해주세요 : ");
            select = sc.nextInt();
            System.out.println("\n");

            switch (select) {
                case 1 -> {
                    hero = new zombieLand.Worrior();
                    i = false;
                }
                case 2 -> {
                    hero = new zombieLand.Wizard();
                    i = false;
                }
                case 3 -> {
                    hero = new Archer();
                    i = false;
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }
        }


        System.out.println("----------게임을 시작합니다.----------\n\n");

        String pattern1 = "mm";
        String pattern2 = "ss";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);

        String start_time_m = simpleDateFormat1.format(new Date());
        String start_time_s = simpleDateFormat2.format(new Date());

        zombieLand.PlayGame p = new zombieLand.PlayGame();
        p.play(hero);

        String finish_time_m = simpleDateFormat1.format(new Date());
        String finish_time_s = simpleDateFormat2.format(new Date());

        System.out.println("시작 시간 : " + start_time_m + "분 "+start_time_s + "초");
        System.out.println("종료 시간 : " + finish_time_m + "분 "+finish_time_s + "초");

        int stm=Integer.parseInt(start_time_m);
        int sts=Integer.parseInt(start_time_s);
        int ftm=Integer.parseInt(finish_time_m);
        int fts=Integer.parseInt(finish_time_s);

        int record_s;
        int record_m;

        if(fts<sts){
            ftm--;
            fts += 60;
        }
        record_s = fts - sts;
        record_m = ftm - stm;
        int record = record_m*60 + record_s;

        System.out.println("기록 : " + record + "초");
        if(player.getRecord() == 0 || record < player.getRecord()) {
            player.setRecord(record);
        }
    }

    public void saveData(ArrayList<User> userLists) {
        User player;
        try {
            File file = new File("C:\\Users\\kdha0\\IdeaProjects\\ZombieLand\\src\\zombieLand\\data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < userLists.size(); i++) {
                player = userLists.get(i);
                bw.write(player.getId() + " " + player.getPw() + " " + player.getName() + " " + player.getRecord() + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(){
        String str;
        String[] arr;
        int record;

        System.out.println("Welcome To ZombieLand!!\n");

        try{
            File file = new File("C:\\Users\\kdha0\\IdeaProjects\\ZombieLand\\src\\zombieLand\\data.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader  bufferedReader = new BufferedReader(fileReader);

            while((str = bufferedReader.readLine()) != null){
                arr = str.split(" ");
                record = Integer.parseInt(arr[3]);
                add(new User(arr[0], arr[1], arr[2], record, false));
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

