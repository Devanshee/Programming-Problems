
public class ReverseString {
			String Reverse(String s){
				if(s == null) return null;
				if(s.length() == 1) return s;
				String rev = "";
				rev = rev+String.valueOf(s.charAt(s.length()-1))+Reverse(s.substring(0,s.length()-1));
				return rev;
			}
			
			public static void main(String a[])
			{
				ReverseString rs = new ReverseString();
				System.out.println("Reverse of abcd is : "+ rs.Reverse("devanshee"));
			}
}
