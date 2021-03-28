
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

   
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("books.xml");
         XPathFactory xpf = XPathFactory.newInstance();
         XPath path = xpf.newXPath();
         XPathExpression exp = path.compile ("//book[price>10.0 and translate(publish_date,'-','')>20050101]");
            Object result = exp.evaluate(doc, XPathConstants.NODESET);
            NodeList list = (NodeList) result;
            for(int i=0; i<list.getLength();i++){
                Node node= (Node)list.item(i);
                    System.out.println("Book:");
                    System.out.println("id: "+list.item(i).getAttributes().getNamedItem("id").getNodeValue());
                    XPathExpression exp1 = path.compile("author"); 
                    String author = exp1.evaluate(list.item(i));
                    System.out.println("Author: "+author);
                    XPathExpression exp2 = path.compile("title"); 
                    String title = exp2.evaluate(list.item(i));
                    System.out.println("Title: "+title);
                    XPathExpression exp3 = path.compile("genre"); 
                    String genre = exp3.evaluate(list.item(i));
                    System.out.println("Genre: "+genre);
                    XPathExpression exp4 = path.compile("price");
                    String price = exp4.evaluate(list.item(i));
                    System.out.println("Price: "+price);
                    XPathExpression exp5 = path.compile("publish_date"); 
                    String date = exp5.evaluate(list.item(i));
                    System.out.println("Publish date:"+date);
                    XPathExpression exp6 = path.compile("description"); 
                    String desc = exp6.evaluate(list.item(i));
                    System.out.println("Description: "+ desc);
                    System.out.println("------------------------------------------");
    }
            }
    }
    

