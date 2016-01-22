package autInteraction.autExecution;

import dtos.pageInteraction.PageContext;
import dtos.pageInteraction.PageEntity;

public class ContextCreator {

	private PageEntity pageEntity = new PageEntity();

	public PageEntity getPageEntity() {
		return pageEntity;
	}
	
	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

	public PageContext getPageContext() {
		PageContext pageContext = new PageContext();
		pageContext.setPageEntity(pageEntity);
		
		
		return pageContext;
	}

}
