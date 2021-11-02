package br.com.mysafeestablishment.api.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String body;
        Gson gson = new Gson();
        try {
            body = IOUtils.toString(response.body().asInputStream(), Charsets.UTF_8);
        } catch (IOException e) {
            return e;
        }
        JsonObject json = gson.fromJson(body, JsonObject.class);
        if (json.isJsonNull()){
            return new Exception(response.body().toString());
        }
        return new Exception(json.get("message").getAsString());
    }
}
