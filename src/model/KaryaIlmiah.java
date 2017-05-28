/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class KaryaIlmiah { 
    String nik = null;
    String No = null;
    String Judul = null;
    String Peran = null;
    String Institusi = null;
    String sumberDana = null;
    String nilaiDana = null;
    String tahunPen = null;

    public KaryaIlmiah(String NIK, String no, String judul, String peran, String inst,
            String sDana, String nDana, String tahun) {
        nik = NIK;
        No = no;
        Judul = judul;
        Peran = peran;
        Institusi = inst;
        sumberDana = sDana;
        nilaiDana = nDana;
        tahunPen = tahun;
    }

    public String getNIK(){
     return nik;   
    }
    public String getNo() {
        return No;
    }

    public String getJudul() {
        return Judul;
    }

    public String getPeran() {
        return Peran;
    }

    public String getInstitusi() {
        return Institusi;
    }

    public String getSumberDana() {
        return sumberDana;
    }

    public String getNilaiDana() {
        return nilaiDana;
    }

    public String getTahunPen() {
        return tahunPen;
    }
    
    
}
