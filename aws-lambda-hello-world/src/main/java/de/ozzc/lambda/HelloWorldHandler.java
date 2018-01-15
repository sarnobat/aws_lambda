package de.ozzc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldHandler implements RequestHandler<Integer, String> {

    @Override
    public String handleRequest(Integer input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);
        return "{        'statusCode': 200,        'headers': { 'Content-Type': 'application/json' },        'body': json.dumps({ 'username': 'bob', 'id': 20 })    }";
    }
}
