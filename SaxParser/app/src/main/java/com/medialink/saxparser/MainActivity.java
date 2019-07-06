package com.medialink.saxparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView1);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                boolean salary = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("salary")) {
                        salary = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {

                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (name) {
                        tv.setText(tv.getText()+"\n\nName: "+new String(ch, start, length));
                        name = false;
                    }
                    if (salary) {
                        tv.setText(tv.getText()+"\nSalary: "+new String(ch, start, length));
                        salary = false;
                    }
                }
            };

            InputStream is = getResources().openRawResource(R.raw.file);
            parser.parse(is, handler);


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
