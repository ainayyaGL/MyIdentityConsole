/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author zain
 */
public class KeluargaDosen {
    String NIK = null;
    String nama = null;
    String jKelamin = null;
    LocalDate tglLahir = LocalDate.parse("0000-01-01");;
    String sttKeluarga = null;
    String ditanggung = null;
    
    public KeluargaDosen(String _NIK, String _nama,String _jKelamin,LocalDate _tglLahir,String _sttKeluarga,
            String _ditanggung)
    {
        this.NIK = _NIK;
        this.nama = _nama;
        this.jKelamin = _jKelamin;
        this.tglLahir = _tglLahir;
        this.sttKeluarga = _sttKeluarga;
        this.ditanggung = _ditanggung;
    }

    public String getNIK() {
        return NIK;
    }

    public String getNama() {
        return nama;
    }

    public String getjKelamin() {
        return jKelamin;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public String getSttKeluarga() {
        return sttKeluarga;
    }

    public String getDitanggung() {
        return ditanggung;
    }
}
