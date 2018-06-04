/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author Giulia
 */
public class Prim {
    private int chave[];
    private int pai[];
    private int Q[];
    private ArrayList<Vertice> X = new ArrayList<Vertice>();
    private ArrayList<Integer> aux = new ArrayList<>();
    
    public Prim(){
        
    }
    
    private void iniVetores(Vertice[] grafo){
        int tamanho = grafo.length;
        chave = new int[tamanho];
        pai = new int[tamanho];
        Q = new int[tamanho];
        
        for(int i = 0; i < tamanho; i++){
            chave[i] = Integer.MAX_VALUE;
            pai[i] = Integer.MAX_VALUE;
            Q[i] = 1; 
        }
    }
    
    private void iniAdj(Vertice[] grafo){
        
        for(int i = 0; i < grafo.length; i++){
            for(String adj : grafo[i].getAdjacencia()){
                String vertAdj[] = adj.split(" ");
                int pos = Integer.parseInt(vertAdj[0]);
                int peso = Integer.parseInt(vertAdj[1]);
                Vertice v = new Vertice();
                v.setNumero(grafo[i].getNumero());
                v.setAdj(pos);
                v.setPeso(peso);
                X.add(v);
            }
        }
        
//        for(int i = 0; i < X.size() -1; i++){ //REMOVENDO AS ARESTAS REPETIDAS SE HOUVER
//            int num1, num2, peso1, peso2;
//            
//            num1 = X.get(i).getNumero();
//            num2 = X.get(i+1).getAdj();
//            peso1 = X.get(i).getPeso();
//            peso2 = X.get(i+1).getPeso();
//            
//            if((num1 == num2) && (peso1 == peso2)){
//                X.remove(i+1);
//            }
//        }
    }
    
    public void AGMPrim(Vertice[] grafo, int r){
        int u;
        iniVetores(grafo);
        iniAdj(grafo);
        int i = 0;
        chave[r] = 0;
        while(verificaQ(Q) != 0){
            u = extrairMinimo(Q, chave);
            if(u != r) aux.add(u);
            for(Vertice v : X){
                    if(X.get(i).getNumero() == u){
                        if(Q[v.getNumero()] == 1 && v.getPeso()< chave[v.getNumero()]){
                            chave[v.getNumero()] = v.getPeso();
                            pai[v.getNumero()] = u;
                        }
                    }
                }
            break;
        }
    }
    
    int extrairMinimo(int vertices[], int chave[]) {
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == 1) {
                if (chave[i] < min) {
                    min = chave[i];
                    pos = i;
                }
            }
        }
        vertices[pos] = -1;
        return pos;
    }
    
    public int verificaQ(int[] Q){
        int j = 0;
        for(int i = 0;i< Q.length; i++){
            if(Q[i] == 1){ 
                j++;
            }
        }
     return j;
    }
    
    int pertence(int vertices[], int vertice) {
        if (vertices[vertice] == 1) {
            return 1;
        }
        return 0;
    }
    
    public String solucao(){
        String sol = new String();
        for(int i = 0; i < chave.length; i++){
            sol += "  Vertice: "+ i + ", Pai: "+ pai[i]+ ", Peso: " + chave[i];
        }
        System.out.println(sol);
        return sol;
    }
}
