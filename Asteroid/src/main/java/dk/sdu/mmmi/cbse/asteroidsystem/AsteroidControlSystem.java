package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation())) + 1 * Math.random();
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation())) + 1 * Math.random();
            asteroid.setX(asteroid.getX() + changeX);
            asteroid.setY(asteroid.getY() + changeY);
            asteroid.setRotation(asteroid.getRotation() + 1 * Math.random());


            if (asteroid.getX() < -2) {
                asteroid.setX(gameData.getDisplayWidth() + 1);
            }

            if (asteroid.getX() > gameData.getDisplayWidth() + 2) {
                asteroid.setX(-1);
            }

            if (asteroid.getY() < -2) {
                asteroid.setY(gameData.getDisplayHeight() + 1);
            }

            if (asteroid.getY() > gameData.getDisplayHeight() + 2) {
                asteroid.setY(-1);
            }

        }
    }

}
