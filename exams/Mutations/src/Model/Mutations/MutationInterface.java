package Model.Mutations;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;

public interface MutationInterface {

    //add
    void aggiungi(Geraldo g);
    //toggle
    void togli(Geraldo g);

    //click
    void clicked(Geraldo g);
}
