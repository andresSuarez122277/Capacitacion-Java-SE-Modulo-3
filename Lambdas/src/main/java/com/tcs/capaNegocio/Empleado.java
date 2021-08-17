package main.java.com.tcs.capaNegocio;

public class Empleado {
   private String nombre;
   private String apellido;
   private String documento;

   public Empleado(String nombre, String apellido, String documento) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.documento = documento;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public String getDocumento() {
      return documento;
   }

   public void setDocumento(String documento) {
      this.documento = documento;
   }

}
