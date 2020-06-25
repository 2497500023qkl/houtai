package com.example.chess.Server;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.Console;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/test")
@Component
@Slf4j
public class receive {
    /**
     * 存放所有在线的客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();
    private static Map<String,String> start=new ConcurrentHashMap<>();
    private static Map<String,String> name=new ConcurrentHashMap<>();
    private Gson gson =new Gson();
    private start s = new start();
    String value="";

    @OnOpen
    public void onOpen(Session session) throws IOException {
        log.info("有新的客户端连接了: {}", session.getId());
        //将新用户存入在线的组
        clients.put(session.getId(), session);
        start.put(session.getId(),"空闲");
        s.setStart("id");
        s.setMessage(session.getId());
        clients.get(session.getId()).getBasicRemote().sendText(JSON.toJSON(s).toString());
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        log.info("有用户断开了, id为:{}", session.getId());
        //将掉线的用户移除在线的组里
            clients.remove(session.getId());
            start.remove(session.getId());
        name.remove(session.getId());
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        throwable.printStackTrace();
        log.info("有用户异常了, id为:{}", session.getId());
        //将掉线的用户移除在线的组里
                clients.remove(session.getId());
                start.remove(session.getId());
        name.remove(session.getId());
    }

    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) throws IOException, EncodeException {
        log.info("服务端收到客户端发来的消息: {}", message);
            this.sendto(gson.fromJson(message,Message.class));

    }

    private void sendto(Message message) throws IOException, EncodeException {
        Session session=clients.get(message.getUserId());
        if(message.getStart().equals("0")){
            name.put(message.getUserId(),message.getMessage());
                for(String key : start.keySet()){
                    System.out.println(key +":"+ start.get(key));
                    if(start.get(key).equals("空闲")){
                        if(value.equals("")){
                            value = key;
                        }else{
                            start.remove(value);
                            start.put(value,key);
                            s.setStart("开始");
                            s.setColor(false);
                            s.setMessage("游戏开始对战玩家"+name.get(key)+"您是红方");
                            clients.get(value).getBasicRemote().sendText(JSON.toJSON(s).toString());
                            start.remove(key);
                            start.put(key,value);
                            start.remove(value);
                            start.put(value,key);
                            s.setColor(true);
                            s.setMessage("游戏开始对战玩家"+name.get(value)+"您是黑方");
                            clients.get(key).getBasicRemote().sendText(JSON.toJSON(s).toString());
                            value="";
                        }
                    }
                }
            if(value.equals(message.getUserId())){
                s.setStart("等待");
                s.setMessage(name.get(message.getUserId())+"你好正在匹配你的对手");
                clients.get(message.getUserId()).getBasicRemote().sendText(JSON.toJSON(s).toString());
            }
        }else if(message.getStart().equals("1")){
                try {
                    clients.get(start.get(message.getUserId())).getBasicRemote().sendText(JSON.toJSON(message).toString());
                }catch (Exception e){
                    System.out.println("失败");
                }
        }
    }
}
