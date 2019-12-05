public class Day4 {

    private int[] convert(String s) {
	int[] res = new int[s.length()];
	for (int i =0; i< s.length(); i++) {
	    res[i] = s.charAt(i) - '0';
	}
	return res;
    }

    // initially we just copy the first digit accross the board
    private void initadapt(int[] arr) {
	for (int i=1; i<arr.length; i++)
		arr[i] = arr[0];
    }

    // move it upwards to the first acceptable value
    private void adapt(int[] arr) {
	boolean sames = false;
	for (int i=1; i<arr.length; i++)
	    if ( arr[i] <= arr[i-1] ) {
		arr[i] = arr[i-1];
		sames = true;
	    }
	int i = arr.length-1;
	if (!sames) {
	    arr[i-1] = arr[i];
	    sames = true;
	}

    }

    private boolean checkDuo(int[] arr) {
	if (arr[0]==arr[1] && arr[1]!=arr[2])
	    return true;
	if (arr[arr.length-1]==arr[arr.length-2] && arr[arr.length-3]!=arr[arr.length-2])
	    return true;
	for (int i=2; i<arr.length-1; i++){
	    if (arr[i-2]!=arr[i-1] && arr[i-1]==arr[i] && arr[i]!=arr[i+1])
		return true;
	}
	return false;
    }

    private void next(int[] arr) {
	int pos = arr.length-1;
	arr[pos]++;
	while ((arr[pos] == 10) && pos>0) {
	    arr[pos] = 0;
	    pos--;
	    arr[pos]++;
	}
    }

    // return the two counters that are the results for part 1 and 2
    private int[] range(String sstart, String send){
	int[] start = convert(sstart);
	//	start = convert("123456");
	int[] end = convert(send);
	//	end = convert("124455");

	//Svetovid.out.println(start);
	//Svetovid.out.println("adapt:");
	initadapt(start);
	//Svetovid.out.println(start);
	int count = 1;
	int count2 = 0;
	if (checkDuo(start)) count2++;
	boolean more = true;
	int pos = 0;
	while (more ) {

	    next(start);
	    //Svetovid.out.print("+ ");
	    //Svetovid.out.println(start);
	    adapt(start);
	    //Svetovid.out.print("a ");
	    //Svetovid.out.println(start);
	    while (more && start[pos]==end[pos]) {
		pos++;
		if ((start[pos]>end[pos]) || (pos == start.length)) {
		    more = false;
		}
	    }	    
	    if (more) {
		count++;
		if (checkDuo(start))
		    count2++;
	    }
	    
	}
	
	
	return new int[]{count,count2};
    }
    
    public static void main(String[] args) {
	String input = Svetovid.in("input4.txt").readLine();
	String[] two = input.split("-");
	Svetovid.out.println(new Day4().range(two[0], two[1]));
    }
}
