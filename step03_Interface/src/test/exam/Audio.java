package test.exam;

public class Audio extends Elec implements ElecFunction {
	private int volumn;
	
	public Audio() {}

	public Audio(int volumn) {
		super();
		this.volumn = volumn;
	}

	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn = volumn;

	}
	
	@Override  //붙여주는 걸 권장 // 어노테이션 
	public void start() {
		System.out.println(super.getCode()+"의 Audio를 " + volumn+"으로 듣는다.");
	}
	
	public void stop() {

	}
	
	public void display() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("의 Audio를 ");
		builder.append(volumn);
		builder.append("으로 듣는다.");
		return builder.toString();
	}
	
}
