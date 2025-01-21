package neetcode150;

import java.util.*;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(3));
	}
	
	public static void generate(int openCnt, int closeCnt, StringBuilder curr, List<String> res, int maxLen) {
		if (curr.length() == maxLen) {
			res.add(curr.toString());
			return;
		}
		
		if (openCnt != 0) {
			curr.append('(');
			generate(openCnt - 1, closeCnt, curr, res, maxLen);
			curr.deleteCharAt(curr.length() - 1);
		}
		if (closeCnt > openCnt) {
			curr.append(')');
			generate(openCnt, closeCnt - 1, curr, res, maxLen);
			curr.deleteCharAt(curr.length() - 1);
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generate(n, n, new StringBuilder(), res, n * 2);
		
		return res;
	}
}
