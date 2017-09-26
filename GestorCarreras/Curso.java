public class Curso {
	private String nombreCurso;
	private int cantidadMaximaAlumnos;
	private int cantidadAlumnosInscriptos;
	
	
	// NOVEDAD: otra tecnica para evitar las colisiones en los nombres
	// de parámetros y atributos de la clase, es utilizar el modificador
	// this. Cuando se utiliza this se desambigua el problema, ya que
	// el mismo hace referencia al atributo de clase. Por ejemplo, 
	// this.nombreCurso hace referencia al atributo nombreCurso de la clase
	public Curso(String nombreCurso, int cantidadMaximaAlumnos) {
		this.nombreCurso = nombreCurso;
		this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
		this.cantidadAlumnosInscriptos = 0;
	}
	
	public String getNombreCurso() {
		return nombreCurso;
	}
	
	public int getCantidadMaximaAlumnos() {
		return cantidadMaximaAlumnos;
	}
	
	public int getCantidadAlumnosInscriptos() {
		return cantidadAlumnosInscriptos;
	}
	
	public boolean isVacanteDisponible() {
		if(cantidadAlumnosInscriptos < cantidadMaximaAlumnos) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCursoVacio() {
		if(cantidadAlumnosInscriptos == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void inscribirAlumno() {
		if(isVacanteDisponible()) {
			cantidadAlumnosInscriptos++;
		} else {
			System.out.println("Curso " + nombreCurso + " completo!");
		}
	}
	
	public void borrarAlumno() {
		if(!isCursoVacio()) {
			cantidadAlumnosInscriptos--;
		} else {
			System.out.println("Curso " + nombreCurso + " ya esta vacio!");
		}
	}
}
