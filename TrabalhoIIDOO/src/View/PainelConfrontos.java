package View;
/*

*/

import Model.JogoIRL;
import Model.JogoSimulation;
import Model.Player;
import static View.Janela.controller;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PainelConfrontos extends javax.swing.JPanel {
    JogoSimulation jogoSimulation = null;
    JogoIRL jogoIRL = null;

    public PainelConfrontos( JogoSimulation jogoSimulation, JogoIRL jogoIRL) {
        this.jogoIRL = jogoIRL;
        this.jogoSimulation = jogoSimulation;
        initComponents();
        ajustes();
//        System.out.println("abriu confrontos");
//        if(this.jogoIRL!=null){
//            System.out.println("irl");
//            for (int i = 0; i < this.jogoIRL.getListaPlayersOrdenadosPeloIndex().size(); i++) {
//                System.out.println(this.jogoIRL.getListaPlayersOrdenadosPeloIndex().get(i).getTime());
//            }
//        }
//        
//        if(this.jogoSimulation!=null){
//            System.out.println("simulation");
//            for (int i = 0; i < this.jogoSimulation.getListaPlayersOrdenadosPeloIndex().size(); i++) {
//                System.out.println(this.jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(i).getTime());
//            }
//        }
        setaPainelConformeFaseEModo();
    }
    
    public void serializaIRL(JogoIRL jogoIRL){
        System.out.println("\nserializaIRL\n");
        String nomeDoArquivo = "irl.ser";

        try{
             FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
             ObjectOutputStream out = new ObjectOutputStream(arquivo);

             out.writeObject(jogoIRL);
             arquivo.close();
             System.out.println("irl serializado com sucesso!");
             System.out.println("fase: " + jogoIRL.getFase());
        }
        catch(IOException e){
            System.out.println("falha na serialização de irl");
         }
    }

    public void serializaSimulation(JogoSimulation jogoSimulation){
        System.out.println("\nserializaSimulation\n");
        String nomeDoArquivo = "simulation.ser";

        try{
             FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
             ObjectOutputStream out = new ObjectOutputStream(arquivo);

             out.writeObject(jogoSimulation);
             arquivo.close();
             System.out.println("simulation serializado com sucesso!");
             System.out.println("fase: " + jogoSimulation.getFase());
        }
        catch(IOException e){
            System.out.println("falha na serialização de irl");
         }
    }
    
    //DEIXA O BACKGROUND DE TODOS OS TEXTFIELDS TRANSLÚCIDOS;
    //SETARIA AS CORES(JÁ AJEITADAS NO DESIGN);
    //CONFIGURA A VISIBILIDADE DOS ELEMENTOS PARA AS OITAVAS, EMBORA NAO RELACIONE 
    //TIME E JLABEL;
    
    public void ajustes(){
        
        tf_golsOitavasIndex0.setOpaque(false);
        tf_golsOitavasIndex1.setOpaque(false);
        tf_golsOitavasIndex2.setOpaque(false);
        tf_golsOitavasIndex3.setOpaque(false);
        tf_golsOitavasIndex4.setOpaque(false);
        tf_golsOitavasIndex5.setOpaque(false);
        tf_golsOitavasIndex6.setOpaque(false);
        tf_golsOitavasIndex7.setOpaque(false);
        tf_golsSemisTm0.setOpaque(false);
        tf_golsSemisTm1.setOpaque(false);
        tf_golsSemisTm2.setOpaque(false);
        tf_golsSemisTm3.setOpaque(false);
        tf_golsFinalTm0.setOpaque(false);
        tf_golsFinalTm1.setOpaque(false);
        
        tf_golsSemisTm0.setVisible(false);
        tf_golsSemisTm1.setVisible(false);
        la_X4.setVisible(false);
        la_semisTm0.setVisible(false);
        la_semisTm1.setVisible(false);
        
        tf_golsSemisTm2.setVisible(false);
        tf_golsSemisTm3.setVisible(false);
        la_X5.setVisible(false);
        la_semisTm2.setVisible(false);
        la_semisTm3.setVisible(false);
        
        tf_golsFinalTm0.setVisible(false);
        tf_golsFinalTm1.setVisible(false);
        la_X6.setVisible(false);
        la_finalTm0.setVisible(false);
        la_finalTm1.setVisible(false);
        
    }       
    
    //METODO CHAMADO POR CADA KEYTYPED DE CADA TEXTFIELD PARA PERMITIR SOMENTE NUMEROS;
    public void formatacaoGols(java.awt.event.KeyEvent evt){
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }
    }
    
    //CONTROLA A VISIBILIDADE E CHAMA METODOS QUE RELACIONAM OS TIMES AOS JLABELS;
    //UTILIZADO TANTO POR IRL QUANTO SIMULATION;
    //ESSENCIAL PARA A DESSERIALIZAÇÃO;
    public void setaPainelConformeFaseEModo(){
        System.out.println("\nsetaPainelConformeFaseEModo[\n");
        if(controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            System.out.println("simulacao "+ jogoSimulation.getFase());
            if(jogoSimulation.getFase().equalsIgnoreCase("oitavas")){
                carregaTimesOitavasSimulation();
            }
            if(jogoSimulation.getFase().equalsIgnoreCase("semis")){
                carregaTimesOitavasSimulation();
                carregaGolsOitavasSimulation();
                carregaTimesSemisSimulation();
            }
            if(jogoSimulation.getFase().equalsIgnoreCase("final")){
                carregaTimesOitavasSimulation();
                carregaGolsOitavasSimulation();
                carregaTimesSemisSimulation();
                carregaGolsSemisSimulation();
                carregaTimesFinalSimulation();
            }
            if(jogoSimulation.getFase().equalsIgnoreCase("resultado")){
                carregaTimesOitavasSimulation();
                carregaGolsOitavasSimulation();
                carregaTimesSemisSimulation();
                carregaGolsSemisSimulation();
                carregaTimesFinalSimulation();
                carregaGolsFinalSimulation();
            }
        }
        
        if(controller.getModoDeJogo().equalsIgnoreCase("irl")){
            System.out.println("irl"+ jogoIRL.getFase());
            if(jogoIRL.getFase().equalsIgnoreCase("oitavas")){
                carregaTimesOitavasIRL();
            }
            if(jogoIRL.getFase().equalsIgnoreCase("semis")){
                carregaTimesOitavasIRL();
                carregaGolsOitavasIRL();
                carregaTimesSemisIRL();
            }
            if(jogoIRL.getFase().equalsIgnoreCase("final")){
                carregaTimesOitavasIRL();
                carregaGolsOitavasIRL();
                carregaTimesSemisIRL();
                carregaGolsSemisIRL();
                carregaTimesFinalIRL();
            }
            if(jogoIRL.getFase().equalsIgnoreCase("resultado")){
                carregaTimesOitavasIRL();
                carregaGolsOitavasIRL();
                carregaTimesSemisIRL();
                carregaGolsSemisIRL();
                carregaTimesFinalIRL();
                carregaGolsFinalIRL();
            }
        }
        System.out.println("]");
    }
    
    //CARREGA O ARRAYLIST DE TIMES ORDENADOS PELO INDEX (0-7) SIMULATION E OS POSICIONA,
    //BLOQUEIA OS TEXT FIELDS DAS OITAVAS;
    //>>ListaPlayersOrdenadosPeloIndex<< DEFINIDO NO PAINEL CADASTRAR TIMES
    public void carregaTimesOitavasSimulation(){
       
        
        
        la_oitavaIndex0.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).getTime());
        tf_golsOitavasIndex0.setEnabled(false);
      
        la_oitavaIndex1.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).getTime());
        tf_golsOitavasIndex1.setEnabled(false);

        la_oitavaIndex2.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).getTime());
        tf_golsOitavasIndex2.setEnabled(false);

        la_oitavaIndex3.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).getTime());
        tf_golsOitavasIndex3.setEnabled(false);

        la_oitavaIndex4.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).getTime());
        tf_golsOitavasIndex4.setEnabled(false);

        la_oitavaIndex5.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).getTime());
        tf_golsOitavasIndex5.setEnabled(false);

        la_oitavaIndex6.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).getTime());
        tf_golsOitavasIndex6.setEnabled(false);

        la_oitavaIndex7.setText(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).getTime());
        tf_golsOitavasIndex7.setEnabled(false);
        System.out.println("\ncarregaTimesOitavasSimulation ok\n");
    }

    //METODO CRUCIAL PARA A DESSERIALIZAÇÃO
    public void carregaGolsOitavasSimulation(){
        
        tf_golsOitavasIndex0.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).getGol0()));
        tf_golsOitavasIndex1.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).getGol0()));
        tf_golsOitavasIndex2.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).getGol0()));
        tf_golsOitavasIndex3.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).getGol0()));
        tf_golsOitavasIndex4.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).getGol0()));
        tf_golsOitavasIndex5.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).getGol0()));
        tf_golsOitavasIndex6.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).getGol0()));
        tf_golsOitavasIndex7.setText(String.valueOf(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).getGol0()));
        
        System.out.println("carregaGolsOitavasSimulation ok");

    }
    
    public void carregaGolsSemisSimulation(){
        System.out.println("carrega gols semis simulation:");
        System.out.println(String.valueOf(jogoSimulation.getListaPlayersSemis().get(0).getGol1()));
        System.out.println(String.valueOf(jogoSimulation.getListaPlayersSemis().get(1).getGol1()));
        System.out.println(String.valueOf(jogoSimulation.getListaPlayersSemis().get(2).getGol1()));
        System.out.println(String.valueOf(jogoSimulation.getListaPlayersSemis().get(3).getGol1()));
        tf_golsSemisTm0.setText(String.valueOf(jogoSimulation.getListaPlayersSemis().get(0).getGol1()));
        tf_golsSemisTm1.setText(String.valueOf(jogoSimulation.getListaPlayersSemis().get(1).getGol1()));
        tf_golsSemisTm2.setText(String.valueOf(jogoSimulation.getListaPlayersSemis().get(2).getGol1()));
        tf_golsSemisTm3.setText(String.valueOf(jogoSimulation.getListaPlayersSemis().get(3).getGol1()));
        System.out.println("\ncarregaGolsSemisSimulation ok\n");
    }
    
    public void carregaGolsFinalSimulation(){
        
        tf_golsFinalTm0.setEnabled(true);
        tf_golsFinalTm1.setEnabled(true);
        System.out.println("\ncarregaGolsFinalSimulation\n");
        System.out.println(jogoSimulation.getListaPlayersFinal().get(0).getGol2()+"x"+jogoSimulation.getListaPlayersFinal().get(1).getGol2());
        String placar[] = (jogoSimulation.getListaPlayersFinal().get(0).getGol2()+"x"+jogoSimulation.getListaPlayersFinal().get(1).getGol2()).split("x");
        tf_golsFinalTm0.setText(placar[0]);
        System.out.println(placar[0]);
        tf_golsFinalTm1.setText(placar[1]);
        System.out.println(placar[1]);
        tf_golsFinalTm0.setEnabled(false);
        tf_golsFinalTm1.setEnabled(false);
        System.out.println("\ncarregaGolsFinalSimulation ok\n");
    }
    
        public void carregaGolsFinalIRL(){
            
        tf_golsFinalTm0.setEnabled(true);
        tf_golsFinalTm1.setEnabled(true);
        System.out.println(jogoIRL.getListaPlayersFinal().get(0).getGol2()+"x"+jogoIRL.getListaPlayersFinal().get(1).getGol2());
        String placar[] = (jogoIRL.getListaPlayersFinal().get(0).getGol2()+"x"+jogoIRL.getListaPlayersFinal().get(1).getGol2()).split("x");
        tf_golsFinalTm0.setText(placar[0]);
        System.out.println(placar[0]);
        tf_golsFinalTm1.setText(placar[1]);
        System.out.println(placar[1]);
        tf_golsFinalTm0.setEnabled(false);
        tf_golsFinalTm1.setEnabled(false);
        System.out.println("\ncarregaGolsFinalIRL ok\n");
    }
   
    
    //METODO CRUCIAL PARA A DESSERIALIZAÇÃO
    public void carregaGolsOitavasIRL(){
        
        tf_golsOitavasIndex0.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).getGol0()));
        tf_golsOitavasIndex1.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).getGol0()));
        tf_golsOitavasIndex2.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).getGol0()));
        tf_golsOitavasIndex3.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).getGol0()));
        tf_golsOitavasIndex4.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).getGol0()));
        tf_golsOitavasIndex5.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).getGol0()));
        tf_golsOitavasIndex6.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).getGol0()));
        tf_golsOitavasIndex7.setText(String.valueOf(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).getGol0()));
        System.out.println("\ncarregaGolsFinalIRL ok\n");
    }
    
    public void carregaGolsSemisIRL(){
        
        tf_golsSemisTm0.setText(String.valueOf(jogoIRL.getListaPlayersSemis().get(0).getGol1()));
        tf_golsSemisTm1.setText(String.valueOf(jogoIRL.getListaPlayersSemis().get(1).getGol1()));
        tf_golsSemisTm2.setText(String.valueOf(jogoIRL.getListaPlayersSemis().get(2).getGol1()));
        tf_golsSemisTm3.setText(String.valueOf(jogoIRL.getListaPlayersSemis().get(3).getGol1()));
        System.out.println("\ncarregaGolsSemisIRL ok\n");
        }

    //CARREGA O ARRAYLIST DE TIMES ORDENADOS PELO INDEX (0-7) IRL E OS POSICIONA,
    //LIBERA OS TEXT FIELDS DAS OITAVAS;
    //>>ListaPlayersOrdenadosPeloIndex<< DEFINIDO NO PAINEL CADASTRAR TIMES
    public void carregaTimesOitavasIRL(){
        
       
        la_oitavaIndex0.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).getTime());
        tf_golsOitavasIndex0.setEnabled(true);

        la_oitavaIndex1.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).getTime());
        tf_golsOitavasIndex1.setEnabled(true);

        la_oitavaIndex2.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).getTime());
        tf_golsOitavasIndex2.setEnabled(true);

        la_oitavaIndex3.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).getTime());
        tf_golsOitavasIndex3.setEnabled(true);

        la_oitavaIndex4.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).getTime());
        tf_golsOitavasIndex4.setEnabled(true);
        
        la_oitavaIndex5.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).getTime());
        tf_golsOitavasIndex5.setEnabled(true);

        la_oitavaIndex6.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).getTime());
        tf_golsOitavasIndex6.setEnabled(true);

        la_oitavaIndex7.setText(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).getTime());
        tf_golsOitavasIndex7.setEnabled(true);
        System.out.println("\ncarregaTimesOitavasIRL ok\n");
    }
    
    //ALOCA OS TIMES DO ARRAYLIST DE SEMIS PARA AS LABELS RESPECTIVAS
    public void carregaTimesSemisSimulation(){
       
        la_semi0.setVisible(false);
        la_semi1.setVisible(false);
        la_semisTm0.setVisible(true);
        la_semisTm1.setVisible(true);
        la_semisTm2.setVisible(true);
        la_semisTm3.setVisible(true);
        la_X4.setVisible(true);
        la_X5.setVisible(true);
        tf_golsSemisTm0.setVisible(true);
        tf_golsSemisTm1.setVisible(true);
        tf_golsSemisTm2.setVisible(true);
        tf_golsSemisTm3.setVisible(true);
        tf_golsSemisTm0.setEnabled(false);
        tf_golsSemisTm1.setEnabled(false);
        tf_golsSemisTm2.setEnabled(false);
        tf_golsSemisTm3.setEnabled(false);
        
        la_semisTm0.setText(jogoSimulation.getListaPlayersSemis().get(0).getTime());
        la_semisTm1.setText(jogoSimulation.getListaPlayersSemis().get(1).getTime());
        la_semisTm2.setText(jogoSimulation.getListaPlayersSemis().get(2).getTime());
        la_semisTm3.setText(jogoSimulation.getListaPlayersSemis().get(3).getTime());
        
        System.out.println("\ncarregaTimesSemisSimulation ok\n");
    }
    
    public void carregaTimesSemisIRL(){
        
        la_semi0.setVisible(false);
        la_semi1.setVisible(false);
        la_semisTm0.setVisible(true);
        la_semisTm1.setVisible(true);
        la_semisTm2.setVisible(true);
        la_semisTm3.setVisible(true);
        la_X4.setVisible(true);
        la_X5.setVisible(true);
        tf_golsSemisTm0.setVisible(true);
        tf_golsSemisTm1.setVisible(true);
        tf_golsSemisTm2.setVisible(true);
        tf_golsSemisTm3.setVisible(true);
        tf_golsOitavasIndex0.setEnabled(false);
        tf_golsOitavasIndex1.setEnabled(false);
        tf_golsOitavasIndex2.setEnabled(false);
        tf_golsOitavasIndex3.setEnabled(false);
        tf_golsOitavasIndex4.setEnabled(false);
        tf_golsOitavasIndex5.setEnabled(false);
        tf_golsOitavasIndex6.setEnabled(false);
        tf_golsOitavasIndex7.setEnabled(false);
        
        la_semisTm0.setText(jogoIRL.getListaPlayersSemis().get(0).getTime());
        la_semisTm1.setText(jogoIRL.getListaPlayersSemis().get(1).getTime());
        la_semisTm2.setText(jogoIRL.getListaPlayersSemis().get(2).getTime());
        la_semisTm3.setText(jogoIRL.getListaPlayersSemis().get(3).getTime());
        System.out.println("\ncarregaTimesSemisIRL\n");
    }
    
    //SETA GOLS E PREENCHE O VETOR ORDENADO PELO INDEX SEMIFINAIS DO SIMULATION
    public void sorteiaResultadosOitavasSimulation(){
        String saldos = jogoSimulation.setResultadoAleatorio();
        String gols1[] = saldos.split("x");
        tf_golsOitavasIndex0.setText(gols1[0]);
        tf_golsOitavasIndex1.setText(gols1[1]);
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).setGol0(Integer.parseInt(gols1[0]));
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).setGol0(Integer.parseInt(gols1[1]));
        if(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).getGol0()>jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).getGol0()){
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).setVenceu0(true);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).setVenceu0(false);
        }else{
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).setVenceu0(false);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).setVenceu0(true);
        }
        
        System.out.println("index 0 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(0).getVenceu0());
        System.out.println("index 1 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(1).getVenceu0());
        
        saldos = jogoSimulation.setResultadoAleatorio();
        String gols2[] = saldos.split("x");
        tf_golsOitavasIndex2.setText(gols2[0]);
        tf_golsOitavasIndex3.setText(gols2[1]);
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).setGol0(Integer.parseInt(gols2[0]));
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).setGol0(Integer.parseInt(gols2[1]));
        if(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).getGol0()>jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).getGol0()){
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).setVenceu0(true);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).setVenceu0(false);
        }else{
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).setVenceu0(false);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).setVenceu0(true);
        }
        System.out.println("index 2 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(2).getVenceu0());
        System.out.println("index 3 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(3).getVenceu0());
        
        saldos = jogoSimulation.setResultadoAleatorio();
        String gols3[] = saldos.split("x");
        tf_golsOitavasIndex4.setText(gols3[0]);
        tf_golsOitavasIndex5.setText(gols3[1]);
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).setGol0(Integer.parseInt(gols3[0]));
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).setGol0(Integer.parseInt(gols3[1]));
        if(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).getGol0()>jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).getGol0()){
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).setVenceu0(true);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).setVenceu0(false);
        }else{
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).setVenceu0(false);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).setVenceu0(true);
        }
        System.out.println("index 4 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(4).getVenceu0());
        System.out.println("index 5 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(5).getVenceu0());
        
        saldos = jogoSimulation.setResultadoAleatorio();
        String gols4[] = saldos.split("x");
        tf_golsOitavasIndex6.setText(gols4[0]);
        tf_golsOitavasIndex7.setText(gols4[1]);
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).setGol0(Integer.parseInt(gols4[0]));
        jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).setGol0(Integer.parseInt(gols4[1]));
        if(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).getGol0()>jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).getGol0()){
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).setVenceu0(true);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).setVenceu0(false);
        }else{
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).setVenceu0(false);
            jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).setVenceu0(true);
        }
        System.out.println("index 6 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(6).getVenceu0());
        System.out.println("index 7 venceu->" + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(7).getVenceu0());
        
       
        for (int i = 0; i<jogoSimulation.getListaPlayersOrdenadosPeloIndex().size(); i++) {
            
            if(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(i).getVenceu0()==true){
                jogoSimulation.getListaPlayersSemis().add(jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(i));
                System.out.println("i = " + i);
                System.out.println("posicao [" + i + "] = " + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(i).getTime());
            }
        }
        
        System.out.println("VETOR ORDENADO PELO INDEX SEMIFINAIS SIMULATION:");
        System.out.println("posicao [0] = " + jogoSimulation.getListaPlayersSemis().get(0).getTime());
        System.out.println("posicao [1] = " + jogoSimulation.getListaPlayersSemis().get(1).getTime());
        System.out.println("posicao [2] = " + jogoSimulation.getListaPlayersSemis().get(2).getTime());
        System.out.println("posicao [3] = " + jogoSimulation.getListaPlayersSemis().get(3).getTime());

    }
    
    //EXIGE PREENCHIMENTO DOS TEXTFIELDS
    //RETORNA TRUE EM CASO DE TF EM BRANCO
    public boolean verificaTextFieldEmBrancoOitavasIRL(){
        //Feito com try catch para praticar
        boolean blank = false;
        try{
            String text = tf_golsOitavasIndex0.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex1.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex2.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex3.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex4.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex5.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex6.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsOitavasIndex7.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
            blank = true;
        }
        return blank;
    }
    
    public boolean verificaTextFieldEmBrancoSemisIRL(){
        //Feito com try catch para praticar
        boolean blank = false;
        try{
            String text = tf_golsSemisTm0.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsSemisTm1.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsSemisTm2.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsSemisTm3.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
            blank = true;
        }
        return blank;
    }
    
     public boolean verificaTextFieldEmBrancoFinalIRL(){
        //Feito com try catch para praticar
        boolean blank = false;
        try{
            String text = tf_golsFinalTm0.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }text = tf_golsFinalTm1.getText();
            if(text.isBlank()){
                throw new NumberFormatException();
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
            blank = true;
        }
        return blank;
    }
    
    //RETORNA TRUE EM CASO DE EMPATE
    public boolean verificaEmpatesOitavasIRL(){
        
            
        
        boolean empate=false;
        
        int gol1;
        int gol2;
        
        gol1 = Integer.parseInt(tf_golsOitavasIndex0.getText());
        gol2 = Integer.parseInt(tf_golsOitavasIndex1.getText());
        if(gol1==gol2){
            empate = true;
        }
        
        gol1 = Integer.parseInt(tf_golsOitavasIndex2.getText());
        gol2 = Integer.parseInt(tf_golsOitavasIndex3.getText());
        if(gol1==gol2){
            empate = true;
        }
        
        gol1 = Integer.parseInt(tf_golsOitavasIndex4.getText());
        gol2 = Integer.parseInt(tf_golsOitavasIndex5.getText());
        if(gol1==gol2){
            empate = true;
        }

        gol1 = Integer.parseInt(tf_golsOitavasIndex6.getText());
        gol2 = Integer.parseInt(tf_golsOitavasIndex7.getText());
        if(gol1==gol2){
            empate = true;
        }
        
        if(empate)
            JOptionPane.showMessageDialog(null, "A aplicação não suporta empates", "Erro", JOptionPane.ERROR_MESSAGE);
        
        return empate; 
    }
    
    //RETORNA TRUE EM CASO DE EMPATE
    public boolean verificaEmpatesSemisIRL(){
            
        boolean empate=false;
        int gol1;
        int gol2;
        
        gol1 = Integer.parseInt(tf_golsSemisTm0.getText());
        gol2 = Integer.parseInt(tf_golsSemisTm1.getText());
        
        if(gol1==gol2){
            empate = true;
        }
        
        gol1 = Integer.parseInt(tf_golsSemisTm2.getText());
        gol2 = Integer.parseInt(tf_golsSemisTm3.getText());
        if(gol1==gol2){
            empate = true;
        }
        
        if(empate)
            JOptionPane.showMessageDialog(null, "A aplicação não suporta empates", "Erro", JOptionPane.ERROR_MESSAGE);
        
        return empate; 
    }
    
    public boolean verificaEmpatesFinalIRL(){
        boolean empate=false;
        int gol1;
        int gol2;
        
        gol1 = Integer.parseInt(tf_golsFinalTm0.getText());
        gol2 = Integer.parseInt(tf_golsFinalTm1.getText());
        if(gol1==gol2){
            empate = true;
        }
        
        if(empate)
            JOptionPane.showMessageDialog(null, "A aplicação não suporta empates", "Erro", JOptionPane.ERROR_MESSAGE);
        
        return empate; 
    }
    
    //FORMA O VETOR SEMIS 
    public void setaArrayListSemisIRL(){
        System.out.println("\nsetaArrayListSemisIRL\n");
        
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).setGol0(Integer.parseInt(tf_golsOitavasIndex0.getText()));
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).setGol0(Integer.parseInt(tf_golsOitavasIndex1.getText()));
        if(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).getGol0()>jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).getGol0()){
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).setVenceu0(true);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).setVenceu0(false);
        }else{
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).setVenceu0(false);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).setVenceu0(true);
        }
        
        System.out.println("index 0 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(0).getVenceu0());
        System.out.println("index 1 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(1).getVenceu0());
        
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).setGol0(Integer.parseInt(tf_golsOitavasIndex2.getText()));
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).setGol0(Integer.parseInt(tf_golsOitavasIndex3.getText()));
        if(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).getGol0()>jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).getGol0()){
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).setVenceu0(true);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).setVenceu0(false);
        }else{
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).setVenceu0(false);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).setVenceu0(true);
        }
        
        System.out.println("index 2 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(2).getVenceu0());
        System.out.println("index 3 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(3).getVenceu0());
        
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).setGol0(Integer.parseInt(tf_golsOitavasIndex4.getText()));
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).setGol0(Integer.parseInt(tf_golsOitavasIndex5.getText()));
        if(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).getGol0()>jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).getGol0()){
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).setVenceu0(true);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).setVenceu0(false);
        }else{
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).setVenceu0(false);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).setVenceu0(true);
        }
        
        System.out.println("index 4 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(4).getVenceu0());
        System.out.println("index 5 venceu->" + jogoIRL.getListaPlayersOrdenadosPeloIndex().get(5).getVenceu0());
        
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).setGol0(Integer.parseInt(tf_golsOitavasIndex6.getText()));
        jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).setGol0(Integer.parseInt(tf_golsOitavasIndex7.getText()));
        if(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).getGol0()>jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).getGol0()){
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).setVenceu0(true);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).setVenceu0(false);
        }else{
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(6).setVenceu0(false);
            jogoIRL.getListaPlayersOrdenadosPeloIndex().get(7).setVenceu0(true);
        }
        

       
        for (int i = 0; i<jogoIRL.getListaPlayersOrdenadosPeloIndex().size(); i++) {
            
            if(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(i).getVenceu0()==true){
                jogoIRL.getListaPlayersSemis().add(jogoIRL.getListaPlayersOrdenadosPeloIndex().get(i));
            }
        }
        
        System.out.println("VETOR ORDENADO PELO INDEX SEMIFINAIS IRL:");
        System.out.println("posicao [0] = " + jogoIRL.getListaPlayersSemis().get(0).getTime());
        System.out.println("posicao [1] = " + jogoIRL.getListaPlayersSemis().get(1).getTime());
        System.out.println("posicao [2] = " + jogoIRL.getListaPlayersSemis().get(2).getTime());
        System.out.println("posicao [3] = " + jogoIRL.getListaPlayersSemis().get(3).getTime());

        System.out.println("\n");
    }
    
    //SORTEIA RESULTADOS DAS SEMIS E MONTA O ARRAYLIST DA FINAL
    public void sorteiaResultadosSemisSimulation(){

        System.out.println("\n***setaGolsSemisSimulation\n");

        String saldos = jogoSimulation.setResultadoAleatorio();
        String[] gols1 = saldos.split("x");
        tf_golsSemisTm0.setText(gols1[0]);
        tf_golsSemisTm1.setText(gols1[1]);
        jogoSimulation.getListaPlayersSemis().get(0).setGol1(Integer.parseInt(gols1[0]));
        jogoSimulation.getListaPlayersSemis().get(1).setGol1(Integer.parseInt(gols1[1]));
        if(jogoSimulation.getListaPlayersSemis().get(0).getGol1()>jogoSimulation.getListaPlayersSemis().get(1).getGol1()){
            jogoSimulation.getListaPlayersSemis().get(0).setVenceu1(true);
            jogoSimulation.getListaPlayersSemis().get(1).setVenceu1(false);
        }else{
            jogoSimulation.getListaPlayersSemis().get(0).setVenceu1(false);
            jogoSimulation.getListaPlayersSemis().get(1).setVenceu1(true);
        }

        System.out.println("index 0 "+jogoSimulation.getListaPlayersSemis().get(0).getTime()+" venceu->" + jogoSimulation.getListaPlayersSemis().get(0).getVenceu1());
        System.out.println("index 1 "+jogoSimulation.getListaPlayersSemis().get(1).getTime()+"venceu->" + jogoSimulation.getListaPlayersSemis().get(1).getVenceu1());


        saldos = jogoSimulation.setResultadoAleatorio();
        String gols2[] = saldos.split("x");
        tf_golsSemisTm2.setText(gols2[0]);
        tf_golsSemisTm3.setText(gols2[1]);
        jogoSimulation.getListaPlayersSemis().get(2).setGol1(Integer.parseInt(gols2[0]));
        jogoSimulation.getListaPlayersSemis().get(3).setGol1(Integer.parseInt(gols2[1]));
        if(jogoSimulation.getListaPlayersSemis().get(2).getGol1()>jogoSimulation.getListaPlayersSemis().get(3).getGol1()){
            jogoSimulation.getListaPlayersSemis().get(2).setVenceu1(true);
            jogoSimulation.getListaPlayersSemis().get(3).setVenceu1(false);
        }else{
            jogoSimulation.getListaPlayersSemis().get(2).setVenceu1(false);
            jogoSimulation.getListaPlayersSemis().get(3).setVenceu1(true);
        }

        System.out.println("index 2 "+jogoSimulation.getListaPlayersSemis().get(2).getTime()+" venceu->" + jogoSimulation.getListaPlayersSemis().get(2).getVenceu1());
        System.out.println("index 3 "+jogoSimulation.getListaPlayersSemis().get(3).getTime()+"venceu->" + jogoSimulation.getListaPlayersSemis().get(3).getVenceu1());

        for (int i = 0; i<jogoSimulation.getListaPlayersSemis().size(); i++) {

            if(jogoSimulation.getListaPlayersSemis().get(i).getVenceu1()==true){
                jogoSimulation.getListaPlayersFinal().add(jogoSimulation.getListaPlayersSemis().get(i));
                System.out.println("i = " + i);
                System.out.println("posicao [" + i + "] = " + jogoSimulation.getListaPlayersOrdenadosPeloIndex().get(i).getTime());
            }
        }

        System.out.println("VETOR ORDENADO PELO INDEX FINAIS SIMULATION:");
        System.out.println("posicao [0] = " + jogoSimulation.getListaPlayersFinal().get(0).getTime());
        System.out.println("posicao [1] = " + jogoSimulation.getListaPlayersFinal().get(1).getTime());
        System.out.println("***");
    }
        
    public void setaArrayListFinalIRL(){
        System.out.println("\nsetaArrayListFinalIRL\n");
        System.out.println("toString ArrayList ArrayList times semis:");
        System.out.println("time 0: "+jogoIRL.getListaPlayersSemis().get(0).getTime());
        System.out.println("time 1: "+jogoIRL.getListaPlayersSemis().get(1).getTime());
        System.out.println("time 2: "+jogoIRL.getListaPlayersSemis().get(2).getTime());
        System.out.println("time 3: "+jogoIRL.getListaPlayersSemis().get(3).getTime());
        
        jogoIRL.getListaPlayersSemis().get(0).setGol1(Integer.parseInt(tf_golsSemisTm0.getText()));
        jogoIRL.getListaPlayersSemis().get(1).setGol1(Integer.parseInt(tf_golsSemisTm1.getText()));
        if(jogoIRL.getListaPlayersSemis().get(0).getGol1()>jogoIRL.getListaPlayersSemis().get(1).getGol1()){
            System.out.println("time 0 > time 1");
            jogoIRL.getListaPlayersSemis().get(0).setVenceu1(true);
            jogoIRL.getListaPlayersSemis().get(1).setVenceu1(false);
        }else{
            System.out.println("time 0 < time 1");
            jogoIRL.getListaPlayersSemis().get(0).setVenceu1(false);
            jogoIRL.getListaPlayersSemis().get(1).setVenceu1(true);
        }
        
        System.out.println("index 0 venceu->" + jogoIRL.getListaPlayersSemis().get(0).getVenceu1());
        System.out.println("index 1 venceu->" + jogoIRL.getListaPlayersSemis().get(1).getVenceu1());
        
        jogoIRL.getListaPlayersSemis().get(2).setGol1(Integer.parseInt(tf_golsSemisTm2.getText()));
        jogoIRL.getListaPlayersSemis().get(3).setGol1(Integer.parseInt(tf_golsSemisTm3.getText()));
        if(jogoIRL.getListaPlayersSemis().get(2).getGol1()>jogoIRL.getListaPlayersSemis().get(3).getGol1()){
            System.out.println("time 2 > time 3");
            jogoIRL.getListaPlayersSemis().get(2).setVenceu1(true);
            jogoIRL.getListaPlayersSemis().get(3).setVenceu1(false);
        }else{
            System.out.println("time 2 < time 3");
            jogoIRL.getListaPlayersSemis().get(2).setVenceu1(false);
            jogoIRL.getListaPlayersSemis().get(3).setVenceu1(true);
        }
        
        System.out.println("index 2 venceu->" + jogoIRL.getListaPlayersSemis().get(2).getVenceu1());
        System.out.println("index 3 venceu->" + jogoIRL.getListaPlayersSemis().get(3).getVenceu1());
        
        for (int i = 0; i<jogoIRL.getListaPlayersSemis().size(); i++) {
            
            if(jogoIRL.getListaPlayersSemis().get(i).getVenceu1()==true){
                jogoIRL.getListaPlayersFinal().add(jogoIRL.getListaPlayersSemis().get(i));
                System.out.println("i = " + i);
                System.out.println("posicao [" + i + "] = " + jogoIRL.getListaPlayersSemis().get(i).getTime());
            }
        }
        System.out.println("vetor final:\n"+jogoIRL.getListaPlayersFinal().get(0).getTime());
        System.out.println(jogoIRL.getListaPlayersFinal().get(1).getTime());
    }
    //SALVA OS GOLS DA FINAL 
    public void setaArrayListResultadoIRL(){
        System.out.println("\nsetaArrayListResultadoIRL\n");
        System.out.println("toString ArrayList times semis:");
        System.out.println("time 0: "+jogoIRL.getListaPlayersFinal().get(0).getTime());
        System.out.println("time 1: "+jogoIRL.getListaPlayersFinal().get(1).getTime());
        
        jogoIRL.getListaPlayersFinal().get(0).setGol2(Integer.parseInt(tf_golsFinalTm0.getText()));
        jogoIRL.getListaPlayersFinal().get(1).setGol2(Integer.parseInt(tf_golsFinalTm1.getText()));
        if(jogoIRL.getListaPlayersFinal().get(0).getGol2()>jogoIRL.getListaPlayersFinal().get(1).getGol2()){
            System.out.println("time 0 > time 1");
            jogoIRL.getListaPlayersFinal().get(0).setVenceu2(true);
            jogoIRL.getListaPlayersFinal().get(1).setVenceu2(false);
        }else{
            System.out.println("time 0 < time 1");
            jogoIRL.getListaPlayersFinal().get(0).setVenceu2(false);
            jogoIRL.getListaPlayersFinal().get(1).setVenceu2(true);
        }
        
        System.out.println("index 0 venceu->" + jogoIRL.getListaPlayersFinal().get(0).getVenceu2());
        System.out.println("index 1 venceu->" + jogoIRL.getListaPlayersFinal().get(1).getVenceu2());
    }
    
   //SORTEIA RESULTADOS DAS FINAL
   //SETA GOLS2 E VENCEU2 A CADA PLAYER
   //SET EDITABLES = FALSE
   public void sorteiaResultadosFinalSimulation(){
        
        System.out.println("\nsetaGolsFinalSimulation\n");
        
        String saldos = jogoSimulation.setResultadoAleatorio();
        String[] gols1 = saldos.split("x");
        tf_golsFinalTm0.setText(gols1[0]);
        tf_golsFinalTm1.setText(gols1[1]);
        jogoSimulation.getListaPlayersFinal().get(0).setGol2(Integer.parseInt(gols1[0]));
        System.out.println("gol2 de "+jogoSimulation.getListaPlayersFinal().get(0).getTime()+": "+ jogoSimulation.getListaPlayersFinal().get(0).getGol2());
        jogoSimulation.getListaPlayersFinal().get(1).setGol2(Integer.parseInt(gols1[1]));
        System.out.println("gol2 de "+jogoSimulation.getListaPlayersFinal().get(1).getTime()+": "+ jogoSimulation.getListaPlayersFinal().get(1).getGol2());
        if(jogoSimulation.getListaPlayersFinal().get(0).getGol2()>jogoSimulation.getListaPlayersFinal().get(1).getGol2()){
            jogoSimulation.getListaPlayersFinal().get(0).setVenceu2(true);
            jogoSimulation.getListaPlayersFinal().get(1).setVenceu2(false);
        }else{
            jogoSimulation.getListaPlayersFinal().get(0).setVenceu2(false);
            jogoSimulation.getListaPlayersFinal().get(1).setVenceu2(true);
        }
        System.out.println("index 0 "+jogoSimulation.getListaPlayersFinal().get(0).getTime()+" venceu->" + jogoSimulation.getListaPlayersFinal().get(0).getVenceu2());
        System.out.println("index 1 "+jogoSimulation.getListaPlayersFinal().get(1).getTime()+" venceu->" + jogoSimulation.getListaPlayersFinal().get(1).getVenceu2());

    }
        
        public void carregaTimesFinalSimulation(){
            
            tf_golsSemisTm0.setEnabled(false);
            tf_golsSemisTm1.setEnabled(false);
            tf_golsSemisTm2.setEnabled(false);
            tf_golsSemisTm3.setEnabled(false);
            la_final.setVisible(false);
            la_finalTm0.setVisible(true);
            la_finalTm1.setVisible(true);
            la_X6.setVisible(true);
            tf_golsFinalTm0.setVisible(true);
            tf_golsFinalTm1.setVisible(true);
            tf_golsFinalTm0.setEnabled(false);
            tf_golsFinalTm1.setEnabled(false);
            
            la_finalTm0.setText(jogoSimulation.getListaPlayersFinal().get(0).getTime());
            la_finalTm1.setText(jogoSimulation.getListaPlayersFinal().get(1).getTime());
            
            System.out.println("\ncarregaTimesFinalSimulation ok\n");
        }
        
        public void carregaTimesFinalIRL(){
            tf_golsSemisTm0.setEnabled(false);
            tf_golsSemisTm1.setEnabled(false);
            tf_golsSemisTm2.setEnabled(false);
            tf_golsSemisTm3.setEnabled(false);
            la_final.setVisible(false);
            la_finalTm0.setVisible(true);
            la_finalTm1.setVisible(true);
            la_X6.setVisible(true);
            tf_golsFinalTm0.setVisible(true);
            tf_golsFinalTm1.setVisible(true);
            
            la_finalTm0.setText(jogoIRL.getListaPlayersFinal().get(0).getTime());
            la_finalTm1.setText(jogoIRL.getListaPlayersFinal().get(1).getTime());
            System.out.println("\ncarregaTimesFinalIRL OK\n");
        }
        
        public int ObtemIndexCampeaoNoArrayListFinalIRL(){
            int index = 0;

            for (int i = 0; i < jogoIRL.getListaPlayersFinal().size(); i++) {
                if(jogoIRL.getListaPlayersFinal().get(i).getVenceu2())
                    index = i;
            }
            
            return index;
        }
        
        public int ObtemIndexCampeaoNoArrayListFinalSimulation(){
            int index = 0;

            for (int i = 0; i < jogoSimulation.getListaPlayersFinal().size(); i++) {
                if(jogoSimulation.getListaPlayersFinal().get(i).getVenceu2())
                    index = i;
            }
            
            return index;
        }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        la_finalTm0 = new javax.swing.JLabel();
        tf_golsFinalTm0 = new javax.swing.JTextField();
        la_finalTm1 = new javax.swing.JLabel();
        tf_golsFinalTm1 = new javax.swing.JTextField();
        la_oitavaIndex0 = new javax.swing.JLabel();
        tf_golsOitavasIndex0 = new javax.swing.JTextField();
        la_oitavaIndex1 = new javax.swing.JLabel();
        tf_golsOitavasIndex1 = new javax.swing.JTextField();
        la_oitavaIndex2 = new javax.swing.JLabel();
        tf_golsOitavasIndex2 = new javax.swing.JTextField();
        la_oitavaIndex3 = new javax.swing.JLabel();
        tf_golsOitavasIndex3 = new javax.swing.JTextField();
        la_oitavaIndex4 = new javax.swing.JLabel();
        tf_golsOitavasIndex4 = new javax.swing.JTextField();
        la_oitavaIndex5 = new javax.swing.JLabel();
        tf_golsOitavasIndex5 = new javax.swing.JTextField();
        la_oitavaIndex6 = new javax.swing.JLabel();
        tf_golsOitavasIndex6 = new javax.swing.JTextField();
        la_oitavaIndex7 = new javax.swing.JLabel();
        tf_golsOitavasIndex7 = new javax.swing.JTextField();
        la_semisTm0 = new javax.swing.JLabel();
        tf_golsSemisTm0 = new javax.swing.JTextField();
        la_semisTm1 = new javax.swing.JLabel();
        tf_golsSemisTm1 = new javax.swing.JTextField();
        la_semisTm2 = new javax.swing.JLabel();
        tf_golsSemisTm2 = new javax.swing.JTextField();
        la_semisTm3 = new javax.swing.JLabel();
        tf_golsSemisTm3 = new javax.swing.JTextField();
        la_X0 = new javax.swing.JLabel();
        la_X1 = new javax.swing.JLabel();
        la_X2 = new javax.swing.JLabel();
        la_X3 = new javax.swing.JLabel();
        la_X4 = new javax.swing.JLabel();
        la_X5 = new javax.swing.JLabel();
        la_X6 = new javax.swing.JLabel();
        bt_proximo = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        la_semi1 = new javax.swing.JLabel();
        la_final = new javax.swing.JLabel();
        la_semi0 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        la_finalTm0.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_finalTm0.setForeground(new java.awt.Color(255, 0, 0));
        la_finalTm0.setText("IX1");
        add(la_finalTm0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        tf_golsFinalTm0.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsFinalTm0.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsFinalTm0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsFinalTm0.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsFinalTm0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsFinalTm0KeyTyped(evt);
            }
        });
        add(tf_golsFinalTm0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 22, -1));

        la_finalTm1.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_finalTm1.setForeground(new java.awt.Color(255, 0, 0));
        la_finalTm1.setText("IX2");
        add(la_finalTm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        tf_golsFinalTm1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsFinalTm1.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsFinalTm1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsFinalTm1.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsFinalTm1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsFinalTm1KeyTyped(evt);
            }
        });
        add(tf_golsFinalTm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 22, -1));

        la_oitavaIndex0.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex0.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex0.setText("TO1");
        add(la_oitavaIndex0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tf_golsOitavasIndex0.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex0.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex0.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tf_golsOitavasIndex0.setName(""); // NOI18N
        tf_golsOitavasIndex0.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex0KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 22, -1));

        la_oitavaIndex1.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex1.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex1.setText("TO2");
        add(la_oitavaIndex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        tf_golsOitavasIndex1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex1.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex1.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex1KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 22, -1));

        la_oitavaIndex2.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex2.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex2.setText("TO3");
        add(la_oitavaIndex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        tf_golsOitavasIndex2.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex2.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex2.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex2KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 22, -1));

        la_oitavaIndex3.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex3.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex3.setText("TO4");
        add(la_oitavaIndex3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        tf_golsOitavasIndex3.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex3.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex3.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex3KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 22, -1));

        la_oitavaIndex4.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex4.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex4.setText("TO5");
        add(la_oitavaIndex4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        tf_golsOitavasIndex4.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex4.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex4.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex4KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 22, -1));

        la_oitavaIndex5.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex5.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex5.setText("TO6");
        add(la_oitavaIndex5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        tf_golsOitavasIndex5.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex5.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex5.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex5KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 22, -1));

        la_oitavaIndex6.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex6.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex6.setText("TO7");
        add(la_oitavaIndex6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        tf_golsOitavasIndex6.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex6.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex6.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex6KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 22, -1));

        la_oitavaIndex7.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_oitavaIndex7.setForeground(new java.awt.Color(255, 0, 0));
        la_oitavaIndex7.setText("TO8");
        add(la_oitavaIndex7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, -1, -1));

        tf_golsOitavasIndex7.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsOitavasIndex7.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsOitavasIndex7.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsOitavasIndex7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsOitavasIndex7KeyTyped(evt);
            }
        });
        add(tf_golsOitavasIndex7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 22, -1));

        la_semisTm0.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semisTm0.setForeground(new java.awt.Color(255, 0, 0));
        la_semisTm0.setText("TS1");
        add(la_semisTm0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        tf_golsSemisTm0.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsSemisTm0.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsSemisTm0.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsSemisTm0KeyTyped(evt);
            }
        });
        add(tf_golsSemisTm0, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 22, -1));

        la_semisTm1.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semisTm1.setForeground(new java.awt.Color(255, 0, 0));
        la_semisTm1.setText("TS2");
        add(la_semisTm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        tf_golsSemisTm1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsSemisTm1.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_golsSemisTm1.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsSemisTm1KeyTyped(evt);
            }
        });
        add(tf_golsSemisTm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 22, -1));

        la_semisTm2.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semisTm2.setForeground(new java.awt.Color(255, 0, 0));
        la_semisTm2.setText("TS3");
        add(la_semisTm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        tf_golsSemisTm2.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsSemisTm2.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm2.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsSemisTm2KeyTyped(evt);
            }
        });
        add(tf_golsSemisTm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 22, -1));

        la_semisTm3.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semisTm3.setForeground(new java.awt.Color(255, 0, 0));
        la_semisTm3.setText("TS4");
        add(la_semisTm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        tf_golsSemisTm3.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        tf_golsSemisTm3.setForeground(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm3.setSelectionColor(new java.awt.Color(204, 0, 0));
        tf_golsSemisTm3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_golsSemisTm3KeyTyped(evt);
            }
        });
        add(tf_golsSemisTm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 22, -1));

        la_X0.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X0.setForeground(new java.awt.Color(255, 0, 0));
        la_X0.setText("x");
        add(la_X0, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        la_X1.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X1.setForeground(new java.awt.Color(255, 0, 0));
        la_X1.setText("x");
        add(la_X1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        la_X2.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X2.setForeground(new java.awt.Color(255, 0, 0));
        la_X2.setText("x");
        add(la_X2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        la_X3.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X3.setForeground(new java.awt.Color(255, 0, 0));
        la_X3.setText("x");
        add(la_X3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, -1, -1));

        la_X4.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X4.setForeground(new java.awt.Color(255, 0, 0));
        la_X4.setText("x");
        add(la_X4, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 148, -1, -1));

        la_X5.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X5.setForeground(new java.awt.Color(255, 0, 0));
        la_X5.setText("x");
        add(la_X5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        la_X6.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_X6.setForeground(new java.awt.Color(255, 0, 0));
        la_X6.setText("x");
        add(la_X6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        bt_proximo.setBackground(new java.awt.Color(51, 51, 51));
        bt_proximo.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_proximo.setForeground(new java.awt.Color(255, 0, 0));
        bt_proximo.setText("PRÓXIMO");
        bt_proximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_proximo.setFocusPainted(false);
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });
        add(bt_proximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 370, 150, 90));

        bt_voltar.setBackground(new java.awt.Color(51, 51, 51));
        bt_voltar.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_voltar.setForeground(new java.awt.Color(255, 0, 0));
        bt_voltar.setText("VOLTAR");
        bt_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar.setFocusPainted(false);
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });
        add(bt_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 370, 150, 90));

        la_semi1.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semi1.setForeground(new java.awt.Color(255, 0, 0));
        la_semi1.setText("<SEMIFINAL>");
        add(la_semi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 150, -1));

        la_final.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_final.setForeground(new java.awt.Color(255, 0, 0));
        la_final.setText("<FINAL>");
        add(la_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 140, -1));

        la_semi0.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        la_semi0.setForeground(new java.awt.Color(255, 0, 0));
        la_semi0.setText("<SEMIFINAL>");
        add(la_semi0, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 140, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagemConfrontos700x500.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        
        
        //------------------------SIMULATION--------------------------
        
        if(controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            if(jogoSimulation.getFase().equalsIgnoreCase("oitavas")){
                sorteiaResultadosOitavasSimulation();
                carregaTimesSemisSimulation();
                jogoSimulation.setFase("semis");
                serializaSimulation(jogoSimulation);
            }
            else if(jogoSimulation.getFase().equalsIgnoreCase("semis")){
                sorteiaResultadosSemisSimulation();
                carregaTimesFinalSimulation();
                jogoSimulation.setFase("final");
                serializaSimulation(jogoSimulation);
                
            }
            else if(jogoSimulation.getFase().equalsIgnoreCase("final")){
                sorteiaResultadosFinalSimulation();
                int index = ObtemIndexCampeaoNoArrayListFinalSimulation();
                jogoSimulation.setCampeao(jogoSimulation.getListaPlayersFinal().get(index));
                System.out.println("campeao:" +jogoSimulation.getCampeao().getTime());
                carregaGolsFinalSimulation();
                serializaSimulation(jogoSimulation);
                jogoSimulation.setFase("resultado");
                serializaSimulation(jogoSimulation);
                
                
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(PainelConfrontos.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }//final simulation 
            
                                        /*ERRO CRITICO*/
                //Só Deus sabe como o Sleep está executando antes do carregaGolsFinalSimulation;
                //desistimos da implementação do cooldown
                
            
            //ABAIXO REALMENTE NÃO DEVE TER ELSE, DEVE EXECUTAR SEQUENCIALMENTE
            if(jogoSimulation.getFase().equalsIgnoreCase("resultado")){
                
                Janela.painelCampeao = new PainelCampeao(jogoSimulation.getCampeao(),jogoSimulation ,jogoIRL);
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
                janela.getContentPane().remove(Janela.painelConfrontos);
                janela.add(Janela.painelCampeao, BorderLayout.CENTER);
                janela.pack();
            }
        }//simulacao
        
        //------------------------IRL--------------------------
        
        if(controller.getModoDeJogo().equalsIgnoreCase("irl")){
            if(jogoIRL.getFase().equalsIgnoreCase("oitavas")){
                boolean haBlank = verificaTextFieldEmBrancoOitavasIRL();
                if(haBlank == true){
                    System.out.println("Corrija");
                }
                else{
                    
                    boolean haEmpate = verificaEmpatesOitavasIRL();
                    if(haEmpate==true){
                        System.out.println("Corrija");
                    }
                    else{
                    setaArrayListSemisIRL();
                    carregaTimesSemisIRL();
                    jogoIRL.setFase("semis");
                        serializaIRL(jogoIRL);
                    }//nao ha empate
                }//nao ha blank
            }//oitavas irl
            else if(jogoIRL.getFase().equalsIgnoreCase("semis")){              
                boolean haBlank = verificaTextFieldEmBrancoSemisIRL();
                if(haBlank == true){
                    System.out.println("Corrija");
                }
                else{
                    boolean haEmpate = verificaEmpatesSemisIRL();
                    if(haEmpate==true){
                        System.out.println("Corrija");
                    }
                    else{
                    setaArrayListFinalIRL();
                    carregaTimesFinalIRL();
                    jogoIRL.setFase("final");
                        serializaIRL(jogoIRL);
                    }//nao ha empate
                }//nao ha blank
            }//semis irl
            else if(jogoIRL.getFase().equalsIgnoreCase("final")){
                boolean haBlank = verificaTextFieldEmBrancoFinalIRL();
                if(haBlank == true){
                    System.out.println("Corrija");
                }
                else{
                    boolean haEmpate = verificaEmpatesFinalIRL();
                    if(haEmpate==true){
                        System.out.println("Corrija");
                    }
                    else{
                        
                        tf_golsFinalTm0.setEnabled(false);
                        tf_golsFinalTm1.setEnabled(false);
                        setaArrayListResultadoIRL();
                        int index = ObtemIndexCampeaoNoArrayListFinalIRL();
                        jogoIRL.setCampeao(jogoIRL.getListaPlayersFinal().get(index));
                        System.out.println("campeao:" +jogoIRL.getCampeao().getTime());
                        jogoIRL.setFase("resultado");
                        serializaIRL(jogoIRL);
                    }//nao ha empate
                }//nao ha blank
            }//final irl
            //REALMENTE NÃO DEVE TER ELSE, EXECUTA EM SEQUÊNCIA
            if(jogoIRL.getFase().equalsIgnoreCase("resultado")){
                Janela.painelCampeao = new PainelCampeao(jogoIRL.getCampeao(),jogoSimulation ,jogoIRL);
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
                janela.getContentPane().remove(Janela.painelConfrontos);
                janela.add(Janela.painelCampeao, BorderLayout.CENTER);
                janela.pack();
            }
            
        }//irl
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void tf_golsOitavasIndex0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex0KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex0KeyTyped

    private void tf_golsOitavasIndex1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex1KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex1KeyTyped

    private void tf_golsOitavasIndex2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex2KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex2KeyTyped

    private void tf_golsOitavasIndex3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex3KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex3KeyTyped

    private void tf_golsOitavasIndex4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex4KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex4KeyTyped

    private void tf_golsOitavasIndex5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex5KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex5KeyTyped

    private void tf_golsOitavasIndex6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex6KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex6KeyTyped

    private void tf_golsOitavasIndex7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsOitavasIndex7KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsOitavasIndex7KeyTyped

    private void tf_golsSemisTm0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsSemisTm0KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsSemisTm0KeyTyped

    private void tf_golsSemisTm1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsSemisTm1KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsSemisTm1KeyTyped

    private void tf_golsSemisTm2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsSemisTm2KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsSemisTm2KeyTyped

    private void tf_golsSemisTm3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsSemisTm3KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsSemisTm3KeyTyped

    private void tf_golsFinalTm1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsFinalTm1KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsFinalTm1KeyTyped

    private void tf_golsFinalTm0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_golsFinalTm0KeyTyped
        formatacaoGols(evt);
    }//GEN-LAST:event_tf_golsFinalTm0KeyTyped

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        Janela.painelSelecao = new PainelSelecao(/*jogoSimulation, jogoIRL*/);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.painelConfrontos);
        janela.add(Janela.painelSelecao, BorderLayout.CENTER);
        janela.pack();
    }//GEN-LAST:event_bt_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JLabel la_X0;
    private javax.swing.JLabel la_X1;
    private javax.swing.JLabel la_X2;
    private javax.swing.JLabel la_X3;
    private javax.swing.JLabel la_X4;
    private javax.swing.JLabel la_X5;
    private javax.swing.JLabel la_X6;
    private javax.swing.JLabel la_final;
    private javax.swing.JLabel la_finalTm0;
    private javax.swing.JLabel la_finalTm1;
    private javax.swing.JLabel la_oitavaIndex0;
    private javax.swing.JLabel la_oitavaIndex1;
    private javax.swing.JLabel la_oitavaIndex2;
    private javax.swing.JLabel la_oitavaIndex3;
    private javax.swing.JLabel la_oitavaIndex4;
    private javax.swing.JLabel la_oitavaIndex5;
    private javax.swing.JLabel la_oitavaIndex6;
    private javax.swing.JLabel la_oitavaIndex7;
    private javax.swing.JLabel la_semi0;
    private javax.swing.JLabel la_semi1;
    private javax.swing.JLabel la_semisTm0;
    private javax.swing.JLabel la_semisTm1;
    private javax.swing.JLabel la_semisTm2;
    private javax.swing.JLabel la_semisTm3;
    private javax.swing.JTextField tf_golsFinalTm0;
    private javax.swing.JTextField tf_golsFinalTm1;
    private javax.swing.JTextField tf_golsOitavasIndex0;
    private javax.swing.JTextField tf_golsOitavasIndex1;
    private javax.swing.JTextField tf_golsOitavasIndex2;
    private javax.swing.JTextField tf_golsOitavasIndex3;
    private javax.swing.JTextField tf_golsOitavasIndex4;
    private javax.swing.JTextField tf_golsOitavasIndex5;
    private javax.swing.JTextField tf_golsOitavasIndex6;
    private javax.swing.JTextField tf_golsOitavasIndex7;
    private javax.swing.JTextField tf_golsSemisTm0;
    private javax.swing.JTextField tf_golsSemisTm1;
    private javax.swing.JTextField tf_golsSemisTm2;
    private javax.swing.JTextField tf_golsSemisTm3;
    // End of variables declaration//GEN-END:variables


}
