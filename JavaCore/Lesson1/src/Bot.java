public class Bot implements Running, Jumping {

    private String name;
    private int maxSpeed;
    private int jumpLength;
    private int jump;
    private int run;
    private int deBuff;

    public Bot(String name, int maxSpeed,int jumpLength, int deBuff) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.jumpLength = jumpLength;
        this.deBuff = deBuff;
    }
    public void jumping(int value){
        this.jump += value;
        if(value>1){
            System.out.println(name +" не может прыгнуть на " + value + " м ");
        }else{
            System.out.println(name + " прыгнул " +value + " м ");
        }
    }
    public void running(int value){
        this.run += value;
        if(value>=1500){
            System.out.println(name +" не может пробежать на " + value + " м ");
        }else{
            System.out.println(name + " пробежал " +value + " м ");
        }
    }
    @Override
    public double jump(int length) {
        return jumpLength * length;
    }

    @Override
    public double run(int length) {
        return maxSpeed * length;
    }

}

//   1 Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать
//      и прыгать (методы просто выводят информацию о действии в консоль).
//   2 Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//      соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//   3 Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

//        * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
//        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.