package com.uprightlaw.price.engine.test.util;

import com.uprightlaw.price.engine.test.model.PriceModel;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by peng cheng on 2017/9/14.
 */
public class PriceEngineUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceEngineUtil.class);
    
    String testUrl = "https://kufz36bpz9.execute-api.us-west-2.amazonaws.com/dev/priceengine/v1/price";
    String proUrl = "https://kufz36bpz9.execute-api.us-west-2.amazonaws.com/dev/priceengine/v1/price";

    public boolean cha7Test(PriceModel priceModel){
        JSONObject jsonResult;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("x-api-key",apiKey);
            HttpResponse response = httpClient.execute(httpGet);
            String strResult = "";
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity());
                jsonResult = new JSONObject(strResult);
                String code = jsonResult.optString("code");
                if(code.equals("900101")){
                    return true;
                }else{
                    String data = jsonResult.optString("data");
                    JSONObject jsonData = new JSONObject(data);
                    double tmp = jsonData.optDouble("price");
                    if(tmp==priceModel.getExpectPrice()){
                        return true;
                    }else {
                        LOGGER.info("Check price engine error:priceModel="+JsonUtil.beanToJson(priceModel).toString()+"and price engine data ="+strResult);
                        return false;
                    }
                }
            } else {
                LOGGER.info("Price engine response error");
                return false;
            }
        }catch (IOException e){
            LOGGER.info("Fail to connect price engine");
            return false;
        }
    }

    public boolean cha13Test(PriceModel priceModel) {
        JSONObject jsonResult;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("x-api-key",apiKey);
            HttpResponse response = httpClient.execute(httpGet);
            String strResult = "";
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                strResult = EntityUtils.toString(response.getEntity());
                jsonResult = new JSONObject(strResult);
                String code = jsonResult.optString("code");
                if(code.equals("900101")){
                    return true;
                }else{
                    String data = jsonResult.optString("data");
                    JSONObject jsonData = new JSONObject(data);
                    double price = jsonData.optDouble("price");
                    double totalPrice = jsonData.optDouble("totalPrice");
                    if(price == priceModel.getExpectPrice() && totalPrice == priceModel.getExpectTotalPrice()){
                        return true;
                    }else{
                        if(priceModel.getRushCase() > 30 && price == priceModel.getExpectPrice()){
                            return true;
                        }
                        if(priceModel.getIncome()==0&&priceModel.getHouseholdMember()==0){
                            return true;
                        }
                        LOGGER.info("Check price engine error:priceModel="+JsonUtil.beanToJson(priceModel).toString()+"and price engine data ="+strResult);
                        return false;
                    }
                }
            }else {
                LOGGER.info("Price engine response error");
                return false;
            }
        }catch (IOException e){
            LOGGER.info("Fail to connect price engine");
            return false;
        }
    }
}
