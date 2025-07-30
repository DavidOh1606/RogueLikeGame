package Assets.Entities;

import Assets.Battle.EnemyPlayerMove;
import Assets.Moves.*;

public class Duck extends Enemy {
    private static final String FILE = "src/Images/Enemies/duck.png";

    public Duck() {
        super(FILE, "Duck", 100, 100, 2, 10, 10, 10);
        addMove(new Quack());
    }

    public void setMoveValue(EnemyPlayerMove enemyMove) {
        super.setMoveValue(enemyMove);
        int value = enemyMove.getValue();

        Enemy user = enemyMove.user;
        Entity target = enemyMove.target;
        Move move = enemyMove.move;

        if (move instanceof Quack) {
            value += 100;
        }

        enemyMove.setValue(value);
    }

    public Entity createCopy() {
        return new Duck();
    }

}
