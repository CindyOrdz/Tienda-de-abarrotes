
package Almacenamiento;

public class Cliente {
    //Atributos
    private long codigo;    
    private String nombre;
    private String direccion;
    private String telefono;
    
    //Constructores
    public Cliente(){}

    public Cliente(long codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
        //Setters and getters
        public long getCodigo() {
               return codigo;
        }
        
        public void setCodigo(long codigo) {
               this.codigo = codigo;
        }
   
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
