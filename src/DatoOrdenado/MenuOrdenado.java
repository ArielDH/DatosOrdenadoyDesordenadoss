package DatoOrdenado;

import javax.swing.JOptionPane;

import ToolsPanel.ToolsPanel;

public class MenuOrdenado {
	public static void menu3(String menu){  
		String sel="";
		datoOrd obj = new datoOrd((byte)10);
		byte pos=0;
		do {
				sel=boton(menu);
				switch(sel){
				case "AgregarOr":
					obj.AgregaOr();
					break;
				case "BuscarOr":
					if(obj.validaVacio()) {
						ToolsPanel.imprimeErrorMsje("Array vacio");
					}
					else {
					pos = obj.buscarSecOrdenado(ToolsPanel.leerInt("Inserta un numero a buscar"));
					if(pos>=0) {
						ToolsPanel.imprime("Se encuentra en la posicion: " +pos);
					}else {
						ToolsPanel.imprimeErrorMsje("Dato no encontrado");
					}
				}
					break;
				case "Imprimir":
					if(obj.validaVacio()) ToolsPanel.imprimeErrorMsje("Array vacio");
					else ToolsPanel.imprime("Datos del arreglo\n"+obj.imprimeDatosOrd());
					
					break;
				case "Eliminar":
					if(obj.validaVacio()) ToolsPanel.imprimeErrorMsje("Array vacio");
					else 
					{
						pos = obj.buscarSecOrdenado(ToolsPanel.leerInt("Numero a eliminar"));
						if(pos>=0)
						{
							obj.eliminarOrd(pos);
							ToolsPanel.imprime("Datos del arreglo"+obj.imprimeDatosOrd());
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
						pos = obj.buscarSecOrdenado(ToolsPanel.leerInt("Numero a modificar"));
						if(pos>=0)
						{
							ToolsPanel.imprime("Dato modificado en la posicion: " +pos);
							obj.modificarOrd(pos);
							ToolsPanel.imprime("Datos del arreglo"+obj.imprimeDatosOrd());
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
		
		menu3("AgregarOr,BuscarOr,Imprimir,Eliminar,Modificar,Salir");

	}
	
}
