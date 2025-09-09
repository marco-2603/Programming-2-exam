package view;

import control.EnemyController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Enemy;

public class EnemyPane extends HBox {
    private Text enemyStats;
    private Button reset;

    public EnemyPane(EnemyController ec){
        enemyStats = new Text("HP " + ec.getEnemy().getHealth());
        reset = new Button("Reset");
        reset.setOnAction(e -> {
           ec.respawn();
        });
        this.getChildren().addAll(enemyStats,reset);
        this.setSpacing(10);
    }


    public void refresh(Enemy enemy) {
        enemyStats.setText("HP " + enemy.getHealth());
    }
}
