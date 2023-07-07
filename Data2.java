import java.util.ArrayList;
import java.util.List;

public class Data2 {
    public static List<Block> getData() {
        // Create new small blocks
        Block block1 = new Wall.MyBlock("red", "wood");
        Block block2 = new Wall.MyBlock("blue", "stone");
        Block block3 = new Wall.MyBlock("green", "wood");

        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);

        // Create a composite block with the blocks
        List<Block> compositeBlocks = new ArrayList<>();
        compositeBlocks.add(block1);
        compositeBlocks.add(block2);
        CompositeBlock compositeBlock = new Wall.Composite(compositeBlocks);
        blocks.add(compositeBlock);

        // Create a composite block 2 with the blocks
        List<Block> compositeBlocks2 = new ArrayList<>();
        compositeBlocks2.add(block1);
        compositeBlocks2.add(block2);
        compositeBlocks2.add(block3);
        compositeBlocks2.add(block3); // Duplicate block3

        CompositeBlock compositeBlock2 = new Wall.Composite(compositeBlocks2);

        blocks.add(compositeBlock2);
        blocks.add(compositeBlock2);

        return blocks;
    }
}



