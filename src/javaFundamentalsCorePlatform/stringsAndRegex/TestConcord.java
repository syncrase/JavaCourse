package javaFundamentalsCorePlatform.stringsAndRegex;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestConcord {

	public static void main(String... args) {

		String names = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
		String company = "Example";

// Solution s = new Solution();
// System.out.println(s.solution(names, company));
// System.out.println(s.solutionStreamAndChars(names, company));
// System.out.println(s.solutionHandleDuplicatesWithStreamAndChars(names, company));
// System.out.println(s.solutionRefactored(names, company));
// System.out.println(s.solutionRefactored2(names, company));
// System.out.println(s.solutionRefactored3(names, company));
// System.out.println(s.solutionRefactored4(names, company));
// System.out.println(s.solutionRefactored5(names, company));
		FinalSolution s = new FinalSolution();
		System.out.println(s.buildAddressBook(names, company));
	}
}

class Solution {

	public String solution(String names, String company) {

		String[] allNames = names.split(", ");
		StringBuilder sb = new StringBuilder();
		String[] nameSplitted;

		for (int i = 0; i < allNames.length; i++) {
			sb.append(allNames[i]);
			sb.append(" ");
			sb.append("<");

			nameSplitted = allNames[i].split(" ");

			sb.append(nameSplitted[0].toLowerCase().charAt(0));
			sb.append("_");
			String name;

			if (nameSplitted.length == 2) {
				name = nameSplitted[1].replace("-", "");
				name = name.length() > 8 ? name.substring(0, 8) : name;

			} else {

				sb.append(nameSplitted[1].toLowerCase().charAt(0));
				sb.append("_");

				name = nameSplitted[2].replace("-", "");
				name = name.length() > 8 ? name.substring(0, 8) : name;
			}

			sb.append(name.toLowerCase());

			sb.append("@");
			sb.append(company.toLowerCase());
			sb.append(".com");
			sb.append(i == allNames.length - 1 ? ">" : ">, ");

		}

		return sb.toString();
	}

	/**
	 * Don't use stringBuilder, buffer, concat, format, + or any other thing to
	 * handle strings. Only arrays and streams
	 *
	 * @param names
	 * @param company
	 * @return
	 */
	public String solutionStreamAndChars(String names, String company) {

		String[] allNames = names.split(", ");

		Stream<String> myStream;
		myStream = Arrays.asList(allNames).stream();
		myStream = Stream.of(allNames);

		return myStream//
				.map(name -> {
					String[] splittedName = name.split(" ");
					char[] onlyFirstLetters = Stream.of(splittedName).map(nameMonade -> nameMonade.substring(0, 1))
							.collect(Collectors.joining("_")).toCharArray();

					String nonTruncatedLastName = splittedName[splittedName.length - 1].replace("-", "");
					char[] onlyLastName = (nonTruncatedLastName.length() > 8 ? nonTruncatedLastName.substring(0, 8)
							: nonTruncatedLastName).toCharArray();

					char[] completeEmailId = new char[onlyFirstLetters.length - 1 + onlyLastName.length];
					for (int i = 0; i < onlyFirstLetters.length - 1; i++) {
						completeEmailId[i] = onlyFirstLetters[i];
					}
					for (int i = onlyFirstLetters.length - 1; i < completeEmailId.length; i++) {
						completeEmailId[i] = onlyLastName[i - onlyFirstLetters.length + 1];
					}

					String[] arrForRes = new String[splittedName.length + 1];
					for (int i = 0; i < splittedName.length; i++) {
						arrForRes[i] = splittedName[i];
					}
					arrForRes[splittedName.length] = Stream
							.of(new String[] {
									Stream.of(completeEmailId).map(String::valueOf).collect(Collectors.joining()),
									company })
							.map(String::valueOf).collect(Collectors.joining("@", "<", ">")).toLowerCase();

					return Stream.of(arrForRes).map(String::valueOf).collect(Collectors.joining(" "));

				})//
				.collect(Collectors.joining(", "));

	}

