package fileWork;

import model.Car;
import model.Coordinates;
import model.HumanBeing;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class HumanBeingsToXml implements HumanBeingsToFile {
    private final FileChecker fileChecker;
    private Document doc;

    public HumanBeingsToXml(FileChecker fileChecker) {
        this.fileChecker = fileChecker;
    }

    @Override
    public void writeToFile(Vector<HumanBeing> entities, String filename) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("HumanBeingsList");
            doc.appendChild(rootElement);

            for (HumanBeing hb : entities) {
                rootElement.appendChild(getElement(hb));
            }
            FileWriter writer = new FileWriter(filename);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Element getElement(HumanBeing hb) {
        Element element = doc.createElement("HumanBeing");

        element.setAttribute("id", String.valueOf(hb.getId()));

        element.appendChild(getNode("name", hb.getName()));
        element.appendChild(getCoordinatesElement(hb.getCoordinates()));
        element.appendChild(getNode("creationDate", hb.getCreationDate().toString()));
        element.appendChild(getNode("realHero", String.valueOf(hb.isRealHero())));
        element.appendChild(getNode("hasToothpick", String.valueOf(hb.isHasToothpick())));
        element.appendChild(getNode("impactSpeed", String.valueOf(hb.getImpactSpeed())));
        element.appendChild(getNode("weaponType", hb.getWeaponType().toString()));
        element.appendChild(getNode("mood", hb.getMood().toString()));
        element.appendChild(getCarElement(hb.getCar()));
        return element;
    }

    private Element getNode(String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private Element getCoordinatesElement(Coordinates coordinates) {
        Element element = doc.createElement("coordinates");
        element.appendChild(getNode("coordinateX", String.valueOf(coordinates.getX())));
        element.appendChild(getNode("coordinateY", String.valueOf(coordinates.getY())));
        return element;
    }

    private Element getCarElement(Car car) {
        Element element = doc.createElement("car");
        element.appendChild(getNode("name", String.valueOf(car.getName())));
        return element;
    }
}
