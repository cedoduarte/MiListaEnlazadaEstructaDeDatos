/**
 * Created by cedo on 14/10/2015.
 */

public class Nodo {
    public Nodo(int info, Nodo liga) {
        this.info = info;
        this.liga = liga;
    }

    public void imprime() {
        System.out.println("info = " + info + ";"
                + "liga = " + liga);
    }

    public int info;
    public Nodo liga;
}
