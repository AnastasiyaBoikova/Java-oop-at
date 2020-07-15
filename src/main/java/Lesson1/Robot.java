package Lesson1;

public class Robot implements Move {
    String name;
    int dRun;
    int hJump;

    public Robot(String name, int dRun, int hJump) {
        this.name = name;
        this.dRun = dRun;
        this.hJump = hJump;
    }


    public void run() {
        System.out.println("Робот бежит ");

    }

    public void jump() {
        System.out.println("Робот прыгает ");
    }

    public void jumpWall() {
        System.out.println("Робот не смог прыгнул через стену");
    }

    public void runTrack() {
        System.out.println("Робот успешно бежит по дорожке");
    }

    public void runTrack1(int a) {
        if (dRun > a) {
            System.out.println("Робот успешно пробежал");
        } else
            System.out.println("Робот не смог пробежать");

    }

    public void jumpWall1(int a) {
        if (hJump > a) {
            System.out.println("Робот успешно прыгнул");
        } else
            System.out.println("Робот не смог прыгнуть");

    }

}
