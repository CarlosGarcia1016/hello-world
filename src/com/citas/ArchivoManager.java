package com.citas;

import java.io.File;
import java.io.IOException;

public class ArchivoManager {

    public static void verificarArchivos() {

        try {

            File carpeta = new File("db");

            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            new File("db/doctores.csv").createNewFile();
            new File("db/pacientes.csv").createNewFile();
            new File("db/citas.csv").createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
