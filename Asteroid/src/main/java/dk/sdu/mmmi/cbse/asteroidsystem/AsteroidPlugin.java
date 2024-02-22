package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
public class AsteroidPlugin implements IGamePluginService {

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
    }

    private Entity spawnAsteroid(GameData gameData) {

        Entity enemy = new Asteroid();
        enemy.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemy.setX(gameData.getDisplayWidth()+1);
        enemy.setY(Math.random()*gameData.getDisplayHeight());
        return enemy;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
//        world.removeEntity(enemy);
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Asteroid.class) {
                world.removeEntity(e);
            }
        }
    }

}