	/**
	 * Don't use stringBuilder, buffer, concat, format, + or any other thing to
	 * handle strings. Only arrays and streams
	 *
	 * @param names
	 * @param company
	 * @return
	 */
	public String solutionHandleDuplicatesWithStreamAndChars(String names, String company) {

		String[] allNames = names.split(", ");

		Stream<String> myStream;
		myStream = Arrays.asList(allNames).stream();
		myStream = Stream.of(allNames);
		Map<String, Integer> occurenceCounter = new HashMap<>();

		return myStream//
				.map(name -> {
					String[] splittedName = name.split(" ");
					char[] onlyFirstLetters = Stream.of(splittedName).map(nameMonade -> nameMonade.substring(0, 1))
							.collect(Collectors.joining("_")).toCharArray();

					String nonTruncatedLastName = splittedName[splittedName.length - 1].replace("-", "");
					char[] onlyLastName = (nonTruncatedLastName.length() > 8 ? nonTruncatedLastName.substring(0, 8)
							: nonTruncatedLastName).toCharArray();

					char[] completeEmailIdArray = new char[onlyFirstLetters.length - 1 + onlyLastName.length];

					for (int i = 0; i < onlyFirstLetters.length - 1; i++) {
						completeEmailIdArray[i] = onlyFirstLetters[i];
					}

					for (int i = onlyFirstLetters.length - 1; i < completeEmailIdArray.length; i++) {
						completeEmailIdArray[i] = onlyLastName[i - onlyFirstLetters.length + 1];
					}

					String completeEmailId = Stream.of(completeEmailIdArray).map(String::valueOf)
							.collect(Collectors.joining());
					occurenceCounter.compute(completeEmailId, (k, v) -> (v == null) ? Integer.valueOf(1) : v + 1);

					String[] arrForRes = new String[splittedName.length + 1];

					for (int i = 0; i < splittedName.length; i++) {
						arrForRes[i] = splittedName[i];
					}

					completeEmailId = Stream//
							.of(new String[] { completeEmailId,
									occurenceCounter.get(completeEmailId) > 1
											? occurenceCounter.get(completeEmailId) + ""
											: "" })
							.collect(Collectors.joining());

					arrForRes[splittedName.length] = Stream//
							.of(new String[] { completeEmailId, company })//
							.collect(Collectors.joining("@", "<", ">"))//
							.toLowerCase();

					return Stream.of(arrForRes).map(String::valueOf).collect(Collectors.joining(" "));

				})//
				.collect(Collectors.joining(", "));

	}

	public String solutionRefactored(String names, String company) {

		String[] allNames = names.split(", ");
		StringBuilder sb = new StringBuilder();
		String[] nameSplitted;

		for (int i = 0; i < allNames.length; i++) {
			sb.append(allNames[i]);
			sb.append(" ");
			sb.append("<");

			nameSplitted = allNames[i].split(" ");

// Refactoring 1 : remove the if/else for handle the lastname => for loop which
// skip the latest
			for (int j = 0; j < nameSplitted.length - 1; j++) {
				sb.append(nameSplitted[j].toLowerCase().charAt(0));
				sb.append("_");
			}

			String name;
			name = nameSplitted[nameSplitted.length - 1].replace("-", "");
			name = name.length() > 8 ? name.substring(0, 8) : name;
			sb.append(name.toLowerCase());

			sb.append("@");
			sb.append(company.toLowerCase());
			sb.append(".com");
			sb.append(i == allNames.length - 1 ? ">" : ">, ");

		}

		return sb.toString();
	}

