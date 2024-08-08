package aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Integer, String> {
    @Override
    public String handleRequest(Integer integer, Context context) {
        return "";
    }
}
