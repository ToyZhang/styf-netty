package com.styf.netty;


import com.styf.pojo.AppVersion;
import com.styf.service.AppVersionService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ywy on 16/9/13.
 */
@Component
public class HelloServerHandler extends  ChannelHandlerAdapter{
    @Autowired
    private AppVersionService appVersionService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
//            String body = (String) msg;
//            System.out.println("server receive msg : " + body);
//
////        String respMsg = "hello==>" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
////                + System.getProperty("line.separator");
//
//            String respMsg = "";
//            List<AppVersion> list = appVersionService.selectAllApp();
//            for (AppVersion a : list) {
//                respMsg += a.getAppName() + ",";
//            }
            String respMsg = "数据库测试数据:拓宇最牛逼";
            respMsg += System.getProperty("line.separator");


            ByteBuf resp = Unpooled.copiedBuffer(respMsg.getBytes());
            ctx.writeAndFlush(resp);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    public AppVersionService getAppVersionService() {
        return appVersionService;
    }

    public void setAppVersionService(AppVersionService appVersionService) {
        this.appVersionService = appVersionService;
    }
}
