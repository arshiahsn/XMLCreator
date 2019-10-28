import java.io.FileWriter;
import java.io.IOException;
import org.jdom.*;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class Creator {
    public static void main(String[] args) {

        try {

            Element company = new Element("company");
            Document doc = new Document(company);
            doc.setRootElement(company);

            Element staff = new Element("staff");
            staff.setAttribute(new Attribute("id", "1"));
            staff.addContent(new Element("firstname").setText("Luke"));
            staff.addContent(new Element("lastname").setText("Skywalker"));
            staff.addContent(new Element("nickname").setText("Jedi Knight"));
            staff.addContent(new Element("lightsaber").setText("Green/Blue"));

            doc.getRootElement().addContent(staff);

            Element staff2 = new Element("staff");
            staff2.setAttribute(new Attribute("id", "2"));
            staff2.addContent(new Element("firstname").setText("Anakin"));
            staff2.addContent(new Element("lastname").setText("Skywalker"));
            staff2.addContent(new Element("nickname").setText("Darth Vader"));
            staff2.addContent(new Element("lightsaber").setText("Red"));

            doc.getRootElement().addContent(staff2);

            new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // Display in a readable format
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("file.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}