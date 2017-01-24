package nevagonlose.timedash;

/**
 * Created by Zi on 2016-08-26.
 */
public class snowflakes {
    public float x;
    public float y;
    public float radius;

    public void updatePositions(float sw, float sh) {
        x = x - 1;
        y = y + 3;

        if (y > (3 * (sh / 4))) {
            y = 0;
        }

        if (x < 0) {
            x = sw;
        }
    }
}
