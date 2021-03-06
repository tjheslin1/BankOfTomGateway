package io.github.tjheslin1.gateway.infrastructure.application.web;

import io.github.tjheslin1.gateway.application.web.JsonUnmarshaller;
import org.json.JSONObject;

public class DepositRequestJsonUnmarshaller implements JsonUnmarshaller<DepositRequest> {

    @Override
    public DepositRequest unmarshall(String requestBody) {
        JSONObject jsonObject = new JSONObject(requestBody);

        return new DepositRequest(
                Integer.parseInt(jsonObject.get("accountId").toString()),
                Double.parseDouble(jsonObject.get("amount").toString()));
    }
}
