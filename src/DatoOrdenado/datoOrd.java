package DatoOrdenado;

import ToolsPanel.ToolsPanel;

public class datoOrd {
	private int datos[];//define un arreglo
	private byte p;//es un subindice,
	
	//constructor que recibe el tamaño para dimensionar (reservar)
	public datoOrd(byte tam) {
		
		 datos= new int[tam];
		 p=-1;//subindice -1 para validar si esta vacio el array
		
	}
	public boolean validaVacio()
	 {
		return (p==-1); 
	 }
	
	public String imprimeDatosOrd()
	 {
		 String cad="";
		 for (int i = 0; i <=p; i++) {
			 cad+=i+"["+datos[i]+"]"+"\n";
			
		}
		 return "\n"+cad;
	 }
	
	public byte buscarSecOrdenado(int dat) {
		
			byte i=0;
			while(i<=p && datos[i] < dat) 
				i++;
			return (byte) ((i>p || datos[i] > dat)?-i:i);
		
	}
public void eliminarOrd(byte pos) {
		for(int k=pos; k<=p; k++) {
		datos[k]=datos[k+1];
		}
		p--;
		
}
public void recorrePos(byte pos) {// este metodo recorre de forma ordenada
	for(int j= p+1; j>pos; j--) {
		datos[j]=datos[j-1];
	}
}
	
	public void AgregaOr() {
        if(validaVacio()){
            datos[p+1]= ToolsPanel.leerInt("Ingrese un valor");
            p++;
        }else{
           int dato = ToolsPanel.leerInt("Escribe el valor a insertar");
           byte pos = buscarSecOrdenado( dato);
            if(pos>=0)
            	ToolsPanel.imprimeErrorMsje("Dato existente");
            else{
                pos*=-1;
                recorrePos((byte) pos);
                p++;
            }
            datos[pos] = dato;
        }
	}

	
	public void modificarOrd(byte existe) {
		int dato;
	        if(existe==0)
	        {
	            if(existe<=(Integer)datos[0]){
	                do
	                {
	               
	                    dato =  ToolsPanel.leerByte("Ingresa un valor menor a: " + datos[existe + 1]);
	                }
	                while (dato >= (Integer) datos[existe*(-1)+1]);
	                datos[existe*(-1)] = dato;
	            }
	            else
	            {
	                do
	                {
	                    dato = ToolsPanel.leerByte("Ingresa un valor menor a: '" + datos[existe + 1] +  "'  mayor a: '" + datos[existe - 1] + "'");
	                }
	                while (dato >= (Integer) datos[existe + 1] && existe <= (Integer) datos[existe - 1]);
	                datos[existe] = dato;
	            }
	        }
	        else
	        {
	            do
	            {
	                dato = ToolsPanel.leerByte("Ingresa un valor mayor a: " + datos[existe - 1]);
	            }
	            while (dato <= (Integer) datos[existe - 1]);
	            datos[existe] = dato;
	        }
	}
}
