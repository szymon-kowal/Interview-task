
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Importowanie danych z pliku Data2
        List<Block> data = Data2.getData();
        Wall wall = new Wall(data);

        // Zmienne wobec ktorych szukamy
        String color = "red";
        String material = "wood";


        // Znajdowanie jednego bloku o danym kolorze
        Optional<Block> foundBlock = wall.findBlockByColor(color);
        if (foundBlock.isPresent()) {
            Block block = foundBlock.get();
            System.out.println("Found block with color" + color + " : " + block.getColor() + ", " + block.getMaterial());
        } else {
            System.out.println("No block found with color " + color);
        }

        // Znajdowanie wszystkich bloków o danym materiale
        List<Block> foundBlocks = wall.findBlocksByMaterial(material);
        System.out.println("Found blocks with material wood:");
        for (Block block : foundBlocks) {
            System.out.println(block.getColor() + ", " + block.getMaterial());
        }

        // Podliczanie elementow w Wall. W tym wypadku wzialem pod uwage tylko pojedyncze Block dodawane do listy i
        // Block znajdujacy sie wewnatrz kompozytow. Jesli inputuje 3 pojedyncze bloki i 4 blok to CompositeBlock, ktory
        // Sklada sie z 3 mniejszych elementow to funkcja zwraca 3 pojedyncze bloki + 3 bloki z kompozytu.
        int blockCount = wall.count();
        System.out.println("Total number of blocks in the wall: " + blockCount);


        // Dodatkowa funkcja, ktora zwraca ile zostalo dodanych pojedynczych blokow i blokow kompozytowych.
        // Na poprzednim przykladzie : Jesli inputuje 3 pojedyncze bloki i 4 blok to CompositeBlock, ktory
        // Sklada sie z 3 mniejszych elementow to funkcja zwraca 3 pojedyncze bloki + CompositeBlock.
        // Jezeli jak w przypadku Data3.java inputujemy pusty Composite block nie majacy zadnych blokow w sobie to
        // ta metoda nie bierze compositBlocks pod uwage
        Wall.BlockCount blockCountBlocks = wall.countBlocks();
        System.out.println("Single blocks: " + blockCountBlocks.getSingleBlockCount());
        System.out.println("Composite blocks: " + blockCountBlocks.getCompositeBlockCount());
    }
}
