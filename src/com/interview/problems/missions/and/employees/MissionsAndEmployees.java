package com.interview.problems.missions.and.employees;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Missions and Employees
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MissionsAndEmployees {

	// List to hold the input data
	static List<String> missionAndEmployees = new LinkedList<>();

	// static block to initialize sample input data
	static {
		missionAndEmployees.add("1,Sam");
		missionAndEmployees.add("2,Iiya");
		missionAndEmployees.add("2,Sue");
		missionAndEmployees.add("3,Megan");
		missionAndEmployees.add("4,Iiya");
		missionAndEmployees.add("5,Iiya");
		missionAndEmployees.add("5,Sue");
		missionAndEmployees.add("6,Sue");
		missionAndEmployees.add("7,Sam");
	}
	
	public static void main(String[] args) {

		Map<String, Set<String>> missionsByEmployee = new HashMap<String, Set<String>>();
		Map<String, Set<String>> employeesByMission = new HashMap<String, Set<String>>();
		SortedSet<String> missions = new TreeSet<String>();
		Map<String, String> result = new HashMap<String, String>();
		
		for (String missionAndEmployee : missionAndEmployees) {
			StringTokenizer token = new StringTokenizer(missionAndEmployee, ",");
			String mission = token.nextToken();
			String name = token.nextToken();

			// Collect unique mission ids
			missions.add(mission);

			// Prepare map of Employees by mission ids
			if (missionsByEmployee.containsKey(name)) {
				missionsByEmployee.get(name).add(mission);
			} else {
				Set<String> missionSet = new HashSet<String>();
				missionSet.add(mission);
				missionsByEmployee.put(name, missionSet);
			}

			// Prepare map of missions by Employee Name
			if (employeesByMission.containsKey(mission)) {
				employeesByMission.get(mission).add(name);
			} else {
				Set<String> nameSet = new HashSet<String>();
				nameSet.add(name);
				employeesByMission.put(mission, nameSet);
			}
		}

		System.out.println("Missions by Employee-Id: " + missionsByEmployee);
		System.out.println();
		System.out.println("Employees by Mission-Id: " + employeesByMission);
		System.out.println();

		// Loop over unique mission ids and get all missions completed by employees  
		for (String mission : employeesByMission.keySet()) {
			Set<String> cumulativeMissions = new HashSet<String>();
			// Get all employees by particular mission id 
			// for e.g. for 2 get Iiya and Sue
			Set<String> employees = employeesByMission.get(mission); 
			for (String employee : employees){
				// Set ensures that it will insert only unique mission ids
				cumulativeMissions.addAll(missionsByEmployee.get(employee));
			}
			// Delete current mission from the set
			cumulativeMissions.remove(mission);
			// Add mission id and corresponding count from cumulative mission set
			result.put(mission, String.valueOf(cumulativeMissions.size()));
		}
		
		// Display Output by mission ids and no. of other mission
		System.out.printf("%10s | %20s\n", "Mission Id", "# of other missions");
		for (String mission : missions) {
			System.out.printf("%-10s | %-20s\n", "   " + mission, "      " + result.get(mission));
		}
	}
}
