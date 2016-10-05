package design.book;

import java.util.List;

public class Chapter {
	private int num;
	private String title;
	private List<Page> pages;
	
	public int getStartPageNum(){
		return pages.get(0).getNum();
		
	}
	public int getEndPageNum(){
		return pages.get(pages.size()-1).getNum();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

}
