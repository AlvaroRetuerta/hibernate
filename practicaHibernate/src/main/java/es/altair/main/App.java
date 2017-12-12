package es.altair.main;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;

import es.altair.bean.Cliente;
import es.altair.bean.Oficina;
import es.altair.bean.Vehiculo;
import es.altair.dao.ClienteDAO;
import es.altair.dao.ClienteDAOImplHibernate;
import es.altair.dao.OficinaDAO;
import es.altair.dao.OficinaDAOImplHibernate;
import es.altair.dao.VehiculoDAO;
import es.altair.dao.VehiculoDAOImplHibernate;

public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		OficinaDAO ofiDAO = new OficinaDAOImplHibernate();

		ClienteDAO cDAO = new ClienteDAOImplHibernate();

		VehiculoDAO vDAO = new VehiculoDAOImplHibernate();

		// Oficina ofi = new Oficina("Sevilla", "Calle falsa 123");
		//
		// ofiDAO.save(ofi); //OK
		//
		// Vehiculo v1 = new Vehiculo("audi", "tt", ofi, "1234AA"); // funciona solo si
		// la ofi esta guardada en la misma ejecucion de la app
		//
		// Vehiculo v2 = new Vehiculo("bmw", "m3", ofi, "1234BB");
		//
		// Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
		// vehiculos.add(v1);
		// vehiculos.add(v2);
		//
		// ofi.setVehiculos(vehiculos);
		//
		// Cliente c = new Cliente("nombre", "apellidos", "45778855K"); //NO DEJA
		// REPETIR EL DNI OK
		//
		// cDAO.save(c); //OK
		//
		// v1.getClientes().add(c);
		// vDAO.save(v1);
		// --------Los saves funcionan, pero para guardar un vehiculo hay que darle la
		// oficina guardada antes-------------

		// --------Los Select por id funcionan correctamente-------------

		// --------Los delete por objeto funcionan sin problemas con oficinas
		// ofiDAO.delete(ofiDAO.get(2));

		// cDAO.deleteById(2);//perfe

		// al borrar un vehiculo borra tambien los clientes de los alquileres //
		// Solucionado
		// vDAO.deleteById(2);

		// listado de todos los objetos de las tablas, funcionando
		// List<Oficina> oficinas = ofiDAO.listado();
		// for (Oficina oficina : oficinas) {
		// System.out.println(oficina.getIdOficina() + " " + oficina.getCiudad()+ "
		// "+oficina.getDireccion());
		// }

		// -------Updates pasando el objeto completo funcionando-----------



		int opcion;
		do {

			System.out.println("\n\n\n\n");
			System.out.println("\t\t\t╔════════════════════════╗");
			System.out.println("\t\t\t║          MENÚ          ║");
			System.out.println("\t\t\t╠════════════════════════╣");
			System.out.println("\t\t\t║                        ║");
			System.out.println("\t\t\t║    1)   Vehiculos.     ║");
			System.out.println("\t\t\t║                        ║");
			System.out.println("\t\t\t║    2)   Oficinas.      ║");
			System.out.println("\t\t\t║                        ║");
			System.out.println("\t\t\t║    3)   Clientes.      ║");
			System.out.println("\t\t\t╠════════════════════════╣");
			System.out.println("\t\t\t║    0)   Salir          ║");
			System.out.println("\t\t\t╚════════════════════════╝");

			System.out.print("Opcion: ");

			opcion = sc.nextInt();
			int opcion2;
			switch (opcion) {
			case 1:// vehiculos

				System.out.println("\n\n\n\n");
				System.out.println("\t\t\t╔════════════════════════════╗");
				System.out.println("\t\t\t║            MENÚ            ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    1)   Insert.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    2)   Delete.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    3)   List.   	       ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    4)   Update.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    5)   List by IdCliente. ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    6)   List paginado.     ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║    0)   Salir              ║");
				System.out.println("\t\t\t╚════════════════════════════╝");
				System.out.print("Opcion: ");

				opcion2 = sc.nextInt();

				switch (opcion2) {
				case 1:
					System.out.println("Marca:");
					String marca = sc.next();
					System.out.println("Modelo:");
					String modelo = sc.next();
					System.out.println("Matricula:");
					String matricula = sc.next();
					System.out.println("Id Oficina");
					int idOficina = sc.nextInt();
					Oficina o = ofiDAO.get(idOficina);
					vDAO.save(new Vehiculo(marca, modelo, o, matricula));
					break;
				case 2:
					System.out.println("Id del vehiculo a eliminar:");
					int idVehiculo = sc.nextInt();
					// Vehiculo vd= vDAO.get(idVehiculo);
					vDAO.deleteById(idVehiculo);
					break;
				case 3:
					List<Vehiculo> vehiculos = vDAO.listado();
					for (Vehiculo vehiculo : vehiculos) {
						System.out.println(vehiculo);
					}
					break;
				case 4:
					System.out.println("id del vehiculo a actualizar:");
					int idV = sc.nextInt();
					Vehiculo vu = vDAO.get(idV);
					System.out.println("nueva Marca:");
					vu.setMarca(sc.next());
					System.out.println("nuevo Modelo:");
					vu.setModelo(sc.next());
					System.out.println("nueva Matricula:");
					vu.setMatricula(sc.next());
					System.out.println("nuevo Id Oficina");
					int idOficinaU = sc.nextInt();
					Oficina oU = ofiDAO.get(idOficinaU);
					vu.setOficina(oU);
					vDAO.update(vu);
					break;
				case 5:
					System.out.println("Id del cliente por el que buscar:");
					int idCliente = sc.nextInt();
					 List<Vehiculo> vehiculos1 = vDAO.listadoByIdCliente(idCliente);
					 for (Vehiculo vehiculo : vehiculos1) {
						 System.out.println(vehiculo.toString());
					 }
					break;
				case 6:
					System.out.println("Tamaño de pagina");
					int tam = sc.nextInt();
					vDAO.listadoPaginado(tam);
					break;

				default:
					break;
				}

				break;
			case 2:// oficinas

				System.out.println("\n\n\n\n");
				System.out.println("\t\t\t╔════════════════════════════╗");
				System.out.println("\t\t\t║            MENÚ            ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    1)   Insert.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    2)   Delete.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    3)   List.              ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    4)   Update.            ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║    0)   Salir              ║");
				System.out.println("\t\t\t╚════════════════════════════╝");
				System.out.print("Opcion: ");

				opcion2 = sc.nextInt();
				switch (opcion2) {
				case 1:// insert
					System.out.println("Ciudad");
					String ciudad = sc.next();
					System.out.println("Direccion");
					String direccion = sc.next();
					ofiDAO.save(new Oficina(ciudad, direccion));
					break;
				case 2:// delete
					System.out.println("Id Oficina");
					int idOfi = sc.nextInt();
					Oficina od = ofiDAO.get(idOfi);
					ofiDAO.delete(od);
					break;
				case 3:// list
					List<Oficina> oficinas = ofiDAO.listado();
					for (Oficina oficina : oficinas) {
						System.out.println(oficina);
					}
					break;
				case 4:
					System.out.println("id oficina");
					Oficina o = ofiDAO.get(sc.nextInt());
					System.out.println("nueva Ciudad");
					o.setCiudad(sc.next());
					System.out.println("Nueva Direccion");
					o.setDireccion(sc.next());
					break;
				default:
					break;
				}

				break;
			case 3:// clientes

				System.out.println("\n\n\n\n");
				System.out.println("\t\t\t╔════════════════════════════╗");
				System.out.println("\t\t\t║            MENÚ            ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    1)   Insert.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    2)   Delete.            ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    3)   List.              ║");
				System.out.println("\t\t\t║                            ║");
				System.out.println("\t\t\t║    4)   Update.            ║");
				System.out.println("\t\t\t╠════════════════════════════╣");
				System.out.println("\t\t\t║    0)   Salir              ║");
				System.out.println("\t\t\t╚════════════════════════════╝");
				System.out.print("Opcion: ");

				opcion2 = sc.nextInt();
				switch (opcion2) {
				case 1:// insert
					System.out.println("Nombre");
					String nombre = sc.next();
					System.out.println("Apellidos");
					String apellidos = sc.next();
					System.out.println("DNI");
					String dni = sc.next();
					cDAO.save(new Cliente(nombre, apellidos, dni));
					break;
				case 2:// delete
					System.out.println("Id Cliente");
					int idCd = sc.nextInt();
					// Cliente cd = cDAO.get(idCd);
					cDAO.deleteById(idCd);
					break;
				case 3:// list
					List<Cliente> clientes = cDAO.listado();
					for (Cliente cliente : clientes) {
						System.out.println(cliente);
					}
					
					break;
				case 4:
					System.out.println("id");
					Cliente c = cDAO.get(sc.nextInt());
					System.out.println("Nuevo nombre");
					c.setNombre(sc.next());
					System.out.println("Nuevos apellidos");
					c.setApellidos(sc.next());
					System.out.println("nuevo DNI");
					c.setDni(sc.next());
					break;
				default:
					break;
				}

				break;
			case 0:// salir

				break;

			default:
				break;
			}

		} while (opcion != 0);

	}

}
