package examples;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.*;

public class HelloWorldHandler implements RequestHandler<Map<String,Object>, String> {

    @Override
    public String handleRequest(Map<String,Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("SRIDHAR received : " + input.toString());
        // I can't get this to work in AWS API Gateway. ProxyWithStream does work though.
        return "{     'isBase64Encoded': true,       'statusCode': 200,        'headers': { 'Content-Type': 'application/json' },        'body': { 'username': 'bob', 'id': 20 }    }";
    }
}
