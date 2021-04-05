package Homework12;

import java.io.Serializable;
import java.util.Arrays;

public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    @Override
    public String toString() {
        return Arrays.toString(header) +
                " " + Arrays.toString(data) ;
    }
}
