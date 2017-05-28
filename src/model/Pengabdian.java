/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zain
 */
public class Pengabdian {
    String nik = null; 
    String PeranPeng = null;
    String InstPeng = null;
    LocalDate TglPeng = LocalDate.parse("0000-01-01");
    
    public Pengabdian(String _nik, String _peranpeng, String _instpeng, LocalDate _tglpeng)
    {
        this.nik = _nik;
        this.PeranPeng = _peranpeng;
        this.InstPeng = _instpeng;
        this.TglPeng = _tglpeng;
    }
    
    public String getNIK(){
        return nik;
    }
    public String getPeranPeng()
    {
        return PeranPeng;
    }
     public String getInstPeng()
    {
        return InstPeng;
    }
      public LocalDate getTglPeng()
    {
        return TglPeng;
    }
}
