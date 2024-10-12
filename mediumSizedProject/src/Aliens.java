import java.util.Random;

public class Aliens {

    private enum MovingDiraction{
        left,right
    }
    protected Position[] bullets = new Position[0];
    protected boolean canShoot;
//    private MovingDiraction movingDiraction;
    protected int movingDiraction;
    protected int movmentMultiplier = 7;
    protected Position alienPosition;
    protected boolean isNull;
    private String location = "Space-Invader.jpg";


    public Aliens(){
        this.alienPosition = new Position();
    }

    public Aliens(int x,int y){
        this.alienPosition = new Position(x,y,50,50);

//        this.movingDiraction = MovingDiraction.left;
        this.movingDiraction = -5;
        this.isNull =false;
    }
    public Aliens(int x,int y,int width,int length){
        this.alienPosition = new Position(x,y,width,length);

//        this.movingDiraction = MovingDiraction.left;
        this.movingDiraction = -5;
        this.isNull =false;
    }

    public Position[] getBullets() {
        return bullets;
    }

    public void readyAlien(){

        for (int i = 0; i < bullets.length; i++) {

            if (bullets[i] != null) {
                bullets[i].setY(bullets[i].getY() + 20);

                if ( bullets[i] != null) {
                    if (isBulletHitPlayer(bullets[i], main.ship)) {
                        this.alienPosition = main.ship.getShipPosition();
                    }
                }
            }
//                System.out.println("x="+this.getBullets()[i].getX()+"y="+this.getBullets()[i].getY());
        }

    }

    public void shoot(){
        Random rng = new Random();
        int num = rng.nextInt(3);
        if (num ==0) {
            Position[] newBullets = new Position[bullets.length + 1];
            for (int i = 0; i < bullets.length; i++) {
                newBullets[i + 1] = bullets[i];
            }
            newBullets[0] = new Position(alienPosition.getX(), alienPosition.getY() + alienPosition.getWidth() / 2);
            bullets = newBullets;
        }
    }
    private boolean isBulletHitPlayer(Position pos,Ship player){
                return player !=null
                &&pos!=null
                && (player.getShipPosition().getX()+player.getShipPosition().getWidth()/2)>=pos.getX()
                && (player.getShipPosition().getX()-player.getShipPosition().getWidth()/2)<=pos.getX()
                && (player.getShipPosition().getY()+player.getShipPosition().getLength()/2)>=pos.getY()
                && (player.getShipPosition().getY()-player.getShipPosition().getLength()/2)<=pos.getY();
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public Aliens(Position position){
        this.alienPosition = new Position(position.getX(), position.getY());
        this.isNull =false;
    }

    public Position getAlienPosition() {
        if(!isNull)
        return alienPosition;
        return null;
    }

    public void move(){
        if(!isNull) {

            if (movingDiraction == 5) {
                alienPosition.setY(alienPosition.getY() + movmentMultiplier*2);
                movingDiraction = -5;
            }
          else if (movingDiraction ==0) {
                alienPosition.setY(alienPosition.getY() + movmentMultiplier*2);
            }
          else if (movingDiraction <= -1)
                alienPosition.setX(alienPosition.getX() + movmentMultiplier*2);
//
            else if (movingDiraction >=1)
                alienPosition.setX(alienPosition.getX() - movmentMultiplier*2);
            else {}
            movingDiraction++;
        }
    }
    public int getMovmentMultiplier() {
        return movmentMultiplier;
    }

    public void setMovmentMultiplier(int movmentMultiplier) {
        this.movmentMultiplier = movmentMultiplier;
    }
    public Aliens gotHit(){
        return null;
    }
    public int getHp() {
        return 1;
    }

    public boolean isNull() {
        return isNull;
    }


    @Override
    public String toString() {
        return "aliens{" +
                "alienPosition=" + alienPosition +
                '}';
    }

    public Picture getPicture(){
        int num = this.alienPosition.getX()-(this.alienPosition.getWidth())/2;
        int num1 = this.alienPosition.getY()-this.alienPosition.getLength()/2;
        return new Picture(num,num1,this.location);

    }

    public Rectengles getRectengle(){
        return new Rectengles(this.alienPosition.getX()-(this.alienPosition.getWidth())/2,this.alienPosition.getY()-this.alienPosition.getLength()/2,this.alienPosition.getWidth(),this.getAlienPosition().getLength());

    }

}
