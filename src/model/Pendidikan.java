/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author zain
 */
public class Pendidikan {
    String NIK = null;
    String Pendidikan = null;
    String Institusi = null;
    String thnLulus = null;
    
    public Pendidikan(String _NIK, String _Pendidikan,String _Institusi, String _thnLulus)
    {
        this.NIK = _NIK;
        this.Pendidikan = _Pendidikan;
        this.Institusi = _Institusi;
        this.thnLulus = _thnLulus;
    }    

    public String getNIK() {
        return NIK;
    }

    public String getPendidikan() {
        return Pendidikan;
    }

    public String getInstitusi() {
        return Institusi;
    }

    public String getThnLulus() {
        return thnLulus;
    }

    
}
