package pl.poznan.uam.Utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.NoArgsConstructor;
import pl.poznan.uam.Email;
import pl.poznan.uam.QueriesMapping.StudentWithSubjectAndGrades;
import pl.poznan.uam.QueriesMapping.SubjectWithGrade;

import javax.mail.MessagingException;
import java.io.*;
import java.util.Properties;

@NoArgsConstructor
public class PDFFromJson {
    public String createSummary(StudentWithSubjectAndGrades data) throws IOException, DocumentException {
        //getting config.properties
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream resourceFile = loader.getResourceAsStream("config.properties");
        Properties appProps = new Properties();
        appProps.load(resourceFile);

        Email email = new Email();

        //aazon s3 initialization
        String fileName = data.getName() + data.getSurname() + "summary.pdf";
        AWSCredentials credentials = new BasicAWSCredentials(appProps.getProperty("accessKey"), appProps.getProperty("secretKey"));
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        //creating PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(fileName));

        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(data.getName() + ' ' + data.getSurname(), font);
        document.add(chunk);
        document.add(new Paragraph("\n\n"));
        for (SubjectWithGrade sg : data.getSubjectDetails()) {
            Chunk chunk2 = new Chunk(sg.getSubjectName() + ": " + sg.getGrade(), font);
            document.add(chunk2);
            document.add(new Paragraph("\n"));
        }

        document.close();
        File file = new File(fileName);
        s3Client.putObject(new PutObjectRequest(appProps.getProperty("bucketName"), fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));

        String returnUrl = appProps.getProperty("endpointUrl") + "/" + appProps.getProperty("bucketName") + "/" + fileName;
        return returnUrl;
    }
}
