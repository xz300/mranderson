package Homework8;

public class Wall {
    private int wallLength;
    public Wall(int wallLength) {
        this.wallLength = wallLength;
    }
    public double getTimeJump(Jumping jumper){
        return jumper.jump(wallLength);
    }


}


