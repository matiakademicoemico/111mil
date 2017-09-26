import java.util.Scanner;

public class Carrera {
	// esto es una constante que define la cantidad de cursos de la carrera
	static final int CANTIDAD_CURSOS = 4;
	
	private String nombreCarrera;
	private boolean carreraFinalizada;
	
	// utilizo un vector de Cursos de 4 posiciones. Obsérvese que el uso de
	// la constante CANTIDAD_CURSOS eventualmente me permitirá variar la 
	// cantidad de cursos por carrera sin tocar demasiado código (bajo acoplamiento)
	// Recordar que cuando declaro un vector de 4 posiciones las mismas serán: 0, 1, 2 y 3
	// Por eso en el código veran manupilaciones tipo CANTIDAD_CURSOS - 1 y cosas por el estilo
	private Curso cursosCarrera[] = new Curso[CANTIDAD_CURSOS];
	
	public Carrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
		
		//Otra vez uso la constante CANTIDAD_CURSOS
		for(int i = 0; i <= CANTIDAD_CURSOS - 1; i++){
			Scanner teclado = new Scanner(System.in);
			
			System.out.print("Ingrese el nombre del " + (i + 1) + " Curso: ");
			String nombreCurso = teclado.next();
			
			System.out.print("Ingrese la cantidad máxima de alumnos: ");
			int cantidadMaximaAlumnos = teclado.nextInt();
			
			cursosCarrera[i] = new Curso(nombreCurso, cantidadMaximaAlumnos);
		}
	}
	
	// Método utilitario para determinar si un número de curso es válido.
	// De esta manera me ahorro de escribir código repetitivo, y como usa
	// la constante CANTIDAD_CURSOS es flexible.
	public boolean isNumeroCursoValido(int numeroCurso) {
		if(numeroCurso >= 0 && numeroCurso <= CANTIDAD_CURSOS - 1){
			return true;
		} else {
			return false;
		}
	}
	
	// Método utilitario para mostrar un mensaje de error si el número de curso
	// está fuera de rango.
	public void mensajeCursoFueraRango() {
		System.out.println("Número de curso fuera de rango");
	}
	
	// Idem anterior pero para cuando la carrera ha finalizado.
	public void mensajeCarreraFinalizada() {
		System.out.println("la carrera ya ha finalizado");
	}
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	
	public boolean isCarreraFinalizada() {
		return carreraFinalizada;
	}
	
	public void finalizarCarrera() {
		carreraFinalizada = true;
	}
	
	// Método para listar los cursos y sus estados. Me genero
	// Strings con parte de los datos que quiero mostar y despues los
	// concateno. Un ejemplo de la salida sería:
	// 1) Matemática 6 / 10 alumnos inscriptos
	// 2) Biología 5 / 12 alumnos inscriptos
	// 3) Geografía 8 / 8 alumnos inscriptos
	// 4) Historia 12 / 12 alumnos inscriptos
	public void listarCursos() {
		for(int i = 0; i <= CANTIDAD_CURSOS - 1; i++) {
			String numeroCurso = (i + 1) + ") ";
			String nombreCurso = cursosCarrera[i].getNombreCurso() + " ";
			
			// El método valueOf de la clase String recibe un entero y lo convierte en un 
			// String. 
			String estadoAlumnos = String.valueOf(cursosCarrera[i].getCantidadAlumnosInscriptos()); 
			estadoAlumnos += " / " + String.valueOf(cursosCarrera[i].getCantidadMaximaAlumnos());
			estadoAlumnos += " alumnos inscriptos";
			
			System.out.println(numeroCurso + nombreCurso + estadoAlumnos);
		}
	}
	
	public int getCantidadAlumnosInscriptosCurso(int numeroCurso) {
		// Uso el método utilitario isNumeroCursoValido para determinar si el número
		// de curso que vino como parametro es válido
		if(isNumeroCursoValido(numeroCurso)) {
			return cursosCarrera[numeroCurso].getCantidadAlumnosInscriptos();
		} else {
			mensajeCursoFueraRango();
			return 0;
		}
	}
	
	public int getCantidadMaximaAlumnosCurso(int numeroCurso) {
		if(isNumeroCursoValido(numeroCurso)) {
			return cursosCarrera[numeroCurso].getCantidadMaximaAlumnos();
		} else {
			mensajeCursoFueraRango();
			return 0;
		}
	}
	
	public boolean isVacanteDisponibleCurso(int numeroCurso) {
		// Si la carrera ya finalizó no tiene sentido ver si hay 
		// vacantes en un curso.
		if(!isCarreraFinalizada()) {
			if(isNumeroCursoValido(numeroCurso)) {
				return cursosCarrera[numeroCurso].isVacanteDisponible();
			} else {
				mensajeCursoFueraRango();
				return false;
			}
		} else {
			mensajeCarreraFinalizada();
			return false;
		}
	}
	
	public void inscribirAlumnoCurso(int numeroCurso) {
		// Si la carrera ya finalizó no tiene sentido inscribir alumnos
		if(!isCarreraFinalizada()) {
			if(isNumeroCursoValido(numeroCurso)) {
				cursosCarrera[numeroCurso].inscribirAlumno();
				System.out.println("Alumno inscripto");
			} else {
				mensajeCursoFueraRango();
			}
		} else {
				mensajeCarreraFinalizada();
		}
	}
	
	public void borrarAlumnoCurso(int numeroCurso) {
		// Si la carrera ya finalizó no tiene sentido borrar alumnos
		if(!isCarreraFinalizada()) {
			if(isNumeroCursoValido(numeroCurso)) {
				cursosCarrera[numeroCurso].borrarAlumno();
				System.out.println("Alumno borrado");
			} else {
				mensajeCursoFueraRango();
			}
		} else {
			mensajeCarreraFinalizada();
		}
	}
	
	public String getNombreCurso(int numeroCurso) {
		if(isNumeroCursoValido(numeroCurso)) {
			return cursosCarrera[numeroCurso].getNombreCurso();
		} else {
			mensajeCursoFueraRango();
			return "";
		}
	}
}
