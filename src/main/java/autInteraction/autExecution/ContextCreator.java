package autInteraction.autExecution;

import autInteraction.autDataExtraction.toExtraction.dtos.field.PageContext;
import autInteraction.autDataExtraction.toExtraction.dtos.field.PageEntity;

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
