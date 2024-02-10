
package Almacenamiento;

public class Articulo {
    //Atributos
    private long codigoArt;  //Long= entero largo
    private String nombre;
    private String descrip;
    private String stock;
    private String precio;
       
    //Constructores
    public Articulo (){} 
    
    public Articulo(String nombre,String precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public Articulo(long codigoArt, String nombre, String descrip, String stock, String precio) {
        this.codigoArt = codigoArt;
        this.nombre = nombre;
        this.descrip = descrip;
        this.stock = stock;
        this.precio = precio;
    }

        //Setters and getters
        public long getCodigoArt() {
            return codigoArt;
        }

        public void setCodigoArt(long codigoArt) {
            this.codigoArt = codigoArt;
        }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	      
}
