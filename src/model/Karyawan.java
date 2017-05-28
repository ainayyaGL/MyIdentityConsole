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
public class Karyawan {
    String NIK = null;
    String NamaKar = null;
    String  JKel= null;
    String TmpLahir = null;
    LocalDate TglLahir = LocalDate.parse("0000-01-01");
    String Agama = null;
    String PendTing = null;
    LocalDate TMT = LocalDate.parse ("0000-01-01");
    String PangGol = null;
    String Jab = null;
    LocalDate Today = LocalDate.parse("0000-01-01");
    String MasaKerja = null;
    LocalDate MPP = LocalDate.parse("0000-01-01");
    String umur = null;
    String StatKer = null;
    LocalDate pensiun = LocalDate.parse("0000-01-01");
    String UnitKer = null;
    String tlpn = null;
    String noHP = null;
    String email = null;
    String alamat = null;
    LocalDate skPer = LocalDate.parse("0000-01-01");
    String JabStruk = null;
    
    public Karyawan(String _nik, String _jkel, String _nama, String _tmplahir, LocalDate _tgllahir, String _agama, String _pendting, LocalDate _tmt, 
            String _panggol, String _jab, LocalDate _today, String _masaker, LocalDate _mpp, String _umur, String _statker, LocalDate _pensiun, String _unitker, 
            String _tlpn, String _nohp, String _email, String _alamat, LocalDate _skper, String _jabstruk){
        this.NIK = _nik;
        this.NamaKar = _nama;
        this.JKel = _jkel;
        this.TmpLahir = _tmplahir;
        this.TglLahir = _tgllahir;
        this.Agama = _agama;
        this.PendTing = _pendting;
        this.TMT = _tmt;
        this.PangGol = _panggol;
        this.Jab = _jab;
        this.Today = _today;
        this.MasaKerja = _masaker;
        this.MPP = _mpp;
        this.umur = _umur;
        this.StatKer = _statker;
        this.pensiun = _pensiun;
        this.UnitKer = _unitker;
        this.tlpn = _tlpn;
        this.noHP = _nohp;
        this.email = _email;
        this.alamat = _alamat;
        this.skPer = _skper;
        this.JabStruk = _jabstruk;
    }

    public String getNIK() {
        return NIK;
    }

    public String getNamaKar() {
        return NamaKar;
    }

    public String getJKel() {
        return JKel;
    }

    public String getTmpLahir() {
        return TmpLahir;
    }

    public LocalDate getTglLahir() {
        return TglLahir;
    }

    public String getAgama() {
        return Agama;
    }

    public String getPendTing() {
        return PendTing;
    }

    public LocalDate getTMT() {
        return TMT;
    }

    public String getPangGol() {
        return PangGol;
    }

    public String getJab() {
        return Jab;
    }

    public LocalDate getToday() {
        return Today;
    }

    public String getMasaKerja() {
        return MasaKerja;
    }

    public LocalDate getMPP() {
        return MPP;
    }

    public String getUmur() {
        return umur;
    }

    public String getStatKer() {
        return StatKer;
    }

    public LocalDate getPensiun() {
        return pensiun;
    }

    public String getUnitKer() {
        return UnitKer;
    }

    public String getTlpn() {
        return tlpn;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public LocalDate getSkPer() {
        return skPer;
    }

    public String getJabStruk() {
        return JabStruk;
    }

   
}