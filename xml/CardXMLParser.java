package starco.code.xml;


// SAX parser to parse job

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import starco.code.models.CardModel;

public class CardXMLParser extends DefaultHandler
{
    private static final String TAG = "CardXMLParser";
    private List<CardModel> list=null;

    // string builder acts as a buffer
    StringBuilder builder;
    CardModel cardValues=null;


    // Initialize the arraylist
    // @throws SAXException

    @Override
    public void startDocument() throws SAXException {

        /******* Create ArrayList To Store CardModel object ******/
        list = new ArrayList<CardModel>();
    }


    // Initialize the temp XmlValuesModel object which will hold the parsed info
    // and the string builder that will store the read characters
    // @param uri
    // @param localName ( Parsed Node name will come in localName  )
    // @param qName
    // @param attributes
    // @throws SAXException

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        /****  When New XML Node initiating to parse this function called *****/

        // Create StringBuilder object to store xml node value
        builder=new StringBuilder();

        if(localName.equals("card")){
            /********** Create Model Object  *********/
            cardValues = new CardModel();
        }
    }


    // Finished reading the login tag, add it to arraylist
    // @param uri
    // @param localName
    // @param qName
    // @throws SAXException

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        Log.d(TAG, builder.toString());

        if(localName.equals("card")){

            /** finished reading a card xml node, add it to the arraylist **/
            list.add( cardValues );

        }
        else  if(localName.equalsIgnoreCase("id")){
            cardValues.setId(Integer.parseInt(builder.toString()));
        }
        else if(localName.equalsIgnoreCase("name")){
            cardValues.setName(builder.toString());
        }
        else if(localName.equalsIgnoreCase("title")){
            cardValues.setTitle(builder.toString());
        }
        else if(localName.equalsIgnoreCase("description")){
            cardValues.setDescription(builder.toString());
        }
    }


    // Read the value of each xml NODE
    // @param ch
    // @param start
    // @param length
    // @throws SAXException

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        /******  Read the characters and append them to the buffer  ******/
        String tempString=new String(ch, start, length);
        builder.append(tempString);
    }


    public List<CardModel> getList() {
        return list;
    }
}
