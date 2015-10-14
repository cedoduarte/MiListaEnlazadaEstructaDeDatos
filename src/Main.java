/**
 * Created by cedo on 14/10/2015.
 */

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            iniciaAplicacion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public enum Opcion {
        SI, NO
    }

    public static void creaInicio() {
        Scanner scanner = new Scanner(System.in);
        Opcion opcion = Opcion.SI;

        if (P == null) {
            System.out.println("inserta dato:");
            P = new Nodo(scanner.nextInt(), null);
        }

        do {
            System.out.println("inserta dato:");
            Q = new Nodo(scanner.nextInt(), P);
            P = Q;
            System.out.println("otro dato [1=si,2=no]:");
            opcion = (scanner.nextInt() == 1) ? Opcion.SI
                    : Opcion.NO;
        } while (opcion != Opcion.NO);
        recorridoDeLaLista();
    }

    public static void creaFinal() {
        Scanner scanner = new Scanner(System.in);
        Opcion opcion = Opcion.SI;
        Nodo T = null;

        if (P == null) {
            System.out.println("inserta dato");
            P = new Nodo(scanner.nextInt(), null);
            T = P;
        }
        do {
            System.out.println("inserta dato:");
            Q = new Nodo(scanner.nextInt(), null);
            T.liga = Q;
            T = Q;
        } while (opcion != Opcion.NO);
        recorridoDeLaLista();
    }

    public static void recorridoDeLaLista() {
        Q = P;
        while (Q != null) {
            Q.imprime();
            Q = Q.liga;
        }
    }

    public static void recorreRecursivo(Nodo N) {
        if (N != null) {
            N.imprime();
            recorreRecursivo(N.liga);
        }
    }

    public static void insertaAlInicio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta dato:");
        Q = new Nodo(scanner.nextInt(), P);
        P = Q;
    }

    public static void insertaAlFinal() {
        Scanner scanner = new Scanner(System.in);
        Nodo T = P;
        while (T.liga != null) {
            T = T.liga;
        }
        System.out.println("inserta dato:");
        Q = new Nodo(scanner.nextInt(), null);
        T.liga = Q;
    }

    public static void insertaAntesDeX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta el dato:");
        int dato = scanner.nextInt();
        System.out.println("inserta la referencia:");
        int ref = scanner.nextInt();
        Q = P;
        Nodo T = null;
        Nodo X = null;
        boolean band = true;
        while (Q.info != ref && band) {
            if (Q.liga != null) {
                T = Q;
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (band) {
            X = new Nodo(dato, null);
            if (P == Q) {
                X.liga = P;
                P = X;
            } else {
                T.liga = X;
                X.liga = Q;
            }
        }
    }

    public static void insertaDespuesDeX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta el dato:");
        int dato = scanner.nextInt();
        System.out.println("inserta la referencia:");
        int ref = scanner.nextInt();
        Q = P;
        Nodo T = null;
        boolean band = true;
        while (Q.info != ref && band) {
            if (Q.liga != null) {
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (band) {
            T = new Nodo(dato, Q.liga);
            Q.liga = T;
        }
    }

    public static void eliminaPrimero() {
        Q = P;
        if (Q.liga != null) {
            P = Q.liga;
        } else {
            P = null;
        }
    }

    public static void eliminaUltimo() {
        Nodo T = null;
        if (P.liga == null) {
            P = null;
        } else {
            Q = P;
        }
        while (Q.liga != null) {
            T = Q;
            Q = Q.liga;
        }
        T.liga = null;
    }

    public static void eliminaX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta x:");
        int x = scanner.nextInt();
        Q = P;
        Nodo T = null;
        boolean band = true;
        while (Q.info != x && band) {
            if (Q.liga != null) {
                T = Q;
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (!band) {
            System.out.println("el elemento no se encuentra");
        } else {
            if (P == Q) {
                P = Q.liga;
            } else {
                T.liga = Q.liga;
            }
        }
    }

    public static void eliminaAntesDeX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta x:");
        int x = scanner.nextInt();
        Nodo T = null;
        Nodo R = null;
        boolean band = true;
        if (P.info == x) {
            System.out.println("no hay nodo que preceda a x");
        } else {
            Q = P;
            T = P;
            band = false;
        }
        while (Q.info != x && !band) {
            if (Q.liga != null) {
                R = T;
                T = Q;
                Q = Q.liga;
            } else {
                band = true;
            }
        }
        if (band) {
            System.out.println("el elemento no fue encontrado");
        } else {
            if (P.liga == Q) {
                P = Q;
            } else {
                R.liga = Q;
            }
        }
    }

    public static void eliminaDespuesDeX() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta x:");
        int x = scanner.nextInt();
        Q = P;
        boolean band = true;
        while (Q.info != x && band) {
            if (Q.liga != null) {
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (!band) {
            System.out.println("el elemento no fue encontrado");
        } else {
            Nodo ix = P;
            while (ix.info != x) {
                ix = ix.liga;
            }
            if (ix.liga == null) {
                System.out.println("no hay nodo siguiente");
                return;
            }
            if (ix.liga.liga == null) {
                System.out.println("no hay nodo final");
                return;
            }
            ix.liga = ix.liga.liga;
        }
    }

    public static void busquedaDesordenada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta x:");
        int x = scanner.nextInt();
        Q = P;
        boolean band = true;
        while (Q.info != x && band) {
            if (Q.liga != null) {
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (!band) {
            System.out.println("el elemento no fue encontrado");
        } else {
            System.out.println("el elemento esta en la lista");
        }
    }

    public static void busquedaOrdenada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserta x:");
        int x = scanner.nextInt();
        Q = P;
        boolean band = true;
        while (Q.info < x && band) {
            if (Q.liga != null) {
                Q = Q.liga;
            } else {
                band = false;
            }
        }
        if (Q.info == x) {
            System.out.println("el elemento esta en la lista");
        } else {
            System.out.println("el elemento no fue encontrado");
        }
    }

    public static void imprimeMenu() {
        System.out.println("menu:");
        System.out.println("1. crea inicio");
        System.out.println("2. crea final");
        System.out.println("3. recorrido de la lista");
        System.out.println("4. recorre recursivo");
        System.out.println("5. inserta al inicio");
        System.out.println("6. inserta al final");
        System.out.println("7. inserta antes de x");
        System.out.println("8. inserta despues de x");
        System.out.println("9. elimina primero");
        System.out.println("10. elimina ultimo");
        System.out.println("11. elimina x");
        System.out.println("12. elimina antes de x");
        System.out.println("13. elimina despues de x");
        System.out.println("14. busqueda desordenada");
        System.out.println("15. busqueda ordenada");
        System.out.println("16. salir");
        System.out.println("opcion:");
    }

    public static void iniciaAplicacion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        imprimeMenu();
        while ((opcion = scanner.nextInt()) != 16) {
            switch (opcion) {
                case 1:
                    creaInicio();
                    break;
                case 2:
                    creaFinal();
                    break;
                case 3:
                    recorridoDeLaLista();
                    break;
                case 4:
                    recorreRecursivo(P);
                    break;
                case 5:
                    insertaAlInicio();
                    break;
                case 6:
                    insertaAlFinal();
                    break;
                case 7:
                    insertaAntesDeX();
                    break;
                case 8:
                    insertaDespuesDeX();
                    break;
                case 9:
                    eliminaPrimero();
                    break;
                case 10:
                    eliminaUltimo();
                    break;
                case 11:
                    eliminaX();
                    break;
                case 12:
                    eliminaAntesDeX();
                    break;
                case 13:
                    eliminaDespuesDeX();
                    break;
                case 14:
                    busquedaDesordenada();
                    break;
                case 15:
                    busquedaOrdenada();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            imprimeMenu();
        }
        System.out.println("adios");
    }

    public static Nodo Q = null;
    public static Nodo P = null;
}
