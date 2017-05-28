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
public class listPengabdian {
    public List <Pengabdian> pengabdian;

    public listPengabdian(){
        this.pengabdian = new ArrayList();
    }
    
    public void saveDataToXML(listPengabdian _larikPng) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("pengabdian");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikPng.pengabdian.size();i++){
           Element elemen_pengabdian = doc.createElement("Pengabdian");
           elemen_pengabdian.setAttribute("NIK", ""+_larikPng.pengabdian.get(i).getNIK());
           rootElement.appendChild(elemen_pengabdian);
           
           Element fieldPeran = doc.createElement("Peran");
           fieldPeran.setTextContent(_larikPng.pengabdian.get(i).getPeranPeng());
           elemen_pengabdian.appendChild(fieldPeran);
           
           Element fieldInst = doc.createElement("Institusi");
           fieldInst.setTextContent(_larikPng.pengabdian.get(i).getInstPeng());
           elemen_pengabdian.appendChild(fieldInst);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("pengabdian.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listPengabdian _larikPng, Pengabdian _png){
        _larikPng.pengabdian.add(_png);
    }
    
    public int cariElemen(String _NIK, listPengabdian _listPng){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listPng.pengabdian.size()-1 & !ketemu){
            if (_listPng.pengabdian.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listPengabdian _larikPng) throws Exception{
        String nik, PeranPeng, InstPeng, RootElemen, RowElemen, strTgl;
        LocalDate TglPeng;
        
        
       File fileXML = new File("pengabdian.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("pengabdian");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIK");
             PeranPeng = eElement.getElementsByTagName("Peran").item(0).getTextContent();
             InstPeng = eElement.getElementsByTagName("Institusi").item(0).getTextContent();
             strTgl = eElement.getElementsByTagName("Tanggal").item(0).getTextContent();
             TglPeng = LocalDate.parse(strTgl);
             Pengabdian A;
              A = new Pengabdian(nik, PeranPeng, InstPeng, TglPeng);
             _larikPng.pengabdian.add(A);
          }
       }
    }
    
}
