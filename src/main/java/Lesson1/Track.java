package Lesson1;

public class Track implements Barrier {
    String name;
    int distance;

    public Track(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(Move obj) {
        obj.runTrack();
    }
    public void check(Move obj) {
        obj.runTrack1(distance);

    }
}

