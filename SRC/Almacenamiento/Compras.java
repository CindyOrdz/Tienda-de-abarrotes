
package Almacenamiento;

public class Compras extends Articulo{
    //Atributos
    private String cantidad;
    
    //Constructor con herencia
    public Compras(String nombre,String cantidad, String precio) {
        super(nombre, precio);
        this.cantidad = cantidad;
    }
    
    //Setters and getters con Override
    @Override
    public void setPrecio(String precio) {
        super.setPrecio(precio);
    }

    @Override
    public String getPrecio() {
        return super.getPrecio(); 
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); 
    }
    
    public double getPrecioIva() {
        //Retorna el precio por articulo segun la cantidad a llevar  + iva
        return (1.19*Integer.parseInt(getPrecio())*Integer.parseInt(cantidad)); 
    }
}
