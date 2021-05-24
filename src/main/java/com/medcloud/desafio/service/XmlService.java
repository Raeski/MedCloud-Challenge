package com.medcloud.desafio.service;
import com.medcloud.desafio.model.retPatient.Return;
import com.thoughtworks.xstream.XStream;

import com.medcloud.desafio.model.patient.Patient;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class XmlService extends XStream {

    public boolean serialize(Patient patient)
    {
        FileOutputStream fos = null;
        try {
            File file = new File("C:/MedCloud/ " + patient.getName() + ".xml");
            if (file.isDirectory()) {
                throw new IllegalArgumentException ("The path must point to a file.");
            }
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            toXML(patient, fos);
            return true;
        } catch (Throwable e) {
            return false;
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {}
        }
    }

    public Patient deserialize(Patient patient)
    {
        FileInputStream fis = null;
        try {
            File file = new File("C:/MedCloud/ " + patient.getName() + ".xml");
            if (file.isDirectory()) {
                throw new IllegalArgumentException ("The path must point to a file.");
            }
            if (file.exists()) {
                fis = new FileInputStream("C:/MedCloud/ " + patient.getName() + ".xml");
                Object o = fromXML(fis, patient);
                System.out.println(o);
                return (Patient) o;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {}
        }
        return null;
    }


    public String serializeList(List<Patient> patient)
    {
        FileOutputStream fos = null;
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Digite o nome do arquivo xml: ");
            String nameArchive = in.nextLine();
            File file = new File("C:/MedCloud/ " + nameArchive + ".xml");
            if (file.isDirectory()) {
                throw new IllegalArgumentException ("The path must point to a file.");
            }
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            toXML(patient, fos);
            return nameArchive;
        } catch (Throwable e) {
            return e.getMessage();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {}
        }
    }

    public List<Patient> deserializeList(String path)
    {
        FileInputStream fis = null;
        List<Patient> patient = new ArrayList<>();
        try {
            File file = new File("C:/MedCloud/ " + path + ".xml");
            if (file.isDirectory()) {
                throw new IllegalArgumentException ("The path must point to a file.");
            }
            if (file.exists()) {
                fis = new FileInputStream("C:/MedCloud/ " + path + ".xml");
                Object o = fromXML(fis, patient);
                System.out.println(o);
                return (List<Patient>) o;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {}
        }
        return null;
    }

}
