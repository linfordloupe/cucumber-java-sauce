package helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonHelper {
    @SuppressWarnings("unchecked")

    public static void formatJsonOutput(String Timestamp) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("target/cucumber-report.json")) {
            JSONArray output = (JSONArray) parser.parse(reader);
            JSONObject FormattedJSON = new JSONObject();
            FormattedJSON.put("Timestamp", Timestamp);
            FormattedJSON.put("TestRun", output);
            FileWriter file = new FileWriter("target/TestRuns/" + Timestamp + "/" + Timestamp + ".json");
            file.write(FormattedJSON.toString());
            file.flush();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
