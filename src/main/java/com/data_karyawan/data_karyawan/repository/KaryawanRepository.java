package com.data_karyawan.data_karyawan.repository;

import com.data_karyawan.data_karyawan.model.Karyawan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {

    @Query("SELECT k FROM Karyawan k ORDER BY k.created_at DESC")
    List<Karyawan> findAllOrderByCreatedAt();
    @Query("SELECT k FROM Karyawan k WHERE k.nik = :nik ORDER BY k.created_at DESC")
    List<Karyawan> findByNikList(@Param("nik") String nik);
    @Query("SELECT k FROM Karyawan k WHERE k.nik = :nik ORDER BY k.created_at DESC")
    Karyawan findByNik(@Param("nik") String nik);
    @Query("SELECT k FROM Karyawan k WHERE CAST(k.nik AS string) LIKE %:nik% AND k.name LIKE %:name% ORDER BY k.created_at DESC")
    List<Karyawan> findByNikAndNameParamList(@Param("name") String name, @Param("nik") String nik);
    @Query("SELECT k FROM Karyawan k WHERE CAST(k.nik AS string) LIKE %:nik% ORDER BY k.created_at DESC")
    List<Karyawan> findByNikParamList(@Param("nik") String nik);
    @Query("SELECT k FROM Karyawan k WHERE k.name LIKE %:name% ORDER BY k.created_at DESC")
    List<Karyawan> findByNameParamList(@Param("name") String name);
}
