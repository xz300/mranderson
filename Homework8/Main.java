package Homework8;


public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Кот", 8,3, 1);
        Human human = new Human("Человек", 8,2,1);
        Bot bot = new Bot("Робот", 10, 1,1);


        System.out.println("//////////// Задание 1 ////////////");
        cat.running(10);
        human.jumping(2);
        bot.running(20);

        System.out.println("//////////// Задание 2 ////////////");
        cat.jumping(2);
        cat.running(600);
        human.jumping(5);
        human.running(1000);
        bot.jumping(1);
        bot.running(1000);

        Track[] tracks = {new Track(90), new Track(150)};
        Wall[] walls = {new Wall(1), new Wall(2)};

        double catTime = 0;
        double humanTime = 0;
        double botTime = 0;

        for (Track track : tracks){
            catTime = catTime + track.getTimeRun(cat);
            humanTime = humanTime + track.getTimeRun(human);
            botTime = botTime + track.getTimeRun(bot);
        }
        for (Wall wall : walls){
            catTime = catTime + wall.getTimeJump(cat);
            humanTime = humanTime + wall.getTimeJump(human);
            botTime = botTime + wall.getTimeJump(bot);
        }
        System.out.println("//////////// Задание 3 ////////////");
        System.out.println("Время кота: " + catTime);
        System.out.println("Время человека: " + humanTime);
        System.out.println("Время робота: " + botTime);

    }
}
