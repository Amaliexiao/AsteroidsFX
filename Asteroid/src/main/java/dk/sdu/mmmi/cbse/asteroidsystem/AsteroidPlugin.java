package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
public class AsteroidPlugin implements IGamePluginService {
    public AsteroidPlugin() {
    }
    public Entity createAsteroid(int size, double xCoord, double yCoord){
        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setRadius(size);
        asteroid.setX(xCoord);
        asteroid.setY(yCoord);
        asteroid.setRotation(180);
        return asteroid;
    }

    @Override
    public void start(GameData gameData, World world) {
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Asteroid.class) {
                world.removeEntity(e);
            }
        }
    }

}
