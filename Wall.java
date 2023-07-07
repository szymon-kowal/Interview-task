import java.util.*;



/*
Muszę :
Zaimplementowac metody [ findBlockByColor, findBlocksByMaterial,
                            count]
   findBlockByColor - zwraca dowolny element o danym kolorze
   findBlocksByMaterial - zwraca wszystkie elementy o danym materiale
   count - zwraca liczbe elementow tworzacych strukture
Uwzględnić podział na Block i CompositeBlock
Umieścić całą logike w superklasie Wall.

Notatki personalne :
Musze miec funkcje, gdzie :

Wall wall = new Wall(lista)
Wall(lista).findBlockByColor("color") - zwraca dowolny element
Wall(lista).findBlocksByMaterial("material") - zwraca
liste elementow o danym materiale
Wall(lista).count() - zwraca liczbe elementow

CompositeBlock - traktuje go jako duzy block skladajacy sie z
mniejszych blokow
 */

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

class StructureUtils {
    public static Optional<Block> findBlockByColor(Block block, String color) {
        if (block.getColor().equalsIgnoreCase(color)) {
            return Optional.of(block);
        }
        if (block instanceof CompositeBlock) {
            return ((CompositeBlock) block).findBlockByColor(color);
        }
        return Optional.empty();
    }

    public static List<Block> findBlocksByMaterial(Block block, String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        if (block.getMaterial().equalsIgnoreCase(material)) {
            matchingBlocks.add(block);
        }
        if (block instanceof CompositeBlock) {
            matchingBlocks.addAll(((CompositeBlock) block).findBlocksByMaterial(material));
        }
        return matchingBlocks;
    }

    public static int count(Block block) {
        int count = 1;
        if (block instanceof CompositeBlock) {
            count += ((CompositeBlock) block).count();
            count--;
        }

        return count;
    }
}

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks){
        this.blocks = blocks;
    }

    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            Optional<Block> result = StructureUtils.findBlockByColor(block, color);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        for (Block block : blocks) {
            matchingBlocks.addAll(StructureUtils.findBlocksByMaterial(block, material));
        }
        return matchingBlocks;
    }

    public int count() {
        int count = 0;
        for (Block block : blocks) {
            count += StructureUtils.count(block);
        }
        return count;
    }
    public static class MyBlock implements Block {

        private String color;
        private String material;

        public MyBlock(String color, String material) {
            this.material = material;
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public String getMaterial() {
            return material;
        }

    }

    public static class Composite implements CompositeBlock {
        private List<Block> blocks;
        private String colors;
        private String materials;

        public Composite(List<Block> blocks) {
            this.blocks = blocks;
        }

        public List<Block> getBlocks() {
            return blocks;
        }

        public String getColor() {
            String output = "Nothing";
            return output;
        }

        public String getMaterial() {
            String output = "Nothing";
            return output;
        }

        public Optional<Block> findBlockByColor(String color) {
            for (Block block : blocks) {
                if (block.getColor().equalsIgnoreCase(color)) {
                    return Optional.of(block);
                }
                if (block instanceof CompositeBlock) {
                    Optional<Block> compositeResult = ((CompositeBlock) block).findBlockByColor(color);
                    if (compositeResult.isPresent()) {
                        return compositeResult;
                    }
                }
            }
            return Optional.empty();
        }

        public List<Block> findBlocksByMaterial(String material) {
            List<Block> matchingBlocks = new ArrayList<>();
            for (Block block : blocks) {
                if (block.getMaterial().equalsIgnoreCase(material)) {
                    matchingBlocks.add(block);
                }
                if (block instanceof CompositeBlock) {
                    matchingBlocks.addAll(((CompositeBlock) block).findBlocksByMaterial(material));
                }
            }
            return matchingBlocks;
        }

        public int count() {
            int count = 0;
            for (Block block : blocks) {
                count++;
                if (block instanceof CompositeBlock) {
                    int subCount = ((CompositeBlock) block).count();
                    count += subCount;
                }
            }
            return count;
        }


    }

    public BlockCount countBlocks() {
        int singleBlockCount = 0;
        int compositeBlockCount = 0;

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                if (compositeBlock.getBlocks().size() > 0) {
                    compositeBlockCount++;
                }
            } else {
                singleBlockCount++;
            }
        }

        return new BlockCount(singleBlockCount, compositeBlockCount);
    }
    public static class BlockCount {
        private int singleBlockCount;
        private int compositeBlockCount;

        public BlockCount(int singleBlockCount, int compositeBlockCount) {
            this.singleBlockCount = singleBlockCount;
            this.compositeBlockCount = compositeBlockCount;
        }

        public int getSingleBlockCount() {
            return singleBlockCount;
        }

        public int getCompositeBlockCount() {
            return compositeBlockCount;
        }
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
    int count();
    List<Block> findBlocksByMaterial(String material);
    Optional<Block> findBlockByColor(String color);

}