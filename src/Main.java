package com.citas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArchivoManager.verificarArchivos();

        Scanner sc = new Scanner(System.in);

        Administrador admin = new Administrador();

        System.out.println("=== SISTEMA DE CITAS ===");

        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!admin.login(usuario, password)) {

            System.out.println("Acceso denegado");
            return;
        }

        ArrayList<Doctor> doctores = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Cita> citas = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\nMENU");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Mostrar citas");
            System.out.println("5. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    System.out.print("ID Doctor: ");
                    String idD = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreD = sc.nextLine();

                    System.out.print("Especialidad: ");
                    String esp = sc.nextLine();

                    doctores.add(
                            new Doctor(idD, nombreD, esp));

                    System.out.println("Doctor registrado.");
                    break;

                case 2:

                    System.out.print("ID Paciente: ");
                    String idP = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreP = sc.nextLine();

                    pacientes.add(
                            new Paciente(idP, nombreP));

                    System.out.println("Paciente registrado.");
                    break;

                case 3:

                    if (doctores.isEmpty()
                            || pacientes.isEmpty()) {

                        System.out.println(
                                "Debe registrar doctor y paciente.");
                        break;
                    }

                    System.out.print("ID Cita: ");
                    String idC = sc.nextLine();

                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();

                    Cita cita = new Cita(
                            idC,
                            fecha,
                            hora,
                            motivo,
                            doctores.get(0),
                            pacientes.get(0));

                    citas.add(cita);

                    System.out.println("Cita creada.");
                    break;

                case 4:

                    for (Cita c : citas) {
                        System.out.println(c);
                    }

                    break;
            }

        } while (opcion != 5);

        System.out.println("Programa finalizado.");
    }
}