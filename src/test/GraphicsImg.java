package test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by ST on 2017/4/11.
 */
public class GraphicsImg {


    public static void main(String[] args) {
        try
        {
            int width = 128;
            int height = 64;
            // 创建BufferedImage对象
            Font font=new Font("宋体",Font.PLAIN,16);
            BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
            // 获取Graphics2D
            Graphics2D g2d = image.createGraphics();
            // 画图
            g2d.setBackground(new Color(255,255,255));
            g2d.setPaint(new Color(0,0,0));
            g2d.clearRect(0, 0, width, height);
            g2d.drawString("名称：娃哈哈纯净水",0,10);
            g2d.drawString("产地：浙江杭州",0,26);
            g2d.drawString("品牌：娃娃哈哈",0,42);
            g2d.drawString("单价：9876543210",0,58);
            g2d.setFont(font);
            //释放对象
            g2d.dispose();
            // 保存文件
            ImageIO.write(image, "png", new File("D:/test.png"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
