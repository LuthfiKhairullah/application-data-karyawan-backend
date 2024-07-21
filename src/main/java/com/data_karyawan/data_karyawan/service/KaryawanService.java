package com.data_karyawan.data_karyawan.service;

import com.data_karyawan.data_karyawan.model.Karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KaryawanService {
    List<Karyawan> findByNikList(String nik);
    List<Karyawan> findByParams(String name, String nik);
    Karyawan createKaryawan(Karyawan karyawan);
    Karyawan updateKaryawan(String nik, Karyawan karyawan);
    void deleteKaryawan(String nik);
}
