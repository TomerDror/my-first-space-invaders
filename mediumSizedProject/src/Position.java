public class Position {
    private int x;
    private int y;
    private int width;
    private int length;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
        this.width =0;
        this.length =0;
    }
    public Position(){
        this.x = 0;
        this.y = 0;
        this.width =0;
        this.length =0;
    }

    public Position(int x,int y,int width,int length){
        this.x = x;
        this.y = y;
        this.width =width;
        this.length =length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
