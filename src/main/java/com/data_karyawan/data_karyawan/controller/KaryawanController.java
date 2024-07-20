package com.data_karyawan.data_karyawan.controller;

import com.data_karyawan.data_karyawan.model.Karyawan;
import com.data_karyawan.data_karyawan.service.KaryawanService;
import com.data_karyawan.data_karyawan.util.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/karyawan")
public class KaryawanController {
    private KaryawanService karyawanService;

    @GetMapping("/get_karyawan")
    public ResponseEntity<Object> findAllKaryawan() {
        List<Karyawan> karyawanList = karyawanService.findAll();
        return new ResponseEntity<>(
                new ResponseBodyUtil(
                        "success",
                        "Successfully get all data karyawan",
                        karyawanList
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/add_karyawan")
    public ResponseEntity<Object> addKaryawan(@RequestBody Karyawan karyawan) {
        List<Karyawan> karyawanList = karyawanService.findByNikList(karyawan.getNik());
        if(karyawanList.isEmpty()) {
            Karyawan karyawanResult = karyawanService.createKaryawan(karyawan);
            return new ResponseEntity<>(
                new ResponseBodyUtil(
                    "success",
                    "Karyawan has been successfully added"
                ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                new ResponseBodyUtil(
                    "error",
                    "NIK Karyawan is exists"
                ), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_karyawan/{nik}")
    public ResponseEntity<Object> updateKaryawan(@PathVariable("nik") Long nik, @RequestBody Karyawan karyawan) {
        List<Karyawan> karyawanList = karyawanService.findByNikList(nik);
        if(karyawanList.isEmpty()) {
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "error",
                            "NIK Karyawan is not exists"
                    ), HttpStatus.BAD_REQUEST);
        } else {
            Karyawan karyawanResult = karyawanService.updateKaryawan(nik, karyawan);
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "success",
                            "Karyawan has been successfully updated"
                    ), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete_karyawan/{nik}")
    public ResponseEntity<Object> deleteKaryawanById(@PathVariable("nik") Long nik) {
        List<Karyawan> karyawanList = karyawanService.findByNikList(nik);
        if(karyawanList.isEmpty()) {
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "error",
                            "NIK Karyawan is not exists"
                    ), HttpStatus.BAD_REQUEST);
        } else {
            karyawanService.deleteKaryawan(nik);
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "success",
                            "Karyawan has been successfully deleted"
                    ), HttpStatus.OK);
        }
    }

}
