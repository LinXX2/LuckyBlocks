package linxx.luckyblocks.api;

import java.lang.reflect.Method;

public class LuckyEvent {

	private String name;
	private Method action;
	private Object classinstance;
	private EventType eventtype;
	
	public LuckyEvent(String name, Method action, Object classinstance, EventType eventtype) {
		this.name = name;
		this.action = action;
		this.classinstance = classinstance;
		this.eventtype = eventtype;
	}
	
	public Method getAction() {
		return action;
	}
	public String getName() {
		return name;
	}
	public Object getClassinstance() {
		return classinstance;
	}
	
	public EventType getEventtype() {
		return eventtype;
	}
}
