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
    @Query("SELECT k FROM Karyawan k WHERE CAST(k.nik AS string) LIKE %:nik% AND k.name LIKE %:name%")
    List<Karyawan> findByNikAndNameParamList(@Param("name") String name, @Param("nik") Long nik);
    @Query("SELECT k FROM Karyawan k WHERE CAST(k.nik AS string) LIKE %:nik%")
    List<Karyawan> findByNikParamList(@Param("nik") Long nik);
    @Query("SELECT k FROM Karyawan k WHERE k.name LIKE %:name%")
    List<Karyawan> findByNameParamList(@Param("name") String name);
}
