package dtos.pageInteraction;

import java.util.ArrayList;
import java.util.List;

public class PageContext {

	private PageEntity pageEntity = new PageEntity();
	private List<PageField> fields = new ArrayList<PageField>();
	
	public PageEntity getPageEntity() {
		return pageEntity;
	}

	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

	public List<PageField> getFields() {
		return fields;
	}

	public void setFields(List<PageField> fields) {
		this.fields = fields;
	}
	
}