package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class OpenChat {

	public static void main(String[] args) {

		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] output = solution(input);
		
		for(String s: output) {
			System.out.println(s);
		}

	}

	public static String[] solution(String[] record) {
		
		String[] answer = {};
		List<String> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();

		StringTokenizer st;
		String type, uid;
		for (String s : record) {
			st = new StringTokenizer(s);
			type = st.nextToken();
			if (type.equals("Enter") || type.equals("Change")) {
				map.put(st.nextToken(), st.nextToken());
			}
		}
		StringBuffer sb;
		for (String s : record) {
			st = new StringTokenizer(s);
			sb = new StringBuffer();
			type = st.nextToken();
			uid = st.nextToken();
			if (type.equals("Enter")) {
				sb.append(map.get(uid)).append("´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
				list.add(sb.toString());
			}
			if (type.equals("Leave")) {
				sb.append(map.get(uid)).append("´ÔÀÌ ³ª°¬½À´Ï´Ù.");
				list.add(sb.toString());
			}			
		}
		
		return answer = list.toArray(answer);
		
	}

}
