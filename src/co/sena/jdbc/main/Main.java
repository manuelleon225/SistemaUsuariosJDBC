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
    }
}
