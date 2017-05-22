package exos.lujan.jose.joselujanexos.model;

/**
 * Created by Quezacoo on 5/21/2017.
 */

import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.simpleframework.xml.core.ElementException;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Verbosity;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class SimpleXmlConverterFactoryTest {
    interface Service {
        @GET("/") Call<MyObject> get();
        @POST("/") Call<MyObject> post(@Body MyObject impl);
        @GET("/") Call<String> wrongClass();
    }

    @Rule public final MockWebServer server = new MockWebServer();

    private Service service;

    @Before public void setUp() {
        Format format = new Format(0, null, new HyphenStyle(), Verbosity.HIGH);
        Persister persister = new Persister(format);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(SimpleXmlConverterFactory.create(persister))
                .build();
        service = retrofit.create(Service.class);
    }

    @Test public void bodyWays() throws IOException, InterruptedException {
        server.enqueue(new MockResponse().setBody(
                "<my-object><message>hello world</message><count>10</count></my-object>"));

        Call<MyObject> call = service.post(new MyObject("hello world", 10));
        Response<MyObject> response = call.execute();
        MyObject body = response.body();
        assertThat(body.getMessage()).isEqualTo("hello world");
        assertThat(body.getCount()).isEqualTo(10);

        RecordedRequest request = server.takeRequest();
        assertThat(request.getBody().readUtf8()).isIn(
                "<my-object><message>hello world</message><count>10</count></my-object>",
                "<my-object><count>10</count><message>hello world</message></my-object>");
        assertThat(request.getHeader("Content-Type")).isEqualTo("application/xml; charset=UTF-8");
    }

    @Test public void honorsCharacterEncoding() throws IOException {
        Buffer buffer = new Buffer().writeString(
                "<my-object><message>你好，世界</message><count>10</count></my-object>",
                Charset.forName("GBK"));
        server.enqueue(
                new MockResponse().setBody(buffer).addHeader("Content-Type", "text/xml;charset=GBK"));

        Call<MyObject> call = service.get();
        Response<MyObject> response = call.execute();
        MyObject body = response.body();
        assertThat(body.getMessage()).isEqualTo("你好，世界");
    }

    @Test public void deserializeWrongValue() throws IOException {
        server.enqueue(new MockResponse().setBody("<myObject><foo/><bar/></myObject>"));

        Call<?> call = service.get();
        try {
            call.execute();
            fail();
        } catch (RuntimeException e) {
            assertThat(e.getCause()).isInstanceOf(ElementException.class)
                    .hasMessageStartingWith("Element 'foo' does not have a match in class retrofit2.converter.simplexml.MyObject");
        }
    }

    @Test public void deserializeWrongClass() throws IOException {
        server.enqueue(new MockResponse().setBody(
                "<my-object><message>hello world</message><count>10</count></my-object>"));

        Call<?> call = service.wrongClass();
        try {
            call.execute();
            fail();
        } catch (RuntimeException e) {
            assertThat(e).hasMessage("Could not deserialize body as class java.lang.String");
        }
    }
}