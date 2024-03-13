import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module SplitModule {
    exports dk.sdu.mmmi.cbse.playersystem;
    requires Common;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
}
