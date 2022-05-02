package fileWork;

import exception.BrokenDataException;
import exception.FileIsNotAvailableException;
import exception.InvalidFieldException;
import model.Car;
import model.HumanBeing;
import model.Mood;
import model.WeaponType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import validation.HumanBeingBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Vector;

public class XmlToHumanBeings implements FileToHumanBeings {
    private final FileChecker fileChecker;
    private final HumanBeingBuilder builder;
    private Document doc;

    public XmlToHumanBeings(FileChecker fileChecker, HumanBeingBuilder builder) {
        this.fileChecker = fileChecker;
        this.builder = builder;
    }

    @Override
    public Vector<HumanBeing> readFromXml(String filename) throws FileIsNotAvailableException, BrokenDataException {
        if (!fileChecker.checkFile(filename))
            throw new FileIsNotAvailableException("File is not available");
        Vector<HumanBeing> result = new Vector<>();

        try (BufferedInputStream streamReader = new BufferedInputStream(new FileInputStream(filename))) {
            InputSource inputSource = new InputSource(streamReader);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(inputSource);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            throw new BrokenDataException();
        }

        try {
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("HumanBeing");
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                result.add(createPerson(element));
            }
        } catch (NullPointerException | InvalidFieldException e) {
            throw new BrokenDataException();
        }
        return result;
    }

    private HumanBeing createPerson(Element element) throws InvalidFieldException {
        try {
            builder.setId(
                    Long.parseLong(element.getAttribute("id"))
            );
            builder.setName(
                    element.getElementsByTagName("name").item(0).getTextContent());

            Element coordinatesElement = (Element) element.getElementsByTagName("coordinates").item(0);
            builder.setCoordinateX(
                    Long.parseLong(coordinatesElement.getElementsByTagName("coordinateX").item(0).getTextContent()));
            builder.setCoordinateY(
                    Long.parseLong(coordinatesElement.getElementsByTagName("coordinateY").item(0).getTextContent()));


            builder.setCreationDate(
                    LocalDate.parse(element.getElementsByTagName("creationDate").item(0).getTextContent()));

            builder.setRealHero(
                    (element.getElementsByTagName("realHero").item(0).getTextContent()));

            builder.setHasToothpick(
                    (element.getElementsByTagName("hasToothpick").item(0).getTextContent()));

            builder.setImpactSpeed(
                    Integer.parseInt(element.getElementsByTagName("impactSpeed").item(0).getTextContent()));

            builder.setWeaponType(
                    WeaponType.valueOf(element
                            .getElementsByTagName("weaponType").item(0).getTextContent().toUpperCase()));

            builder.setMood(
                    Mood.valueOf(element
                            .getElementsByTagName("mood").item(0).getTextContent().toUpperCase()));


            Element carElement = (Element) element.getElementsByTagName("car").item(0);
            builder.setCar(
                    new Car(carElement.getElementsByTagName("name").item(0).getTextContent()));

            return builder.getHumanBeing();
        } catch (IllegalArgumentException e) {
            throw new InvalidFieldException("Поле в файле не соответствует формату");
        }
    }
}
