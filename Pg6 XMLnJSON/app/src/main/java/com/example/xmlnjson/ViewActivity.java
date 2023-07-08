package com.example.xmlnjson;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
public class ViewActivity extends AppCompatActivity {
    TextView txtXML, txtJSON;
    int mode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        txtXML = findViewById(R.id.textView_xml);
        txtJSON = findViewById(R.id.textView_json);

        mode=getIntent().getIntExtra("mode",0);
        if(mode == 1) parseJson();
        else parseXml();
    }
    public void parseXml()
    {
        try {
            InputStream is = getAssets().open("input.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

            NodeList nList = doc.getElementsByTagName("employee");
            Element elem = (Element)nList.item(0);

            txtXML.setText("City Name : " + getValue("city_name", elem)+"\n");
            txtXML.append("Latitude : " + getValue("Latitude", elem)+"\n");
            txtXML.append("Longitude : " + getValue("Longitude", elem)+"\n");
            txtXML.append("Temperature : " + getValue("Temperature", elem)+"\n");
            txtXML.append("Humidity : " + getValue("Humidity", elem)+"\n");

        }
        catch (Exception e) {}
    }
    public String getValue(String tag, Element elem) {
        NodeList nList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        return nList.item(0).getNodeValue();
    }
    public void parseJson()
    {
        try {
            InputStream is = getAssets().open("input.json");
            byte[] data=new byte[is.available()];
            is.read(data);
            String str=new String(data);
            JSONObject jsonObj=new JSONObject(str).getJSONObject("employee");

            txtJSON.setText("City Name : "+jsonObj.getString("city_name")+"\n");
            txtJSON.append("Latitude : "+jsonObj.getString("Latitude")+"\n");
            txtJSON.append("Longitude : "+jsonObj.getString("Longitude")+"\n");
            txtJSON.append("Temperature : "+jsonObj.getInt("Temperature")+"\n");
            txtJSON.append("Humidity : "+jsonObj.getString("Humidity")+"\n");
        }
        catch (Exception e) {}
    }
}