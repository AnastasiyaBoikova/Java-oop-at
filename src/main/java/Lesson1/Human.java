package Lesson1;

public class Human implements Move {
    int dRun;
    int hJump;

    public void run() {
        System.out.println("Человек бежит ");

    }

    public void jump() {
        System.out.println("Человек прыгает ");
    }

    public void jumpWall() {
        System.out.println("Человек успешно прыгнул через стену");
    }

    public void runTrack() {
        System.out.println("Человек успешно бежит по дорожке");
    }

    public void runTrack1(int a) {
        if (dRun > a) {
            System.out.println("Человек успешно пробежал");
        } else
            System.out.println("Человек не смог пробежать");

    }

    public void jumpWall1(int a) {
        if (hJump > a) {
            System.out.println("Человек успешно прыгнул");
        } else
            System.out.println("Человек не смог прыгнуть");

    }

//    public boolean jumpWall2(int a) {
//        if (hJump > a) {
//            System.out.println("Человек успешно прыгнул");
//            return true;
//        }
//        else
//            return false;
//
//    }

}