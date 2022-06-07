package org.betterx.betternether.interfaces;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import org.betterx.bclib.api.v2.tag.CommonBlockTags;
import org.betterx.bclib.interfaces.SurvivesOnTags;

import java.util.List;

public interface SurvivesOnSouldGround extends SurvivesOnTags {
    List<TagKey<Block>> TAGS = List.of(CommonBlockTags.SOUL_GROUND);

    @Override
    default List<TagKey<Block>> getSurvivableTags() {
        return TAGS;
    }
}
