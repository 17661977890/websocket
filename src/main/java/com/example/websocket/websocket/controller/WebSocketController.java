package com.example.websocket.websocket.controller;

import com.example.websocket.websocket.server.WebSocketServer;
import com.example.websocket.websocket.server.WebSocketServer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 彬
 * @Date 2019/7/2
 */
@RequestMapping("/webSocket")
@RestController
public class WebSocketController {
    @Autowired
    private WebSocketServer webSocketServer;
    @Autowired
    private WebSocketServer2 webSocketServer2;

    /**
     * ================================================案例一============================================
     * @param param
     * @return
     */
    @RequestMapping(value="/pushVideoListToWeb",method= RequestMethod.POST,consumes = "application/json")
    public Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<String,Object>();
        try {
            WebSocketServer.sendInfo("有新客户呼入");
            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }


    /**
     * ==================================================案例2================================================
     */

    /**
     * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public void testSocket1(@RequestParam String userName, @RequestParam String message){
        webSocketServer2.sendInfo(userName, message);
    }


    /**
     * 给所有用户推送消息
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(@RequestParam String message){
        try {
            webSocketServer2.onMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
