package Model;

import java.io.Serializable;

public class Player implements Serializable {
    
    private String nome;
    private String time;
    private int[] gols = new int[3];
    private int index;
    private boolean[] venceu = new boolean[3];

    public Player(String nome, String time) {
        this.nome = nome;
        this.time = time;
        gols[0] = 0;
        gols[1] = 0;
        gols[2] = 0;
        venceu[0] = false;
        venceu[1] = false;
        venceu[2] = false;
        
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int[] getGols() {
        return gols;
    }
    
    public int getGol0() {
        return gols[0];
    }
    
    public int getGol1() {
        return gols[1];
    }
    
    public int getGol2() {
        return gols[2];
    }

    public void setGols(int[] gols) {
        this.gols = gols;
    }

    public void setGol0(int gol){
        gols[0] = gol;
    }
    
    public void setGol1(int gol){
        gols[1] = gol;
    }
    
    public void setGol2(int gol){
        gols[2] = gol;
    }
    
    public boolean[] getVenceu() {
        return venceu;
    }
    
    public boolean getVenceu0() {
        return venceu[0];
    }
    
    public boolean getVenceu1() {
        return venceu[1];
    }
        
    public boolean getVenceu2() {
        return venceu[2];
    }

    public void setVenceu(boolean[] venceu) {
        this.venceu = venceu;
    }
    
    public void setVenceu0(boolean venceu) {
        this.venceu[0] = venceu;
    }
    
    public void setVenceu1(boolean venceu) {
        this.venceu[1] = venceu;
    }
    
    public void setVenceu2(boolean venceu) {
        this.venceu[2] = venceu;
    }
    
    
    
    
    
}
    