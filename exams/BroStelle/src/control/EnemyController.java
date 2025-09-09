package control;

import javafx.scene.control.Alert;
import model.Enemy;
import model.Exceptions.EnemyKilledException;
import model.bros.Bro;
import view.EnemyPane;

public class EnemyController {
    Enemy mob;
    EnemyPane ep;

    public EnemyController(Enemy mob){
        this.mob = mob;
        this.ep = new EnemyPane(this);
    }

    public void respawn(){
        mob = new Enemy();
        ep.refresh(mob);
    }

    public Enemy getEnemy(){
        return mob;
    }

    public EnemyPane getEnemyPane(){
        return ep;
    }

    public void getHit(Bro b) {
        try {
            mob.getHit(b.getDamage());
            ep.refresh(mob);
        }catch (EnemyKilledException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("enemy killed, respawning");
            alert.showAndWait();
            respawn();
        }
    }
}
