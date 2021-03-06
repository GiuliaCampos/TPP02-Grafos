/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

public class Vertice {
    private int numero;
    private int componente = 0;
    private int cor;                    // atingibilidade do vertice 1- Branco 2- Cinza 3-Preto
    private Vertice predecessor; //"pai" do vertice          //para BFS
    private int distancia;              //distancia ate a raiz      //para BFS
    private int tempoInicial;                   //tempo de descoberta       //para DFS
    private int tempoFinal;                     //tempo de descoberta       //para DFS
    private ArrayList <String> adjacencia = new ArrayList <>();    //vertices adjacentes e seus pesos (para lista de adj)
    private int peso; //kruskal
    private int adj; //kruskal
    private int grau;
    
    public Vertice(int valor){
        this.numero = valor;
    }
    
    public Vertice(){
        
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getAdj() {
        return adj;
    }

    public void setAdj(int adj) {
        this.adj = adj;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public ArrayList<String> getAdjacencia() {
        return adjacencia;
    }

    public void setAdjacencia(ArrayList<String> adjacencia) {
        this.adjacencia = adjacencia;
    }

    public int getCor() {
        return cor;
    }
    
    public int getComponente(){
        return componente;
    }
    
    public void setComponente(int componente){
        this.componente = componente;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    
    public Integer busca(Integer numero){
        for(int i = 0; i < adjacencia.size(); i++){
            if(adjacencia.get(i).equals(numero))
                return 1;
        }
        return 0;
    }
    
    public void addAdjacencia(String adj){
        this.adjacencia.add(adj);
    }
    
    public void setPredecessor(Vertice v){
        this.predecessor = v;
    }
    
    public Vertice getPredecessor(){
        return this.predecessor;
    }
    
    public void setDistancia (int d){
        this.distancia = d;
    }
    
    public int getDistancia (){
        return this.distancia;
    }
    
    public void setTempoInicial(int tempo){
        tempoInicial = tempo;
    }
    
    public int getTempoInicial(){
        return tempoInicial;
    }
    
    public void setTempoFinal (int tempo){
        tempoFinal = tempo;
    }
    
    public int getTempoFinal (){
        return tempoFinal;
    }
    
}
