package com.medcloud.desafio.model.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_paciente", schema = "medcloud")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String sexo;

    private String dataDeNascimento;

    private String doencas;

    @ManyToOne
    private Adress id_adress;

    public Patient(String name, String email, String sexo, String dataDeNascimento, String doencas) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.doencas = doencas;
    }
}
