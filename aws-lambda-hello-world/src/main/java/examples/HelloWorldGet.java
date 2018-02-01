package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class HelloWorldGet implements RequestStreamHandler {

  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
      throws IOException {

    String name = "(default)";
    JSONObject event;
    try {
      event =
          (JSONObject)
              new JSONParser().parse(new BufferedReader(new InputStreamReader(inputStream)));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
    if (event.get("queryStringParameters") != null) {
      JSONObject qps = (JSONObject) event.get("queryStringParameters");
      if (qps.get("name") != null) {
        name = (String) qps.get("name");
      }
    }

    JSONObject responseBody = new JSONObject();
    responseBody.put("message", "Hello 4 " + name);

    JSONObject responseJson = new JSONObject();
    responseJson.put("body", responseBody.toString());

    OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
    writer.write(responseJson.toJSONString());
    writer.close();
  }
}
