public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        Mapa.Mapa mapa = new Mapa.Mapa();

        /*mapa.cambiarContenidoDeCasillero(0,0,1);
        mapa.cambiarContenidoDeCasillero(0,1,2);
        mapa.cambiarContenidoDeCasillero(0,2,3);
        mapa.cambiarContenidoDeCasillero(0,3,4);
        mapa.cambiarContenidoDeCasillero(0,4,5);
        mapa.cambiarContenidoDeCasillero(1,0,6);
        mapa.cambiarContenidoDeCasillero(1,1,7);
        mapa.cambiarContenidoDeCasillero(1,2,8);
        mapa.cambiarContenidoDeCasillero(1,3,9);
        mapa.cambiarContenidoDeCasillero(1,4,10);
        mapa.cambiarContenidoDeCasillero(2,0,11);
        mapa.cambiarContenidoDeCasillero(2,1,12);
        mapa.cambiarContenidoDeCasillero(2,2,13);
        mapa.cambiarContenidoDeCasillero(2,3,14);
        mapa.cambiarContenidoDeCasillero(2,4,15);
        mapa.cambiarContenidoDeCasillero(3,0,16);
        mapa.cambiarContenidoDeCasillero(3,1,17);
        mapa.cambiarContenidoDeCasillero(3,2,18);
        mapa.cambiarContenidoDeCasillero(3,3,19);
        mapa.cambiarContenidoDeCasillero(3,4,20);*/


        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.println(mapa.obtenerCasillero(i,j));
                if(j==4)
                {
                    System.out.println("\n");
                }
            }

        }

        for(int i=0;i<4;i++)
        {
            System.out.println(mapa.obtenerCajas().get(1).obtenerCasillero(i));
        }

    }

}
