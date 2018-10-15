package tw.proj.spider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import tw.proj.entity.Blog;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;
import javax.management.JMException;


/**
 * @author MY
 */
@Component("mySpider")
public class MySpider {
	@Resource(name = "myPipeline")
	private PageModelPipeline myPipeline;

	public void crawl() throws JMException {
		Spider spider = OOSpider.create(
				Site.me().setRetryTimes(6).setSleepTime(600).setTimeOut(6000).addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"), myPipeline, Blog.class)
				.addUrl("https://blog.csdn.net")
				.thread(24);
		SpiderMonitor.instance().register(spider);
		spider.start();
	}


	public static void main(String[] args) throws JMException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MySpider mySpider = (MySpider) applicationContext.getBean("mySpider");
		mySpider.crawl();

	}
}
