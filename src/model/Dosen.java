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
public class Dosen {
    String nama;
    String nik;
    String tmpLahir;
    LocalDate tglLahir = LocalDate.parse("0000-01-01");
    String JKel;
    String agama;
    String statusP;
    String pendT;
    String gol;
    String tmt;
    String telp;
    String noHp;
    String email;
    String alamat;

    public Dosen(String _nik, String _nama, String _tmpL, LocalDate _tglLahir, String _Jkel, String _agama, String _statusP, String _pendT, String _gol, String _tmt, String _telp, String _noHP, String _email, String _alamat ) {
    this.nik = _nik;
    this.nama = _nama;
    this.tmpLahir = _tmpL;
    this.tglLahir = _tglLahir;
    this.JKel=_Jkel;
    this.agama =  _agama;
    this.statusP = _statusP;
    this.pendT = _pendT;
    this.gol = _gol;
    this.tmt =  _tmt; 
    this.telp = _telp;
    this.noHp = _noHP;
    this.email = _email;
    this.alamat = _alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getTmpLahir() {
        return tmpLahir;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public String getJKel() {
        return JKel;
    }

    public String getAgama() {
        return agama;
    }

    public String getStatusP() {
        return statusP;
    }

    public String getPendT() {
        return pendT;
    }

    public String getGol() {
        return gol;
    }

    public String getTmt() {
        return tmt;
    }

    public String getTelp() {
        return telp;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

   
    
}
