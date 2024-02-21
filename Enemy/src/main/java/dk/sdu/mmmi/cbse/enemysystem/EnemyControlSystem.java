package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
            
        for (Entity enemy : world.getEntities(Enemy.class)) {

            double randomNumber = 0;

            randomNumber  = Math.random()*10;

            if(false){
                enemy.setRotation(enemy.getRotation() - 5);
            }
            if(false){
                enemy.setRotation(enemy.getRotation() + 5);
            }

            if(false){
                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }

//            if(gameData.getKeys().isPressed(GameKeys.SPACE)){
//                for(BulletSPI bullet : getBulletSPIs()){
//                    world.addEntity(bullet.createBullet(player,gameData));
//                }
//            }

            if (enemy.getX() < -2) {
                enemy.setX(gameData.getDisplayWidth()+1);
            }

            if (enemy.getX() > gameData.getDisplayWidth()+2) {
                enemy.setX(-1);
            }

            if (enemy.getY() < -2) {
                enemy.setY(gameData.getDisplayHeight()+1);
            }

            if (enemy.getY() > gameData.getDisplayHeight()+2) {
                enemy.setY(-1);
            }
            
                                        
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
