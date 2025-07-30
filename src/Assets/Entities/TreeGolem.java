package Assets.Entities;

import Assets.Battle.EnemyPlayerMove;
import Assets.Moves.Move;
import Assets.Moves.Attack;

public class TreeGolem extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/treegolem.png";

    public TreeGolem() {
        super(FILE, "Tree Golem", 300, 300, 55, 60, 60, 5);
    }

    public Entity createCopy() {
        return new TreeGolem();
    }

    public void setMoveValue(EnemyPlayerMove enemyMove) {
        super.setMoveValue(enemyMove);
        int value = enemyMove.getValue();

        Enemy user = enemyMove.user;
        Entity target = enemyMove.target;
        Move move = enemyMove.move;

        if (move instanceof Attack) {
            value += target.getStats().get("defense");
            value += target.getStats().get("health");
        }

        enemyMove.setValue(value);
    }

}
