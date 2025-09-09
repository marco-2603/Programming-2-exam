package Main;

import Model.Titoli.Anime;
import Model.Titoli.Film;
import Model.Titoli.SerieTV;
import Model.Titoli.TitleInterface;
import View.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TitleInterface t1 = new SerieTV("Boris", 2010, "Italiano", 4, 10);
        TitleInterface t2 = new Anime("Attack on Titan", 2013, "Giapponese", "Italiano", 10);
        TitleInterface t3 = new Film("Parasite", 2019, "Inglese", 20);
        TitleInterface t4 = new Anime("Pokemon", 2010, "Giapponese", null, 10);
        TitleInterface t5 = new Film("The Irishman", 2019, "Inglese", 5);
        TitleInterface t6 = new SerieTV("1994", 2019, "Italiano", 3, 10);
        TitleInterface t7 = new Film("Her", 2013, "Inglese", 20);


        ArrayList<TitleInterface> titoli = new ArrayList<>();
        titoli.add(t1);
        titoli.add(t2);
        titoli.add(t3);
        titoli.add(t4);
        titoli.add(t5);
        titoli.add(t6);
        titoli.add(t7);


        MainView mainView = new MainView(titoli);

        primaryStage.setScene(new Scene(mainView, 400, 250));
        primaryStage.show();
    }
}
