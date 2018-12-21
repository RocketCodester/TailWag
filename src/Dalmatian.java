
import org.lgna.story.resources.quadruped.DalmatianResource;
import org.lgna.story.*;

public class Dalmatian extends Quadruped {

    public Dalmatian() {
        super(DalmatianResource.DEFAULT);
    }

    public SJoint getLeftEarMiddle() {
        return this.getJoint(DalmatianResource.LEFT_EAR_MIDDLE);
    }

    public SJoint getRightEarMiddle() {
        return this.getJoint(DalmatianResource.RIGHT_EAR_MIDDLE);
    }

    @Override
    public SJoint getTail4() {
        return this.getJoint(DalmatianResource.TAIL_4);
    }

    public void wag(final Double speed) {
        this.getTail().turn(TurnDirection.LEFT, 0.125, Turn.duration(speed));
        this.getTail().turn(TurnDirection.RIGHT, 0.25, Turn.duration(speed));
        this.getTail().turn(TurnDirection.LEFT, 0.125, Turn.duration(speed));
    }
}
