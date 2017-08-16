package test;

import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

public class Print implements Printable {

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		if (page > 0) {
			return NO_SUCH_PAGE;
		}
		BufferedImage back_img = null;
		File fpic = new File("D:\\water-cube.png");
		try {
			back_img =  ImageIO.read(fpic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("Default", Font.PLAIN, 14));
		g2d.drawImage(back_img,null,50,0);
		g2d.drawString("深水证考核收费单据", 50, 120);
		g2d.drawString("------------------------------------------------", 7, 135);
		g2d.drawString("深水证类型：" + "单次", 10, 155);
		g2d.drawString("日      期：" + "2017-04-05", 10, 170);
		g2d.drawString("------------------------------------------------", 7, 185);


		return PAGE_EXISTS;
	}

	public static void main(String[] args) {

		int height = 175 + 3 * 15 + 20;

		// 通俗理解就是书、文档
		Book book = new Book();

		// 打印格式
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);

		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(230, height);
		p.setImageableArea(5, -10, 230, height + 20);
		pf.setPaper(p);

		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new Print(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(book);
		try {
			job.print();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("================打印出现异常");
		}

	}

}