import javax.swing.ImageIcon;
import javax.swing.*;

import java.awt.*;

public class myPanel extends JPanel {
    private int width;
    private int height;

    // set image
    private Image xWing;
    private Image Invader;

    private Picture[] pictures = new Picture[0];


    public myPanel(int width, int height) {

        this.width = width;
        this.height = height;

        // add here all the diffrent pictures u want
        // this.BackgroundImage = new ImageIcon("Background.png").getImage();
        //  this.xImage = new ImageIcon("Ex.png").getImage();
        // this.oImage = new ImageIcon("OO.png").getImage();

        this.xWing = new ImageIcon("shipImage.jpeg").getImage();
        this.Invader = new ImageIcon("Space-Invaders.shep.jpeg").getImage();

        this.setPreferredSize(new Dimension(width, height));

    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;


        // g2d.drawImage(this.image, x, y, null);

        paintRecs(g2d);
//        paintImages(g2d);
        // if you want to refresh the screen go main



    }

    private void paintRecs(Graphics g2d){
        Rectengles[] recs= main.rectengles;

        for (int i = 0; i < recs.length; i++) {
            if (recs[i]!=null)
                g2d.fillRect(recs[i].getX(),recs[i].getY(),recs[i].getWidth(),recs[i].getLength());
        }
        try {
            for (int i = 0; i < main.ship.getBullets().length; i++) {
                if (main.ship.getBullets()[i] != null) ;
                g2d.setColor(Color.RED);
                g2d.fillRect(main.ship.getBullets()[i].getX(), main.ship.getBullets()[i].getY(), 5, 5);


            }

        }
        catch(Exception e){}

        try {
            for (int i = 0; i < main.aliens[0].getBullets().length; i++) {
                if (main.aliens[0].getBullets()[i] != null) ;
                g2d.setColor(Color.RED);
                g2d.fillRect(main.aliens[0].getBullets()[i].getX(), main.aliens[0].getBullets()[i].getY(), 5, 5);
            }
        }
        catch(Exception e){}







    }


    public void paintImages(Graphics2D g2d){
        for (int i = 0; i < pictures.length; i++) {
            if(pictures[i]!=null)

                g2d.drawImage(pictures[i].getPicture(),pictures[i].getX(),pictures[i].getY(),null);



        }
    }
    public void addPicture(Picture picture){

        Picture[] newPictures = new Picture[pictures.length+1];
        for (int i = 0; i < pictures.length; i++) {
            if (pictures[i] != null) {
                newPictures[i] = pictures[i];
            }
        }
        newPictures[pictures.length]= picture;
        this.pictures = newPictures;
    }
    @Deprecated
    public void removePicture(Picture picture){
        for (int i = 0; i < pictures.length; i++) {
            if ((pictures[i]!=null)&&
                (pictures[i].getX()==picture.getX())&&
                (pictures[i].getY()==picture.getY())&&
                (pictures[i].getLocation()==picture.getLocation())) {

                pictures[i] = null;

            }

        }
        int count=0;
        for (int i = 0; i < pictures.length; i++) {
            if (pictures[i]==null){
                count-=-1;
            }
        }
        Picture[] newPictures =new Picture[pictures.length-count];

        int pos=0;
        for (int i = 0; i < pictures.length; i++) {
            if (pictures[i]!=null){
                newPictures[pos] = pictures[i];
                pos++;
            }
        }
    }




}
