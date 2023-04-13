package DatosDesordenado;

import javax.swing.JOptionPane;
import ToolsPanel.ToolsPanel;

public class MenuDesordenado {
	public static void menu3(String menu){  
		String sel="";
		datosDesordenados obj = new datosDesordenados((byte)10);
		byte pos=0;
		do {
				sel=boton(menu);
				switch(sel){
				case "AgregarDesordenado":
					obj.almacenarDatos();
					break;
				case "BuscarDesordenado":
					if(obj.validaVacio()) {
						ToolsPanel.imprimeErrorMsje("Array vacio");
					}
					else {
					pos = obj.busquedaSecuencial(ToolsPanel.leerInt("Inserta un numero a buscar"));
					if(pos>=0) {
						ToolsPanel.imprime("Se encuentra en la posicion: " +pos);
					}else {
						ToolsPanel.imprimeErrorMsje("Dato no encontrado");
					}
				}
					break;
				case "Imprimir":
					if(obj.validaVacio()) ToolsPanel.imprimeErrorMsje("Array vacio");
					else ToolsPanel.imprime("Datos del arreglo\n"+obj.imprimeDatos());
					
					break;
				case "Eliminar":
					if(obj.validaVacio()) ToolsPanel.imprimeErrorMsje("Array vacio");
					else 
					{
						pos = obj.busquedaSecuencial(ToolsPanel.leerInt("Numero a eliminar"));
						if(pos>=0)
						{
							obj.eliminaDatos(pos);
							ToolsPanel.imprime("Datos del arreglo"+obj.imprimeDatos());
						}
						else {
							ToolsPanel.imprimeErrorMsje("Dato no encontrado");
						}
					}
					break;
				case "Modificar":
					if(obj.validaVacio()) ToolsPanel.imprimeErrorMsje("Array vacio");
					else 
					{
						pos = obj.busquedaSecuencial(ToolsPanel.leerInt("Numero a modificar"));
						if(pos>=0)
						{
							ToolsPanel.imprime("Dato modificado en la posicion: " +pos);
							obj.modificarDato(pos);
							ToolsPanel.imprime("Datos del arreglo"+obj.imprimeDatos());
						}
						else ToolsPanel.imprimeErrorMsje("Dato encontrado");
					}
					break;

				case "Salir": 
					break;
				}//switch
		}while(!sel.equalsIgnoreCase("Salir"));
		
	}
	public static String boton(String menu) {
		String valores[]=menu.split(",");
		int n;
		n = JOptionPane.showOptionDialog(null,"SELECCIONA  DANDO CLICK ", " M E N U", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return ( valores[n]);
	}
public static void main(String[] args) {
		
		menu3("AgregarDesordenado,BuscarDesordenado,Imprimir,Eliminar,Modificar,Salir");

	}
}
