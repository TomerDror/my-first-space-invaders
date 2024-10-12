import javax.swing.*;
import java.awt.*;

public class Picture {


    private int x;
    private int y;
    private String location;

    public Picture(int x,int y, String location){
        this.x = x;
        this.y = y;
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
    public Image getPicture(){
        return  new ImageIcon(location).getImage();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
