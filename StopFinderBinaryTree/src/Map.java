import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that represents a map of {@link Stop} loaded from a given csv file.
 * @author francesco.rossato
 */
public class Map {
    /**
     * {@link LinkedList} of {@link Stop} with all the loaded stops.
     */
    private BinarySearchTree list;

    /**
     * Class constructor that loads the given csv file in the {@link Map#list} with the method {@link Map#load(String)}.
     * @param path The {@link String} with the csv file's path.
     * @throws FileNotFoundException if the given path is wrong.
     */
    public Map(String path) throws FileNotFoundException {
        load(path);
    }

    /**
     * Class constructor with no parameters
     */
    public Map(){
        list = new BinarySearchTree();
    }

    /**
     * Loads the given csv file in the {@link Map#list}.
     * @param path The csv file's path.
     * @throws FileNotFoundException If the given path is wrong.
     */
    public void load(String path) throws FileNotFoundException {
        list = new BinarySearchTree();
            Scanner in = new Scanner(new File(path));
            while(in.hasNextLine()){
                String[] line = in.nextLine().split(",");
                try {
                    list.add(new Stop(Integer.parseInt(line[0]), line[2], Double.parseDouble(line[4]), Double.parseDouble(line[5])));
                } catch (NumberFormatException e) {}
            }
    }

    /**
     * Searches the {@link Map#list} for the {@link Stop} closest to the given coordinates.
     * @param latitude The user's latitude.
     * @param longitude The user's longitude.
     * @return The {@link Stop} closest to the given coordinates
     */
    public Stop search(double latitude, double longitude){
        Stop nearest = null;
        double dist = Double.MAX_VALUE;
        for (Object s : BinarySearchTree.inOrderTraversal(list)) {
            double newDist = Math.sqrt(Math.pow(((Stop) s).getLATITUDE() - latitude, 2) + Math.pow(((Stop) s).getLONGITUDE() - longitude, 2));
            if(newDist < dist) {
                dist = newDist;
                nearest = (Stop) s;
            }
        }
        return nearest;
    }

}
