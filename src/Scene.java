
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.*;

public class Scene extends SScene {

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.ground.setPaint(SGround.SurfaceAppearance.GRASS);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995185, 0.0980144, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.56, -7.85));
        this.spot.setPaint(Color.WHITE);
        this.spot.setOpacity(1.0);
        this.spot.setName("spot");
        this.spot.setVehicle(this);
        this.spot.setOrientationRelativeToVehicle(new Orientation(0.0, 0.724867, 0.0, 0.688889));
        this.spot.setPositionRelativeToVehicle(new Position(0.141, 0.0, -1.95));
        this.spot.setSize(new Size(2.344, 0.876, 1.24));
        this.fido.setPaint(Color.WHITE);
        this.fido.setOpacity(1.0);
        this.fido.setName("fido");
        this.fido.setVehicle(this);
        this.fido.setOrientationRelativeToVehicle(new Orientation(0.0, -0.803434, 0.0, 0.595394));
        this.fido.setPositionRelativeToVehicle(new Position(-1.29, 0.0, -2.12));
        this.fido.setSize(new Size(0.512, 1.31, 1.84));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public void myFirstMethod() {
        this.spot.wag(0.25);
        this.fido.wag(2.0);
    }

    public SGround getGround() {
        return this.ground;
    }

    public SCamera getCamera() {
        return this.camera;
    }

    public Dalmatian getSpot() {
        return this.spot;
    }

    public Dalmatian getFido() {
        return this.fido;
    }
    private final SGround ground = new SGround();
    private final SCamera camera = new SCamera();
    private final Dalmatian spot = new Dalmatian();
    private final Dalmatian fido = new Dalmatian();
}
