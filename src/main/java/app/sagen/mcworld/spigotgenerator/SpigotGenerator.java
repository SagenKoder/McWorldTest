package app.sagen.mcworld.spigotgenerator;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

/**
 * @author Alexander Sagen
 * @date 2021-03-04
 */
public class SpigotGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        ChunkData chunk = createChunkData(world);

        SimplexOctaveGenerator octave = new SimplexOctaveGenerator(world, 8);
        octave.setScale(0.005d);

        // set all blocks in chunk to biome Plains
        for(int cx = 0; cx < 16; cx++) {
            for(int cz = 0; cz < 16; cz++) {
                for(int cy = 0; cy < chunk.getMaxHeight(); cy++) {
                    biome.setBiome(cx, cy, cz, Biome.PLAINS);
                }
            }
        }

        for(int cx = 0; cx < 16; cx++ ) {
            for(int cz = 0; cz < 16; cz++ ) {
                int calcHeight = (int)((octave.noise(x*16+cx, z*16+cz, 0.9d, 0.5d, true) + 1) * 60d + 30d);
                for(int cy = 0; cy <= calcHeight; cy++) {
                    Material material = Material.STONE;
                    if(cy <= 3) material = Material.BEDROCK;
                    else if(cy == calcHeight) material = Material.GRASS_BLOCK;
                    else if(cy > calcHeight - 6) material = Material.DIRT;
                    chunk.setBlock(cx, cy, cz, material);
                }
            }
        }
        return chunk;
    }
}
