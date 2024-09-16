package task.runner;

import task.string.StringTask;

public class TestRunner {

    public static void main(String[] args) {
        StringTask stringTask = new StringTask();

        String[] arr = new String[]{"Hello", null, null, "Hiii"};
        
	try{
        System.out.println(stringTask.concatenateArray(4, arr, "-"));
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
    }
}

