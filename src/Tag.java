import java.util.ArrayList;

public class Tag {
	private String name;
	static ArrayList<Tag> list = new ArrayList<Tag>();
	
	public Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Tag getTag(String name) {
		if (list.contains(new Tag(name))) {
			return list.get(list.indexOf(new Tag(name)));
		}
		else {
			Tag tag = new Tag(name);
			list.add(tag);
			return tag;
		}
	}

	
	@Override
	public boolean equals(Object obj) {
		Tag tag = (Tag) obj;
		if (tag != null) {
			return tag.getName()==this.getName();
		}
		else {
			return super.equals(obj);
		}
		
	}
	
	
}
