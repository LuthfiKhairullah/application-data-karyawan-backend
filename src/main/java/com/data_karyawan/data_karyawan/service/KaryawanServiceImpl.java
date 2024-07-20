package com.data_karyawan.data_karyawan.service;

import com.data_karyawan.data_karyawan.model.Karyawan;
import com.data_karyawan.data_karyawan.repository.KaryawanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class KaryawanServiceImpl implements KaryawanService {

    private KaryawanRepository karyawanRepository;

    @Override
    public List<Karyawan> findAll() {
        return karyawanRepository.findAll();
    }

    @Override
    public List<Karyawan> findByNikList(Long nik) {
        return karyawanRepository.findByNikList(nik);
    }

    @Override
    public Karyawan createKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    @Override
    public Karyawan updateKaryawan(Long nik, Karyawan karyawan) {
        Karyawan karyawanExists = karyawanRepository.findByNik(nik);
        karyawanExists.setNik(karyawan.getNik());
        karyawanExists.setName(karyawan.getName());
        karyawanExists.setUmur(karyawan.getUmur());
        karyawanExists.setJenis_kelamin(karyawan.getJenis_kelamin());
        karyawanExists.setTgl_lahir(karyawan.getTgl_lahir());
        karyawanExists.setAlamat(karyawan.getAlamat());
        karyawanExists.setNegara(karyawan.getNegara());

        return karyawanRepository.save(karyawanExists);
    }

    @Override
    public void deleteKaryawan(Long nik) {
        karyawanRepository.deleteById(nik.toString());
    }
}
