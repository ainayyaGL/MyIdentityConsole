/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.identity.console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Dosen;
import model.Karyawan;
import model.Pendidikan;
import model.Dakwah;
import model.Pengabdian;
import model.KaryaIlmiah;
import model.Penunjang;
import model.KeluargaDosen;
import model.KeluargaKaryawan;

import model.listKeluargaKaryawan;
import model.listDosenn;
import model.listKaryawan;
import model.listPendidikan;
import model.listDakwah;
import model.listPengabdian;
import model.listKarIl;
import model.listPenunjang;
import model.listKeluargaDosen;



import model.listDakwah;

/**
 *
 * @author USER
 */
public class MyIdentityConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String passAd, passCo, userAd, userCo, mu, jur, tempTglH, tempTglb, tempTglpe;
        String Pendidikan,Institusi,thnLulus; 
        String PeranDak,InstitusiDak, strTglDak, tempTglDak;
        LocalDate TglDak;
        Dakwah tempDakwah;
        String PeranPeng, InstPeng,strTglpe;
        LocalDate TglPeng;
        Pengabdian tempPng;
        String KegPen, PeranPen, InstPen, strTglpen, tempTglpen;
        LocalDate TglPen;
        Penunjang tempPnj;
        String No, Judul, Peran, InstitusiKarIl, sumberdana, nilaiDana, tahunPen;
        KaryaIlmiah tempKarIl;
        int jmlPend;
        int jmlAnggota;
        String namaKD,jKelaminKD,sttKeluargaKD,ditanggungKD, strTglLahirKD, tempTglKD;
        LocalDate tglLahirKD;
        KeluargaDosen tempKeluargaDosen;
        
        Boolean a = true;
        char pil;
        Scanner pi = new Scanner(System.in);
        boolean x = true;
        Pendidikan tempPendidikan;
        while (x){
                System.out.println("======= My Identity =======");
                System.out.println("Siapa Anda?");
                System.out.println("1. Admin");
                System.out.println("2. Co-Admin");
                System.out.print("Jawaban anda : ");
                pil = pi.next().toString().charAt(0);
                        
                        
                    switch(pil){
                        case '1' :
                        {
                            Scanner b = new Scanner(System.in);
                            boolean cek = true;
                            while (cek ){
                            System.out.print("Masukkan username : ");
                            userAd = b.nextLine();
                            System.out.print("Masukkan Password : ");
                            userCo = b.nextLine();
                            
                                if (userAd.equalsIgnoreCase("erna") && userCo.equalsIgnoreCase("12345")){
                                System.out.println("Selamat datang.");
                                cek = false;
                                boolean m = true;
                                while (m){
                                    menu :
                                    System.out.println("");
                                    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                                    System.out.println("");
                                    String MenuUtama =("Menu Utama : \n"
                                                        +"01. Dosen \n"
                                                        + "02. Karyawan \n"
                                                        +"x. Keluar \n");
                                                       
                                    System.out.println(MenuUtama);
                                    
                                    System.out.print("Jawaban anda : ");
                                    Scanner c = new Scanner(System.in);
                                    mu = c.nextLine();
                                    switch (mu)
                                    { case "01" : {
                                        
                                            char pilih;
                                            String namaD, nikD, tmpLahirD, strTglLahirD, tempTglD,JKelD, agamaD, statusPD, pendTD, golD, tmtD, telpD, noHPD, emailD, alamatD, RootElemenD, RowElemenD;
                                            LocalDate tglLahirD;
                                            Dosen tempDsnD;
                                            Boolean blmDisimpanD;

                                            DateTimeFormatter formatTanggal;
                                            formatTanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                            listDosenn larikDosen = new listDosenn();
                                            larikDosen.openXMLtoList(larikDosen);
                                            
                                            listKeluargaDosen larikKeluargaDosen = new listKeluargaDosen();
                                            larikKeluargaDosen.openXMLtoList(larikKeluargaDosen);
                                            
                                            listPendidikan larikPendidikan = new listPendidikan();
                                            larikPendidikan.openXMLtoList(larikPendidikan);
                                            
                                            listDakwah larikDakwah = new listDakwah();
                                            larikDakwah.openXMLtoList(larikDakwah);
                                            
                                            listPengabdian larikpengabdian = new listPengabdian();
                                            larikpengabdian.openXMLtoList(larikpengabdian);
                                            
                                            listPenunjang larikPenunjang = new listPenunjang();
                                            larikPenunjang.openXMLtoList(larikPenunjang);
                                            
                                            listKarIl larikKaryaIlmiah = new listKarIl();
                                            larikKaryaIlmiah.openXMLtoList(larikKaryaIlmiah);
                                            
                                            Scanner scChar = new Scanner(System.in);
                                            Scanner scString = new Scanner(System.in);
                                            Boolean lagi = true;
                                            blmDisimpanD = false;
                                            while (lagi) {
                                                System.out.println("PENGOLAHAN DATA DOSEN (karakter lain untuk Exit)");
                                                System.out.println("1. Tambah Data");
                                                System.out.println("2. Tampilkan Rincian Data");
                                                System.out.println("3. Hapus Data");
                                                System.out.println("4. Simpan Data");
                                                System.out.println("5. Kembali ke Menu Utama");
                                                System.out.println("s. Keluar");
                                                System.out.print("PILIHAN ANDA: "); 
                                                pilih = scChar.next().toString().charAt(0);


                                                switch (pilih){
                                                    case '1': {
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println("TAMBAH DATA BARU: "); 
                                                        System.out.print("NIK : "); 
                                                        nikD = scString.nextLine();
                                                        System.out.print("Nama : "); 
                                                        namaD = scString.nextLine();
                                                        System.out.print("Tempat Lahir : "); 
                                                        tmpLahirD = scString.nextLine();
                                                        System.out.print("Tanggal lahir (format dd-MM-yyyy) : "); 
                                                        strTglLahirD = scString.nextLine();
                                                        tempTglD = strTglLahirD.substring(6, 10)+"-"+strTglLahirD.substring(3, 5)+"-"+strTglLahirD.substring(0, 2);
                                                        tglLahirD = LocalDate.parse(tempTglD);
                                                        System.out.print("Jenis Kelamin : "); 
                                                        JKelD = scString.nextLine();
                                                        System.out.print("Agama : "); 
                                                        agamaD = scString.nextLine();
                                                        System.out.print("Status Pernikahan : "); 
                                                        statusPD = scString.nextLine();
                                                        System.out.print("Pendidikan Tertinggi : "); 
                                                        pendTD = scString.nextLine();
                                                        System.out.print("Golongan : "); 
                                                        golD = scString.nextLine();
                                                        System.out.print("TMT : "); 
                                                        tmtD = scString.nextLine();
                                                        System.out.print("Telepon : "); 
                                                        telpD = scString.nextLine();
                                                        System.out.print("No HP : "); 
                                                        noHPD = scString.nextLine();
                                                        System.out.print("Email : "); 
                                                        emailD = scString.nextLine();
                                                        System.out.print("Alamat : "); 
                                                        alamatD = scString.nextLine();
                                                        tempDsnD = new Dosen(nikD, namaD, tmpLahirD, tglLahirD, JKelD, agamaD, statusPD, pendTD, golD, tmtD, telpD, noHPD, emailD, alamatD);
                                                        larikDosen.nambahElemen(larikDosen, tempDsnD);
                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==KELUARGA==");
                                                            System.out.println("");    
                                                        System.out.print("Jumlah Anggota Keluarga : ");
                                                        Scanner scInt = new Scanner (System.in);
                                                        jmlAnggota = scInt.nextInt();
                                                        for (int i = 0;i < jmlAnggota ;i++){
                                                        System.out.print("Nama : "); 
                                                        namaKD = scString.nextLine();
                                                        System.out.print("Jenis Kelamin : "); 
                                                        jKelaminKD = scString.nextLine();
                                                        System.out.print("Tanggal Lahir (format dd-MM-yyyy) : "); 
                                                        strTglLahirKD = scString.nextLine();
                                                        tempTglKD = strTglLahirKD.substring(6, 10)+"-"+strTglLahirKD.substring(3, 5)+"-"+strTglLahirKD.substring(0, 2);
                                                        tglLahirKD = LocalDate.parse(tempTglKD);
                                                        System.out.print("Status Keluarga : "); 
                                                        sttKeluargaKD = scString.nextLine();
                                                        System.out.print("Ditanggung : "); 
                                                        ditanggungKD = scString.nextLine();
                                                        tempKeluargaDosen = new KeluargaDosen(nikD, namaKD,jKelaminKD,tglLahirKD,sttKeluargaKD,ditanggungKD);
                                                        larikKeluargaDosen.nambahElemen(larikKeluargaDosen, tempKeluargaDosen);
                                                        }
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENDIDIKAN==");
                                                            System.out.println("");    
                                                        System.out.print("Jumlah Pendidikan : ");
                                                        
                                                        jmlPend = scInt.nextInt();
                                                        for (int q = 0;q < jmlPend ;q++){
                                                            System.out.print("Tingkat Pendidikan : "); 
                                                            Pendidikan = scString.nextLine();
                                                            System.out.print("Institusi Pendidikan : "); 
                                                            Institusi = scString.nextLine();
                                                            System.out.print("Tahun Lulus : "); 
                                                            thnLulus = scString.nextLine();
                                                            tempPendidikan = new Pendidikan(nikD, Pendidikan,Institusi, thnLulus);
                                                            larikPendidikan.nambahElemen(larikPendidikan, tempPendidikan);
                                                            
                                                        }   
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==DAKWAH==");
                                                            System.out.println("");
                                                        System.out.print("Peran Dakwah : "); 
                                                        PeranDak = scString.nextLine();
                                                        System.out.print("Institusi Dakwah : "); 
                                                        InstitusiDak = scString.nextLine();
                                                        System.out.print("Tanggal Dakwah (format dd-MM-yyyy) : "); 
                                                        strTglDak = scString.nextLine();
                                                        tempTglDak = strTglDak.substring(6, 10)+"-"+strTglDak.substring(3, 5)+"-"+strTglDak.substring(0, 2);
                                                        TglDak = LocalDate.parse(tempTglDak);
                                                        tempDakwah = new Dakwah(nikD, PeranDak,InstitusiDak, TglDak);
                                                        larikDakwah.nambahElemen(larikDakwah, tempDakwah);
                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENGABDIAN==");
                                                            System.out.println("");
                                                        System.out.print("Peran Pengabdian : "); 
                                                        PeranPeng = scString.nextLine();
                                                        System.out.println("Institusi Pengabdian : ");
                                                        InstPeng = scString.nextLine();
                                                        System.out.print("Tanggal (format dd-MM-yyyy) : "); 
                                                        strTglpe = scString.nextLine();
                                                        tempTglb = strTglpe.substring(6, 10)+"-"+strTglpe.substring(3, 5)+"-"+strTglpe.substring(0, 2);
                                                        TglPeng = LocalDate.parse(tempTglb);
                                                        tempPng = new Pengabdian(nikD, PeranPeng, InstPeng, TglPeng);
                                                        larikpengabdian.nambahElemen(larikpengabdian, tempPng);
                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENUNJANG==");
                                                            System.out.println("");
                                                        System.out.print("Kegiatan : "); 
                                                        KegPen = scString.nextLine();
                                                        System.out.print("Peran : "); 
                                                        PeranPen = scString.nextLine();
                                                        System.out.print("Institusi : "); 
                                                        InstPen = scString.nextLine();
                                                        System.out.print("Tanggal Kegiatan (format dd-MM-yyyy) : "); 
                                                        strTglpen = scString.nextLine();
                                                        tempTglpen = strTglpen.substring(6, 10)+"-"+strTglpen.substring(3, 5)+"-"+strTglpen.substring(0, 2);
                                                        TglPen = LocalDate.parse(tempTglpen);
                                                        tempPnj = new Penunjang(nikD, KegPen, PeranPen, InstPen, TglPen);
                                                        larikPenunjang.nambahElemen(larikPenunjang, tempPnj);
                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==Karya Ilmiah==");
                                                            System.out.println("");
                                                        System.out.print("No : "); 
                                                        No = scString.nextLine();
                                                        System.out.print("Judul Karya Ilmiah : "); 
                                                        Judul = scString.nextLine();
                                                        System.out.print("Peran Karya Ilmiah : "); 
                                                        Peran = scString.nextLine();
                                                        System.out.print("Institusi : "); 
                                                        Institusi = scString.nextLine();
                                                        System.out.print("Sumber Dana : "); 
                                                        sumberdana = scString.nextLine();
                                                        System.out.print("Nilai Dana : "); 
                                                        nilaiDana = scString.nextLine();
                                                        System.out.print("Tahun Karya Ilmiah : "); 
                                                        tahunPen = scString.nextLine(); 
                                                        tempKarIl = new KaryaIlmiah(nikD, No , Judul, Peran, Institusi, sumberdana, nilaiDana, tahunPen);
                                                        larikKaryaIlmiah.nambahElemen(larikKaryaIlmiah, tempKarIl);
                                                        
                                                        
                                                        blmDisimpanD = true;
                                                        
                                                        if (blmDisimpanD) {
                                                               System.out.print("TERJADI PERUBAHAN DATA, MAU DISIMPAN (y/t)? "); 
                                                               pilih = scChar.next().toString().charAt(0);
                                                               if (pilih=='y'){
                                                                   larikDosen.saveDataToXML(larikDosen);
                                                                   larikKeluargaDosen.saveDataToXML(larikKeluargaDosen);
                                                                   larikPendidikan.saveDataToXML(larikPendidikan);
                                                                   larikDakwah.saveDataToXML(larikDakwah);
                                                                   larikpengabdian.saveDataToXML(larikpengabdian);
                                                                   larikPenunjang.saveDataToXML(larikPenunjang);
                                                                   larikKaryaIlmiah.saveDataToXML(larikKaryaIlmiah);
                                                               }
                                                            }
                                                            lagi = false;
                                                        
                                                    
                                                    }break;
                                                    case '2':{
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println("RINCIAN DATA DARI DOSEN: "); 
                                                        System.out.print("Masukkan NIK : "); 
                                                        nikD = scString.nextLine();
                                                        int posisi = larikDosen.cariElemen(nikD, larikDosen);
                                                        if (posisi < larikDosen.dos.size()){
                                                            System.out.println("Nama mahasiswa : "+larikDosen.dos.get(posisi).getNama());
                                                            LocalDate temp = larikDosen.dos.get(posisi).getTglLahir();
                                                            tempTglD = temp.format(formatTanggal);
                                                            System.out.println("NIK :"+nikD);
                                                            System.out.println("Tempat Lahir : "+larikDosen.dos.get(posisi).getTmpLahir());
                                                            System.out.println("Tanggal lahir  : "+tempTglD);
                                                            System.out.println("Jenis Kelamin : "+larikDosen.dos.get(posisi).getJKel());
                                                            System.out.println("Agama : "+larikDosen.dos.get(posisi).getAgama());
                                                            System.out.println("Status Pernikahan : "+larikDosen.dos.get(posisi).getStatusP());
                                                            System.out.println("Pendidikan Tertinggi : "+larikDosen.dos.get(posisi).getPendT());
                                                            System.out.println("Golongan :"+larikDosen.dos.get(posisi).getGol());
                                                            System.out.println("TMT : "+larikDosen.dos.get(posisi).getTmt());
                                                            System.out.println("Nomor Handphone :"+larikDosen.dos.get(posisi).getNoHp());
                                                            System.out.println("Email : "+larikDosen.dos.get(posisi).getEmail());
                                                            System.out.println("Alamat : "+larikDosen.dos.get(posisi).getAlamat());
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==KELUARGA==");
                                                            System.out.println("");
                                                            larikKeluargaDosen.pencarian(nikD, larikKeluargaDosen);
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENDIDIKAN==");
                                                            System.out.println("");
                                                            larikPendidikan.pencarian(nikD, larikPendidikan);
                                                                                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==DAKWAH==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikDakwah.cariElemen(nikD, larikDakwah);
                                                            if (posisi < larikDakwah.dakwah.size()){
                                                                System.out.println("Peran Dakwah : "+larikDakwah.dakwah.get(posisi).getPeranDak());
                                                                System.out.println("Institusi Dakwah : "+larikDakwah.dakwah.get(posisi).getInstitusiDak());
                                                                LocalDate tempH = larikDakwah.dakwah.get(posisi).getTglDak();
                                                                tempTglH = tempH.format(formatTanggal);
                                                                System.out.println("Tanggal Dakwah  : "+tempTglH);
                                                            } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENGABDIAN==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikpengabdian.cariElemen(nikD, larikpengabdian);
                                                            if (posisi < larikpengabdian.pengabdian.size()){
                                                                System.out.println("Peran Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                System.out.println("Institusi Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                LocalDate tempb = larikpengabdian.pengabdian.get(posisi).getTglPeng();
                                                                tempTglb = tempb.format(formatTanggal);
                                                                System.out.println("Tanggal Pengabdian  : "+tempTglb);
                                                            } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENUNJANG==");
                                                            System.out.println("");
                                                            
                                                           posisi = larikPenunjang.cariElemen(nikD, larikPenunjang);
                                                           if (posisi < larikPenunjang.penunjang.size()){
                                                               System.out.println("Kegiatan :" +larikPenunjang.penunjang.get(posisi).getKegPen());
                                                               System.out.println("Peran : " +larikPenunjang.penunjang.get(posisi).getPeranPen());
                                                               System.out.println("Insitusi : "+larikPenunjang.penunjang.get(posisi).getInstPen());
                                                               System.out.println("Tanggal Kegiatan : "+larikPenunjang.penunjang.get(posisi).getTglPen());
                                                               LocalDate temppen = larikPenunjang.penunjang.get(posisi).getTglPen();
                                                               tempTglpen = temppen.format(formatTanggal);
                                                               System.out.println("Tanggal Kegiatan: "+tempTglpen);
                                                           } else {
                                                               System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                           }
                                                           
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==Karya Ilmiah==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikKaryaIlmiah.cariElemen(nikD, larikKaryaIlmiah);
                                                            if (posisi < larikKaryaIlmiah.daftarPenelitian.size()){
                                                                System.out.println("Judul Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getJudul());
                                                                System.out.println("Peran Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getPeran());
                                                                System.out.println("Institusi : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getInstitusi());
                                                                System.out.println("Sumber Dana: "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getSumberDana());
                                                                System.out.println("Nilai Dana : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getNilaiDana());
                                                                System.out.println("Tahun Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getTahunPen());
                                                           } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            

                                                        } else {
                                                            System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                        }
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        
                                                    }break;
                                                    case '3' :{
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println("HAPUS DATA DOSEN: "); 
                                                        System.out.print("Masukkan NIK : "); 
                                                        nikD = scString.nextLine();
                                                        int posisi = larikDosen.cariElemen(nikD, larikDosen);
                                                        if (posisi < larikDosen.dos.size()){
                                                            System.out.println("Nama mahasiswa : "+larikDosen.dos.get(posisi).getNama());
                                                            LocalDate temp = larikDosen.dos.get(posisi).getTglLahir();
                                                            tempTglD = temp.format(formatTanggal);
                                                            System.out.println("NIK :"+nikD);
                                                            System.out.println("Tempat Lahir : "+larikDosen.dos.get(posisi).getTmpLahir());
                                                            System.out.println("Tanggal lahir  : "+tempTglD);
                                                            System.out.println("Jenis Kelamin : "+larikDosen.dos.get(posisi).getJKel());
                                                            System.out.println("Agama : "+larikDosen.dos.get(posisi).getAgama());
                                                            System.out.println("Status Pernikahan : "+larikDosen.dos.get(posisi).getStatusP());
                                                            System.out.println("Pendidikan Tertinggi : "+larikDosen.dos.get(posisi).getPendT());
                                                            System.out.println("Golongan :"+larikDosen.dos.get(posisi).getGol());
                                                            System.out.println("TMT : "+larikDosen.dos.get(posisi).getTmt());
                                                            System.out.println("Nomor Handphone :"+larikDosen.dos.get(posisi).getNoHp());
                                                            System.out.println("Email : "+larikDosen.dos.get(posisi).getEmail());
                                                            System.out.println("Alamat : "+larikDosen.dos.get(posisi).getAlamat());
                                                        }   
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==KELUARGA==");
                                                            System.out.println("");
                                                            larikKeluargaDosen.pencarian(nikD, larikKeluargaDosen);
                                                            
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENDIDIKAN==");
                                                            System.out.println("");
                                                            larikPendidikan.pencarian(nikD, larikPendidikan);
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==DAKWAH==");
                                                            System.out.println("");
                                                            posisi = larikDakwah.cariElemen(nikD, larikDakwah);
                                                            if (posisi < larikDakwah.dakwah.size()){
                                                                System.out.println("Peran Dakwah : "+larikDakwah.dakwah.get(posisi).getPeranDak());
                                                                System.out.println("Institusi Dakwah : "+larikDakwah.dakwah.get(posisi).getInstitusiDak());
                                                                LocalDate tempH = larikDakwah.dakwah.get(posisi).getTglDak();
                                                                tempTglH = tempH.format(formatTanggal);
                                                                System.out.println("Tanggal Dakwah  : "+tempTglH);
                                                            }   
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENGABDIAN==");
                                                            System.out.println("");
                                                                posisi = larikpengabdian.cariElemen(nikD, larikpengabdian);
                                                            if (posisi < larikpengabdian.pengabdian.size()){
                                                                System.out.println("Peran Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                System.out.println("Institusi Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                LocalDate tempb = larikpengabdian.pengabdian.get(posisi).getTglPeng();
                                                                tempTglb = tempb.format(formatTanggal);
                                                                System.out.println("Tanggal Pengabdian  : "+tempTglb);
                                                            } 
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENUNJANG==");
                                                            System.out.println("");
                                                            
                                                           posisi = larikPenunjang.cariElemen(nikD, larikPenunjang);
                                                           if (posisi < larikPenunjang.penunjang.size()){
                                                               System.out.println("Kegiatan :" +larikPenunjang.penunjang.get(posisi).getKegPen());
                                                               System.out.println("Peran : " +larikPenunjang.penunjang.get(posisi).getPeranPen());
                                                               System.out.println("Insitusi : "+larikPenunjang.penunjang.get(posisi).getInstPen());
                                                               System.out.println("Tanggal Kegiatan : "+larikPenunjang.penunjang.get(posisi).getTglPen());
                                                               LocalDate temppen = larikPenunjang.penunjang.get(posisi).getTglPen();
                                                               tempTglpen = temppen.format(formatTanggal);
                                                               System.out.println("Tanggal Kegiatan: "+tempTglpen);
                                                           } 
                                                           
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==Karya Ilmiah==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikKaryaIlmiah.cariElemen(nikD, larikKaryaIlmiah);
                                                            if (posisi < larikKaryaIlmiah.daftarPenelitian.size()){
                                                                System.out.println("Judul Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getJudul());
                                                                System.out.println("Peran Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getPeran());
                                                                System.out.println("Institusi : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getInstitusi());
                                                                System.out.println("Sumber Dana: "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getSumberDana());
                                                                System.out.println("Nilai Dana : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getNilaiDana());
                                                                System.out.println("Tahun Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getTahunPen());
                                                           }
                                                            System.out.print("DATA DI ATAS YAKIN DIHAPUS (y/t)? ");
                                                            char yakin = scChar.next().charAt(0);
                                                            if (yakin=='y'){
                                                                larikDosen.dos.remove(posisi);
                                                                larikKeluargaDosen.keluargaDosen.remove(posisi);
                                                                larikPendidikan.pendidikan.remove(posisi);
                                                                larikDakwah.dakwah.remove(posisi);
                                                                larikpengabdian.pengabdian.remove(posisi);
                                                                larikPenunjang.penunjang.remove(posisi);
                                                                larikKaryaIlmiah.daftarPenelitian.remove(posisi);
                                                                blmDisimpanD = true;
                                                            }
                                                         else {
                                                            System.out.println("DATA YANG AKAN DIHAPUS TIDAK ADA"); 
                                                        }
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        break;

                                                        
                                                    }
                                                
                                                    case '4':{
                                                        System.out.println("SIMPAN DATA KE XML "); 

                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                        larikDosen.saveDataToXML(larikDosen);
                                                        larikKeluargaDosen.saveDataToXML(larikKeluargaDosen);
                                                        larikPendidikan.saveDataToXML(larikPendidikan);
                                                        larikDakwah.saveDataToXML(larikDakwah);
                                                        larikpengabdian.saveDataToXML(larikpengabdian);
                                                        larikPenunjang.saveDataToXML(larikPenunjang);
                                                        larikKaryaIlmiah.saveDataToXML(larikKaryaIlmiah);
                                                        blmDisimpanD = false;
                                                        break;
                                                    }
                                                    case 's' : {
                                                        lagi = false;
                                                        x = false;
                                                        m = false;
                                                    } break;
                                                    case '5' :{
                                                         m = true;
                                                        //m = true;
                                                        //lagi = false;
                                                        System.out.println(MenuUtama);
                                                        System.out.print("Jawaban anda : ");
                                                        mu = c.nextLine();
                                                       lagi = true;
                                                        
                                                        
                                                    } break;
                                                    default : {
                                                            System.out.println("");
                                                            System.out.println("Input yang anda masukkan salah!");
                                                            lagi = true;
                                                    } 
                                            
                                                        
                                                }

                                            } 
                                            m = false;
                                    }break;
                                    case "02" :  {
                                                    char pilihi;
                                                    String NIK, Nama, JKel, tempTgl, tmpLahir, agama, pendTing, pangkat, jab, MasaKerja, umur, Statker, UnitKer, tlpn, hp, email,alamat, JabStruk,strTglLahir,strTMT, tempTMT, strToday, tempToday,strMPP, tempMPP, strpensiun, temppensiun, strskPer, tempskPer;
                                                    LocalDate tglLahir, TMT, today, MPP, pensiun, skPer;
                                                    Karyawan tempKry;
                                                    Boolean blmDisimpan;
                                                    
                                                    int jmlAnggotaKr;
                                                    String namaKr,jKelaminKr,sttKeluargaKr,ditanggungKr, strTglLahirKr, tempTglKr;
                                                    LocalDate tglLahirKr;
                                                    KeluargaKaryawan tempKeluargaKaryawan;
                                                    
                                                    listKeluargaKaryawan larikKeluargaKaryawan = new listKeluargaKaryawan();
                                                    larikKeluargaKaryawan.openXMLtoList(larikKeluargaKaryawan);
        
                                                    DateTimeFormatter formatTanggall;
                                                    formatTanggall = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                                    listKaryawan larikKaryawan = new listKaryawan();
                                                    larikKaryawan.openXMLtoList(larikKaryawan);
                                                    Scanner scCharr = new Scanner(System.in);
                                                    Scanner scStringg = new Scanner(System.in);
                                                    Boolean lagii = true;
                                                    blmDisimpan = false;
                                                    while (lagii) {
                                                        System.out.println("PENGOLAHAN KARYAWAN");
                                                        System.out.println("1. Tambah Data");
                                                        System.out.println("2. Tampilkan Rincian Data");
                                                        System.out.println("3. Hapus Data");
                                                        System.out.println("4. Simpan Data");
                                                        System.out.println("5. Kembali ke Menu Utama");
                                                        System.out.println("s. keluar");
                                                        System.out.print("PILIHAN ANDA: "); 
                                                        pilihi = scCharr.next().toString().charAt(0);


                                                        switch (pilihi){
                                                            case '1': {
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println("TAMBAH DATA BARU: "); 
                                                                System.out.print("NIK : "); 
                                                                NIK = scStringg.nextLine();
                                                                System.out.print("Nama : "); 
                                                                Nama = scStringg.nextLine();
                                                                System.out.print("Jenis Kelamin : "); 
                                                                JKel = scStringg.nextLine();
                                                                System.out.print("Tempat Lahir : "); 
                                                                tmpLahir = scStringg.nextLine();
                                                                System.out.print("Tanggal lahir (format dd-MM-yyyy) : "); 
                                                                strTglLahir = scStringg.nextLine();
                                                                tempTgl = strTglLahir.substring(6, 10)+"-"+strTglLahir.substring(3, 5)+"-"+strTglLahir.substring(0, 2);
                                                                tglLahir = LocalDate.parse(tempTgl);
                                                                System.out.print("Agama : "); 
                                                                agama = scStringg.nextLine();
                                                                System.out.print("Pendidikan Tertinggi : "); 
                                                                pendTing = scStringg.nextLine();
                                                                System.out.print("TMT (format dd-MM-yyyy) : "); 
                                                                strTMT = scStringg.nextLine();
                                                                tempTMT = strTMT.substring(6, 10)+"-"+strTMT.substring(3, 5)+"-"+strTMT.substring(0, 2);
                                                                TMT = LocalDate.parse(tempTMT);
                                                                System.out.print("Pangkat Golongan : "); 
                                                                pangkat = scStringg.nextLine();
                                                                System.out.print("Jabatan : "); 
                                                                jab = scStringg.nextLine();
                                                                System.out.print("Today (format dd-MM-yyyy) : "); 
                                                                strToday = scStringg.nextLine();
                                                                tempToday = strToday.substring(6, 10)+"-"+strToday.substring(3, 5)+"-"+strToday.substring(0, 2);
                                                                today = LocalDate.parse(tempToday);
                                                                System.out.print("Masa Kerja : "); 
                                                                MasaKerja = scStringg.nextLine();
                                                                System.out.print("MPP (format dd-MM-yyyy) : "); 
                                                                strMPP = scStringg.nextLine();
                                                                tempMPP = strMPP.substring(6, 10)+"-"+strMPP.substring(3, 5)+"-"+strMPP.substring(0, 2);
                                                                MPP = LocalDate.parse(tempMPP);
                                                                System.out.print("Umur : "); 
                                                                umur = scStringg.nextLine();
                                                                System.out.print("Status Kerja : "); 
                                                                Statker = scStringg.nextLine();
                                                                System.out.print("Pensiun (format dd-MM-yyyy) : "); 
                                                                strpensiun = scStringg.nextLine();
                                                                temppensiun = strpensiun.substring(6, 10)+"-"+strpensiun.substring(3, 5)+"-"+strTglLahir.substring(0, 2);
                                                                pensiun = LocalDate.parse(temppensiun);
                                                                System.out.print("Unit Kerja : "); 
                                                                UnitKer = scStringg.nextLine();
                                                                System.out.print("Telepon : "); 
                                                                tlpn = scStringg.nextLine();
                                                                System.out.print("Nomor Handphone  : "); 
                                                                hp = scStringg.nextLine();
                                                                System.out.print("Email : "); 
                                                                email = scStringg.nextLine();
                                                                System.out.print("Alamat : "); 
                                                                alamat = scStringg.nextLine();
                                                                System.out.print("SK pertama (format dd-MM-yyyy) : "); 
                                                                strskPer = scStringg.nextLine();
                                                                tempskPer = strskPer.substring(6, 10)+"-"+strskPer.substring(3, 5)+"-"+strskPer.substring(0, 2);
                                                                skPer = LocalDate.parse(tempskPer);
                                                                System.out.print("Jabatan Struktural : "); 
                                                                JabStruk = scStringg.nextLine();
                                                                tempKry = new Karyawan(NIK, Nama, JKel, tmpLahir,tglLahir ,agama,pendTing, TMT, pangkat, jab, today, MasaKerja, MPP, umur, Statker, pensiun, UnitKer, tlpn, hp, email,alamat, skPer, JabStruk);
                                                                larikKaryawan.nambahElemen(larikKaryawan, tempKry);
                                                                
                                                                System.out.println("");
                                                                System.out.println("");
                                                                System.out.println("==KELUARGA==");
                                                                System.out.println("");
                                                                System.out.print("Jumlah Anggota Keluarga : ");
                                                                Scanner scInt = new Scanner (System.in);
                                                                jmlAnggota = scInt.nextInt();
                                                                for (int i = 0;i < jmlAnggota ;i++){
                                                                System.out.print("Nama : "); 
                                                                namaKr = scStringg.nextLine();
                                                                System.out.print("Jenis Kelamin : "); 
                                                                jKelaminKr = scStringg.nextLine();
                                                                System.out.print("Tanggal Lahir (format dd-MM-yyyy) : "); 
                                                                strTglLahirKr = scStringg.nextLine();
                                                                tempTgl = strTglLahirKr.substring(6, 10)+"-"+strTglLahirKr.substring(3, 5)+"-"+strTglLahirKr.substring(0, 2);
                                                                tglLahirKr = LocalDate.parse(tempTgl);
                                                                System.out.print("Status Keluarga : "); 
                                                                sttKeluargaKr = scStringg.nextLine();
                                                                System.out.print("Ditanggung : "); 
                                                                ditanggungKr = scStringg.nextLine();
                                                                tempKeluargaKaryawan = new KeluargaKaryawan(NIK, namaKr,jKelaminKr,tglLahirKr,sttKeluargaKr,ditanggungKr);
                                                                larikKeluargaKaryawan.nambahElemen(larikKeluargaKaryawan, tempKeluargaKaryawan);
                                                                }
                                                                
                                                                blmDisimpan = true;
                                                                if (blmDisimpan) {
                                                                       System.out.print("TERJADI PERUBAHAN DATA, MAU DISIMPAN (y/t)? "); 
                                                                       pilihi = scCharr.next().toString().charAt(0);
                                                                       if (pilihi=='y'){
                                                                           larikKaryawan.saveDataToXML(larikKaryawan);
                                                                           larikKeluargaKaryawan.saveDataToXML(larikKeluargaKaryawan);
                                                                       }
                                                                    }
                                                                
                                                            }break;
                                                            case '2':{
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println("RINCIAN DATA DARI KARYAWAN: "); 
                                                                System.out.print("Masukkan NIK : "); 
                                                                NIK = scStringg.nextLine();
                                                                int posisi = larikKaryawan.cariElemen(NIK, larikKaryawan);
                                                                if (posisi < larikKaryawan.kar.size()){
                                                                    System.out.println("Nama karyawan : "+larikKaryawan.kar.get(posisi).getNamaKar());
                                                                    System.out.println("Jenis Kelamin : " +larikKaryawan.kar.get(posisi).getJKel());
                                                                    System.out.println("Tempat Lahir : " +larikKaryawan.kar.get(posisi).getTmpLahir());
                                                                    LocalDate temp = larikKaryawan.kar.get(posisi).getTglLahir();
                                                                    tempTgl = temp.format(formatTanggall);
                                                                    System.out.println("Tanggal lahir  : "+tempTgl);
                                                                    System.out.println("Agama : " +larikKaryawan.kar.get(posisi).getAgama());
                                                                    System.out.println("Pendidikan Tertinggi : " +larikKaryawan.kar.get(posisi).getPendTing());
                                                                    LocalDate tempT = larikKaryawan.kar.get(posisi).getTMT();
                                                                    tempTMT = tempT.format(formatTanggall);
                                                                    System.out.println("TMT  : "+tempTMT);
                                                                    System.out.println("Pangkat/Golongan : " +larikKaryawan.kar.get(posisi).getPangGol());
                                                                    System.out.println("Jabatan : " +larikKaryawan.kar.get(posisi).getJab());
                                                                    LocalDate tempTo = larikKaryawan.kar.get(posisi).getToday();
                                                                    tempToday = tempTo.format(formatTanggall);
                                                                    System.out.println("Today  : "+tempToday);
                                                                    System.out.println("Masa Kerja : " +larikKaryawan.kar.get(posisi).getMasaKerja());
                                                                    LocalDate tempM = larikKaryawan.kar.get(posisi).getMPP();
                                                                    tempMPP = tempM.format(formatTanggall);
                                                                    System.out.println("MPP  : "+tempMPP);
                                                                    System.out.println("Umur : " +larikKaryawan.kar.get(posisi).getUmur());
                                                                    System.out.println("Status Kerja : " +larikKaryawan.kar.get(posisi).getStatKer());
                                                                    LocalDate temppen = larikKaryawan.kar.get(posisi).getPensiun();
                                                                    temppensiun = temppen.format(formatTanggall);
                                                                    System.out.println("Pensiun  : "+temppensiun);
                                                                    System.out.println("UnitKerja : " +larikKaryawan.kar.get(posisi).getUnitKer());
                                                                    System.out.println("Telepon : " +larikKaryawan.kar.get(posisi).getTlpn());
                                                                    System.out.println("Nomor Handphone : " +larikKaryawan.kar.get(posisi).getNoHP());
                                                                    System.out.println("Email : " +larikKaryawan.kar.get(posisi).getEmail());
                                                                    System.out.println("Alamat : " +larikKaryawan.kar.get(posisi).getAlamat());
                                                                    LocalDate tempsk = larikKaryawan.kar.get(posisi).getSkPer();
                                                                    tempskPer = tempsk.format(formatTanggall);
                                                                    System.out.println("SK Pertama  : "+tempskPer);
                                                                    System.out.println("Jabatan Struktural : " +larikKaryawan.kar.get(posisi).getJabStruk());
                                                                    
                                                                    System.out.println("");
                                                                    System.out.println("");
                                                                    System.out.println("==KELUARGA==");
                                                                    System.out.println("");
                                                                    larikKeluargaKaryawan.pencarian(NIK, larikKeluargaKaryawan);
                                                                } else {
                                                                    System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                                }
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                
                                                            } break;
                                                            case '3' :{
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println("HAPUS DATA KARYAWAN: "); 
                                                                System.out.print("Masukkan NIK : "); 
                                                                NIK = scStringg.nextLine();
                                                                int posisi = larikKaryawan.cariElemen(NIK, larikKaryawan);
                                                                if (posisi < larikKaryawan.kar.size()){
                                                                    System.out.println("Nama karyawan : "+larikKaryawan.kar.get(posisi).getNamaKar());
                                                                    System.out.print("Jenis Kelamin : " +larikKaryawan.kar.get(posisi).getJKel());
                                                                    System.out.print("Tempat Lahir : " +larikKaryawan.kar.get(posisi).getTmpLahir());
                                                                    LocalDate temp = larikKaryawan.kar.get(posisi).getTglLahir();
                                                                    tempTgl = temp.format(formatTanggall);
                                                                    System.out.println("Tanggal lahir  : "+tempTgl);
                                                                    System.out.print("Agama : " +larikKaryawan.kar.get(posisi).getAgama());
                                                                    System.out.print("Pendidikan Tertinggi : " +larikKaryawan.kar.get(posisi).getPendTing());
                                                                    LocalDate tempT = larikKaryawan.kar.get(posisi).getTMT();
                                                                    tempTMT = tempT.format(formatTanggall);
                                                                    System.out.println("TMT  : "+tempTMT);
                                                                    System.out.print("Pangkat/Golongan : " +larikKaryawan.kar.get(posisi).getPangGol());
                                                                    System.out.print("Jabatan : " +larikKaryawan.kar.get(posisi).getJab());
                                                                    LocalDate tempTo = larikKaryawan.kar.get(posisi).getToday();
                                                                    tempToday = tempTo.format(formatTanggall);
                                                                    System.out.println("Today  : "+tempToday);
                                                                    System.out.print("Masa Kerja : " +larikKaryawan.kar.get(posisi).getMasaKerja());
                                                                    LocalDate tempM = larikKaryawan.kar.get(posisi).getMPP();
                                                                    tempMPP = tempM.format(formatTanggall);
                                                                    System.out.println("MPP  : "+tempMPP);
                                                                    System.out.print("Umur : " +larikKaryawan.kar.get(posisi).getUmur());
                                                                    System.out.print("Status Kerja : " +larikKaryawan.kar.get(posisi).getStatKer());
                                                                    LocalDate temppen = larikKaryawan.kar.get(posisi).getPensiun();
                                                                    temppensiun = temppen.format(formatTanggall);
                                                                    System.out.println("Pensiun  : "+temppensiun);
                                                                    System.out.print("UnitKerja : " +larikKaryawan.kar.get(posisi).getUnitKer());
                                                                    System.out.print("Telepon : " +larikKaryawan.kar.get(posisi).getTlpn());
                                                                    System.out.print("Nomor Handphone : " +larikKaryawan.kar.get(posisi).getNoHP());
                                                                    System.out.print("Email : " +larikKaryawan.kar.get(posisi).getEmail());
                                                                    System.out.print("Alamat : " +larikKaryawan.kar.get(posisi).getAlamat());
                                                                    LocalDate tempsk = larikKaryawan.kar.get(posisi).getSkPer();
                                                                    tempskPer = tempsk.format(formatTanggall);
                                                                    System.out.println("SK Pertama  : "+tempskPer);
                                                                    System.out.print("Jabatan Struktural : " +larikKaryawan.kar.get(posisi).getJabStruk());
                                                                    
                                                                    System.out.println("");
                                                                    System.out.println("");
                                                                    System.out.println("==KELUARGA==");
                                                                    System.out.println("");
                                                                    larikKeluargaKaryawan.pencarian(NIK, larikKeluargaKaryawan);
                                                                    
                                                                    System.out.print("DATA DI ATAS YAKIN DIHAPUS (y/t)? ");
                                                                    char yakin = scCharr.next().charAt(0);
                                                                    if (yakin=='y'){
                                                                        larikKaryawan.kar.remove(posisi);
                                                                        larikKeluargaKaryawan.keluargaKaryawan.remove(posisi);
                                                                        blmDisimpan = true;
                                                                    }
                                                                } else {
                                                                    System.out.println("DATA YANG AKAN DIHAPUS TIDAK ADA"); 
                                                                }
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                lagii = true;

                                                            }break;
                                                            case '4':{
                                                                System.out.println("SIMPAN DATA KE XML "); 

                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                larikKaryawan.saveDataToXML(larikKaryawan);
                                                                larikKeluargaKaryawan.saveDataToXML(larikKeluargaKaryawan);
                                                                blmDisimpan = false;
                                                                
                                                            }break;
                                                            case '5' : {
                                                                    m = true;
                                                                   System.out.println(MenuUtama);
                                                                    System.out.print("Jawaban anda : ");
                                                                    mu = c.nextLine();
                                                                    lagii = true;
                                                                    break;
                                                            }
                                                            case 's' : {
                                                                lagii = false;
                                                                x = false;
                                                                m = false;
                                                                
                                                            } break;
                                                            default : {
                                                                    System.out.println("");
                                                                    System.out.println("Input yang anda masukkan salah!");
                                                                    System.out.println("");
                                                                    lagii = true;
                                                                       }
                                                                    }
  
                                                             
                                                        }

                                                     
                                    }break;
                                    
                                    case "x" : {
                                            x=false;
                                            m=false;
                                    }break;       
                                    default : 
                                        System.out.println("input anda salah!");
                                        System.out.println("");
                                        m = true;
                                    }
                                }
                                    
                                 
                                }  
                        else {
                                System.out.println("Username / password anda salah");
                                cek = true;
                                    }
                        } 
                    
                        }
                    break;
//CO ADMIN
                        case '2' : {
                            Scanner e = new Scanner(System.in);
                            boolean cekk = true;
                            while (cekk){
                            System.out.print("Masukkan username :");
                            userAd = e.nextLine();
                            System.out.print("Masukkan Password : ");
                            userCo = e.nextLine();
                            
                            if (userAd.equalsIgnoreCase("kajur") && userCo.equalsIgnoreCase("123")){
                                System.out.println("Selamat datang.");
                                cekk = false;
                                boolean y = true;
                                String namaD, nikD, tmpLahirD, strTglLahirD, tempTglD,JKelD, agamaD, statusPD, pendTD, golD, tmtD, telpD, noHPD, emailD, alamatD, RootElemenD, RowElemenD;
                                            LocalDate tglLahirD;
                                            Dosen tempDsnD;
                                            Boolean blmDisimpanD;

                                            DateTimeFormatter formatTanggal;
                                            formatTanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                            listDosenn larikDosen = new listDosenn();
                                            larikDosen.openXMLtoList(larikDosen);
                                            
                                            listKeluargaDosen larikKeluargaDosen = new listKeluargaDosen();
                                            larikKeluargaDosen.openXMLtoList(larikKeluargaDosen);
                                            
                                            listPendidikan larikPendidikan = new listPendidikan();
                                            larikPendidikan.openXMLtoList(larikPendidikan);
                                            
                                            listDakwah larikDakwah = new listDakwah();
                                            larikDakwah.openXMLtoList(larikDakwah);
                                            
                                            listPengabdian larikpengabdian = new listPengabdian();
                                            larikpengabdian.openXMLtoList(larikpengabdian);
                                            
                                            listPenunjang larikPenunjang = new listPenunjang();
                                            larikPenunjang.openXMLtoList(larikPenunjang);
                                            
                                            listKarIl larikKaryaIlmiah = new listKarIl();
                                            larikKaryaIlmiah.openXMLtoList(larikKaryaIlmiah);
                                            
                                            Scanner scChar = new Scanner(System.in);
                                            Scanner scString = new Scanner(System.in);
                                while(y==true){
                                
                                    System.out.println("");
                                    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                                    System.out.println("");
                                    String MenuUtamaC =("Menu Utama : \n"
                                                        +"01. Dosen \n"
                                                        + "02. Karyawan \n"
                                                        +"xx. Keluar \n");
                                                       
                                    System.out.println(MenuUtamaC);
                                    
                                    System.out.print("Jawaban anda : ");
                                    Scanner c = new Scanner(System.in);
                                    String muC;
                                    muC = c.nextLine();
                                    char pilihC;
                                    switch (muC) { 
                                        case "01" : {
                                            boolean lagiC = true;
                                            while(lagiC){
                                                System.out.println("PENGOLAHAN DATA DOSEN (karakter lain untuk Exit)");
                                                System.out.println("1. Tampilkan Rincian Data");
                                                System.out.println("2. Kembali ke Menu Utama");
                                                System.out.println("s. Keluar");
                                                System.out.print("PILIHAN ANDA: "); 
                                                pilihC =    c.next().toString().charAt(0);
                                                
                                                switch(pilihC){
                                                    case '1':{
                                                        System.out.println();
                                                       System.out.println();
                                                        System.out.println();
                                                        System.out.println("RINCIAN DATA DARI DOSEN: "); 
                                                        System.out.print("Masukkan NIK : "); 
                                                        nikD = scString.nextLine();
                                                        int posisi = larikDosen.cariElemen(nikD, larikDosen);
                                                        if (posisi < larikDosen.dos.size()){
                                                            System.out.println("Nama mahasiswa : "+larikDosen.dos.get(posisi).getNama());
                                                            LocalDate temp = larikDosen.dos.get(posisi).getTglLahir();
                                                            tempTglD = temp.format(formatTanggal);
                                                            System.out.println("NIK :"+nikD);
                                                            System.out.println("Tempat Lahir : "+larikDosen.dos.get(posisi).getTmpLahir());
                                                            System.out.println("Tanggal lahir  : "+tempTglD);
                                                            System.out.println("Jenis Kelamin : "+larikDosen.dos.get(posisi).getJKel());
                                                            System.out.println("Agama : "+larikDosen.dos.get(posisi).getAgama());
                                                            System.out.println("Status Pernikahan : "+larikDosen.dos.get(posisi).getStatusP());
                                                            System.out.println("Pendidikan Tertinggi : "+larikDosen.dos.get(posisi).getPendT());
                                                            System.out.println("Golongan :"+larikDosen.dos.get(posisi).getGol());
                                                            System.out.println("TMT : "+larikDosen.dos.get(posisi).getTmt());
                                                            System.out.println("Nomor Handphone :"+larikDosen.dos.get(posisi).getNoHp());
                                                            System.out.println("Email : "+larikDosen.dos.get(posisi).getEmail());
                                                            System.out.println("Alamat : "+larikDosen.dos.get(posisi).getAlamat());
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==KELUARGA==");
                                                            System.out.println("");
                                                            larikKeluargaDosen.pencarian(nikD, larikKeluargaDosen);
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENDIDIKAN==");
                                                            System.out.println("");
                                                            larikPendidikan.pencarian(nikD, larikPendidikan);
                                                                                                                        
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==DAKWAH==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikDakwah.cariElemen(nikD, larikDakwah);
                                                            if (posisi < larikDakwah.dakwah.size()){
                                                                System.out.println("Peran Dakwah : "+larikDakwah.dakwah.get(posisi).getPeranDak());
                                                                System.out.println("Institusi Dakwah : "+larikDakwah.dakwah.get(posisi).getInstitusiDak());
                                                                LocalDate tempH = larikDakwah.dakwah.get(posisi).getTglDak();
                                                                tempTglH = tempH.format(formatTanggal);
                                                                System.out.println("Tanggal Dakwah  : "+tempTglH);
                                                            } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENGABDIAN==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikpengabdian.cariElemen(nikD, larikpengabdian);
                                                            if (posisi < larikpengabdian.pengabdian.size()){
                                                                System.out.println("Peran Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                System.out.println("Institusi Pengabdian : "+larikpengabdian.pengabdian.get(posisi).getPeranPeng());
                                                                LocalDate tempb = larikpengabdian.pengabdian.get(posisi).getTglPeng();
                                                                tempTglb = tempb.format(formatTanggal);
                                                                System.out.println("Tanggal Pengabdian  : "+tempTglb);
                                                            } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==PENUNJANG==");
                                                            System.out.println("");
                                                            
                                                           posisi = larikPenunjang.cariElemen(nikD, larikPenunjang);
                                                           if (posisi < larikPenunjang.penunjang.size()){
                                                               System.out.println("Kegiatan :" +larikPenunjang.penunjang.get(posisi).getKegPen());
                                                               System.out.println("Peran : " +larikPenunjang.penunjang.get(posisi).getPeranPen());
                                                               System.out.println("Insitusi : "+larikPenunjang.penunjang.get(posisi).getInstPen());
                                                               System.out.println("Tanggal Kegiatan : "+larikPenunjang.penunjang.get(posisi).getTglPen());
                                                               LocalDate temppen = larikPenunjang.penunjang.get(posisi).getTglPen();
                                                               tempTglpen = temppen.format(formatTanggal);
                                                               System.out.println("Tanggal Kegiatan: "+tempTglpen);
                                                           } else {
                                                               System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                           }
                                                           
                                                            System.out.println("");
                                                            System.out.println("");
                                                            System.out.println("==Karya Ilmiah==");
                                                            System.out.println("");
                                                            
                                                            posisi = larikKaryaIlmiah.cariElemen(nikD, larikKaryaIlmiah);
                                                            if (posisi < larikKaryaIlmiah.daftarPenelitian.size()){
                                                                System.out.println("Judul Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getJudul());
                                                                System.out.println("Peran Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getPeran());
                                                                System.out.println("Institusi : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getInstitusi());
                                                                System.out.println("Sumber Dana: "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getSumberDana());
                                                                System.out.println("Nilai Dana : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getNilaiDana());
                                                                System.out.println("Tahun Karya Ilmiah : "+larikKaryaIlmiah.daftarPenelitian.get(posisi).getTahunPen());
                                                           } else {
                                                                System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                            }
                                                            

                                                        } else {
                                                            System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                        }
                                                        System.out.println();
                                                        System.out.println();
                                                        System.out.println();
                                                } break;
                                                
                                                    case '2' : {
                                                        
                                                        y = true;
                                                        System.out.println(MenuUtamaC);
                                                        System.out.print("Jawaban anda : ");
                                                        muC = c.nextLine();
                                                        lagiC = true;
                                                    }break;
                                                    
                                                    case 's' : {
                                                        lagiC = false;
                                                                x=false;
                                                                y=false;
                                                                break;                                                        
                                                      
                                                    }
                                                    default : 
                                                        System.out.println("");
                                                        System.out.println("Input anda salah!");
                                                        System.out.println("");
                                                        lagiC = true;
                                                        break;
                                            }
                                    }    
                                }
                                    case "02" : {
                                        boolean lagiCo = true;
                                                    String NIK, Nama, JKel, tempTgl, tmpLahir, agama, pendTing, pangkat, jab, MasaKerja, umur, Statker, UnitKer, tlpn, hp, email,alamat, JabStruk,strTglLahir,strTMT, tempTMT, strToday, tempToday,strMPP, tempMPP, strpensiun, temppensiun, strskPer, tempskPer;
                                                    LocalDate tglLahir, TMT, today, MPP, pensiun, skPer;
                                                    Karyawan tempKry;
                                                                                                        
                                                    int jmlAnggotaKr;
                                                    String namaKr,jKelaminKr,sttKeluargaKr,ditanggungKr, strTglLahirKr, tempTglKr;
                                                    LocalDate tglLahirKr;
                                                    KeluargaKaryawan tempKeluargaKaryawan;
                                                    
                                                    listKeluargaKaryawan larikKeluargaKaryawan = new listKeluargaKaryawan();
                                                    larikKeluargaKaryawan.openXMLtoList(larikKeluargaKaryawan);
        
                                                    DateTimeFormatter formatTanggall;
                                                    formatTanggall = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                                    listKaryawan larikKaryawan = new listKaryawan();
                                                    larikKaryawan.openXMLtoList(larikKaryawan);
                                                    Scanner scCharr = new Scanner(System.in);
                                                    Scanner scStringg = new Scanner(System.in);
                                                    
                                                    while(lagiCo){
                                                        char pilihiC;
                                                        System.out.println("PENGOLAHAN KARYAWAN (karakter lain untuk Exit)");
                                                        System.out.println("1. Tampilkan Rincian Data");
                                                        System.out.println("2. Kembali Menu Utama");
                                                        System.out.println("s. keluar");
                                                        System.out.print("PILIHAN ANDA: "); 
                                                        pilihiC = scCharr.next().toString().charAt(0);
                                                        
                                                        switch(pilihiC){
                                                            case '1' : {
                                                             System.out.println();
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println("RINCIAN DATA DARI KARYAWAN: "); 
                                                                System.out.print("Masukkan NIK : "); 
                                                                NIK = scStringg.nextLine();
                                                                int posisi = larikKaryawan.cariElemen(NIK, larikKaryawan);
                                                                if (posisi < larikKaryawan.kar.size()){
                                                                    System.out.println("Nama karyawan : "+larikKaryawan.kar.get(posisi).getNamaKar());
                                                                    System.out.println("Jenis Kelamin : " +larikKaryawan.kar.get(posisi).getJKel());
                                                                    System.out.println("Tempat Lahir : " +larikKaryawan.kar.get(posisi).getTmpLahir());
                                                                    LocalDate temp = larikKaryawan.kar.get(posisi).getTglLahir();
                                                                    tempTgl = temp.format(formatTanggall);
                                                                    System.out.println("Tanggal lahir  : "+tempTgl);
                                                                    System.out.println("Agama : " +larikKaryawan.kar.get(posisi).getAgama());
                                                                    System.out.println("Pendidikan Tertinggi : " +larikKaryawan.kar.get(posisi).getPendTing());
                                                                    LocalDate tempT = larikKaryawan.kar.get(posisi).getTMT();
                                                                    tempTMT = tempT.format(formatTanggall);
                                                                    System.out.println("TMT  : "+tempTMT);
                                                                    System.out.println("Pangkat/Golongan : " +larikKaryawan.kar.get(posisi).getPangGol());
                                                                    System.out.println("Jabatan : " +larikKaryawan.kar.get(posisi).getJab());
                                                                    LocalDate tempTo = larikKaryawan.kar.get(posisi).getToday();
                                                                    tempToday = tempTo.format(formatTanggall);
                                                                    System.out.println("Today  : "+tempToday);
                                                                    System.out.println("Masa Kerja : " +larikKaryawan.kar.get(posisi).getMasaKerja());
                                                                    LocalDate tempM = larikKaryawan.kar.get(posisi).getMPP();
                                                                    tempMPP = tempM.format(formatTanggall);
                                                                    System.out.println("MPP  : "+tempMPP);
                                                                    System.out.println("Umur : " +larikKaryawan.kar.get(posisi).getUmur());
                                                                    System.out.println("Status Kerja : " +larikKaryawan.kar.get(posisi).getStatKer());
                                                                    LocalDate temppen = larikKaryawan.kar.get(posisi).getPensiun();
                                                                    temppensiun = temppen.format(formatTanggall);
                                                                    System.out.println("Pensiun  : "+temppensiun);
                                                                    System.out.println("UnitKerja : " +larikKaryawan.kar.get(posisi).getUnitKer());
                                                                    System.out.println("Telepon : " +larikKaryawan.kar.get(posisi).getTlpn());
                                                                    System.out.println("Nomor Handphone : " +larikKaryawan.kar.get(posisi).getNoHP());
                                                                    System.out.println("Email : " +larikKaryawan.kar.get(posisi).getEmail());
                                                                    System.out.println("Alamat : " +larikKaryawan.kar.get(posisi).getAlamat());
                                                                    LocalDate tempsk = larikKaryawan.kar.get(posisi).getSkPer();
                                                                    tempskPer = tempsk.format(formatTanggall);
                                                                    System.out.println("SK Pertama  : "+tempskPer);
                                                                    System.out.println("Jabatan Struktural : " +larikKaryawan.kar.get(posisi).getJabStruk());
                                                                    
                                                                    System.out.println("");
                                                                    System.out.println("");
                                                                    System.out.println("==KELUARGA==");
                                                                    System.out.println("");
                                                                    larikKeluargaKaryawan.pencarian(NIK, larikKeluargaKaryawan);
                                                                } else {
                                                                    System.out.println("DATA YANG DICARI TIDAK ADA"); 
                                                                }
                                                                System.out.println();
                                                                System.out.println();
                                                                System.out.println();   
                                                            }break;
                                                            
                                                            case '2' :{
                                                                y = true;
                                                                System.out.println(MenuUtamaC);
                                                                System.out.print("Jawaban anda : ");
                                                                muC = c.nextLine();
                                                                lagiCo = true;

                                                                
                                                                
                                                            }break;
                                                            
                                                            case 's' : {
                                                                lagiCo = false;
                                                                x=false;
                                                                y=false;
                                                                break;
                                                            }
                                                                
                                                        }
                                                    
                                                    
                                    }
                             }
                                    case "xx" :
                                    {
                                        x=false;
                                        y=false;
                                        break;
                                    }
                                    default : {
                                        System.out.println("Input anda salah!");
                                        y=true;
                                    }
                            }
                                }
                            }else {
                                System.out.println("Username / password anda salah");
                                }                   
                            }
                            break;
                        }
                        default :
                            System.out.println("Input anda salah!");
                            x=true;
                    }
                    

    }
  }
}
