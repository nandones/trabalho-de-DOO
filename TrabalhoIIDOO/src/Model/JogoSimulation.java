
package Model;

import java.util.ArrayList;

public class JogoSimulation extends Jogo implements JogoSimulationInterface{
    
    private ArrayList <Player> listaPlayers = new ArrayList<>(8);// já instanciado com 8 players
    private ArrayList <Player> listaPlayersOrdenadosPeloIndex = new ArrayList<>(8);
    private ArrayList <Player> listaPlayersSemis = new ArrayList<>(4);
    private ArrayList <Player> listaPlayersFinal = new ArrayList<>(2);
    private Player campeao = null;
    private String fase = "oitavas";


    public JogoSimulation() {
        super.enumerandoPlayersDefault(listaPlayers);
        this.fase = "oitavas";
    }

    public Player getCampeao() {
        return campeao;
    }

    public void setCampeao(Player campeao) {
        this.campeao = campeao;
    }
    
    

    
    public ArrayList<Player> getListaPlayersFinal() {
        return listaPlayersFinal;
    }

    public void setListaPlayersFinal(ArrayList<Player> listaPlayersFinal) {
        this.listaPlayersFinal = listaPlayersFinal;
    }
    
    
    

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public ArrayList<Player> getListaPlayersOrdenadosPeloIndex() {
        return listaPlayersOrdenadosPeloIndex;
    }

    public void setListaPlayersOrdenadosPeloIndex(ArrayList<Player> listaPlayersOrdenadosPeloIndex) {
        this.listaPlayersOrdenadosPeloIndex = listaPlayersOrdenadosPeloIndex;
    }

    public ArrayList<Player> getListaPlayersSemis() {
        return listaPlayersSemis;
    }

    public void setListaPlayersSemis(ArrayList<Player> listaPlayersSemis) {
        this.listaPlayersSemis = listaPlayersSemis;
    }
    
    
    
    

    @Override
    public String setResultadoAleatorio() {
        int gols1 = (int) (Math.random() * 6);
        int gols2 = (int) (Math.random() * 6);
        
        if(gols1 == gols2){
            int aux = (int) (Math.random() * 2);
            if(aux == 0){gols1++;}
            if(aux == 1){gols2++;}
        }
       
        String saldo= String.valueOf(gols1)+"x"+String.valueOf(gols2);
        return saldo ;
    }
    
    public ArrayList<Player> getListaPlayers() {
        return listaPlayers;
    }

    public void setListaPlayers(ArrayList<Player> listaPlayers) {
        this.listaPlayers = listaPlayers;
    }
    


    @Override
    public String toString() {
        return "JogoSimulation{" + "listaPlayers=" + listaPlayers + "}\n" +
                listaPlayers.get(7).getNome() + " " + listaPlayers.get(7).getTime()+ " " + listaPlayers.get(7).getIndex();
    }
                                                                                                                    ;
    }
    
    
    
    
    

