class  Team 
{
	private String name;
	private String stadium;
	private String capacity;
	public Team(String n,String s,String c){
		name=n; stadium=s; capacity=c;}

	public String readName() {return name;}
	public String readStadium() {return stadium;}
	public String readCapacity(){return capacity;}
	public void updateStadium(String s){stadium=s;}
	public void updateCapacity(String c){capacity=c;}
}