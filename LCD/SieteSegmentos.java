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
public class SieteSegmentos extends CaracterImplementor {

    private int[] pf1;
    private int[] pf2;
    private int[] pf3;
    private int[] pf4;
    private int[] pf5;

    public SieteSegmentos() {

    }

    private void iniciarPuntosFijos() {
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }

    //Calcula los puntos fijos que se usarán para ubicar cada segmento en la matriz
    private void calcularPuntosFijos(int filas, int columnas) {
        this.pf1[0] = 0;
        this.pf1[1] = 0;

        this.pf2[0] = (filas / 2);
        this.pf2[1] = 0;

        this.pf3[0] = (filas - 1);
        this.pf3[1] = 0;

        this.pf4[0] = (columnas - 1);
        this.pf4[1] = (filas / 2);

        this.pf5[0] = 0;
        this.pf5[1] = (columnas - 1);

    }

    //Método para adicionar la linea correspondiente a un segmento en la matriz
    private void adicionarLinea(String[][] matriz, int size, int[] punto, LCDOpcionesImpresion posFija,
            String caracter) {

        if (posFija.equals(LCDOpcionesImpresion.POSICION_X)) {
            for (int linea = 1; linea <= size; linea++) {
                int y = punto[1] + linea;
                int x = punto[0];
                matriz[x][y] = caracter;
            }
        }
        if (posFija.equals(LCDOpcionesImpresion.POSICION_Y)) {
            for (int linea = 1; linea <= size; linea++) {
                int x = punto[0] + linea;
                int y = punto[1];
                matriz[x][y] = caracter;
            }
        }
    }

    private String[][] setupSieteSegmentos(int size) {
        iniciarPuntosFijos();
        calcularPuntosFijos(getFilas(size), getColumnas(size));
        return crearMatriz(getFilas(size), getColumnas(size));
    }

    @Override
    public String[][] getDigitoUno(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoDos(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoDos(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoTres(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoCuatro(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoCinco(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoSeis(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoDos(size, matriz);
        agregarSegmentoSiete(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoSiete(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoOcho(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoDos(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoNueve(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoSeis(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    @Override
    public String[][] getDigitoCero(int size) {
        String[][] matriz = setupSieteSegmentos(size);
        agregarSegmentoUno(size, matriz);
        agregarSegmentoDos(size, matriz);
        agregarSegmentoTres(size, matriz);
        agregarSegmentoCuatro(size, matriz);
        agregarSegmentoCinco(size, matriz);
        agregarSegmentoSiete(size, matriz);
        return matriz;
    }

    //Métodos para agregar los segmentos del 1 al 7
    protected void agregarSegmentoUno(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf1, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoDos(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf2, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoTres(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf5, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoCuatro(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf4, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoCinco(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf1, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }

    protected void agregarSegmentoSeis(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf2, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }

    protected void agregarSegmentoSiete(int size, String[][] matriz) {
        adicionarLinea(matriz, size, pf3, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }
}
