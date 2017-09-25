/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor.LCD;

/**
 *
 * @author jorge
 */
public class LectorEntrada {

    public LectorEntrada() {
    }

    public ComandoProcesado procesar(String comando, int espacioDig) {
        validarLimitesEspacio(espacioDig);
        validarComando(comando);

        //Se hace el split de la cadena
        String[] parametros = comando.split(",");

        //Valida la cantidad de parametros
        validarCantidadParametros(parametros, comando);

        //Valida que el parametro size sea numerico
        int size = validarParametroSize(parametros);

        // Devuelve el comando procesado y validado
        return new ComandoProcesado(size, parametros[1], espacioDig);

    }

    private static void validarLimitesEspacio(int espacioEntreDigito){
        if (espacioEntreDigito < 0 || espacioEntreDigito > 5) {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }
    }
    public static int validarEspacio(String espacioEntreDigito) {
        if (isNumeric(espacioEntreDigito)) {
            int espacioDig = Integer.parseInt(espacioEntreDigito);

            // se valida que el espaciado este entre 0 y 5
            validarLimitesEspacio(espacioDig);
            return espacioDig;
        } else {
            throw new IllegalArgumentException("Cadena " + espacioEntreDigito
                    + " no es un entero");
        }
    }

    private void validarComando(String comando) {
        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void validarCantidadParametros(String[] parametros, String comando) {
        if (parametros.length > 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,");
        }
        //Valida la cantidad de parametros
        if (parametros.length < 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }
    }

    private int validarParametroSize(String[] parametros) {
        int tam;
        if (isNumeric(parametros[0])) {
            tam = Integer.parseInt(parametros[0]);

            // se valida que el size este entre 1 y 10
            if (tam < 1 || tam > 10) {
                throw new IllegalArgumentException("El parametro size [" + tam
                        + "] debe estar entre 1 y 10");
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        return tam;
    }
}
