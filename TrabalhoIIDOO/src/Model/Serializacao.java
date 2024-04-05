package Model;

import java.io.Serializable;

public class Serializacao implements Serializable{
    
    JogoSimulation jogoSimulationSerializable = new JogoSimulation();

    public JogoSimulation getJogoSimulationSerializable() {
        return jogoSimulationSerializable;
    }

    public void setJogoSimulationSerializable(JogoSimulation jogoSimulationSerializable) {
        this.jogoSimulationSerializable = jogoSimulationSerializable;
    }
    
    
    
}
