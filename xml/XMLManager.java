package starco.code.xml;

import android.content.Context;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import starco.code.com.R;
import starco.code.models.CardModel;

public class XMLManager {

    private static final String TAG = "XMLManager";

    static List<CardModel> myCards = null;
    static String cardXMLData = "";
    static Context mCtx;

    public static List<CardModel> parseCards(Context ctx) {

        mCtx = ctx;

        try{

            /************  Load XML **************/
            cardXMLData = loadDataFromXML();
            BufferedReader br=new BufferedReader(new StringReader(cardXMLData));
            InputSource is=new InputSource(br);

            /************  Parse XML **************/
            CardXMLParser parser=new CardXMLParser();
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser sp=factory.newSAXParser();
            XMLReader reader=sp.getXMLReader();
            reader.setContentHandler(parser);
            reader.parse(is);

            /************* Get Parse data in a ArrayList **********/
            myCards=parser.getList();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return myCards;
    }

    private static String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    private static String loadDataFromXML(){
        String xml = null;

        // Load XML for parsing.
        InputStream inputStream = null;
        try {
            inputStream = mCtx.getResources().openRawResource(R.raw.cards_es);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

        xml = readTextFile(inputStream);
        return xml;
    }
}