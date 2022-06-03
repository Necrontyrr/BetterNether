package org.betterx.betternether.registry.features;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import org.betterx.bclib.api.features.BCLFeature;
import org.betterx.bclib.api.features.BCLFeatureBuilder;
import org.betterx.bclib.api.tag.CommonBlockTags;
import org.betterx.betternether.BetterNether;

public class TerrainFeatures {
    public static final BCLFeature LAVA_PITS = BCLFeatureBuilder
            .start(BetterNether.makeID("lava_pits"), Feature.SIMPLE_BLOCK)
            .decoration(GenerationStep.Decoration.LAKES)
            .onEveryLayer()
            .stencil()
            .onceEvery(4)
            .findSolidFloor(3)
            .offset(Direction.DOWN)
            .onlyInBiome()
            .inBasinOf(BlockPredicate.anyOf(
                    BlockPredicate.matchesTag(CommonBlockTags.TERRAIN),
                    BlockPredicate.matchesBlocks(Blocks.LAVA)
            ))
            .buildAndRegister(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LAVA)));
    public static final BCLFeature LAVA_PITS_SPARE = BCLFeatureBuilder
            .start(BetterNether.makeID("lava_pits_spare"), Feature.SIMPLE_BLOCK)
            .decoration(GenerationStep.Decoration.LAKES)
            .onEveryLayer()
            .stencil()
            .onceEvery(6)
            .findSolidFloor(3)
            .offset(Direction.DOWN)
            .onlyInBiome()
            .inBasinOf(BlockPredicate.anyOf(
                    BlockPredicate.matchesTag(CommonBlockTags.TERRAIN),
                    BlockPredicate.matchesBlocks(Blocks.LAVA)
            ))
            .buildAndRegister(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LAVA)));

    public static void ensureStaticInitialization() {
    }
}
