import java.util.Scanner;

public class GestorCarrera {
	private Carrera miCarrera;
	private Scanner teclado = new Scanner(System.in);
	
	public GestorCarrera(String nombreCarrera) {
		miCarrera = new Carrera(nombreCarrera);
	}
	
	public void menuPrincipal() {
		int opcion = 0;
		do {
			System.out.println();
			System.out.println("Menu Principal " + miCarrera.getNombreCarrera());
			System.out.println("==== =========");
			System.out.println();
			System.out.println("1) Verificar estado de la carrera");
			System.out.println("2) Listar cursos disponibles");
			System.out.println("3) Opciones de curso");
			System.out.println("4) Finalizar carrera");
			System.out.println("0) Salir de este menu");
			System.out.println();
			System.out.print("Elija una opción: ");
			
			opcion = teclado.nextInt();
			
			switch(opcion) {
				case 1:
					if(miCarrera.isCarreraFinalizada()) {
						System.out.println("La carrera está FINALIZADA");
					} else {
						System.out.println("La carrera está EN CURSO");
					}
					
					break;
					
				case 2:
					miCarrera.listarCursos();
					
					break;
					
				case 3:
					menuCurso();
					
					break;
				
				case 4:
					miCarrera.finalizarCarrera();
					
					break;
				
				case 0:
					break;
					
				default:
					System.out.println("Opción Inválida!");
					break;
			}
		} while(opcion != 0);
	}
	
	public void menuCurso() {
		int opcion = 0;
		
		do {
			System.out.println();
			System.out.println("Menu de Curso");
			System.out.println("==== == =====");
			System.out.println();
			System.out.println("1) Ver la cantidad máxima de alumnos para un curso");
			System.out.println("2) Ver la cantidad de alumnos inscriptos en un curso");
			System.out.println("3) Ver si hay vacantes disponibles para un curso");
			System.out.println("4) Inscribir alumno a un curso");
			System.out.println("5) Borrar alumno de un curso");
			System.out.println("0) Salir de este menu");
			System.out.println();
			System.out.print("Elija una opción: ");
			
			opcion = teclado.nextInt();
			
			if(opcion > 0 && opcion <= 5) {
				System.out.print("Ingrese número de curso: ");
				int numeroCurso = teclado.nextInt() - 1;
				
				if(miCarrera.isNumeroCursoValido(numeroCurso)) {
					System.out.println("Curso: " + miCarrera.getNombreCurso(numeroCurso));
					
					switch(opcion) {
						case 1:
							int j = miCarrera.getCantidadMaximaAlumnosCurso(numeroCurso);
							System.out.println("Cantidad máxima de alumnos: " + j);
							
							break;
							
						case 2:
							int k = miCarrera.getCantidadAlumnosInscriptosCurso(numeroCurso);
							System.out.println("Cantidad de alumnos inscriptos: " + k);
							
							break;
							
						case 3:
							if(miCarrera.isVacanteDisponibleCurso(numeroCurso)) {
								System.out.println("Vacantes disponibles");
							} else {
								System.out.println("Sin vacantes");
							}
							
							break;
							
						case 4:
							miCarrera.inscribirAlumnoCurso(numeroCurso);
							
							break;
						
						case 5:
							miCarrera.borrarAlumnoCurso(numeroCurso);
							
							break;
						}
					} else {
						miCarrera.mensajeCursoFueraRango();
					}
			} else {
				System.out.println();
				System.out.println("Opción Inválida");
				System.out.println();
			}
		} while(opcion != 0);
	}
}
