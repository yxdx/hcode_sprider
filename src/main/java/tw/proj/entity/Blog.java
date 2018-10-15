package tw.proj.entity;

import us.codecraft.webmagic.model.annotation.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @author MY
 */
@Entity
@TargetUrl("https://blog.csdn.net/\\w+/article/details/\\d+")
@HelpUrl("https://blog.csdn.net/\\w+/article/list/\\d+?t=1")
public class Blog {
	@ExtractByUrl
	private String url;

	@ExtractBy("//h1[@class='title-article']/text()")
	private String tittle;

	@ExtractBy("//a[@class='follow-nickName']/text()")
	private String authorName;

	@ExtractBy("//a[@class='follow-nickName']/@href")
	private String authorUrl;

	@ExtractBy("//div[@id='article_content']/allText()")
	private String summary;

	@ExtractBy("//span[@class='read-count']/regex('\\d+')")
	private int pageviews;

	@Formatter("yyyy年MM月dd日 HH:mm:ss")
	@ExtractBy("//span[@class='time']/text()")
	private Date postdate;


	@Basic
	@Column(name = "tittle")
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@Id
	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Basic
	@Column(name = "author_name")
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Basic
	@Column(name = "author_url")
	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	@Basic
	@Column(name = "summary")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Basic
	@Column(name = "pageviews")
	public int getPageviews() {
		return pageviews;
	}

	public void setPageviews(int pageviews) {
		this.pageviews = pageviews;
	}

	@Basic
	@Column(name = "postdate")
	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Blog)) {
			return false;
		}
		Blog blog = (Blog) o;
		return getPageviews() == blog.getPageviews() &&
				Objects.equals(getTittle(), blog.getTittle()) &&
				Objects.equals(getUrl(), blog.getUrl()) &&
				Objects.equals(getAuthorName(), blog.getAuthorName()) &&
				Objects.equals(getAuthorUrl(), blog.getAuthorUrl()) &&
				Objects.equals(getSummary(), blog.getSummary()) &&
				Objects.equals(getPostdate(), blog.getPostdate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTittle(), getUrl(), getAuthorName(), getAuthorUrl(), getSummary(), getPageviews(), getPostdate());
	}
}
