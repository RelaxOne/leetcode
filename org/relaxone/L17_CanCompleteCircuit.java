package org.relaxone;

public class L17_CanCompleteCircuit {

	public int cancompleteCircuit(int[] gas, int[] cost) {
		if (cost.length != gas.length || gas.length == 0 || cost.length == 0 || gas == null || cost == null) {
			return -1;
		}
		for (int i = 0; i < gas.length; i++) {
			if (cancomplete(gas, cost, i)) {
				return i;
			}
		}
		return -1;
	}

	public boolean cancomplete(int[] gas, int[] cost, int start) {
		int count = 0;
		int index = 0;
		int i = start;
		while (index < gas.length) {
			if (i == gas.length)
				i = 0;
			count += (gas[i] - cost[i]);
			if (count < 0)
				return false;
			i++;
			index++;
		}
		return true;
	}

	public int cancompleteCircuit_2(int[] gas, int[] cost) {
		int total = 0, index = 0;
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				sum = 0;
				index = i+1;
			}
		}
		return total >= 0 ? index : -1;
	}

	public static void main(String[] args) {
		L17_CanCompleteCircuit canCompleteCircuit = new L17_CanCompleteCircuit();
		int[] gas = { 1, 2 };
		int[] cost = { 2, 1 };
		int i = canCompleteCircuit.cancompleteCircuit_2(gas, cost);
		System.out.println(i);
	}

}
