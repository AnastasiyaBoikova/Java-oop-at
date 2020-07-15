package Lesson1;

public class Start {
    public static void main(String[] args) {
        Human man1 = new Human("Стас", 1000, 10);
        Human man2 = new Human("Петр", 1500, 7);
        Cat cat1 = new Cat("Барсик", 150, 1);
        Cat cat2 = new Cat("Том", 100, 1);
        Robot robot1 = new Robot("777", 9450, 17);
        Robot robot2 = new Robot("745", 15000, 25);
        Track track1 = new Track("Трек_1", 1500);
        Track track2 = new Track("Трек_2", 5500);
        Track track3 = new Track("Трек_3", 10500);
        Wall wall1 = new Wall("Стена_1", 4);
        Wall wall2 = new Wall("Стена_2", 7);
        Wall wall3 = new Wall("Стена_3", 10);
        Move[] players = {man1, man2, cat1, cat2, robot1, robot2};
        Barrier[] barriers = {track1, wall1, track2, wall3, track3, wall2};

        System.out.println("Задание 1");
        man1.run();
        cat1.jump();
        robot1.run();
        man1.jump();
        cat1.run();
        robot1.jump();
        System.out.println();

        System.out.println("Задание 2");

        wall1.move(cat1);
        wall1.move(robot1);
        wall1.move(man1);

        track1.move(man1);
        track1.move(cat1);
        track1.move(robot1);

        System.out.println();


        System.out.println("Задание 3");

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                barriers[j].move(players[i]);
            }
        }
        System.out.println();

        System.out.println("Задание 4");

        System.out.println("Гонка началась");
        for (int i = 0; i < barriers.length; i++) {
            System.out.println();
            System.out.println("Препятствие " + (i + 1));
            System.out.println();
            for (int j = 0; j < players.length; j++) {

                barriers[i].check(players[j]);

            }

        }
    }


}
