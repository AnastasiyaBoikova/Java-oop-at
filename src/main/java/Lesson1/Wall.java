package Lesson1;

public class Wall implements Barrier {
    String name;
    int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void move(Move obj) {
        obj.jumpWall();
    }


    public void check(Move obj) {
        obj.jumpWall1(height);


    }


}
