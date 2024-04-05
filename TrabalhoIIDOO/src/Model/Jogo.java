package Model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Jogo implements Serializable {
    
    //MÉTODO UTILIZADO PELO CONSTRUTOR DAS CASSES FILHAS
    public void enumerandoPlayersDefault(ArrayList<Player> listaPlayers){
        for (int i = 0; i < 8; i++) {
            Player p = new Player("Player" + (i+1), "TM"+(i+1));
            p.setIndex(99);
            listaPlayers.add(p);
        }
    }
    
    public void sorteioIndex(ArrayList<Player> listaPlayers, ArrayList<Player> listaPlayersOrdenadosPeloIndex){
        

        
        for (Player player : listaPlayers) {
            boolean verificaRepeticao = false;
            while(verificaRepeticao == false){
                int numeroInteiro = (int) (Math.random() * 8);
                System.out.println("numero inteiro : " +numeroInteiro);
                if(numeroInteiro != listaPlayers.get(0).getIndex() && numeroInteiro != listaPlayers.get(1).getIndex() &&
                   numeroInteiro != listaPlayers.get(2).getIndex() && numeroInteiro != listaPlayers.get(3).getIndex() &&
                   numeroInteiro != listaPlayers.get(4).getIndex() && numeroInteiro != listaPlayers.get(5).getIndex() &&
                   numeroInteiro != listaPlayers.get(6).getIndex() && numeroInteiro != listaPlayers.get(7).getIndex()){
                    
                    player.setIndex(numeroInteiro);
                   
                    System.out.println("time : " + player.getTime()+ "        index : " + player.getIndex() + "      numero inteiro : " +numeroInteiro);
                    verificaRepeticao=true;
                }
            }
            
            
        }
        for (int j = 0; j < listaPlayers.size(); j++) {
            
        
            for (int i = 0; i < listaPlayers.size(); i++) {
                if(listaPlayers.get(i).getIndex()==j){
                    listaPlayersOrdenadosPeloIndex.add(listaPlayers.get(i));
                    continue;
                }
            }
        }
        System.out.println("lista de players ordenados pelo index: ");
            System.out.println("elemento 0: " + listaPlayersOrdenadosPeloIndex.get(0).getTime());
            System.out.println("elemento 1: " + listaPlayersOrdenadosPeloIndex.get(1).getTime());
            System.out.println("elemento 2: " + listaPlayersOrdenadosPeloIndex.get(2).getTime());
            System.out.println("elemento 3: " + listaPlayersOrdenadosPeloIndex.get(3).getTime());
            System.out.println("elemento 4: " + listaPlayersOrdenadosPeloIndex.get(4).getTime());
            System.out.println("elemento 5: " + listaPlayersOrdenadosPeloIndex.get(5).getTime());
            System.out.println("elemento 6: " + listaPlayersOrdenadosPeloIndex.get(6).getTime());
            System.out.println("elemento 7: " + listaPlayersOrdenadosPeloIndex.get(7).getTime());
    }
    
    
    
}
