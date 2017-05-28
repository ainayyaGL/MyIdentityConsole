/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;


import java.io.File;
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
public class listPendidikan {
    public List <Pendidikan> pendidikan;

    public listPendidikan(){
        this.pendidikan = new ArrayList();
    }
    
    public void saveDataToXML(listPendidikan _larikPendidikan) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("pendidikan");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikPendidikan.pendidikan.size();i++){
           Element elemen_pendidikan = doc.createElement("Pendidikan");
           elemen_pendidikan.setAttribute("NIK", ""+_larikPendidikan.pendidikan.get(i).getNIK());
           rootElement.appendChild(elemen_pendidikan);
           
           Element fieldPendidikan = doc.createElement("TingkatPend");
           fieldPendidikan.setTextContent(_larikPendidikan.pendidikan.get(i).getPendidikan());
           elemen_pendidikan.appendChild(fieldPendidikan);
           
           Element fieldInstitusi = doc.createElement("InstitusiPend");
           fieldInstitusi.setTextContent(_larikPendidikan.pendidikan.get(i).getInstitusi());
           elemen_pendidikan.appendChild(fieldInstitusi);
           
           Element fieldthnLulus = doc.createElement("TahunLulus");
           fieldthnLulus.setTextContent(_larikPendidikan.pendidikan.get(i).getThnLulus());
           elemen_pendidikan.appendChild(fieldthnLulus);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("pendidikan.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listPendidikan _larikPendidikan, Pendidikan _Pendidikan){
        _larikPendidikan.pendidikan.add(_Pendidikan);
    }
    
    public int cariElemen(String _NIK, listPendidikan _listPendidikan){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listPendidikan.pendidikan.size()-1 & !ketemu){
            if (_listPendidikan.pendidikan.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
     public void pencarian(String _NIK, listPendidikan _listPendidikan){
        boolean ada = false;
        for(int i = 0; i < _listPendidikan.pendidikan.size(); i++){
            if(_listPendidikan.pendidikan.get(i).getNIK().equals(_NIK)){
            System.out.println("Tingkat Pendidikan : "+_listPendidikan.pendidikan.get(i).getPendidikan());
            System.out.println("Institusi Pendidikan : "+_listPendidikan.pendidikan.get(i).getInstitusi());
            System.out.println("Tahun Lulus : "+_listPendidikan.pendidikan.get(i).getThnLulus());
            System.out.println("");
                ada = true;
            }
        }
        if(ada == false){
            System.out.println("Data Tidak Tersedia");
        }
    }
    
    public void openXMLtoList(listPendidikan _larikPendidikan) throws Exception{
        String NIK, Pendidikan,Institusi,thnLulus, RootElemen, RowElemen; 
        
       
       File fileXML = new File("pendidikan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Pendidikan");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK = eElement.getAttribute("NIK");
             Pendidikan = eElement.getElementsByTagName("TingkatPend").item(0).getTextContent();
             Institusi = eElement.getElementsByTagName("InstitusiPend").item(0).getTextContent();
             thnLulus = eElement.getElementsByTagName("TahunLulus").item(0).getTextContent();
             Pendidikan A = new Pendidikan(NIK, Pendidikan,Institusi, thnLulus);
             _larikPendidikan.pendidikan.add(A);
          }
       }
    }
    
}
