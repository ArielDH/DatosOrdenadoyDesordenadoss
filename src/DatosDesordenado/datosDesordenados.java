package DatosDesordenado;

import ToolsPanel.ToolsPanel;

public class datosDesordenados {
	 private Integer datos[];
	    private byte p;
	    public datosDesordenados(byte tam)
	    {
	        datos = new Integer[tam];
	        p=-1;
	    }

	    public boolean validaVacio()
	    {
	        return(p==-1);
	    }

	    public void almacenarDatos()
	    {
	        if(p< datos.length)
	        {
	            datos[p+1] = ToolsPanel.leerInt("Escribe un numero");
	            p++;
	        }
	        else
	            ToolsPanel.imprimeErrorMsje("Arreglo Lleno.");
	    }

	    public String imprimeDatos()
	    {
	        String cad="";

	        for (int i = 0; i<=p; i++)
	        {
	            cad+= "[" + datos[i] + "]" + "\n";
	        }
	        return "\n" + cad;
	    }

	    public byte busquedaSecuencial(Object val)
	    {
	        byte i=0;
	        while(i<=p && !val.equals(datos[i]))
	            i++;
	        return(i<=p)? i:-1;
	    }

	    public void modificarDato(byte pos){

	        int val=0;
	        val = ToolsPanel.leerInt("Ingrese el nuevo dato");
	        for (int j = pos; j<= pos; j++){
	            datos[j] = val;
	        }
	    }

	    public void eliminaDatos(int pos)
	    {
	        for (int j=pos; j<= p; j++)
	        {
	            datos[j]= datos[j+1];
	        }

	        p--;
	    }

}
