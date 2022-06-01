//import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        //Declaração dos arrays
        int[] a = new int[]{
            2, 4, 7, 13, 14, 15, 1
        };
        //ArrayList<Integer> lista1 = new ArrayList<Integer>(); testando melhorias
        //ArrayList<Integer> lista2 = new ArrayList<Integer>();
        
        int[] b = new int[]{
            1, 6, 7, 11, 13, 16, 18
        };

        //chamada dos métodos
        uniao(a, b);
 
        interseccao(a, b);

        diferenca(a, b); //de a para b
        diferenca(b, a); // de b para a
    }

    public static void diferenca(int[] a, int[] b){
        int[] c = new int[a.length];
        int proxlivre = 0;

        for(int i = 0; i < a.length ; i++){
            boolean achei = false;
            for(int j = 0; j < a.length; j++){
                if(a[i] == b[j]){
                    achei = true;
                    break;
                }
            }
            if(!achei){
                c[proxlivre] = a[i];
                proxlivre++;
            }
        }

        Arrays.sort(c);

        System.out.print("Diferença: ");
        for(int i = 0; i < c.length; i++){
            if(c[i] != 0){
                System.out.print(c[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void interseccao(int[] a, int[] b){
        int tamanho;
        int contador = 0;
        if(a.length >= b.length){
            tamanho = a.length;
        }else{
            tamanho = b.length;
        }
        int[] c = new int[tamanho];

        for(int i = 0; i < c.length; i++){
            if(temNoArray(b, a[i]) && !temNoArray(c, a[i])){
                c[i] = a[i];
                contador++;
            }
        }
        for(int i = 0; i < c.length; i++){
            if(temNoArray(a, b[i]) && !temNoArray(c, b[i])){
                c[i + contador] = b[i];
            }
        }

        Arrays.sort(c);

        System.out.print("Intersecção: ");
        for(int i = 0; i < c.length; i++){
            if(c[i] != 0){
                System.out.print(c[i] + " ");
            }
        }
        System.out.println("");
    }

    public static boolean temNoArray(int[] a, int x){
        for(int i = 0; i < a.length; i++){
            if(a[i] == x) return true;
        }
        return false;
    }

    public static void uniao(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        for(int i = 0; i < a.length; i++){
            c[i] = a[i];
        }
        for(int i = 0; i < c.length; i++){
            if(i != 0 && c[i] == 0){
                if(!temNoArray(c, b[i - b.length])){
                    c[i] = b[i - b.length];
                }
            }
        }

        Arrays.sort(c);

        System.out.print("União: ");
        for(int i = 0; i < c.length; i++){
            if(c[i] != 0){
                System.out.print(c[i] + " ");
            }
        }
        System.out.println("");
    }

}