package org.betterx.betternether.registry;

import com.google.common.collect.Maps;
import org.betterx.bclib.world.structures.StructurePlacementType;
import org.betterx.betternether.world.structures.IStructure;

import java.util.Map;

public class StructureRegistry {
    private static final Map<StructurePlacementType, Map<String, IStructure>> REGISTRY;

    public static void register(String name, IStructure structure, StructurePlacementType type) {
        REGISTRY.get(type).put(name, structure);
    }

    public static IStructure getStructure(String name, StructurePlacementType type) {
        return REGISTRY.get(type).get(name);
    }

    static {
        REGISTRY = Maps.newHashMap();
        for (StructurePlacementType type : StructurePlacementType.values()) {
            Map<String, IStructure> list = Maps.newHashMap();
            REGISTRY.put(type, list);
        }


    }
}