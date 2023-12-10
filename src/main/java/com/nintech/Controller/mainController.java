package com.nintech.Controller;
import com.nintech.Model.*;
import com.nintech.Model.Nombre;
import com.nintech.Model.Usuario;
import org.apache.commons.collections4.Get;

import java.util.ArrayList;
import java.util.List;

public class mainController {

    public Usuario usuario;
    public Facultad facultades[];
    public int numeroDeFacultades = 8;



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

            Platillo platillos[] = new Platillo[datosfacultad.size()];
            for (int j = 1; j < datosfacultad.size(); j++) {
                platillos[j] = new Platillo(datosfacultad.get(j)[0], datosfacultad.get(j)[1]);
            }
            Menu menu = new Menu(platillos);

            if (tipoEstablecimiento.equals("Cafeteria")) {
                int numeroMesas = Integer.parseInt(datosfacultad.get(0)[4]);
                Cafeteria cafeteria = new Cafeteria("Cafeteria " + nombreEstablecimiento, horario, menu, tipoEstablecimiento, numeroMesas);

                this.facultades[dicfacultades.get(ubicacion) - 1].setEstablecimientos(cafeteria);

            } else if (tipoEstablecimiento.equals("Puesto de Comida")) {

                String especialidad = datosfacultad.get(0)[4];
                Puesto_de_Comida puesto_de_comida = new Puesto_de_Comida(nombreEstablecimiento, horario, menu, tipoEstablecimiento, especialidad);

                this.facultades[dicfacultades.get(ubicacion) - 1].setEstablecimientos(puesto_de_comida);
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

        // Eliminar facultades vacias (null) en caso de que existan

    }

    public Facultad getDataFacultad(String nombre) {
        for (int i = 0; i < facultades.length; i++) {
            if (facultades[i].getNombre().equals(nombre)) {
                return facultades[i];
            }
        }
        return null;
    }

    public Establecimiento getDataEstablecimiento(String nombreFacultad, String nombreEstablecimiento) {
        Facultad facultad = getDataFacultad(nombreFacultad);
        List<Establecimiento> establecimientos = facultad.getEstablecimientos();
        for (int i = 0; i < establecimientos.size(); i++) {
            if (establecimientos.get(i).getNombre().equals(nombreEstablecimiento)) {
                return establecimientos.get(i);
            }
        }
        return null;
    }

    public String getEspecialidad(String nombreFacultad, String nombreEstablecimiento) {
        for (int i = 0; i < facultades.length; i++) {
            if (facultades[i].getNombre().equals(nombreFacultad)) {
                List<Establecimiento> establecimientos = facultades[i].getEstablecimientos();
                List<Puesto_de_Comida> puestos = new ArrayList<Puesto_de_Comida>();
                for (int j = 0; j < establecimientos.size(); j++) {
                    if (establecimientos.get(j).getTipo().equals("Puesto de Comida")) {
                        puestos.add((Puesto_de_Comida) establecimientos.get(j));
                    }
                }

                for (int j = 0; j < puestos.size(); j++) {
                    if (puestos.get(j).getNombre().equals(nombreEstablecimiento)) {
                        return puestos.get(j).getEspecialidad();
                    }
                }
            }
        }
        return null;
    }

    public int getNumeroDeMesas(String nombreFacultad, String nombreEstablecimiento) {
        for (int i = 0; i < facultades.length; i++) {
            if (facultades[i].getNombre().equals(nombreFacultad)) {
                List<Establecimiento> establecimientos = facultades[i].getEstablecimientos();
                List<Cafeteria> cafeterias = new ArrayList<Cafeteria>();
                for (int j = 0; j < establecimientos.size(); j++) {
                    if (establecimientos.get(j).getTipo().equals("Cafeteria")) {
                        cafeterias.add((Cafeteria) establecimientos.get(j));
                    }
                }

                for (int j = 0; j < cafeterias.size(); j++) {
                    if (cafeterias.get(j).getNombre().equals(nombreEstablecimiento)) {
                        return cafeterias.get(j).getNumeroMesas();
                    }
                }
            }
        }
        return 0;
    }

