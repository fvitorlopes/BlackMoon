package autInteraction.autDataExtraction.htmlExtraction.tableExtraction.dtos;

import java.util.ArrayList;
import java.util.List;

public class TableLineEntity {

	private List<String> headers = new ArrayList<String>();
	private List<String> values = new ArrayList<String>();

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public void addValue(String value){
		this.values.add(value);
	}
}