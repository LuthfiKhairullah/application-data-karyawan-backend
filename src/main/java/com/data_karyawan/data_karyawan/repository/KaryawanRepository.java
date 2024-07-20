package com.data_karyawan.data_karyawan.repository;

import com.data_karyawan.data_karyawan.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {

    @Query("SELECT k FROM Karyawan k WHERE k.nik = :nik")
    List<Karyawan> findByNikList(@Param("nik") Long nik);
    @Query("SELECT k FROM Karyawan k WHERE k.nik = :nik")
    Karyawan findByNik(@Param("nik") Long nik);
}
