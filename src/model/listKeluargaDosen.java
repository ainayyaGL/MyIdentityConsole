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
public class listKeluargaDosen {
    public List <KeluargaDosen> keluargaDosen;

    public listKeluargaDosen(){
        this.keluargaDosen = new ArrayList();
    }
    
    public void saveDataToXML(listKeluargaDosen _larikKeluargaDosen) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("keluargaDosen");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikKeluargaDosen.keluargaDosen.size();i++){
           Element elemen_keluargaDosen = doc.createElement("KeluargaDosen");
           elemen_keluargaDosen.setAttribute("NIK", ""+_larikKeluargaDosen.keluargaDosen.get(i).getNIK());
           rootElement.appendChild(elemen_keluargaDosen);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(_larikKeluargaDosen.keluargaDosen.get(i).getNama());
           elemen_keluargaDosen.appendChild(fieldNama);
           
           Element fieldjKelamin = doc.createElement("JenisKelamin");
           fieldjKelamin.setTextContent(_larikKeluargaDosen.keluargaDosen.get(i).getjKelamin());
           elemen_keluargaDosen.appendChild(fieldjKelamin);
           
           Element fieldtglLahir = doc.createElement("TglLahir");
           fieldtglLahir.setTextContent(_larikKeluargaDosen.keluargaDosen.get(i).getTglLahir().toString());
           elemen_keluargaDosen.appendChild(fieldtglLahir);
           
           Element fieldsttKeluarga = doc.createElement("StatusKeluarga");
           fieldsttKeluarga.setTextContent(_larikKeluargaDosen.keluargaDosen.get(i).getSttKeluarga());
           elemen_keluargaDosen.appendChild(fieldsttKeluarga);
           
           Element fieldDitanggung = doc.createElement("Ditanggung");
           fieldDitanggung.setTextContent(_larikKeluargaDosen.keluargaDosen.get(i).getDitanggung());
           elemen_keluargaDosen.appendChild(fieldDitanggung);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("keluargaDosen.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listKeluargaDosen _larikKeluargaDosen, KeluargaDosen _KeluargaDosen){
        _larikKeluargaDosen.keluargaDosen.add(_KeluargaDosen);
    }
    
    public int cariElemen(String _NIK, listKeluargaDosen _listKeluargaDosen){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listKeluargaDosen.keluargaDosen.size()-1 & !ketemu){
            if (_listKeluargaDosen.keluargaDosen.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void pencarian(String _NIK, listKeluargaDosen _listKeluargaDosen){
        boolean ada = false;
        for(int i = 0; i < _listKeluargaDosen.keluargaDosen.size(); i++){
            if(_listKeluargaDosen.keluargaDosen.get(i).getNIK().equals(_NIK)){
            System.out.println("Nama : "+_listKeluargaDosen.keluargaDosen.get(i).getNama());
            System.out.println("Jenis Kelamin : "+_listKeluargaDosen.keluargaDosen.get(i).getjKelamin());
            System.out.println("Tanggal Lahir : "+_listKeluargaDosen.keluargaDosen.get(i).getTglLahir().toString());
            System.out.println("Status Keluarga : "+_listKeluargaDosen.keluargaDosen.get(i).getSttKeluarga());
            System.out.println("Ditanggung : "+_listKeluargaDosen.keluargaDosen.get(i).getDitanggung());
            System.out.println("");
                ada = true;
            }
        }
        if(ada == false){
            System.out.println("Data Tidak Tersedia");
        }
    }
    
    public void openXMLtoList(listKeluargaDosen _larikKeluargaDosen) throws Exception{
        String NIK, nama,jKelamin,sttKeluarga,ditanggung, RootElemen, RowElemen, strTglLahir;
        LocalDate tglLahir;
        
        
       File fileXML = new File("keluargaDosen.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("KeluargaDosen");
          
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
             KeluargaDosen A = new KeluargaDosen(NIK, nama,jKelamin,tglLahir,sttKeluarga,ditanggung);
             _larikKeluargaDosen.keluargaDosen.add(A);
          }
       }
    }
    
}
