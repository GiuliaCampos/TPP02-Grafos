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
public class Kruskal{
    private ArrayList<Vertice> conjuntoArestas = new ArrayList <>();
    private String sol;
    private ArrayList<Integer> arvore = new ArrayList<>();
    
    public Kruskal(){
        
    }
    
    public Kruskal(Vertice[] vertices){
        int n, tamanho;
        n = vertices.length;
        tamanho = (n*(n-1))/2;
        iniKruskal(vertices);
    }
    
    private void iniKruskal(Vertice[] vertices){
        Vertice aux;
        int tamanho, nVertice, aux1;
        
        aux1 = 0;
        nVertice = vertices.length;
        
        aux = new Vertice();
        for(int i = 0; i < nVertice; i++){
            for(String adj : vertices[i].getAdjacencia()){
                String vertAdj[] = adj.split(" ");
                int pos = Integer.parseInt(vertAdj[0]);
                int peso = Integer.parseInt(vertAdj[1]);
                aux = new Vertice();
                aux.setNumero(vertices[i].getNumero());
                aux.setPeso(peso);
                aux.setAdj(pos);
                conjuntoArestas.add(aux);
                aux1++;
            }
        }
        bubbleSortClassico(conjuntoArestas); //Ordena pelo peso
        
        for(int i = 0; i < conjuntoArestas.size() -1; i++){ //REMOVENDO AS ARESTAS REPETIDAS SE HOUVER
            int num1, num2, peso1, peso2;
            
            num1 = conjuntoArestas.get(i).getNumero();
            num2 = conjuntoArestas.get(i+1).getAdj();
            peso1 = conjuntoArestas.get(i).getPeso();
            peso2 = conjuntoArestas.get(i+1).getPeso();
            
            if((num1 == num2) && (peso1 == peso2)){
                conjuntoArestas.remove(i+1);
            }
        }
    }
    
    private void bubbleSortClassico(ArrayList<Vertice> vetor) { //bubble sort sem melhorias
        int n = vetor.size();
        Vertice aux;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - j - 1; i++) {
                if(vetor.get(i) != null){
                    if (vetor.get(i).getPeso() > vetor.get(i+1).getPeso()) { //compara todas as posições do vetor, se sucessor menor, troca de posição
                        aux = vetor.get(i);
                        vetor.set(i, vetor.get(i+1));
                        vetor.set(i+1, aux);
                    }
                }
            }
        }
    }
    
    private int pertenceArvore(ArrayList<Integer> arvore, int vertice){
        for(int i = 0; i < arvore.size(); i++){
            if(arvore.get(i) == vertice)
                return 1; // ja pertence a arvore
        }
        return 0; //não pertence a arvore
    }
    
    public void AGM_Kruskal(Vertice[] grafo){
        Vertice u;
        int v;
        int pesoFinal = 0;
        sol = ("");
        
        for(int i = 0; i < conjuntoArestas.size(); i++){
            u = conjuntoArestas.get(i);
            v = conjuntoArestas.get(i).getAdj();
            
            if(pertenceArvore(arvore, v) == 0){
                arvore.add(v);
                //u.addArvore(v);
                pesoFinal += conjuntoArestas.get(i).getPeso();
                sol += "Vertice[" + u.getNumero() + "]" + " > " + "Vertice[" + v +"]\n\n";
            }
        }
        System.out.println(sol + "\n Peso Final: "+ pesoFinal);
    }
    
    public String getSol(){
        return sol;
    }
    
}

