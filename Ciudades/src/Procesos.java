import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Map;



public class Procesos {
	
	public void Inicio() {
		
		String menu= "GESTION PAISES\n";
		   menu+="1. Registrar pais\n";
	       menu+="2. Registrar ciudades\n";
	       menu+="3. consultar ciudades por pais\n";
	       menu+="4. consultar ciudad\n";
	       menu+="5. Salir\n";
	       menu+="Ingrese una opcion:\n";
	       
	       
	       int opc=0;
			do {
					opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			        validarMenu(opc);

			} while (opc!=5);
			
	}
	
	HashMap<String, ArrayList<String>> ListaPaises = new HashMap<String, ArrayList<String>>();
	
	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
			registrarPais();
			break;
		case 2:
			registarCiudad();
			break;
		case 3: 
			consultarCiudadesPorPais();
			break;
		case 4:
			consultarCiudad();
			break;
		case 5:
			System.out.println("FINALIZO EL REGISTRO DE CIUDADES Y PAISES");
			break;
		default:
			JOptionPane.showInternalMessageDialog(null, "Ingrese una opcion valida");
			break;
		}
		
	}




	private void registrarPais() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		ArrayList<String>listaCiudades = new ArrayList<String>();
		ListaPaises.put(name,listaCiudades);
	}
	
	private void registarCiudad() {
		String pais = JOptionPane.showInputDialog("Ingrese el pais donde deseas registrar una ciudad");
		if (ListaPaises.containsKey(pais)) {
			String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad que desea registrar");
			ListaPaises.get(pais).add(ciudad);
			System.out.println(ListaPaises);
			System.out.println();
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se ecuentra registrado");
		}
	}
	
	
	private void consultarCiudadesPorPais() {
		String pais = JOptionPane.showInputDialog("Ingrese el pais que desea consultar");
		if (ListaPaises.containsKey(pais)) {
			System.out.println("Pais: " + pais + "\n");
			System.out.println("Ciudades: \n ");
			for (int i = 0; i < ListaPaises.get(pais).size(); i++) {
				System.out.println( ListaPaises.get(pais).get(i));
			}	
		}else {
			JOptionPane.showMessageDialog(null, "El pais que desea buscar no ha sido registrado");
		}	
	}
	
	private void consultarCiudad() {
		String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad que desea buscar");
		for (Map.Entry<String, ArrayList<String>> entry : ListaPaises.entrySet()) {
            String clave = entry.getKey();
            ArrayList<String> listaNueva = entry.getValue();
            if (listaNueva.contains(ciudad)) {
				System.out.println(ciudad + "Se encontro en " + clave);
			}else {
				JOptionPane.showInternalMessageDialog(null, "No se encontro esa ciudad en ningun pais");
			}
		}
		
	}
	
	
}


