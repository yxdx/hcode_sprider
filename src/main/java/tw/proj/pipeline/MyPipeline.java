package tw.proj.pipeline;

import org.springframework.stereotype.Component;
import tw.proj.dao.BlogDao;
import tw.proj.entity.Blog;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * @author MY
 */
@Component("myPipeline")
public class MyPipeline implements PageModelPipeline<Blog> {

	@Resource(name = "blogDao")
	private BlogDao blogDao;

	@Override
	public void process(Blog blog, Task task) {
		blogDao.add(blog);
	}
}
