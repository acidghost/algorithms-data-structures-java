package it.uniba.di.itps.asd.exams.Lab20140220;

/**
 * Created by acidghost on 02/09/14.
 */
public class Process {
    private String path;
    private int ID;

    public Process(String path) {
        this.path = path;
        ID = this.hashCode();
    }

    public int getID() {
        return ID;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\tPath: " + path;
    }
}
