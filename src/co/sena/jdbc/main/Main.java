package co.sena.jdbc.main;

import co.sena.jdbc.dao.UsuarioDAO;
import co.sena.jdbc.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA CRUD USUARIOS =====");
            System.out.println("1. Listar usuarios");
            System.out.println("2. Insertar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    List<Usuario> usuarios = dao.listarUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println(
                                u.getIdUsuario() + " | "
                                + u.getNombre() + " | "
                                + u.getCorreo() + " | "
                                + u.getRol()
                        );
                    }
                    break;

                case 2:
                    Usuario nuevo = new Usuario();
                    System.out.print("Nombre: ");
                    nuevo.setNombre(sc.nextLine());
                    System.out.print("Correo: ");
                    nuevo.setCorreo(sc.nextLine());
                    System.out.print("Rol: ");
                    nuevo.setRol(sc.nextLine());

                    dao.insertarUsuario(nuevo);
                    break;

                case 3:
                    Usuario actualizar = new Usuario();
                    System.out.print("ID: ");
                    actualizar.setIdUsuario(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    actualizar.setNombre(sc.nextLine());
                    System.out.print("Correo: ");
                    actualizar.setCorreo(sc.nextLine());
                    System.out.print("Rol: ");
                    actualizar.setRol(sc.nextLine());

                    dao.actualizarUsuario(actualizar);
                    break;

                case 4:
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminarUsuario(id);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
}
