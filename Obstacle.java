package nevagonlose.timedash;

public class Obstacle {
    public float x;
    public float y;
    public float height;
    public float width;
    public boolean hitDetected = false;
    public float oldX;
    public float oldY;

    public void collision(Player player){
        //colliding with object
        if (player.x + player.width >= (x + width/5)  && player.x <= x + (width - width/5) && player.y + player.height >=  (y + height/5) && player.y <= y + (height - height/5)){
            hitDetected = true;
        }


    }

    public void updatePosition(float screenWidth){
            x = x - screenWidth/190;
    }

}
