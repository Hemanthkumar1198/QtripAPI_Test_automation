package api.utils;

public class CitiesPojo {

	private String id;
	private String city;
	private String description;
	private String image;
	
	public CitiesPojo() { }//bcz Jackson required no Arg constructor
	
	public CitiesPojo(String id, String city, String description, String image) {
        this.id = id;
        this.city = city;
        this.description = description;
        this.image = image;
    } 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
	
}
