package org.betterx.betternether.world.biomes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.SurfaceRules;

import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeBuilder;
import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeBuilder.BiomeSupplier;
import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeSettings;
import org.betterx.bclib.api.v2.levelgen.surface.SurfaceRuleBuilder;
import org.betterx.bclib.api.v2.levelgen.surface.rules.Conditions;
import org.betterx.betternether.registry.NetherBlocks;
import org.betterx.betternether.registry.NetherEntities;
import org.betterx.betternether.registry.SoundsRegistry;
import org.betterx.betternether.registry.features.BiomeFeatures;
import org.betterx.betternether.registry.features.TerrainFeatures;
import org.betterx.betternether.world.NetherBiome;
import org.betterx.betternether.world.NetherBiomeConfig;

public class OldSwampland extends NetherBiome {
    public static class Config extends NetherBiomeConfig {
        public Config(String name) {
            super(name);
        }

        @Override
        protected void addCustomBuildData(BCLBiomeBuilder builder) {
            builder.fogColor(137, 19, 78)
                   .loop(SoundsRegistry.AMBIENT_SWAMPLAND)
                   .additions(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS)
                   .mood(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD)
                   .music(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST)
                   .structure(BiomeTags.HAS_BASTION_REMNANT)
                   .structure(BiomeTags.HAS_NETHER_FORTRESS)
                   .feature(TerrainFeatures.LAVA_SWAMP)
                   .feature(BiomeFeatures.OLD_SWAMPLAND_FLOOR)
                   .feature(BiomeFeatures.OLD_SWAMPLAND_CEIL)
                   .feature(BiomeFeatures.OLD_SWAMPLAND_WALL)
            ;
        }

        @Override
        public BiomeSupplier<NetherBiome> getSupplier() {
            return OldSwampland::new;
        }

        @Override
        public <M extends Mob> int spawnWeight(NetherEntities.KnownSpawnTypes type) {
            int res = super.spawnWeight(type);
            switch (type) {
                case ENDERMAN, GHAST, ZOMBIFIED_PIGLIN, PIGLIN, HOGLIN, PIGLIN_BRUTE -> res = 0;
                case MAGMA_CUBE, STRIDER -> res = 40;
            }
            return res;
        }

        @Override
        public SurfaceRuleBuilder surface() {
            return super
                    .surface()
                    .rule(SurfaceRules.sequence(
                            SurfaceRules.ifTrue(
                                    SurfaceRules.ON_FLOOR,
                                    SurfaceRules.ifTrue(
                                            Conditions.NETHER_VOLUME_NOISE_LARGE,
                                            SurfaceRules.state(NetherBlocks.SWAMPLAND_GRASS.defaultBlockState())
                                    )
                            ),
                            SurfaceRules.ifTrue(
                                    Conditions.NETHER_SURFACE_NOISE_LARGE,
                                    NetherGrasslands.SOUL_SOIL
                            ),
                            NetherGrasslands.SOUL_SAND
                    ));
        }
    }

    public OldSwampland(ResourceLocation biomeID, Biome biome, BCLBiomeSettings settings) {
        super(biomeID, biome, settings);
    }

    @Override
    protected void onInit() {
    }
}