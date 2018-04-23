
public class Mate {

    public Mate() {
    }

    public static double factorial() {
        System.out.println("Introduce un numero: ");
        double num1 = EntradaConsola.leeReal();
        if (num1 < 0) {
            return -1;
        } else {
            double resultado = 1.0;
            for (int i = 1; i <= num1; i++) {
                System.out.println(i);
                resultado = resultado * i;
            }
            return resultado;
        }
    }

    public static boolean Primo(int numero) {
        int contador = 0;
        for (int i = 2; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        if (contador == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean Perfecto(int numero) {
        int acum = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                acum += i;
            }
        }
        if (acum == numero) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean Amigos(int numero1, int numero2) {

        int acum1 = 0;
        int acum2 = 0;
        for (int i = 1; i <= numero1; i++) {
            if (numero1 % i == 0) {
                acum1 += i;
            }
        }

        for (int i = 1; i <= numero2; i++) {
            if (numero2 % i == 0) {
                acum2 += i;
            }
        }

        if ((acum2 == numero1) && (acum1 == numero2)) {
            return true;
        } else {
            return false;
        }
    }

    /*public static int euler(int n){
     int cont = 0;
     for (int i=1; i<n; i++)
     if(Primo(n,i))
     cont++;
     }*/
    public static double divide(double op1, double op2) throws DivisionPorCero {
        if (op2 == 0) {
            DivisionPorCero e = new DivisionPorCero();
            throw e;
        } else {
            return op1 / op2;
        }

    }

}

/*public static boolean Primos(int numero1, int numero2){
int contador=0;
	for (int  i=2; i<=numero1; i++){
		for (int j=2; j<=numero2; j++)
			if(i%j==0)
				return false;
	}		
}
*/
