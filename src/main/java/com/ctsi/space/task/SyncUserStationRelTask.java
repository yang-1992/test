package com.ctsi.space.task;

import com.ctsi.space.domain.dto.UserStationRelUpdateDto;
import net.sf.json.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 统一权限对账户和台站关系进行增加、更新、删除时通知给各子系统
 */
public class SyncUserStationRelTask extends Thread {

    private final static String NAME = "SyncUserStationRelTask";

    private final Logger logger = LoggerFactory.getLogger(SyncUserStationRelTask.class);

    private UserStationRelUpdateDto userStationRelUpdateDto;

    private String url;

    public SyncUserStationRelTask(UserStationRelUpdateDto userStationRelUpdateDto, String url) {
        super(NAME);
        this.userStationRelUpdateDto = userStationRelUpdateDto;
        this.url = url;
    }

    public void sync() {
        JSONObject requestJson = JSONObject.fromObject(userStationRelUpdateDto);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        JSONObject result = null;
        try {
            // 创建HttpClient对象
            httpClient = HttpClients.createDefault();
            // 设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000).setSocketTimeout(10000).build();
            // 创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            // 给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(requestJson.toString(), "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);
            // 发送HttpPost请求，获取返回值
            result  = JSONObject.fromObject(httpClient.execute(httpPost, responseHandler));
            logger.debug(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        sync();
        super.run();
    }
}
