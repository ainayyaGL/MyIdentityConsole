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
public class listKarIl {
    public List <KaryaIlmiah> daftarPenelitian;

    public listKarIl(){
        this.daftarPenelitian = new ArrayList();
    }
    
    public void saveDataToXML(listKarIl _larikKarIl) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("penelitian");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikKarIl.daftarPenelitian.size();i++){
           Element elemen_penelitian = doc.createElement("TabelPenelitian");
           elemen_penelitian.setAttribute("NIK", ""+_larikKarIl.daftarPenelitian.get(i).getNIK());
           rootElement.appendChild(elemen_penelitian);
           
           Element fieldNo = doc.createElement("No");
           fieldNo.setTextContent(_larikKarIl.daftarPenelitian.get(i).getNo());
           elemen_penelitian.appendChild(fieldNo);
           
           Element fieldJudul = doc.createElement("JudulPenelitian");
           fieldJudul.setTextContent(_larikKarIl.daftarPenelitian.get(i).getJudul());
           elemen_penelitian.appendChild(fieldJudul);
           
           Element fieldPeran = doc.createElement("PeranInstitusi");
           fieldPeran.setTextContent(_larikKarIl.daftarPenelitian.get(i).getPeran());
           elemen_penelitian.appendChild(fieldPeran);
           
           Element fieldInstitusi = doc.createElement("Institusi");
           fieldInstitusi.setTextContent(_larikKarIl.daftarPenelitian.get(i).getInstitusi());
           elemen_penelitian.appendChild(fieldInstitusi);
           
           Element fieldSumberDana = doc.createElement("SumberDana");
           fieldSumberDana.setTextContent(_larikKarIl.daftarPenelitian.get(i).getSumberDana());
           elemen_penelitian.appendChild(fieldSumberDana);
           
           Element fieldNilaiDana = doc.createElement("NilaiDana");
           fieldNilaiDana.setTextContent(_larikKarIl.daftarPenelitian.get(i).getNilaiDana());
           elemen_penelitian.appendChild(fieldNilaiDana);
           
           Element fieldTahunPen = doc.createElement("TahunPenelitian");
           fieldTahunPen.setTextContent(_larikKarIl.daftarPenelitian.get(i).getTahunPen());
           elemen_penelitian.appendChild(fieldTahunPen);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("penelitian.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listKarIl _larikKarIl, KaryaIlmiah _KarIl){
        _larikKarIl.daftarPenelitian.add(_KarIl);
    }
    
    public int cariElemen(String _NIK, listKarIl _listKarIl){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listKarIl.daftarPenelitian.size()-1 & !ketemu){
            if (_listKarIl.daftarPenelitian.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listKarIl _larikKarIl) throws Exception{
        String nik,No, Judul, Peran, Institusi, sumberDana, nilaiDana, tahunPen, RootElemen, RowElemen;
        
        
       File fileXML = new File("penelitian.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("TabelPenelitian");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIK");
             No = eElement.getElementsByTagName("No").item(0).getTextContent();
             Judul = eElement.getElementsByTagName("JudulPenelitian").item(0).getTextContent();
             Peran = eElement.getElementsByTagName("PeranPenelitian").item(0).getTextContent();
             Institusi = eElement.getElementsByTagName("Institusi").item(0).getTextContent();
             sumberDana = eElement.getElementsByTagName("SumberDana").item(0).getTextContent();
             nilaiDana = eElement.getElementsByTagName("NilaiDana").item(0).getTextContent();
             tahunPen = eElement.getElementsByTagName("TahunPenelitian").item(0).getTextContent();
            
             KaryaIlmiah A = new KaryaIlmiah(nik, No, Judul, Peran, Institusi, sumberDana, nilaiDana, tahunPen);
             _larikKarIl.daftarPenelitian.add(A);
          }
       }
    }
    
}
