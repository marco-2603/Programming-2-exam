package model.mutations;

import model.geralt.Geralt;
import model.functions.MyConsumer;

public interface MutationInterface {

    MyConsumer<Geralt> applica(Geralt g);
    MyConsumer<Geralt> rimuovi(Geralt g);

    void clicked(Geralt g);
}
