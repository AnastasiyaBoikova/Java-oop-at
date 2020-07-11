package Lesson1;

public class Start {
    public static void main(String[] args) {
        Human man1 = new Human();
        Cat cat1 = new Cat();
        Robot robot1 = new Robot();

        System.out.println("Задание 1");
        man1.run();
        cat1.jump();
        robot1.run();
        man1.jump();
        cat1.run();
        robot1.jump();
        System.out.println();

        System.out.println("Задание 2");
        Wall wall1 = new Wall();
        wall1.move(cat1);
        wall1.move(robot1);
        wall1.move(man1);
        Track track1 = new Track();
        track1.move(man1);
        track1.move(cat1);
        track1.move(robot1);

        System.out.println();


        System.out.println("Задание 3");
        Move[] players = {man1};
        Barrier[] barriers = {wall1, track1};
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                barriers[j].move(players[i]);
            }
        }
        System.out.println();

        System.out.println("Задание 4");

        man1.dRun = 1000;
        man1.hJump = 90;

        wall1.height = 100;
        track1.distance = 500;

       man1.runTrack1(900);
        man1.jumpWall1(10);

        System.out.println();

//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < barriers.length; j++) {
//                if (!barriers[j].move1(players[i])) {
//                    System.out.println("Выбыл");
//                    break;
//                }
//
//
//            }
//        }
//        for (int i = 0; i < players.length; i++) {
//            for (int j = 0; j < barriers.length; j++) {
//                barriers[j].move1(players[i]);
//
//                if (!barriers[j].move1(players[i])) {
//                    System.out.println("Выбыл");
//                    break;
//
//               // }
//            }
//        }
    }
}
