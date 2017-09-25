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

    private int[] puntoFijoBottomLeft;
    private int[] puntoFijoMiddleLeft;
    private int[] puntoFijoTopLeft;
    private int[] puntoFijoMiddleRight;
    private int[] puntoFijoBottomRight;

    public SieteSegmentos() {

    }

    private void iniciarPuntosFijos() {
        this.puntoFijoBottomLeft = new int[2];
        this.puntoFijoMiddleLeft = new int[2];
        this.puntoFijoTopLeft = new int[2];
        this.puntoFijoMiddleRight = new int[2];
        this.puntoFijoBottomRight = new int[2];
    }

    //Calcula los puntos fijos que se usarán para ubicar cada segmento en la matriz
    private void calcularPuntosFijos(int filas, int columnas) {
        this.puntoFijoBottomLeft[0] = 0;
        this.puntoFijoBottomLeft[1] = 0;

        this.puntoFijoMiddleLeft[0] = (filas / 2);
        this.puntoFijoMiddleLeft[1] = 0;

        this.puntoFijoTopLeft[0] = (filas - 1);
        this.puntoFijoTopLeft[1] = 0;

        this.puntoFijoMiddleRight[0] = (columnas - 1);
        this.puntoFijoMiddleRight[1] = (filas / 2);

        this.puntoFijoBottomRight[0] = 0;
        this.puntoFijoBottomRight[1] = (columnas - 1);

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
        adicionarLinea(matriz, size, puntoFijoBottomLeft, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoDos(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoMiddleLeft, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoTres(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoBottomRight, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoCuatro(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoMiddleRight, LCDOpcionesImpresion.POSICION_Y,
                LCDOpcionesImpresion.CARACTER_VERTICAL.toString());
    }

    protected void agregarSegmentoCinco(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoBottomLeft, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }

    protected void agregarSegmentoSeis(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoMiddleLeft, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }

    protected void agregarSegmentoSiete(int size, String[][] matriz) {
        adicionarLinea(matriz, size, puntoFijoTopLeft, LCDOpcionesImpresion.POSICION_X,
                LCDOpcionesImpresion.CARACTER_HORIZONTAL.toString());
    }
}
