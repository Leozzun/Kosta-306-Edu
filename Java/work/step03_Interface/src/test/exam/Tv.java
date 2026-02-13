package test.exam;

public class Tv extends Elec implements ElecFunction {
	private int channel;
	
	public Tv() {}

	public Tv(int channel) {
		super();
		this.channel = channel;
	}

	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel = channel;
	}
	
	@Override
	public void start() {
		System.out.println(super.getCode()+"제품 TV를 " +channel+"을 본다.");
	}
	
	public void stop() {
		
	}
	
	public void display() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("제품 TV를 ");
		builder.append(channel);
		builder.append("을 본다");
		return builder.toString();
	}
	
	
}
