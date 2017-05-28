/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;


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
public class listKeluargaKaryawan {
    public List <KeluargaKaryawan> keluargaKaryawan;

    public listKeluargaKaryawan(){
        this.keluargaKaryawan = new ArrayList();
    }
    
    public void saveDataToXML(listKeluargaKaryawan _larikKeluargaKaryawan) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("keluargaKaryawan");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikKeluargaKaryawan.keluargaKaryawan.size();i++){
           Element elemen_keluargaKaryawan = doc.createElement("KeluargaDosen");
           elemen_keluargaKaryawan.setAttribute("NIK", ""+_larikKeluargaKaryawan.keluargaKaryawan.get(i).getNIK());
           rootElement.appendChild(elemen_keluargaKaryawan);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(_larikKeluargaKaryawan.keluargaKaryawan.get(i).getNama());
           elemen_keluargaKaryawan.appendChild(fieldNama);
           
           Element fieldjKelamin = doc.createElement("JenisKelamin");
           fieldjKelamin.setTextContent(_larikKeluargaKaryawan.keluargaKaryawan.get(i).getjKelamin());
           elemen_keluargaKaryawan.appendChild(fieldjKelamin);
           
           Element fieldtglLahir = doc.createElement("TglLahir");
           fieldtglLahir.setTextContent(_larikKeluargaKaryawan.keluargaKaryawan.get(i).getTglLahir().toString());
           elemen_keluargaKaryawan.appendChild(fieldtglLahir);
           
           Element fieldsttKeluarga = doc.createElement("StatusKeluarga");
           fieldsttKeluarga.setTextContent(_larikKeluargaKaryawan.keluargaKaryawan.get(i).getSttKeluarga());
           elemen_keluargaKaryawan.appendChild(fieldsttKeluarga);
           
           Element fieldDitanggung = doc.createElement("Ditanggung");
           fieldDitanggung.setTextContent(_larikKeluargaKaryawan.keluargaKaryawan.get(i).getDitanggung());
           elemen_keluargaKaryawan.appendChild(fieldDitanggung);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("keluargaKaryawan.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listKeluargaKaryawan _larikKeluargaKaryawan, KeluargaKaryawan _KeluargaKaryawan){
        _larikKeluargaKaryawan.keluargaKaryawan.add(_KeluargaKaryawan);
    }
    
    public int cariElemen(String _NIK, listKeluargaKaryawan _listKeluargaKaryawan){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listKeluargaKaryawan.keluargaKaryawan.size()-1 & !ketemu){
            if (_listKeluargaKaryawan.keluargaKaryawan.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void pencarian(String _NIK, listKeluargaKaryawan _listKeluargaKaryawan){
        boolean ada = false;
        for(int i = 0; i < _listKeluargaKaryawan.keluargaKaryawan.size(); i++){
            if(_listKeluargaKaryawan.keluargaKaryawan.get(i).getNIK().equals(_NIK)){
            System.out.println("Nama : "+_listKeluargaKaryawan.keluargaKaryawan.get(i).getNama());
            System.out.println("Jenis Kelamin : "+_listKeluargaKaryawan.keluargaKaryawan.get(i).getjKelamin());
            System.out.println("Tanggal Lahir : "+_listKeluargaKaryawan.keluargaKaryawan.get(i).getTglLahir().toString());
            System.out.println("Status Keluarga : "+_listKeluargaKaryawan.keluargaKaryawan.get(i).getSttKeluarga());
            System.out.println("Ditanggung : "+_listKeluargaKaryawan.keluargaKaryawan.get(i).getDitanggung());
            System.out.println("");
                ada = true;
            }
        }
        if(ada == false){
            System.out.println("Data Tidak Tersedia");
        }
    }
    
    public void openXMLtoList(listKeluargaKaryawan _larikKeluargaKaryawan) throws Exception{
        String NIK, nama,jKelamin,sttKeluarga,ditanggung, RootElemen, RowElemen, strTglLahir;
        LocalDate tglLahir;
        
        
       File fileXML = new File("keluargaKaryawan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("KeluargaKaryawan");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK = eElement.getAttribute("NIK");
             nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             jKelamin = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             strTglLahir = eElement.getElementsByTagName("TglLahir").item(0).getTextContent();
             tglLahir = LocalDate.parse(strTglLahir);
             sttKeluarga = eElement.getElementsByTagName("StatusKeluarga").item(0).getTextContent();
             ditanggung = eElement.getElementsByTagName("Ditanggung").item(0).getTextContent();
             KeluargaKaryawan A = new KeluargaKaryawan(NIK, nama,jKelamin,tglLahir,sttKeluarga,ditanggung);
             _larikKeluargaKaryawan.keluargaKaryawan.add(A);
          }
       }
    }
    
}
