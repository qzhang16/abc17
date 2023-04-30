import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private Map<String, String> vocabulary = new HashMap<String, String>();

    public Main() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("QUIT", "Q");

    }

    public static void main(String[] args) {
        Main m1 = new Main();
        m1.command();
    }

    public void command() {
        // write code here
        Location loc = locations.get(1);
        System.out.println(loc.getDescription());
        System.out.println();
        System.out.println("Available exits are " + loc.getExits().keySet().toString().replaceAll("[\\[\\]]","") + ",");
        Scanner scanner = new Scanner(System.in);
        String str;
        String s;
        while( true) {
            str = scanner.nextLine().toUpperCase();
            s=null;

            for (String a : vocabulary.keySet()) {
                if ( str.contains(a) ) {
                    s = vocabulary.get(a);
                    if (loc.getExits().containsKey(s)) {
                        loc = locations.get(loc.getExits().get(s));
                        System.out.println(loc.getDescription());
                        System.out.println();
                        System.out.println("Available exits are " + loc.getExits().keySet().toString().replaceAll("[\\[\\]]","")+ ",");

                    } else {
                        s=null;
                    }

                    break;
                }

            }

            if (s ==null) {
                System.out.println("You cannot go in that direction");
                System.out.println();
                System.out.println(loc.getDescription());
                System.out.println();
                System.out.println("Available exits are " + loc.getExits().keySet().toString().replaceAll("[\\[\\]]","")+ ",");
            }

        }

    }

    public class Player {
        // write code here
        private String name;
        private String weapon;
        private int hitPoints;
        private int strength;

        public Player(String name, int hitPoints, int strength) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.strength = strength;
            weapon = "Sword";
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeapon() {
            return weapon;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }
    }
}