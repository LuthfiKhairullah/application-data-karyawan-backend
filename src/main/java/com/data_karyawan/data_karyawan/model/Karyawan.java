package com.data_karyawan.data_karyawan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "data_karyawan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Karyawan {

    @Id
    @Column(nullable = false)
    private Long nik;

    @Column(nullable = false)
    private String name;

    private Integer umur;

    private String jenis_kelamin;

    private Date tgl_lahir;

    private String alamat;

    private String negara;
}
