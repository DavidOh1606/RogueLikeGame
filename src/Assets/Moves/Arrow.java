package Assets.Moves;

public class Arrow extends Attack {
    private static final String FILE = "src/Images/Moves/arrow.png";

    public Arrow() {
        super(FILE, "Ranged Shot", "speed", "speed");
        setMaxUses(5, true);
        setDescription("Damage is based off speed.");
    }
}
