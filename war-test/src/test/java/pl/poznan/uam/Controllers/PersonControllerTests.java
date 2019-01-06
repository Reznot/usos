package pl.poznan.uam.Controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonControllerTests {

    @Test
    public void testAddStudent() throws IOException {
        HttpPost httpPost = new HttpPost("http://localhost:8080/war/person/addEmployee");

        String json = "{\"pesel\": \"12345678909\",\"name\": \"test1\",\"surname\": \"test2\",\"email\": \"test@testujemy.com\",\"titles\": \"doktor\",\"position\": \"prowadzący\"}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpPost);
        assertEquals(201, httpResponse.getStatusLine().getStatusCode());
    }
}
