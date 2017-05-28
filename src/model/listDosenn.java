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
public class listDosenn {
    public List <Dosen> dos;

    public listDosenn(){
        this.dos = new ArrayList();
    }
    
    public void saveDataToXML(listDosenn _larikDsn) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("dosen");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikDsn.dos.size();i++){
           Element elemen_dosen = doc.createElement("Dosen");
           elemen_dosen.setAttribute("NIK", ""+_larikDsn.dos.get(i).getNik());
           rootElement.appendChild(elemen_dosen);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(_larikDsn.dos.get(i).getNama());
           elemen_dosen.appendChild(fieldNama);
           
           Element fieldtmpL = doc.createElement("TempatLahir");
           fieldtmpL.setTextContent(_larikDsn.dos.get(i).getTmpLahir());
           elemen_dosen.appendChild(fieldtmpL);
           
           Element fieldTglLahir = doc.createElement("TanggalLahir");
           fieldTglLahir.setTextContent(_larikDsn.dos.get(i).getTglLahir().toString());
           elemen_dosen.appendChild(fieldTglLahir);
           
           Element fieldJkel = doc.createElement("JenisKelamin");
           fieldJkel.setTextContent(_larikDsn.dos.get(i).getJKel());
           elemen_dosen.appendChild(fieldJkel);
           
           Element fieldagama = doc.createElement("Agama");
           fieldagama.setTextContent(_larikDsn.dos.get(i).getAgama());
           elemen_dosen.appendChild(fieldagama);
           
           Element fieldstatusp = doc.createElement("StatusPernikahan");
           fieldstatusp.setTextContent(_larikDsn.dos.get(i).getStatusP());
           elemen_dosen.appendChild(fieldstatusp);
           
           Element fieldpendt = doc.createElement("Pendidikan");
           fieldpendt.setTextContent(_larikDsn.dos.get(i).getPendT());
           elemen_dosen.appendChild(fieldpendt);
           
           Element fieldgol = doc.createElement("GolonganPangkat");
           fieldgol.setTextContent(_larikDsn.dos.get(i).getGol());
           elemen_dosen.appendChild(fieldgol);
           
           Element fieldtmt = doc.createElement("tmt");
           fieldtmt.setTextContent(_larikDsn.dos.get(i).getTmt());
           elemen_dosen.appendChild(fieldtmt);
           
           Element fieldtelp = doc.createElement("Telepon");
           fieldtelp.setTextContent(_larikDsn.dos.get(i).getTelp());
           elemen_dosen.appendChild(fieldtelp);
           
           Element fieldnohp = doc.createElement("noHP");
           fieldnohp.setTextContent(_larikDsn.dos.get(i).getNoHp());
           elemen_dosen.appendChild(fieldnohp);
           
           Element fieldemail = doc.createElement("Email");
           fieldemail.setTextContent(_larikDsn.dos.get(i).getEmail());
           elemen_dosen.appendChild(fieldemail);
           
           Element fieldalamat = doc.createElement("Alamat");
           fieldalamat.setTextContent(_larikDsn.dos.get(i).getAlamat());
           elemen_dosen.appendChild(fieldalamat);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("Dosen.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listDosenn _larikDsn, Dosen _dsn){
        _larikDsn.dos.add(_dsn);
    }
    
    public int cariElemen(String _NIK, listDosenn _listDsn){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listDsn.dos.size()-1 & !ketemu){
            if (_listDsn.dos.get(j).getNik().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listDosenn _larikDsn) throws Exception{
        String nama, nik, tmpLahir, JKel, agama, statusP, pendT, gol, tmt, telp, noHP, email, alamat, RootElemen, RowElemen;
        LocalDate tglLahir;
        
        
       File fileXML = new File("Dosen.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Dosen");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIK");
             nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             tmpLahir = eElement.getElementsByTagName("TempatLahir").item(0).getTextContent();
             tglLahir = LocalDate.parse(eElement.getElementsByTagName("TanggalLahir").item(0).getTextContent());
             JKel = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             agama = eElement.getElementsByTagName("Agama").item(0).getTextContent();
             statusP = eElement.getElementsByTagName("StatusPernikahan").item(0).getTextContent();
             pendT = eElement.getElementsByTagName("Pendidikan").item(0).getTextContent();
             gol = eElement.getElementsByTagName("GolonganPangkat").item(0).getTextContent();
             tmt = eElement.getElementsByTagName("tmt").item(0).getTextContent();
             telp = eElement.getElementsByTagName("Telepon").item(0).getTextContent();
             noHP = eElement.getElementsByTagName("noHP").item(0).getTextContent();
             email = eElement.getElementsByTagName("Email").item(0).getTextContent();
             alamat = eElement.getElementsByTagName("Alamat").item(0).getTextContent();
             Dosen A = new Dosen(nik, nama, tmpLahir,tglLahir, JKel, agama, statusP, pendT, gol, tmt, telp, noHP, email, alamat);
             _larikDsn.dos.add(A);
          }
       }
    }
    
}
