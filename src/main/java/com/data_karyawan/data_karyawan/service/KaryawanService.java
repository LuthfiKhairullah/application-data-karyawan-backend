package com.data_karyawan.data_karyawan.service;

import com.data_karyawan.data_karyawan.model.Karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KaryawanService {
    List<Karyawan> findByNikList(Long nik);
    List<Karyawan> findByParams(String name, Long nik);
    Karyawan createKaryawan(Karyawan karyawan);
    Karyawan updateKaryawan(Long nik, Karyawan karyawan);
    void deleteKaryawan(Long nik);
}
