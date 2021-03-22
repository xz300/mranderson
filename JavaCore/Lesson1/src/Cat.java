public class Cat implements Running, Jumping{
    private String name;
    private int maxSpeed;
    private int jumpLength;
    private int deBuff;
    private int jump;
    private int run;


    public Cat(String name, int maxSpeed, int jumpLength, int deBuff) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.jumpLength = jumpLength;
        this.deBuff = deBuff;
    }
    public void jumping(int value){
        this.jump += value;
        if(value>=3){
            System.out.println(name +" не может прыгнуть на " + value + " м ");
        }else{
            System.out.println(name + " прыгнул " +value + " м ");
        }
    }
    public void running(int value){
        this.run += value;
        if(value>=500){
            System.out.println(name +" не может пробежать на " + value + " м ");
        }else{
            System.out.println(name + " пробежал " +value + " м ");
        }
    }

    @Override
    public double run(int length) {
        if(length>100){
            setMaxSpeed(3);
        }
        else {
            setMaxSpeed(9);
        }
        return (getMaxSpeed()* getDeBuff()) * length;
    }

    @Override
    public double jump(int length) {
       return  getJumpLength() * length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getJumpLength() {
        return jumpLength;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getDeBuff() {
        return deBuff;
    }

    public int getJump() {
        return jump;
    }

    public int getRun() {
        return run;
    }
}
