package co.sena.jdbc.main;

import co.sena.jdbc.dao.UsuarioDAO;
import co.sena.jdbc.model.Usuario;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            List<Usuario> usuarios = usuarioDAO.listarUsuarios();

            System.out.println("=== LISTA DE USUARIOS ===");
            for (Usuario u : usuarios) {
                System.out.println(
                        u.getIdUsuario() + " | "
                        + u.getNombre() + " | "
                        + u.getCorreo() + " | "
                        + u.getRol()
                );
            }

        } catch (Exception e) {
            System.out.println("Error al listar usuarios");
            e.printStackTrace();
        }
        
        Usuario nuevo = new Usuario();
nuevo.setNombre("Juan");
nuevo.setCorreo("juan@mail.com");
nuevo.setRol("Usuario");

UsuarioDAO dao = new UsuarioDAO();
boolean resultado = dao.insertarUsuario(nuevo);

if (resultado) {
    System.out.println("Usuario insertado correctamente");
} else {
    System.out.println("Error al insertar usuario");
}
Usuario actualizar = new Usuario();
actualizar.setIdUsuario(1); // Usa un ID que exista
actualizar.setNombre("Nombre Actualizado");
actualizar.setCorreo("actualizado@mail.com");
actualizar.setRol("Admin");

boolean actualizado = dao.actualizarUsuario(actualizar);

if (actualizado) {
    System.out.println("Usuario actualizado correctamente");
} else {
    System.out.println("No se pudo actualizar el usuario");
}
boolean eliminado = dao.eliminarUsuario(2); // usa un ID que exista

if (eliminado) {
    System.out.println("Usuario eliminado correctamente");
} else {
    System.out.println("No se pudo eliminar el usuario");
}


    }
        
    
}
