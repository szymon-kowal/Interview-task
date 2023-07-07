import java.util.ArrayList;
import java.util.List;

public class Data1 {
    public static List<Block> getData() {
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

        // Add the composite block to the list of blocks
        blocks.add(compositeBlock);

        return blocks;
    }
}

