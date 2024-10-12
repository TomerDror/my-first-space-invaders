import java.awt.event.KeyEvent;

public class Ship {

    private Position shipPosition;
    private boolean canShoot = false;
    private boolean canMove = false;
    private Position[] bullets = new Position[1];
    private String location = "shipImage.jpeg";


    public Ship(){
        this.shipPosition = new Position();
    }

    public Ship(int x,int y){
        this.shipPosition = new Position(x,y,50,50);

    }


    public Ship(Position Position){
        this.shipPosition = new Position(Position.getX(),Position.getY());
    }


    public Position getShipPosition() {
        return shipPosition;
    }

    public void setShipPosition(Position shipPosition) {
        this.shipPosition = shipPosition;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }


    public void moveLeft(){

        if (shipPosition.getX()>=100&&canMove)
        this.shipPosition.setX(this.shipPosition.getX()-40);
        canMove = false;
    }


    public void moveRight(){

        if (shipPosition.getX()<=900&&canMove)
        this.shipPosition.setX(this.shipPosition.getX()+40);
        canMove = false;
    }

    public void readyShip(Aliens[] aliens){
        canMove = true;
        //moves object in array



        for (int i = 0; i < bullets.length; i++) {

            if(bullets[i]!=null ) {
//                System.out.println("x="+this.getBullets()[i].getX()+"y="+this.getBullets()[i].getY());
                bullets[i].setY(bullets[i].getY()-20 );

                for (int j = 0; j < aliens.length; j++) {
                    if(aliens[j]!=null&&bullets[i]!=null){
                        if (isBulletHitAlien(aliens[j],bullets[i]))
                        {
                            aliens[j]= aliens[j].gotHit();
                            bullets[i] = null;
                        }
                    }
                }
//                System.out.println("x="+this.getBullets()[i].getX()+"y="+this.getBullets()[i].getY());
            }
        }


        canShoot = true;
    }


    private boolean isBulletHitAlien(Aliens alien, Position bullet) {

        return  alien !=null
                &&bullet!=null
                && (alien.getAlienPosition().getX()+alien.alienPosition.getWidth()/2)>=bullet.getX()
                && (alien.getAlienPosition().getX()-alien.alienPosition.getWidth()/2)<=bullet.getX()
                && (alien.getAlienPosition().getY()+alien.alienPosition.getLength()/2)>=bullet.getY()
                && (alien.getAlienPosition().getY()-alien.alienPosition.getLength()/2)<=bullet.getY();
    }

    public void shoot(){

        if (canShoot) {
            canShoot = false;

            Position[] newBullets = new Position[bullets.length+1];
            for (int i = 0; i < bullets.length; i++) {
                newBullets[i+1] = bullets[i];
            }
            bullets = newBullets;
            bullets[0] = new Position(shipPosition.getX(), shipPosition.getY()-25 );
        }

    }


    public void setBullets(Position[] bullets) {
        this.bullets = bullets;
    }

    public Position[] getBullets() {
        return bullets;
    }



    public Picture getPicture(){
        int num = this.shipPosition.getX()-(this.shipPosition.getWidth())/2;
        int num1 = this.shipPosition.getY()-this.shipPosition.getLength()/2;
        return new Picture(num,num1,this.location);

    }
    public Rectengles getRectengle(){
        return new Rectengles(this.shipPosition.getX()-(this.shipPosition.getWidth())/2,this.shipPosition.getY()-this.shipPosition.getLength()/2,this.shipPosition.getWidth(),this.shipPosition.getLength());

    }
}
    