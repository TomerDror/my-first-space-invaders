public class AlienBoss extends Aliens{

    private boolean canShoot;

    private int hp;
    public AlienBoss(){
        super();
        this.canShoot = false;
        this.hp = 5;

    }
    public AlienBoss(int x,int y,int hp){
        super(x,y,700,50);
        this.canShoot = false;
        this.hp = hp;
    }

    public AlienBoss(int x,int y,int width,int length,int hp){
        super(x,y,width,length);
        this.canShoot = true;
        this.hp = hp;
    }
    @Override
    public int getHp() {
        return hp;
    }





    public void setHp(int hp) {
        if(!isNull)
        this.hp = hp;
    }

    @Override
    public AlienBoss gotHit()
    {
        if(this.hp > 1) {
            setHp(getHp() - 1);
            return this;
        }
        return null;

    }

//    @Override
//    public void move(){
//        if(!isNull) {
//
//            if (movingDiraction == 5) {
//                alienPosition.setY(alienPosition.getY() + 2);
//                movingDiraction = -5;
//            }
//            else if (movingDiraction ==0) {
//                alienPosition.setY(alienPosition.getY() + 2);
//            }
//            else if (movingDiraction <= -1)
//                alienPosition.setX(alienPosition.getX() + 5);
////
//            else if (movingDiraction >=1)
//                alienPosition.setX(alienPosition.getX() - 5);
//            else {}
//            movingDiraction++;
//        }
//    }


}
