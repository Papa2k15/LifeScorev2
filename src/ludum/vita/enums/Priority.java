package ludum.vita.enums;

public enum Priority {
	LOW("low"),
	NORMAL("normal"),
	HIGH("high");
	
	private String priority;
	
	private Priority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return priority;
	}

	public static Priority parse(String priority) throws Exception {
		for(Priority p : values()){
			if(priority.equals(p.getPriority())){
				return p;
			}
		}
		throw new Exception("Can't parse priority: " + priority);
	}
}
