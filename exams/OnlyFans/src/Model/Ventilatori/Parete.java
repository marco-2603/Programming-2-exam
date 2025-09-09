package Model.Ventilatori;

import Model.Alimentazioni.PowerInterface;
import Model.Enums.FanTypes;

public class Parete extends AbstractFan {

    public Parete(String marca, PowerInterface alimentazione) {
        super(marca,30 * alimentazione.getCoeff(), FanTypes.parete ,  alimentazione);
    }

    @Override
    public String getTipo() {
        return "Parete";
    }
}
