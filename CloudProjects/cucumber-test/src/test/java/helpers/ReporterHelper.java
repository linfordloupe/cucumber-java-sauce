package helpers;

import com.mashape.unirest.http.exceptions.UnirestException;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ReporterHelper {

    public static void generateCucumberReport() throws UnirestException {
        System.out.println("****generateCucumberReportCalled***");
        File reportOutputDirectory;
        String TimeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime());
        reportOutputDirectory = new File("target/TestRuns/" + TimeStamp);
        ArrayList<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report.json");

        String projectName = "C.Hoare & Co. Prime4";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("config/Configuration.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
        JsonHelper.formatJsonOutput(TimeStamp);
        ConfluenceHelper.UploadRegressionResult("target/TestRuns/" + TimeStamp + "/" + TimeStamp + ".json");
    }
}
