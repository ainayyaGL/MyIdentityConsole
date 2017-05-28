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
public class listDakwah {
    public List <Dakwah> dakwah;

    public listDakwah(){
        this.dakwah = new ArrayList();
    }
    
    public void saveDataToXML(listDakwah _larikDakwah) throws Exception{
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("dakwah");
       doc.appendChild(rootElement);
       
       for(int i=0; i<_larikDakwah.dakwah.size();i++){
           Element elemen_dakwah = doc.createElement("Dakwah");
           elemen_dakwah.setAttribute("NIK", ""+_larikDakwah.dakwah.get(i).getNIK());
           rootElement.appendChild(elemen_dakwah);
           
           Element fieldPeranDak = doc.createElement("PeranDakwah");
           fieldPeranDak.setTextContent(_larikDakwah.dakwah.get(i).getPeranDak());
           elemen_dakwah.appendChild(fieldPeranDak);
           
           Element fieldInstitusiDak = doc.createElement("InstitusiDakwah");
           fieldInstitusiDak.setTextContent(_larikDakwah.dakwah.get(i).getInstitusiDak());
           elemen_dakwah.appendChild(fieldInstitusiDak);
           
           Element fieldTglDak = doc.createElement("TglDakwah");
           fieldTglDak.setTextContent(_larikDakwah.dakwah.get(i).getTglDak().toString());
           elemen_dakwah.appendChild(fieldTglDak);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("dakwah.xml"));
       transformer.transform(dom, result);
    }
    
    public void nambahElemen(listDakwah _larikDakwah, Dakwah _Dakwah){
        _larikDakwah.dakwah.add(_Dakwah);
    }
    
    public int cariElemen(String _NIK, listDakwah _listDakwah){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listDakwah.dakwah.size()-1 & !ketemu){
            if (_listDakwah.dakwah.get(j).getNIK().equals(_NIK)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void openXMLtoList(listDakwah _larikDakwah) throws Exception{
        String NIK, PeranDak,InstitusiDak, RootElemen, RowElemen, strTglDak;
        LocalDate TglDak;
        
        
       File fileXML = new File("dakwah.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Dakwah");
          
       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK= eElement.getAttribute("NIK");
             PeranDak = eElement.getElementsByTagName("PeranDakwah").item(0).getTextContent();
             InstitusiDak = eElement.getElementsByTagName("InstitusiDakwah").item(0).getTextContent();
             strTglDak = eElement.getElementsByTagName("TglDakwah").item(0).getTextContent();
             TglDak = LocalDate.parse(strTglDak);
             Dakwah A = new Dakwah(NIK, PeranDak,InstitusiDak, TglDak);
             _larikDakwah.dakwah.add(A);
          }
       }
    }
    
}
