package kLinhas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
       String local;
       int k = 0,cont = 0,contL = 0;
       Fila<String> dados = new Fila<String>();
       
        try  { 
            System.out.println("Endereço do Arquivo: ");
            local = StdIn.readLine();    
            
            FileReader arq = new FileReader(local);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha
                // a variável "linha" recebe o valor "null" quando o processo
                // de repetição atingir o final do arquivo texto
                
            System.out.println("Imprimir a partir de: ");
            k = StdIn.readInt();
            
            while (k>0) {
                linha = lerArq.readLine(); // lê da segunda até a última linha
                contL++;
                if(linha == null)
                    break;
                if(cont < k){
                    dados.inserir(linha);
                    cont++;
                }else if (cont == k){
                    dados.pop();
                    dados.inserir(linha);
                }
            }
                arq.close();
            } catch (IOException e) {
                System.err.print("ERRO: Arquivo não Encontrado!!!!");
        } 
        
        
        for (int i = 0; i < dados.size(); i++) {
            System.out.println("Linha" + (contL - cont) + ": " + dados.getElementoI(i));
            cont --;
        }
        
        
        }
        
        
        
}

