package Assets.Moves;

public class MagicAttack extends Attack {
    private final static String FILE = "src/Images/Moves/magicattack.png";

    public MagicAttack() {
        super(FILE, "Magic Blast", "magic", "magic");
        setMaxUses(3, true);
        setDescription("Damage is based on magic.");
    }
}
