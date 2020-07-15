package Lesson1;

public class Cat implements Move {
    String name;
    int dRun;
    int hJump;
    public Cat (String name, int dRun, int hJump){
        this.name = name;
        this. dRun = dRun;
        this. hJump = hJump;
    }

    public void run() {
        System.out.println("Кот бежит ");

    }

    public void jump() {
        System.out.println("Кот прыгает ");
    }

    public void jumpWall() {
        System.out.println("Кот не смог прыгнуть через стену");
    }

    public void runTrack() {
        System.out.println("Кот не смог бежать по дорожке");
    }

    public void runTrack1(int a) {
        if (dRun>a){
            System.out.println("Кот успешно пробежал");
        }else
            System.out.println("Кот не смог пробежать");

    }

    public void jumpWall1(int a) {
        if (hJump>a){
            System.out.println("Кот успешно прыгнул");
        }else
            System.out.println("Кот не смог прыгнуть");

    }

}
