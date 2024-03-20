package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CollisionControlSystemTest {
    private Entity entity1;
    private Entity entity2;

    @BeforeEach
    void setUp() {
        entity1 = new Entity();
        entity1.setPolygonCoordinates(-5,-5,10,0,-5,5);
        entity1.setRadius(8);
        entity1.setY(100);
        entity1.setX(100);

        entity2 = new Entity();
        entity2.setPolygonCoordinates(-5,-5,10,0,-5,5);
        entity2.setRadius(8);
        entity2.setY(100);
        entity2.setX(100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void collides() {
        CollisionControlSystem cs = new CollisionControlSystem();
        assertTrue(cs.collides(entity1, entity2));
    }
    @Test
    void notCollides(){
        CollisionControlSystem cs = new CollisionControlSystem();
        entity1.setX(50);
        assertFalse(cs.collides(entity1, entity2));
    }
}