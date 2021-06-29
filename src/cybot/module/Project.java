package cybot.module;

import org.json.simple.JSONObject;

public class Project {
	
	private String name;
	private String description;
	
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Project getProjectDetails(JSONObject jsonobject) {
		JSONObject title = (JSONObject) jsonobject.get("title");
		JSONObject descriptionData = (JSONObject) jsonobject.get("description");
		
		String name = (String) title.get("en-US");
		String description = (String) descriptionData.get("en-US");
		
		return new Project(name, description);
	}

}
