// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Main {
    public static void main(String[] args) {

        int[] v = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] vOrdenado = SelectSort.selectSort(v);
        for (int i = 0; i < vOrdenado.length-2; i++) {
            System.out.print(vOrdenado[i] + ", ");
        }
        System.out.println(vOrdenado[vOrdenado.length-1]);
    }
}