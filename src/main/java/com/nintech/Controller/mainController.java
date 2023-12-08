package com.nintech.Controller;
import com.nintech.Model.*;
import com.nintech.Model.Nombre;
import com.nintech.Model.Usuario;
import org.apache.commons.collections4.Get;
import java.util.List;

public class mainController {

    public Usuario usuario;
    public Facultad facultades[];



    public mainController() {
        System.out.println("mainController Activo");
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        System.out.println("Iniciar Sesion");
        validarInicioSesion validarSesion = new validarInicioSesion();
        boolean result = validarSesion.validarInicio(correo, contraseña);
        if (result) {
            FindUser FindUser = new FindUser();
            String[] user = FindUser.findUser(correo, contraseña);
            Nombre nombre = crearNombre(user[0], user[1]);
            iniciarUsuario(nombre, correo, contraseña);
        }
        return result;
    }

    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contraseña) {
        System.out.println("Registrar Usuario");
        registro registro = new registro();
        boolean result = registro.registrarUsuario(nombres, apellidos, correo, contraseña);
        return result;
    }

    private void iniciarUsuario(Nombre nombre, String correo, String contraseña) {
        Credenciales credenciales = new Credenciales(correo, contraseña);
        Usuario usuario = new Usuario(nombre, credenciales);
        this.usuario = usuario;
    }

    private Nombre crearNombre(String nombres, String apellidos) {
        Nombre nombre = new Nombre(nombres, apellidos);
        return nombre;
    }

    public void añadirEstablecimientos() {
        crearFacultades();
        GetTable getTable = new GetTable();
        var dicfacultades = getTable.table;

        for (int i = 1; i < dicfacultades.size(); i++) {
            List<String[]> datosfacultad = getTable.getTableFrom(i);
            String nombreEstablecimiento = datosfacultad.get(0)[0];
            String tipoEstablecimiento = datosfacultad.get(0)[2];
            String horario = datosfacultad.get(0)[3];
            String ubicacion = datosfacultad.get(0)[5];

            if (tipoEstablecimiento.equals("Cafeteria")) {
                int numeroMesas = Integer.parseInt(datosfacultad.get(0)[4]);
                Platillo platillos[] = new Platillo[datosfacultad.size() - 1];
                for (int j = 1; j < datosfacultad.size() - 1; j++) {
                    platillos[j] = new Platillo(datosfacultad.get(j)[0], datosfacultad.get(j)[1]);
                }
                Menu menu = new Menu(platillos);
                Cafeteria cafeteria = new Cafeteria(nombreEstablecimiento, horario, menu, numeroMesas);

                this.facultades[dicfacultades.get(ubicacion) - 1].setEstablecimientos(cafeteria);
            }
        }
    }
    
    public void crearFacultades() {
        GetTable getTable = new GetTable();
        var lugares = getTable.table;
        facultades = new Facultad[lugares.size()];

        for (int i = 1; i < lugares.size(); i++) {
            List<String[]> datos = getTable.getTableFrom(i);
            String nombreFacultad = datos.get(0)[0];
            facultades[i - 1] = new Facultad(nombreFacultad);
        }
    }
    
}
