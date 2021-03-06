package Mapa;

import java.util.ArrayList;

public class Mapa
{
    private int tamanioFilas;
    private int tamanioColumnas;
    private int tamanioCajas;
    private ArrayList<ArrayList<Casillero>> matriz = new ArrayList<ArrayList<Casillero>>();
    private ArrayList<Fila> filas = new ArrayList<Fila>();
    private ArrayList<Columna> columnas = new ArrayList<Columna>();
    private ArrayList<Caja> cajas = new ArrayList<Caja>();

    //Crea los mxn casilleros (m=tamanioFilas, n=tamanioColumnas)
    private void crearCasilleros()
    {
        for(int i=0;i<tamanioFilas;i++)
        {
            ArrayList<Casillero> fila = new ArrayList<Casillero>();
            matriz.add(fila);
            for(int j=0;j<tamanioColumnas;j++)
            {
                Casillero casillero = new Casillero();
                fila.add(casillero);
            }
        }
    }

    //Devuelve el array de Casilleros (fila de la matriz) en la posicion pasada por parametro
    private ArrayList<Casillero> obtenerFila(int posicion)
    {
        return matriz.get(posicion);
    }

    //Devuelve el casillero del Mapa en la posicion pasada por parametro
    public Casillero obtenerCasillero(int numeroFila,int numeroColumna)
    {
        return this.obtenerFila(numeroFila).get(numeroColumna);
    }

    //Crea las m filas con las referencias a los casilleros ya creados
    private void crearFilas()
    {
        for(int i=0;i<tamanioFilas;i++)
        {
            Fila fila = new Fila(this.tamanioFilas);
            for(int j=0;j<tamanioColumnas;j++)
                fila.referenciarCasillero(this.obtenerFila(i).get(j));

            filas.add(fila);
        }

    }

    //Crean las n columnas con las referencias a los casilleros ya creados
    private void crearColumnas()
    {
        for(int i=0;i<tamanioColumnas;i++)
        {
            Columna columna = new Columna(this.tamanioColumnas);
            for(int j=0;j<tamanioFilas;j++)
                columna.referenciarCasillero(this.obtenerFila(j).get(i));

            columnas.add(columna);
        }

    }

    private void crearCajas()
    {
        int inicioFilas=0;
        int finFilas=2;
        int inicioColumnas=0;
        int finColumnas = 2;

        for(int k=0;k<this.cantidadDeCajas();k++)
        {
            Caja caja = new Caja(this.tamanioCajas);
            for (int i = inicioFilas; i < finFilas; i++)
            {
                for (int j = inicioColumnas; j < finColumnas; j++)
                {
                    caja.referenciarCasillero(this.obtenerFila(i).get(j));
                }
            }
            cajas.add(caja);
            inicioColumnas++;
            finColumnas++;
            if(finColumnas==this.tamanioColumnas+1)
            {
                inicioColumnas=0;
                finColumnas=2;
                inicioFilas++;
                finFilas++;
            }
        }
    }

    public Mapa()
    {
        this.tamanioColumnas = 5;
        this.tamanioFilas = 5;
        this.tamanioCajas = 4;

        this.crearCasilleros();
        this.crearFilas();
        this.crearColumnas();
        this.crearCajas();

    }

    private int cantidadDeCajas()
    {
        return (this.tamanioFilas-1)*(this.tamanioFilas-1);
    }

    public ArrayList<Fila>obtenerFilas()
    {
        return this.filas;
    }

    public ArrayList<Columna>obtenerColumnas()
    {
        return this.columnas;
    }

    public ArrayList<Caja>obtenerCajas()
    {
        return this.cajas;
    }


    public void cambiarContenidoDeCasillero(int fila, int columna,int contenido)
    {
        this.obtenerCasillero(fila,columna).cambiarContenido(contenido);
    }


    //public boolean puedoColocar(int numero, int columnaCasillero, int filaCasillero)
    //{
        //Casillero casillero = new Casillero(filaCasillero,columnaCasillero);
        //if (!casillero.estaLibre()) return false;
        //Fila fila = new Fila (filaCasillero);
        //boolean filaDisponible = !fila.contiene(numero);
       // Columna columna = new Columna (columnaCasillero);
        //boolean columnaDisponible = !columna.contiene(numero);
       // Caja caja = new Caja (filaCasillero, columnaCasillero);
        //boolean cajaDisponible = !caja.contiene(numero);
        //return ( filaDisponible && columnaDisponible && cajaDisponible);
       // return true;
    //}

}
