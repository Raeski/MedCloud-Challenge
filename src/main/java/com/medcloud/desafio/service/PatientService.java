package com.medcloud.desafio.service;

import com.medcloud.desafio.exception.BadRequestException;
import com.medcloud.desafio.model.patient.Adress;
import com.medcloud.desafio.model.patient.Patient;
import com.medcloud.desafio.model.retPatient.Return;
import com.medcloud.desafio.repository.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private AdressService adressService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private XmlService xmlService;

    @Autowired
    private ReturnService returnService;

    public void savePatient(){

        try {
            Patient patient = inputs();

            Patient save = patientRepository.save(patient);
            System.out.println("Arquivo salvo na primeira base de dados com sucesso");

            saveXml(save);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listPatient() {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Digite o nome do paciente: ");
            String namePatient = in.nextLine();

            List<Patient> byName = patientRepository.findByName(namePatient);

            if(byName.isEmpty()) {
                throw new BadRequestException("Patient not found");
            } else {
                System.out.println(byName);
            }

        } catch (BadRequestException e) {
            e.printStackTrace();
        }
    }

    public Patient inputs() {
        Patient patient = new Patient();
        Scanner in = new Scanner(System.in);


        System.out.println("Digite seu nome:");
        String s = in.nextLine();

        System.out.println("Digite seu email:");
        String e = in.nextLine();

        System.out.println("Digite seu sexo:");
        String sexo = in.nextLine();

        System.out.println("Digite sua data de nascimento (DD/MM/YYYY):");
        String dataDeNascimento = in.nextLine();

        System.out.println("Digite suas doenças pré-existentes, separe-as por vírgula:");
        String doencas = in.nextLine();

        System.out.println("Digite seu CEP:");
        String cep = in.nextLine();

        Adress adress = adressService.getAdress(cep);

        patient.setName(s);
        patient.setEmail(e);
        patient.setSexo(sexo);
        patient.setDataDeNascimento(dataDeNascimento);
        patient.setDoencas(doencas);
        patient.setId_adress(adress);

        return patient;
    }

    public void saveXml(Patient save){

        try {
            xmlService.serialize( save );
            System.out.println("Arquivo xml criado com sucesso!");

            Patient deserialize = xmlService.deserialize(save);
            System.out.println("Arquivo xml lido com sucesso!");

            returnService.saveSecondDataBase(deserialize);
            System.out.println("Arquivo gravado em uma segunda base de dados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveXmlList(List<Patient> save){
        try {

            String s = xmlService.serializeList(save);
            System.out.println("Arquivo criado com sucesso!(LISTA COM OS PACIENTES)");

            List<Patient> patients = xmlService.deserializeList(s);
            System.out.println("Arquivo lido com sucesso!(LISTA COM OS PACIENTES)");

            for (Patient next : patients) {
                returnService.saveSecondDataBase(next);
            }

            System.out.println("Arquivo gravado em uma segunda base de dados com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void collectionPatients (){

        Patient patient1  = new Patient("Paciente1", "teste1@hotmail.com", "Masculino", "01/01/2000", "teste1, teste, teste, teste");
        Patient patient2  = new Patient("Paciente2", "teste2@hotmail.com", "Masculino", "01/01/2000", "teste2, teste, teste, teste");
        Patient patient3  = new Patient("Paciente3", "teste3@hotmail.com", "Masculino", "01/01/2000", "teste3, teste, teste, teste");

        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        String cep = "38408194";
        Adress adress = adressService.getAdress(cep);

        for(Patient patient: patients) {
            patient.setId_adress(adress);
            patientRepository.save(patient);
        }
        saveXmlList(patients);
    }






}

