package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     * @param gameData
     * @param world
     * @throws
     * @pre IGamePluginService should run start
     */
    void process(GameData gameData, World world);
}
