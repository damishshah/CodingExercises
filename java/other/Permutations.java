import java.util.ArrayList;
import java.util.List;

public class Permutations {
	// Given a collection of distinct numbers, return all possible permutations.

	public List<List<Integer>> permute(int[] a) {
		List<List<Integer>> results = new ArrayList<>();
		if (a == null || a.length == 0)
			return results;

		permute(a, new ArrayList<Integer>(), results);

		return results;
	}

	public void permute(int[] a, ArrayList<Integer> current, List<List<Integer>> results) {
		if (current.size() == a.length) {
			results.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (!current.contains(a[i])) {
				current.add(a[i]);
				permute(a, current, results);
				current.remove(current.size() - 1);
			}
		}
	}
}