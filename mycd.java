import java.util.*;

public class mycd
{
	static boolean validatePart(String part) {
		if (part.charAt(0) == '.') {
			if (!part.equals("..") && !part.equals(".")) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: java mycd Cur_Dir New_Dir");
			return;
		}	

		String pwd = args[0];
		String target = args[1];
		String []parts1 = pwd.split("/");
		String []parts2 = target.split("/");


		Stack<String> newPath = new Stack<>();

		if (target.charAt(0) != '/') {
			for (String s : parts1) {
				newPath.push(s);
			}
		}

		for (String s : parts2) {
			if (s.equals("")) {
				continue;
			}
			if (validatePart(s)) {
				if (s.equals("..")) {
					if (!newPath.empty()) {
						newPath.pop();
					}
				} else if (s.equals(".")) {
					continue;
				} else {
					newPath.push(s);
				}
			} else {
				System.out.println(target + ": No such file or directory");
				return;
			}
		}

		if (newPath.empty()) {
			System.out.println("/");
		} else {
			ListIterator<String> it = newPath.listIterator();
			while(it.hasNext()) {
				System.out.print("/" + it.next());
			}
			System.out.println();
		}
	}
}
