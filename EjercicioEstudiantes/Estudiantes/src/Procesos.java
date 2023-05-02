import javax.swing.JOptionPane;

public class Procesos {
	
	String[] nombres;
	int[] edades;
	int estudiantes;
	
	public String obtenerMenu() {
		
		String menu = "";
	
		menu+= "**********Menu**********\n\n";
		menu+= "Selecciona la opción:\n\n";
		menu+= "1- Ingresar datos.\n";
		menu+= "2- Imprimir datos.\n";
		menu+= "3- Imprimir promedio de edades.\n";
		menu+= "4- Imprimir los estudiantes mayores de edad de todo el grupo.\n";
		menu+= "5- Imprimir los estudiantes menores de edad de todo el grupo.\n";
		menu+= "6- Imprimir cuántos estudiantes son mayores de edad.\n";
		menu+= "7- Buscar por nombre y mostrar su edad.\n";
		menu+= "8- Buscar por edad y mostrar todos los estudiantes con la misma edad.\n";
		menu+= "9- Salir.\n\n";
		
		return menu;
		
	}
	
	public void iniciarPrograma() {
		
		int opcion;
		
		String menu = obtenerMenu();

		do {		
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			obtenerOpcion(opcion);
		}while(opcion != 9);
		
	}
	
	public void obtenerOpcion(int opcion) {
		
		switch(opcion) {
		
		case 1: System.out.println("Ingresar datos");
				ingresarDatos();
				break;
		
		case 2: System.out.println("Imprimir datos");
				comprobarDatos(opcion);
				break;
				
		case 3: System.out.println("Imprimir promedio de edades");
				comprobarDatos(opcion);
				break;
		
		case 4: System.out.println("Estudiantes mayores: ");
				comprobarDatos(opcion);
				break;
		
		case 5: System.out.println("Estudiantes menores: ");
				comprobarDatos(opcion);
				break;
		
		case 6: System.out.println("Imprimir cuántos estudiantes son mayores de edad");
				comprobarDatos(opcion);
				break;
				
		case 7: System.out.println("Buscar por nombre");
				comprobarDatos(opcion);
				break;
				
		case 8: System.out.println("Buscar por edad");
				comprobarDatos(opcion);
				break;
				
		case 9: System.out.println("Salir");
				JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
				break;		
		
		default: System.out.println("Opción incorrecta");
		 		break;
		}
	}
	
	public void ingresarDatos() {
		
		do {			
			estudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes a calcular"));
		}while(estudiantes < 0);
		
		nombres = new String[estudiantes];
		edades = new int[estudiantes];
		
		for (int i = 0 ; i < estudiantes ; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre del estudiante (" +(i+1)+ ")");
			
			do {				
				edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante (" +(i+1)+ ")"));
			}while(edades[i] < 5 || edades[i] > 100);
		}
	}
	
	public void comprobarDatos (int opcion) {
		
		if (nombres != null && edades != null) {			
			switch (opcion) {
			case 2: imprimirDatos();
					break;
					
			case 3: promedioEdades();
					break;
					
			case 4: imprimirMayores();
					break;
					
			case 5: imprimirMenores();
					break;
					
			case 6: cantidadMayores();
					break;
					
			case 7: buscarNombre();
					break;
					
			case 8: buscarEdad();
					break;
			}
		} else {
			System.out.println("No hay datos registrados");
		}
	}
	
	public void imprimirDatos() {
		
		for(int i = 0 ; i < estudiantes ; i++) {
			System.out.println(" Dato # (" +(i+1)+ ")\n Nombre: " +nombres[i]+ "\n Edad: " +edades[i] +"\n");
		}
	}
	
	public void promedioEdades() {
	
		int sumaEdades = 0, promedio = 0;
		
		for (int i = 0 ; i < estudiantes ; i++) {
			sumaEdades+= edades[i];
		}
		
		promedio = sumaEdades / estudiantes;
		
		System.out.println("La edad promedio de los estudiantes ingresados es de: " +promedio);
	}

	public void imprimirMayores() {
		
		for (int i = 0 ; i < estudiantes ; i++) {
			if (edades[i] >= 18) {
				System.out.print(", " +nombres[i]);
			}
		}
	}
	
	public void imprimirMenores() {
		
		for (int i = 0 ; i < estudiantes ; i++) {
			if (edades[i] < 18) {
				System.out.println(" " +nombres[i]);
			}
		}
	}
	
	public void cantidadMayores() {
		
		int cantidad = 0;
		
		for (int i = 0 ; i < estudiantes ; i++) {
			
			if (edades[i] >= 18) {
				cantidad++;
			}
		}
		
		System.out.println("Cantidad de estudiantes mayores de edad: " +cantidad);
	}
	
	public void buscarNombre() {
	
		int cantidad = 0;
		String nombre = "";
		
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
		
		for (int i = 0 ; i < estudiantes ; i++) {
			if(nombres[i].equalsIgnoreCase(nombre)) {
				System.out.println("El estudiante " +nombres[i]+ " de la posición " +(i+1)+ " tiene " +edades[i]+ " anios");
				cantidad++;
			}
		}
		
		if (cantidad > 0) {
			System.out.println("El nombre " +nombre+ " se repite " +cantidad+ " veces");
		}else{
			System.out.println("El nombre no se encuentra dentro de la lista");
		}
	}
	
	public void buscarEdad() {
		
		int edad = 0;
		
		edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad a consultar"));
		
		for (int i = 0 ; i < estudiantes ; i++) {
			if (edades[i] == edad) {
				System.out.print(" " +nombres[i]);
			}
		}
	}
	
}