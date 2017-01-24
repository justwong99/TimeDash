package nevagonlose.timedash;

import android.util.Log;

public class Player {
    public float x;
    public float y;
    public float height;
    public int width;
    public float acceleration;
    public float gravity;
    public boolean jump = false;
    public boolean slide = false;
    public boolean fall = false;
    public boolean onPlatform = false;
    int slideTimer;
    public float oldHeight;
    public float oldY;
    public boolean flyingSection = false;
    public boolean swimmingSection = false;


    public void saveValues(){
        oldHeight = height;
    }

    public void updatePosition(float screenHeight) {
        if (flyingSection) {
            gravity  = screenHeight/2500;
            width = (int) screenHeight/10;
            y = y - acceleration;
            acceleration = acceleration - gravity;
            height = screenHeight/12;

            if(acceleration <= -11){
                acceleration = -10.9f;
            }

            if (jump){
                Log.e("hi", "lol");
                acceleration = screenHeight/70;
                jump = false;
            }

            if (y <= 0){
                y = screenHeight/80;
                acceleration = 0;
            }

            if (y + height >= screenHeight){
                y = screenHeight- height - 10;
                acceleration = 0;
            }

        } else if (swimmingSection) {
            gravity  = -screenHeight/2500;
            height = (int) screenHeight/10;
            width = (int) screenHeight/10;
            y = y - acceleration;
            acceleration = acceleration - gravity;

            if(acceleration >= 11){
                acceleration = 10f;
            }

            if (jump){
                acceleration = -screenHeight/70;
                jump = false;
            }


            if (y + height >= screenHeight){
                y = screenHeight - (height+5);
                acceleration = 0;
            }
        } else {
            if (jump && !slide) {
                y = y - acceleration;
                acceleration = acceleration - gravity;
                if (acceleration <= 0) {
                    fall = true;
                    jump = false;
                }
            }

            if(acceleration <= -10){
                acceleration = -9.9f;
            }

            if (onPlatform || (y + height) >= screenHeight / 1.1) {
                fall = false;
                if ((y + height) > screenHeight / 1.09) {
                    y = screenHeight / 1.09f - height;
                    Log.e("Ypos", "--" + y);
                }
            } else if (!onPlatform && (y + height) <= screenHeight / 1.1 && !jump) {
                fall = true;
            }

            if (fall) {
                y = y - acceleration;
                acceleration = acceleration - gravity;
            }

            if (slide) {
                slideTimer++;
                if (slideTimer > 50) {
                    slide = false;
                    y = y - height;
                    height = oldHeight;
                    slideTimer = 0;
                }
            }


        }
    }


}

