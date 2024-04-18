package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author corfixen
 */
public class Bullet extends Entity {
    private Boolean pointGiving;

    public Boolean getPointGiving() {
        return pointGiving;
    }

    public void setPointGiving(Boolean pointGiving) {
        this.pointGiving = pointGiving;
    }
}
