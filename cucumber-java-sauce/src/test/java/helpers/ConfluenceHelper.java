package helpers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import managers.FileReaderManager;

import java.io.File;

public class ConfluenceHelper {

    /**
     * Upload the cucumber runner json file to a Confluence page
     * `
     *
     * @param FilePath - file path of the report to be uploaded
     *                 <p>
     *                 Author  - John Nicholls
     *                 Created - 30/01/2020
     */
    public static void UploadRegressionResult(String FilePath) throws UnirestException {
        File attachment = new File(FilePath);
        HttpResponse<JsonNode> response = Unirest.post("https://chcdigital.atlassian.net/wiki/rest/api/content/1863581833/child/attachment")
                .header("X-Atlassian-Token", "nocheck")
                .header("Accept", "application/json")
                .basicAuth(FileReaderManager.getInstance().getConfigReader().getConfluenceUser(), FileReaderManager.getInstance().getConfigReader().getConfluenceAPIKey())
                .field("file", attachment)
                .asJson();
        System.out.println(response.getBody());
    }
}
