package com.medcloud.desafio;

import com.medcloud.desafio.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    private PatientService patientService;

    @Override
    public void run(String... args) throws Exception {

        Scanner in = new Scanner(System.in);

        int s;

        do {
            System.out.println("Quer cadastrar um paciente? Digite: 1 \nQuer consultar um paciente? Digite: 2 \nDeseja salvar uma coleção de pacientes? Digite: 3\nPara encerrar o programa digite: 4");
            s = in.nextInt();
            switch (s) {
                case 1:
                    patientService.savePatient();
                    break;
                case 2:
                    patientService.listPatient();
                    break;
                case 3:
                    patientService.collectionPatients();
                    break;
                case 4:
                    System.out.println("Programa encerrado!");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (s > 4);

    }
}
