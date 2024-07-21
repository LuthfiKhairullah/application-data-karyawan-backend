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
@CrossOrigin(origins = {"http://localhost:8080", "https://application-data-karyawan-frontend-web.vercel.app"})
public class KaryawanController {
    private KaryawanService karyawanService;

    @GetMapping("/get_karyawan/{nik}")
    public ResponseEntity<Object> findKaryawanByNik(@PathVariable("nik") String nik) {
        List<Karyawan> karyawanList = karyawanService.findByNikList(nik);
        if(karyawanList.isEmpty()) {
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "error",
                            "NIK Karyawan is not exists"
                    ), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "success",
                            "Successfully get data karyawan",
                            karyawanList
                    ),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/get_karyawan")
    public ResponseEntity<Object> findKaryawanByParam(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "nik", required = false) String nik) {
        List<Karyawan> karyawanList = karyawanService.findByParams(name, nik);
        if(karyawanList.isEmpty()) {
            String message = "";
            if (name != null && nik != null) message = "Data Karyawan is not found";
            else if (name != null) message = "Name Karyawan is not found";
            else if (nik != null) message = "NIK Karyawan is not found";
            else message = "Data Karyawan is not found";
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "success",
                            message,
                            karyawanList
                    ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ResponseBodyUtil(
                            "success",
                            "Successfully get data karyawan",
                            karyawanList
                    ),
                    HttpStatus.OK);
        }
    }

    @PostMapping("/add_karyawan")
    public ResponseEntity<Object> addKaryawan(@RequestBody Karyawan karyawan) {
        List<Karyawan> karyawanList = karyawanService.findByNikList(karyawan.getNik());
        if(karyawanList.isEmpty()) {
            if(karyawan.getName() != "" && karyawan.getNik() != "") {
                Karyawan karyawanResult = karyawanService.createKaryawan(karyawan);
                return new ResponseEntity<>(
                    new ResponseBodyUtil(
                        "success",
                        "Karyawan has been successfully added"
                    ), HttpStatus.OK);
            } else {
                String message = "";
                if (karyawan.getName() == "") message = "Name Karyawan is required";
                else if (karyawan.getNik() == "") message = "Name Karyawan is required";
                return new ResponseEntity<>(
                        new ResponseBodyUtil(
                                "error",
                                message
                        ), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(
                new ResponseBodyUtil(
                    "error",
                    "NIK Karyawan is exists"
                ), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_karyawan/{nik}")
    public ResponseEntity<Object> updateKaryawan(@PathVariable("nik") String nik, @RequestBody Karyawan karyawan) {
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
    public ResponseEntity<Object> deleteKaryawanById(@PathVariable("nik") String nik) {
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
