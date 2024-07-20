package com.cursee.golden_foods;

import com.cursee.golden_foods.core.registry.GoldenFoodsFabricRegistry;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class GoldenFoodsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        GoldenFoods.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);

        GoldenFoodsFabricRegistry.register();
    }
}