	public String solutionRefactored2(String names, String company) {

		String[] allNames = names.split(", ");
		StringBuilder sb = new StringBuilder();
		String[] nameSplitted;

// Refactoring 2 : remove the condition for address separator at the end => use
// collectors joining
		String[] addressBook = new String[allNames.length];

		for (int i = 0; i < allNames.length; i++) {
			sb.append(allNames[i]);
			sb.append(" ");

			sb.append("<");

			nameSplitted = allNames[i].split(" ");

			for (int j = 0; j < nameSplitted.length - 1; j++) {
				sb.append(nameSplitted[j].toLowerCase().charAt(0));
				sb.append("_");
			}

			String name;
			name = nameSplitted[nameSplitted.length - 1].replace("-", "");
			name = name.length() > 8 ? name.substring(0, 8) : name;
			sb.append(name.toLowerCase());

			sb.append("@");
			sb.append(company.toLowerCase());
			sb.append(".com");
			sb.append(">");
			addressBook[i] = sb.toString();
			sb.setLength(0);
		}

		return Stream.of(addressBook).collect(Collectors.joining(", "));
	}

	public String solutionRefactored3(String names, String company) {

		String[] nameSplitted, addressParts, domainNameParts, usernameParts, allNames, addressesBook;
		String emailAddress, formattedLastName;

		allNames = names.split(", ");
		addressesBook = new String[allNames.length];

		for (int i = 0; i < allNames.length; i++) {

// Refactoring 3 : build all username, domain and then email with the joining
// solution

// Build username
			nameSplitted = allNames[i].split(" ");
			addressParts = new String[nameSplitted.length + 1];
			System.arraycopy(nameSplitted, 0, addressParts, 0, nameSplitted.length);
			usernameParts = new String[nameSplitted.length];
			for (int j = 0; j < nameSplitted.length - 1; usernameParts[j] = nameSplitted[j].substring(0, 1), j++) {
			}
			formattedLastName = nameSplitted[nameSplitted.length - 1].replace("-", "");
			formattedLastName = formattedLastName.length() > 8 ? formattedLastName.substring(0, 8) : formattedLastName;
			usernameParts[nameSplitted.length - 1] = formattedLastName;

// Build domain name
			domainNameParts = new String[] { company, "com" };

// Build email
			emailAddress = Stream.of(new String[] { //
					Stream.of(usernameParts).collect(Collectors.joining("_")), //
					Stream.of(domainNameParts).collect(Collectors.joining("."))//
			}).collect(Collectors.joining("@", "<", ">")).toLowerCase();

// Build address
			addressParts[nameSplitted.length] = emailAddress;
			addressesBook[i] = Stream.of(addressParts).collect(Collectors.joining(" "));
		}

		return Stream.of(addressesBook).collect(Collectors.joining(", "));

	}

	public String solutionRefactored4(String names, String company) {

// Refactoring 4 : Remove the outter for loop
		return Stream.of(names.split(", ")).map(name -> {

			String[] nameSplitted, addressParts, domainNameParts, usernameParts;
			String emailAddress, formattedLastName;
// Build username
			nameSplitted = name.split(" ");
			addressParts = new String[nameSplitted.length + 1];
			System.arraycopy(nameSplitted, 0, addressParts, 0, nameSplitted.length);
			usernameParts = new String[nameSplitted.length];
			for (int j = 0; j < nameSplitted.length - 1; usernameParts[j] = nameSplitted[j].substring(0, 1), j++) {
			}
			formattedLastName = nameSplitted[nameSplitted.length - 1].replace("-", "");
			formattedLastName = formattedLastName.length() > 8 ? formattedLastName.substring(0, 8) : formattedLastName;
			usernameParts[nameSplitted.length - 1] = formattedLastName;

// Build domain name
			domainNameParts = new String[] { company, "com" };

// Build email
			emailAddress = Stream.of(new String[] { //
					Stream.of(usernameParts).collect(Collectors.joining("_")), //
					Stream.of(domainNameParts).collect(Collectors.joining("."))//
			}).collect(Collectors.joining("@", "<", ">")).toLowerCase();

// Build address
			addressParts[nameSplitted.length] = emailAddress;
			return Stream.of(addressParts).collect(Collectors.joining(" "));
		}).collect(Collectors.joining(", "));

	}

