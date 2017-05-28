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
public class listPenunjang {
    public List <Penunjang> penunjang;

    public listPenunjang(){
        this.penunjang = new ArrayList();
    }
    
    public void saveDataToXML(listPenunjang _larikPnj) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("penunjang");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikPnj.penunjang.size();i++){
           Element elemen_penunjang = doc.createElement("Penunjang");
           elemen_penunjang.setAttribute("NIK", ""+_larikPnj.penunjang.get(i).getNIK());
           rootElement.appendChild(elemen_penunjang);
           
           Element fieldKeg = doc.createElement("Kegiatan");
           fieldKeg.setTextContent(_larikPnj.penunjang.get(i).getKegPen());
           elemen_penunjang.appendChild(fieldKeg);
           
           Element fieldInst = doc.createElement("Institusi");
           fieldInst.setTextContent(_larikPnj.penunjang.get(i).getInstPen());
           elemen_penunjang.appendChild(fieldInst);
           
           Element fieldTgl = doc.createElement("Tanggal");
           fieldTgl.setTextContent(_larikPnj.penunjang.get(i).getTglPen().toString());
           elemen_penunjang.appendChild(fieldTgl);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("penunjang.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listPenunjang _larikPnj, Penunjang _pnj){
        _larikPnj.penunjang.add(_pnj);
    }
    
    public int cariElemen(String _NIK, listPenunjang _listPnj){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listPnj.penunjang.size()-1 & !ketemu){
            if (_listPnj.penunjang.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listPenunjang _larikPnj) throws Exception{
        String nik, KegPen, PeranPen, InstPen,RootElemen, RowElemen, strTgl;
        LocalDate TglPen;
        
        
       File fileXML = new File("penunjang.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("DaftarPenunjang");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIK");
             KegPen = eElement.getElementsByTagName("Kegiatan").item(0).getTextContent();
             PeranPen = eElement.getElementsByTagName("Peran").item(0).getTextContent();
             InstPen = eElement.getElementsByTagName("Institusi").item(0).getTextContent();
             strTgl = eElement.getElementsByTagName("Tanggal").item(0).getTextContent();
             TglPen = LocalDate.parse(strTgl);
             Penunjang A = new Penunjang(nik, KegPen, PeranPen, InstPen, TglPen);
             _larikPnj.penunjang.add(A);
          }
       }
    }
    
}
