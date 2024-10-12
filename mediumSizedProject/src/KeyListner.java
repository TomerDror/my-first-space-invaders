import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListner implements KeyListener {
    Ship ship = null;
    public KeyListner(Ship ship){
        this.ship = ship;

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();


        if (key == KeyEvent.VK_A) {
            ship.moveLeft();
        }

        if (key == KeyEvent.VK_D) {
            ship.moveRight();
        }

        if (key == KeyEvent.VK_S){
            ship.shoot();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
