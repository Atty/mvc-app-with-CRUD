package hh.tot_systems.test.parse;

import hh.tot_systems.test.enteties.HistoryOfSecurities;
import hh.tot_systems.test.enteties.Securities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Securities> parseSecurities(String fileName) {
        List<Securities>       securitiesList = new ArrayList<>();
        DocumentBuilderFactory factory        = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document        doc     = builder.parse("src/main/resources/xmlFile/" + fileName + ".xml");
            NodeList        rowList = doc.getElementsByTagName("row");
            for (int i = 0; i < rowList.getLength(); i++) {
                Node rowNode = rowList.item(i);
                if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rowElement    = (Element) rowNode;
                    int     id            = !rowElement.getAttribute("id").equals("") ? Integer.parseInt(rowElement.getAttribute("id")) : 0;
                    String  sec_id        = rowElement.getAttribute("secid");
                    String  reg_number    = rowElement.getAttribute("regnumber");
                    String  name          = rowElement.getAttribute("name");
                    String  emitent_title = rowElement.getAttribute("emitent_title");
                    securitiesList.add(new Securities(id, sec_id, reg_number, name, emitent_title));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securitiesList;
    }

    public static List<HistoryOfSecurities> parseHistoryOfSecurities(String fileName) {
        List<HistoryOfSecurities> historyList = new ArrayList<>();
        DocumentBuilderFactory    factory     = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document        doc     = builder.parse("src/main/resources/xmlFile/" + fileName + ".xml");
            NodeList        rowList = doc.getElementsByTagName("row");
            for (int i = 0; i < rowList.getLength(); i++) {
                Node rowNode = rowList.item(i);
                if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rowElement = (Element) rowNode;
                    if (rowElement.getAttribute("SECID").equals("")) continue;
                    String sec_id     = rowElement.getAttribute("SECID");
                    Date   trade_date = Date.valueOf(rowElement.getAttribute("TRADEDATE").trim());
                    double num_trades = !rowElement.getAttribute("NUMTRADES").equals("") ? Double.parseDouble(rowElement.getAttribute("NUMTRADES")) : 0;
                    double open       = !rowElement.getAttribute("OPEN").equals("") ? Double.parseDouble(rowElement.getAttribute("OPEN")) : 0;
                    double close      = !rowElement.getAttribute("CLOSE").equals("") ? Double.parseDouble(rowElement.getAttribute("CLOSE")) : 0;
                    historyList.add(new HistoryOfSecurities(sec_id, trade_date, num_trades, open, close));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }


}
