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
public class Dakwah {
    String NIK = null;
    String PeranDak = null;
    String InstitusiDak = null;
    LocalDate TglDak = LocalDate.parse("0000-01-01");;
    
    public Dakwah(String _NIK, String _PeranDak,String _InstitusiDak, LocalDate _TglDak)
    {
        this.NIK = _NIK;
        this.PeranDak = _PeranDak;
        this.InstitusiDak = _InstitusiDak;
        this.TglDak = _TglDak;
    }

    public String getNIK() {
        return NIK;
    }

    public String getPeranDak() {
        return PeranDak;
    }

    public String getInstitusiDak() {
        return InstitusiDak;
    }

    public LocalDate getTglDak() {
        return TglDak;
    }
    
    
}
