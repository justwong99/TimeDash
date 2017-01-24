package nevagonlose.timedash;

public class Platform {
    public float x;
    public float y;
    public float height;
    public float width;
    public boolean hitDetected = false;
    public float oldX;
    public float oldY;


    public void collision(Player player){
        //for landing on top
        if (player.x + player.width >= x && player.x <= x + width && player.y + player.height >=  y && player.y <= y + height) {
            if (player.y + player.height <= y + height / 3) {
                player.y = y - player.height;
                player.onPlatform = true;
                player.fall = false;
                player.acceleration = 0;
            } else {
                //hitDetected = true;
            }
        } else {
            player.onPlatform = false;
        }
    }

    public void updatePosition(float screenWidth){
        x = x - screenWidth/190;
    }


}