	public String solutionRefactored5(String names, String company) {

		Map<String, Integer> occurenceCounter = new HashMap<>();

		return Stream.of(names.split(", ")).map(name -> {

			String[] nameSplitted, addressParts, domainNameParts, usernameParts;
			String emailAddress, formattedLastName;
// Build username
			nameSplitted = name.split(" ");
			addressParts = new String[nameSplitted.length + 1];
			System.arraycopy(nameSplitted, 0, addressParts, 0, nameSplitted.length);
			usernameParts = new String[nameSplitted.length];
			for (int j = 0; j < nameSplitted.length - 1; usernameParts[j] = nameSplitted[j].substring(0, 1), j++) {
			}
			formattedLastName = nameSplitted[nameSplitted.length - 1].replace("-", "");
			formattedLastName = formattedLastName.length() > 8 ? formattedLastName.substring(0, 8) : formattedLastName;
			usernameParts[nameSplitted.length - 1] = formattedLastName;

// Refactoring 5 : Handle duplicates
			String username = Stream.of(usernameParts).collect(Collectors.joining("_"));
			occurenceCounter.compute(username, (k, v) -> (v == null) ? Integer.valueOf(1) : v + 1);
			username = Stream//
					.of(new String[] { username,
							occurenceCounter.get(username) > 1 ? occurenceCounter.get(username) + "" : "" })
					.collect(Collectors.joining());

// Build domain name
			domainNameParts = new String[] { company, "com" };

// Build email
			emailAddress = Stream.of(new String[] { //
					username, //
					Stream.of(domainNameParts).collect(Collectors.joining("."))//
			}).collect(Collectors.joining("@", "<", ">")).toLowerCase();

// Build address
			addressParts[nameSplitted.length] = emailAddress;
			return Stream.of(addressParts).collect(Collectors.joining(" "));
		}).collect(Collectors.joining(", "));

	}

}

class FinalSolution {

	Map<String, Integer> occurenceCounter;

	{
		occurenceCounter = new HashMap<>();
	}

	public String buildAddressBook(String names, String company) {

		return Stream.of(names.split(", ")).map(name -> {
			return buildAddress(company, name.split(" "));
		}).collect(Collectors.joining(", "));

	}

	private String buildAddress(String company, String[] nameSplitted) {
		String[] addressParts = new String[nameSplitted.length + 1];

// Copy 1st, middle and last name to the address
		System.arraycopy(nameSplitted, 0, addressParts, 0, nameSplitted.length);

// Add the email
		addressParts[nameSplitted.length] = buildEmail(//
				buildUsername(nameSplitted), //
				buildDomainName(new String[] { company, "com" }) //
		);

		return Stream.of(addressParts).collect(Collectors.joining(" "));
	}

	private String buildDomainName(String[] domainNameParts) {
		return Stream.of(domainNameParts).collect(Collectors.joining("."));
	}

	private String buildEmail(String username, String domainName) {
		return Stream.of(new String[] { //
				username, //
				domainName//
		}).collect(Collectors.joining("@", "<", ">")).toLowerCase();
	}

	private String buildUsername(String[] nameSplitted) {
		String[] usernameParts = new String[nameSplitted.length];
		for (int j = 0; j < nameSplitted.length - 1; j++) {
			usernameParts[j] = nameSplitted[j].substring(0, 1);
		}
		String formattedLastName = nameSplitted[nameSplitted.length - 1].replace("-", "");
		formattedLastName = formattedLastName.length() > 8 ? formattedLastName.substring(0, 8) : formattedLastName;
		usernameParts[nameSplitted.length - 1] = formattedLastName;
		String username = Stream.of(usernameParts).collect(Collectors.joining("_"));

		occurenceCounter.compute(username, (k, v) -> (v == null) ? Integer.valueOf(1) : v + 1);

		return Stream//
				.of(new String[] { username,
						occurenceCounter.get(username) > 1 ? occurenceCounter.get(username) + "" : "" })
				.collect(Collectors.joining());

	}
}