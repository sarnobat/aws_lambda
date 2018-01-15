package de.ozzc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.*;

public class HelloWorldHandler implements RequestHandler<Map<String,Object>, String> {

    @Override
    public String handleRequest(Map<String,Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("SRIDHAR received : " + input.toString());
        return "{     'isBase64Encoded': true|false,       'statusCode': 200,        'headers': { 'Content-Type': 'application/json' },        'body': json.dumps({ 'username': 'bob', 'id': 20 })    }";
    }
}
