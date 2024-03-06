package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        if (1000 * Math.random() > 995) {
            world.addEntity(spawnAsteroid(gameData,1));
        }

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX);
            asteroid.setY(asteroid.getY() + changeY);

            if (asteroid.getX() < 0) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getY() < 0) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(asteroid);
            }

        }
    }
    public Entity spawnAsteroid(GameData gameData, int size) {

        Entity asteroid = new Asteroid();
        asteroid.setX(gameData.getDisplayWidth());
        asteroid.setY(gameData.getDisplayHeight()*Math.random());
        asteroid.setRotation(180);
        switch (size){
            case 1:
                asteroid.setPolygonCoordinates(-20,2,-16,10,-4,16,4,14,8,6,8,-6,-6,-10,-16,-8);
                asteroid.setRadius(20);
                break;
            case 2:
                asteroid.setPolygonCoordinates(-10,6,-4,10,6,10,10,5,8,-8,-2,-10,-8,-4);
                asteroid.setRadius(10);
                break;
            case 3:
                asteroid.setPolygonCoordinates(-4,1,-2,3,2,3,3,1,3,-1,1,-3,-2,-3,-4,-2);
                asteroid.setRadius(4);
                break;
        }
        return asteroid;
    }

}