    public Facultad[] getFacultades() {
        return facultades;
    }

    public String[] getEspecialidades() {
        List<String> especialidades = new ArrayList<String>();
        for (int i = 0; i < facultades.length; i++) {
            List<Establecimiento> establecimientos;
            try {
                establecimientos = facultades[i].getEstablecimientos();
            } catch (Exception e) {
                continue;
            }
            for (int j = 0; j < establecimientos.size(); j++) {
                if (establecimientos.get(j).getTipo().equals("Puesto de Comida")) {
                    especialidades.add(((Puesto_de_Comida) establecimientos.get(j)).getEspecialidad());
                }
            }
        }
        String[] especialidadesArray = new String[especialidades.size()];
        especialidadesArray = especialidades.toArray(especialidadesArray);
        return especialidadesArray;
    }

    public List<String[]> busqueda(String busqueda, String tipo, String filtro) {
        List<String[]> resultados = new ArrayList<String[]>();
        if (tipo.equals("Facultad")) {

            for (int i = 0; i < facultades.length; i++) {
                try {
                    if (facultades[i].getNombre().equals(filtro)) {
                        List<Establecimiento> establecimientos = facultades[i].getEstablecimientos();
                        for (int j = 0; j < establecimientos.size(); j++) {
                            Platillo platillos[] = establecimientos.get(j).getMenu().getPlatillos();
                            for (int k = 1; k < platillos.length; k++) {
                                if (platillos[k].getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                                    String nombreEstablecimiento = establecimientos.get(j).getNombre();
                                    String ubicacion = facultades[i].getNombre();
                                    String tipoEstablecimiento = establecimientos.get(j).getTipo();
                                    String comida = platillos[k].getNombre();
                                    String precio = platillos[k].getPrecio();
                                    String data[] = {nombreEstablecimiento, ubicacion, tipoEstablecimiento, comida, precio};

                                    resultados.add(data);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            return resultados;
        } else if (tipo.equals("Especialidad")) {
            for (int i = 0; i < facultades.length; i++) {
                try {
                    List<Establecimiento> establecimientos = facultades[i].getEstablecimientos();
                    for (int j = 0; j < establecimientos.size(); j++) {
                        if (establecimientos.get(j).getTipo().equals("Puesto de Comida")) {
                            if (((Puesto_de_Comida) establecimientos.get(j)).getEspecialidad().equals(filtro)) {
                                Platillo platillos[] = establecimientos.get(j).getMenu().getPlatillos();
                                for (int k = 1; k < platillos.length; k++) {
                                    if (platillos[k].getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                                        String nombreEstablecimiento = establecimientos.get(j).getNombre();
                                        String ubicacion = facultades[i].getNombre();
                                        String tipoEstablecimiento = establecimientos.get(j).getTipo();
                                        String comida = platillos[k].getNombre();
                                        String precio = platillos[k].getPrecio();
                                        String data[] = {nombreEstablecimiento, ubicacion, tipoEstablecimiento, comida, precio};

                                        resultados.add(data);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            return resultados;
        } else if (tipo.equals("Platillo")) {
            for (int i = 0; i < facultades.length; i++) {
                try {
                    List<Establecimiento> establecimientos = facultades[i].getEstablecimientos();
                    for (int j = 0; j < establecimientos.size(); j++) {
                        Platillo platillos[] = establecimientos.get(j).getMenu().getPlatillos();
                        for (int k = 1; k < platillos.length; k++) {
                            if (platillos[k].getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                                String nombreEstablecimiento = establecimientos.get(j).getNombre();
                                String ubicacion = facultades[i].getNombre();
                                String tipoEstablecimiento = establecimientos.get(j).getTipo();
                                String comida = platillos[k].getNombre();
                                String precio = platillos[k].getPrecio();
                                String data[] = {nombreEstablecimiento, ubicacion, tipoEstablecimiento, comida, precio};

                                resultados.add(data);
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            return resultados;
        }
        return null;
    }

    public String getNombreUsuario() {
        return usuario.getNombre().toString();
    }

}
