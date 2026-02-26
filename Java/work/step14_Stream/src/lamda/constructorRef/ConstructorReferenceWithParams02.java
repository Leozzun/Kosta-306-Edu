package lamda.constructorRef; 
import java.util.function.Function;
import java.util.function.Supplier; 
 
class User { 
    String name; 
    public User() {
    	System.out.println("기본 생성자");
    }
    public User(String name) { 
        this.name = name; 
    } 
     
    public void printName() { 
        System.out.println("User 이름: " + name); 
    } 
} 
 //////////////////////////////////////////////////
public class ConstructorReferenceWithParams02 { 
    public static void main(String[] args) { 
    
    	//기존방식
    	Function<String, User> beforeUser = new Function<String, User>() {
			@Override
			public User apply(String name) {
				return new User(name);
			}
		};
		
		//1. 람다식으로 변경해보자
		Function<String, User> beforeUser2 = (name) -> new User(name);
		
		
		//2. 생성자 참조로 변경해보자
		Function<String, User> beforeUser3 = User :: new;
		
    	
        //3. 호출해보자  
		
		User u1 = beforeUser.apply("홍");
		User u2 = beforeUser2.apply("준");
		User u3 = beforeUser3.apply("화");
		
		u1.printName();
		u2.printName();
		u3.printName();
       
		Supplier<User> s = User :: new;
		
		s.get();
    } 
}