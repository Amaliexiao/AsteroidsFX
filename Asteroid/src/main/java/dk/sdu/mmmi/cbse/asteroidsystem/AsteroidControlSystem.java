package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {
    AsteroidPlugin plugin = new AsteroidPlugin();

    @Override
    public void process(GameData gameData, World world) {
        if (world.getEntities(Asteroid.class).size() < 4) {
            if (Math.random() * 100 > 95) {
                world.addEntity(plugin.createAsteroid(20, gameData.getDisplayWidth(), gameData.getDisplayHeight() * Math.random()));
            }
        }
        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX);
            asteroid.setY(asteroid.getY() + changeY);

            if (asteroid.getX() < 0) {
                asteroid.setRotation(Math.random() * 20);
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setRotation(Math.random() * 20 + 180);
            }

            if (asteroid.getY() < 0) {
                asteroid.setRotation(Math.random() * 20 + 90);
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setRotation(Math.random() * 20 + 270);
            }
            if (asteroid.isCollided()) {
                world.removeEntity(asteroid);
                if (asteroid.getRadius() > 10) {
                    Entity asteroid1 = plugin.createAsteroid(asteroid.getRadius() - 5, asteroid.getX(), asteroid.getY() - 50);
                    asteroid1.setRotation(asteroid.getRotation() + 35);

                    Entity asteroid2 = plugin.createAsteroid(asteroid.getRadius() - 5, asteroid.getX(), asteroid.getY() + 50);
                    asteroid2.setRotation(asteroid.getRotation() - 35);

                    world.addEntity(asteroid1);
                    world.addEntity(asteroid2);
                }
            }
        }
    }
}
