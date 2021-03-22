public class Track {
    private int trackLength;
    public Track(int trackLength) {
        this.trackLength = trackLength;
    }
    public double getTimeRun(Running runner){
        return runner.run(trackLength);
    }

}
