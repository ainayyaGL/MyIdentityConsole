/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.Karyawan;

import java.io.File;
import java.time.LocalDate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 *
 * @author zain
 */
public class listKaryawan {
    public List <Karyawan> kar;

    public listKaryawan(){
        this.kar = new ArrayList();
    }
    
    public void saveDataToXML(listKaryawan _larikKry) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("karyawan");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikKry.kar.size();i++){
           Element elemen_karyawan = doc.createElement("Karyawan");
           elemen_karyawan.setAttribute("NIK", ""+_larikKry.kar.get(i).getNIK());
           rootElement.appendChild(elemen_karyawan);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(_larikKry.kar.get(i).getNamaKar());
           elemen_karyawan.appendChild(fieldNama);
           
           Element fieldJKel = doc.createElement("JenisKelamin");
           fieldJKel.setTextContent(_larikKry.kar.get(i).getJKel());
           elemen_karyawan.appendChild(fieldJKel);
           
           Element fieldTmpLahir = doc.createElement("TempatLahir");
           fieldTmpLahir.setTextContent(_larikKry.kar.get(i).getTmpLahir());
           elemen_karyawan.appendChild(fieldTmpLahir);
           
           Element fieldTglLahir = doc.createElement("TanggalLahir");
           fieldTglLahir.setTextContent(_larikKry.kar.get(i).getTglLahir().toString());
           elemen_karyawan.appendChild(fieldTglLahir);
           
           Element fieldAgama = doc.createElement("Agama");
           fieldAgama.setTextContent(_larikKry.kar.get(i).getAgama());
           elemen_karyawan.appendChild(fieldAgama);
           
           Element fieldPendTing = doc.createElement("PendidikanTertinggi");
           fieldPendTing.setTextContent(_larikKry.kar.get(i).getPendTing());
           elemen_karyawan.appendChild(fieldPendTing);
           
           Element fieldTMT = doc.createElement("TMT");
           fieldTMT.setTextContent(_larikKry.kar.get(i).getTMT().toString());
           elemen_karyawan.appendChild(fieldTMT);
           
           Element fieldPangGol = doc.createElement("PangkatGolongan");
           fieldPangGol.setTextContent(_larikKry.kar.get(i).getPangGol());
           elemen_karyawan.appendChild(fieldPangGol);
           
           Element fieldJab = doc.createElement("Jabatan");
           fieldJab.setTextContent(_larikKry.kar.get(i).getJab());
           elemen_karyawan.appendChild(fieldJab);
           
           Element fieldToday = doc.createElement("Today");
           fieldToday.setTextContent(_larikKry.kar.get(i).getToday().toString());
           elemen_karyawan.appendChild(fieldToday);
           
           Element fieldMasKer = doc.createElement("MasaKerja");
           fieldMasKer.setTextContent(_larikKry.kar.get(i).getMasaKerja());
           elemen_karyawan.appendChild(fieldMasKer);
           
           Element fieldMPP = doc.createElement("MPP");
           fieldMPP.setTextContent(_larikKry.kar.get(i).getMPP().toString());
           elemen_karyawan.appendChild(fieldMPP);
           
           Element fieldUmur = doc.createElement("Umur");
           fieldUmur.setTextContent(_larikKry.kar.get(i).getUmur());
           elemen_karyawan.appendChild(fieldUmur);
           
           Element fieldStatKer = doc.createElement("StatusKerja");
           fieldStatKer.setTextContent(_larikKry.kar.get(i).getStatKer());
           elemen_karyawan.appendChild(fieldStatKer);
           
           Element fieldPens = doc.createElement("Pensiun");
           fieldPens.setTextContent(_larikKry.kar.get(i).getPensiun().toString());
           elemen_karyawan.appendChild(fieldPens);
           
           Element fieldUnitKer = doc.createElement("UnitKerja");
           fieldUnitKer.setTextContent(_larikKry.kar.get(i).getUnitKer());
           elemen_karyawan.appendChild(fieldUnitKer);
           
           Element fieldTelp = doc.createElement("Telepon");
           fieldTelp.setTextContent(_larikKry.kar.get(i).getTlpn());
           elemen_karyawan.appendChild(fieldTelp);
           
           Element fieldNoHp = doc.createElement("NoHp");
           fieldNoHp.setTextContent(_larikKry.kar.get(i).getNoHP());
           elemen_karyawan.appendChild(fieldNoHp);
           
           Element fieldEmail = doc.createElement("Email");
           fieldEmail.setTextContent(_larikKry.kar.get(i).getEmail());
           elemen_karyawan.appendChild(fieldEmail);
           
           Element fieldAlamat = doc.createElement("Alamat");
           fieldAlamat.setTextContent(_larikKry.kar.get(i).getAlamat());
           elemen_karyawan.appendChild(fieldAlamat);
           
           Element fieldSKper = doc.createElement("SKPertama");
           fieldSKper.setTextContent(_larikKry.kar.get(i).getSkPer().toString());
           elemen_karyawan.appendChild(fieldSKper);
           
           Element fieldJabStruk = doc.createElement("JabatanStruktural");
           fieldJabStruk.setTextContent(_larikKry.kar.get(i).getJabStruk());
           elemen_karyawan.appendChild(fieldJabStruk);
           
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("karyawan.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listKaryawan _larikKry, Karyawan _kry){
        _larikKry.kar.add(_kry);
    }
    
    public int cariElemen(String _NIK, listKaryawan _listKry){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listKry.kar.size()-1 & !ketemu){
            if (_listKry.kar.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listKaryawan _larikKry) throws Exception{
        String NIK, Nama, JKel, tmpLahir, agama, pendTing, pangkat, jab, MasaKerja, umur, Statker, UnitKer, tlpn, hp, email,alamat, JabStruk,  RootElemen, RowElemen, strTglLahir,strTMT,strToday,strMPP,strpensiun,strskPer;
        LocalDate tglLahir, TMT, today, MPP, pensiun, skPer;
        
        
       File fileXML = new File("karyawan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Karyawan");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK = eElement.getAttribute("NIK");
             Nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             JKel = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             tmpLahir = eElement.getElementsByTagName("TempatLahir").item(0).getTextContent();
             strTglLahir = eElement.getElementsByTagName("TanggalLahir").item(0).getTextContent();
             tglLahir = LocalDate.parse(strTglLahir);
             agama = eElement.getElementsByTagName("Agama").item(0).getTextContent();
             pendTing = eElement.getElementsByTagName("PendidikanTertinggi").item(0).getTextContent();
             strTMT = eElement.getElementsByTagName("TMT").item(0).getTextContent();
             TMT = LocalDate.parse(strTMT);
             pangkat = eElement.getElementsByTagName("PangkatGolongan").item(0).getTextContent();
             jab = eElement.getElementsByTagName("Jabatan").item(0).getTextContent();
             strToday = eElement.getElementsByTagName("Today").item(0).getTextContent();
             today = LocalDate.parse(strToday);
             MasaKerja = eElement.getElementsByTagName("MasaKerja").item(0).getTextContent();
             strMPP = eElement.getElementsByTagName("MPP").item(0).getTextContent();
             MPP = LocalDate.parse(strMPP);
             umur = eElement.getElementsByTagName("Umur").item(0).getTextContent();
             Statker = eElement.getElementsByTagName("StatusKerja").item(0).getTextContent();
             strpensiun = eElement.getElementsByTagName("Pensiun").item(0).getTextContent();
             pensiun = LocalDate.parse(strpensiun);
             UnitKer = eElement.getElementsByTagName("UnitKerja").item(0).getTextContent();
             tlpn = eElement.getElementsByTagName("Telepon").item(0).getTextContent();
             hp = eElement.getElementsByTagName("NoHp").item(0).getTextContent();
             email = eElement.getElementsByTagName("Email").item(0).getTextContent();
             alamat = eElement.getElementsByTagName("Alamat").item(0).getTextContent();
             strskPer = eElement.getElementsByTagName("SKPertama").item(0).getTextContent();
             skPer = LocalDate.parse(strskPer);
             JabStruk = eElement.getElementsByTagName("JabatanStruktural").item(0).getTextContent();
             
             
             Karyawan A = new Karyawan(NIK, Nama, JKel, tmpLahir,tglLahir ,agama,pendTing, TMT, pangkat, jab, today, MasaKerja, MPP, umur, Statker, pensiun, UnitKer, tlpn, hp, email,alamat, skPer, JabStruk);
             _larikKry.kar.add(A);
          }
       }
    }
    
}
