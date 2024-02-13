import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= factory.newDocumentBuilder();
        Document comp1=builder.parse(new File("plants__000.xml"));
        Document comp2=builder.parse(new File("plants__001.xml"));
        Document comp3=builder.parse(new File("plants__002.xml"));
        Document comp4=builder.parse(new File("plants__003.xml"));
        Document comp5=builder.parse(new File("plants__004.xml"));
        Element el1= comp1.getDocumentElement();
        Element el2= comp2.getDocumentElement();
        Element el3= comp3.getDocumentElement();
        Element el4= comp4.getDocumentElement();
        Element el5= comp5.getDocumentElement();
        Scanner  user=new Scanner(System.in);
        System.out.println("Выберите компанию(1-5):");
        int s = user.nextInt();
        switch (s)
        {
            case 1:
                printElements(el1.getChildNodes(), 0);
                break;
            case 2:
                printElements(el2.getChildNodes(), 0);
                break;
            case 3:
                printElements(el3.getChildNodes(), 0);
                break;
            case 4:
                printElements(el4.getChildNodes(), 0);
                break;
            case 5:
                printElements(el5.getChildNodes(), 0);
                break;
            default:
                System.out.println("Ошибка ввода!");
        }
    }
    static void printElements(NodeList plants,int tabs){
        for(int i =0;i<plants.getLength();i++)
        {
            if(plants.item(i) instanceof Element) {
                String value="";
                if(!plants.item(i).getTextContent().trim().isEmpty()&&!((Text)plants.item(i)
                        .getFirstChild()).getData().trim().isEmpty()&&!((Text)plants.item(i)
                        .getFirstChild()).getData().trim().equals("\n"))
                {
                    Text text=(Text)plants.item(i).getFirstChild();
                    value+=" = "+text.getData().trim();
                }
                System.out.println(getTab(tabs)+plants.item(i).getNodeName()+value);

                System.out.println(getTab(tabs)+((Element) plants.item(i)).getTagName());
                if (plants.item(i).hasChildNodes()) {
                    printElements(plants.item(i).getChildNodes(),++tabs);
                }
            }
        }
    }
    private static String getTextContent() {
        return null;
    }
    static String  getTab(int tabs){
        String srt="";
        for(int i=0;i<tabs;i++){
            srt+="\t";
        }
        return srt;

    }
}