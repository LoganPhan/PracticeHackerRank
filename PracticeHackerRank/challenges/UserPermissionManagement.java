import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */
/**
 * This application is a simple project to manage user and permission via memory storage.
 * It's useful to manage each manager can have multiple users. and each user can have multiple roles (which users manager roles had).
 * This application do not support to one user only have one manager and do not belong to another manager.
 * 
 * @author logan
 *
 */
public class AppTest2 {

	final static String CEO = "CEO";
	static Map<String, Set<String>> userRoles = new LinkedHashMap<>();
	static Map<String, Set<String>> usersManagement = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		String line = inp.readLine();
		int totalUsers = Integer.parseInt(line);
		int userId = 0;
		int rolesIndex = 1;
		userRoles.put(CEO, new HashSet<String>());
		usersManagement.put(CEO, new HashSet<String>());
		boolean isCEO = true;
		List<String> scripts = new ArrayList<>();
		while ((line = inp.readLine()) != null && !line.equals("")) {
			if(!isScript(line)) {
				if (userId > totalUsers) {
					Set<String> rolesOfUser = userRoles.get(String.valueOf(rolesIndex));
					Set<String> newRoles = userRoles.get(line);
					newRoles.addAll(rolesOfUser);
					usersManagement.get(line).add(String.valueOf(rolesIndex));
					rolesIndex++;
				} else if (isCEO) {
					userRoles.put(CEO, new HashSet<String>(Arrays.asList(line.split(" "))));
					isCEO = false;
				}
				else {
					userRoles.put(String.valueOf(userId), new HashSet<String>(Arrays.asList(line.split(" "))));
					usersManagement.put(String.valueOf(userId), new HashSet<String>());
				}
				userId++;
			}else {
				scripts.add(line);
			}
		}
		userRoles.forEach((key, val) -> System.out.println( String.join(", ", val)));
		scripts.forEach(script -> executeScript(script));
	}
	
	static boolean isScript(String script) {
		return script.startsWith("ADD") | script.startsWith("QUERY") | script.startsWith("REMOVE");
	}
	
	static void executeScript(String statement) {
		String[] segments = statement.split(" ");
		String method = segments[0];	
		Script.valueOf(method).executeScript(Arrays.copyOfRange(segments, 1, segments.length));
	}
	
	static boolean isValidToRemove(String userId, String[] roles) {
		Set<String> users = usersManagement.get(userId);
		boolean isValid = false;
		for (String user : users) {
			isValid = isValid(user, roles);
		}
		isValid = isValid(userId, roles);
		return isValid;
	}
	
	static boolean isValid(String userId, String[] rolesTobeRemove) {
		Set<String> currentRoles = new LinkedHashSet<>();
		currentRoles.addAll(userRoles.get(userId));
		currentRoles.removeAll(Arrays.asList(rolesTobeRemove));
		if(currentRoles.size() == 0) {
			System.out.println(String.format("Are you * kidding me... You gonna fire this user %s: ", userId));
			return false;
		}
		return true;
	}
	
	static void addRoles(String userId, String[] roles) {
		Set<String> currentRoles = userRoles.get(userId);
		currentRoles.addAll(Arrays.asList(roles));
	}
	
	static void removeRoles(String userId, String[] roles) {
		Set<String> currentRoles = userRoles.get(userId);
		currentRoles.removeAll(Arrays.asList(roles));
	}

	enum Script {
		ADD {
			@Override
			public void executeScript(String[] params) {
				String userId = params[0];
				Set<String> roles = userRoles.get(userId);
				String[] newRoles = Arrays.copyOfRange(params, 1, params.length);
				roles.addAll(Arrays.asList(newRoles));
				usersManagement.entrySet().stream().forEach(userManager -> {
					if(userManager.getValue().contains(userId)) {
						addRoles(userManager.getKey(), newRoles);
					}
				});
				
			}
		},
		QUERY {
			@Override
			public void executeScript(String[] params) {
				String userId = params[0];
				System.out.println(String.join(", ", userRoles.get(userId)));
			}
		},
		REMOVE {
			@Override
			public void executeScript(String[] params) {
				String userId = params[0];
				String[] roles = Arrays.copyOfRange(params, 1, params.length);
				if(isValidToRemove(userId, roles)) {
					//remove user's users
					Set<String> users = usersManagement.get(userId);
					users.stream().forEach(user -> removeRoles(user, roles));
					// Remove current User Roles
					removeRoles(userId, roles);
					// Remove user's managers roles
					usersManagement.entrySet().stream().forEach(userManager -> {
						if(userManager.getValue().contains(userId)) {
							removeRoles(userManager.getKey(), roles);
						}
					});
				}
				
			}
		};
		public abstract void executeScript(String[] params);
	}

}
